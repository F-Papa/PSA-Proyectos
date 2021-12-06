package com.psa.proyectos.controladores;

import com.psa.proyectos.modelos.Proyecto;
import com.psa.proyectos.modelos.Tarea;
import com.psa.proyectos.repositorios.RepositorioProyectos;
import com.psa.proyectos.repositorios.RepositorioTareas;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
            tarea.setHorasEstimadas(nuevaTarea.getHorasEstimadas());
            tarea.setDescripción(nuevaTarea.getDescripción());
            tarea.setCódigoProyecto(nuevaTarea.getCódigoProyecto());
            tarea.setEstado(nuevaTarea.getEstado());
            tarea.setNombre(nuevaTarea.getNombre());
            tarea.setAsignadaAEmpleado(nuevaTarea.getAsignadaAEmpleado());
            return repositorio.save(tarea);
        })
            .orElseGet(() -> crear(nuevaTarea));
    }

    //Eliminar
    @DeleteMapping("{id}")
    void eliminar(@PathVariable(value = "id") long código){
        repositorio.deleteById(código);
    }

    //Crear
    @PostMapping()
    Tarea crear(@RequestBody Tarea nuevaTarea){
        return repositorio.save(nuevaTarea);
    }

}
