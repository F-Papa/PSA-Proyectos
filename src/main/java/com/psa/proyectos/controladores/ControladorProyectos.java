package com.psa.proyectos.controladores;

import com.psa.proyectos.modelos.Proyecto;
import com.psa.proyectos.repositorios.RepositorioProyectos;
import org.apache.coyote.Response;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("proyectos")
public class ControladorProyectos {

    private final RepositorioProyectos repositorio;

    ControladorProyectos(RepositorioProyectos repositorio){
        this.repositorio = repositorio;
    }

    //Listar
    @GetMapping()
    ResponseEntity<List<Proyecto>> listarTodosLosProyecto (){
        return ResponseEntity.status(200).body(repositorio.findAll());
    }

    //Buscar
    @GetMapping("/{id}")
    ResponseEntity<Optional<Proyecto>> uno(@PathVariable(value = "id") long código) throws Exception {
        Optional<Proyecto> proyecto = repositorio.findById(código);

        if (proyecto.isEmpty())
            return ResponseEntity.status(404).body(null);
        else
            return ResponseEntity.status(200).body(proyecto);
    }

    //Actualizar
    @PutMapping("/{id}")
    ResponseEntity reemplazar(@RequestBody Proyecto nuevoProyecto, @PathVariable(value = "id") long código) throws Exception {

        AtomicBoolean actualizadoAtomic = new AtomicBoolean(false);

        Proyecto p = repositorio.findById(código).map(proyecto -> {

            if(!proyecto.esIgualA(nuevoProyecto) && nuevoProyecto.getNombre() != null){
                proyecto.setLegajoLíder(nuevoProyecto.getLegajoLíder());
                proyecto.setDescripción(nuevoProyecto.getDescripción());
                proyecto.setFechaDeComienzo(nuevoProyecto.getFechaDeComienzo());
                proyecto.setEstado(nuevoProyecto.getEstado());
                proyecto.setNombre(nuevoProyecto.getNombre());
                actualizadoAtomic.set(true);
                return repositorio.save(proyecto);
            }
            return proyecto;

            }).orElseGet(() -> crear(nuevoProyecto).getBody());

        return ResponseEntity.status(((actualizadoAtomic.get())? HttpStatus.OK : HttpStatus.NOT_MODIFIED)).body(p);

    }

    //Eliminar
    @DeleteMapping("{id}")
    void eliminar(@PathVariable(value = "id") long código){
        repositorio.deleteById(código);
    }

    //Crear
    @PostMapping()
    ResponseEntity<Proyecto> crear(@RequestBody Proyecto nuevoProyecto){

        if (nuevoProyecto.getNombre() == null)
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
        else
            return ResponseEntity.status(HttpStatus.OK).body(repositorio.save(nuevoProyecto));

    }

}

