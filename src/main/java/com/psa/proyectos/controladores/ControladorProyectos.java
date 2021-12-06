package com.psa.proyectos.controladores;

import com.psa.proyectos.modelos.Proyecto;
import com.psa.proyectos.repositorios.RepositorioProyectos;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

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
    Proyecto reemplazar(@RequestBody Proyecto nuevoProyecto, @PathVariable(value = "id") long código) throws Exception {

        return repositorio.findById(código).map(proyecto -> {
            proyecto.setLegajoLíder(nuevoProyecto.getLegajoLíder());
            proyecto.setDescripción(nuevoProyecto.getDescripción());
            proyecto.setEstado(nuevoProyecto.getEstado());
            proyecto.setNombre(nuevoProyecto.getNombre());
            return repositorio.save(proyecto);
        })
            .orElseGet(() -> crear(nuevoProyecto));
    }

    //Eliminar
    @DeleteMapping("{id}")
    void eliminar(@PathVariable(value = "id") long código){
        repositorio.deleteById(código);
    }

    //Crear
    @PostMapping()
    Proyecto crear(@RequestBody Proyecto nuevoProyecto){
        return repositorio.save(nuevoProyecto);
    }

}
