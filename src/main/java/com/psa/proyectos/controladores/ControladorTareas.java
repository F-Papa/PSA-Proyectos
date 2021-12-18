package com.psa.proyectos.controladores;

import com.psa.proyectos.modelos.Tarea;
import com.psa.proyectos.repositorios.RepositorioTareas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("tareas")
public class ControladorTareas {

    private final RepositorioTareas repositorio;

    ControladorTareas(RepositorioTareas repositorio){
        this.repositorio = repositorio;
    }

    //Listar
    @GetMapping()
    ResponseEntity<List<Tarea>> listarTodas(){
        return ResponseEntity.status(200).body(repositorio.findAll());
    }

    //BuscarPorProyecto
    @GetMapping("/vinculadas/{id}")
    ResponseEntity<List<Tarea>> porProyecto(@PathVariable(value = "id") long código) throws Exception {

        List<Tarea> tareas = repositorio.findAll();

        for(Tarea t: tareas){
            if (t.getCódigoProyecto() != código)
                tareas.remove(t);
        }

        if (tareas.size() > 0)
            return ResponseEntity.status(200).body(tareas);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }


    //Buscar
    @GetMapping("/{id}")
    ResponseEntity<Optional<Tarea>> uno(@PathVariable(value = "id") long código) throws Exception {
        Optional<Tarea> tarea = repositorio.findById(código);

        if (tarea.isEmpty())
            return ResponseEntity.status(404).body(null);
        else
            return ResponseEntity.status(200).body(tarea);
    }

    //Actualizar
    @PutMapping("/{id}")
    Tarea reemplazar(@RequestBody Tarea nuevaTarea, @PathVariable(value = "id") long código) throws Exception {

        return repositorio.findById(código).map(tarea -> {

            if(!tarea.esIgual(nuevaTarea) && nuevaTarea.getNombre() != null) {
                tarea.setDuraciónEstimada(nuevaTarea.getDuraciónEstimada());
                tarea.setDescripción(nuevaTarea.getDescripción());
                tarea.setCódigoProyecto(nuevaTarea.getCódigoProyecto());
                tarea.setEstado(nuevaTarea.getEstado());
                tarea.setNombre(nuevaTarea.getNombre());
                tarea.setAsignadaAEmpleado(nuevaTarea.getAsignadaAEmpleado());
                return repositorio.save(tarea);
            }
            else return tarea;
        })
            .orElseGet(() -> crear(nuevaTarea).getBody());
    }

    //Eliminar
    @DeleteMapping("{id}")
    void eliminar(@PathVariable(value = "id") long código){
        repositorio.deleteById(código);
    }

    //Crear
    @PostMapping()
    ResponseEntity<Tarea> crear(@RequestBody Tarea nuevaTarea){
        if (nuevaTarea.getNombre() == null)
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
        else
            return ResponseEntity.status(HttpStatus.OK).body(repositorio.save(nuevaTarea));

    }

    //Crear para ticket
    @PostMapping("/soporte")
    Tarea crearParaTicket(@RequestBody Tarea nuevaTarea, @RequestParam(value = "ticket") String ticketID){

        crear(nuevaTarea);
        //Endpoint para vincular ticket con tarea (Mód. Soporte)
        String url = "" + "?tarea=" + nuevaTarea.getCódigo();
        RestTemplate restTemplate = new RestTemplate();
        return nuevaTarea;
    }

}
