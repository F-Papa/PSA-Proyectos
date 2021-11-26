package com.psa.proyectos.rest;

import com.psa.proyectos.modelos.Proyecto;
import com.psa.proyectos.servicios.ProyectoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/proyecto")
public class ProyectoREST {

    @Autowired
    private ProyectoServicio proyectoServicio;

    @PostMapping
    private ResponseEntity<Proyecto> guardar (@RequestBody Proyecto proyecto){
        Proyecto temp = proyectoServicio.crear(proyecto);

        try{

            return ResponseEntity.created(new URI("api/proyecto"+temp.getId())).body(temp);

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    private ResponseEntity<List<Proyecto>> listarTodosLosProyecto (@RequestBody Proyecto proyecto){
        return ResponseEntity.ok(proyectoServicio.getProyectos());
    }

    @DeleteMapping
    private ResponseEntity<Void> eliminarProyecto (@RequestBody Proyecto proyecto){
        proyectoServicio.eliminar(proyecto);
        return ResponseEntity.ok().build();
    }
//
//    @GetMapping(value = "{id}")
//    private ResponseEntity<Optional<Proyecto>> getProyecto (@PathVariable("id") Long id){
//        return ResponseEntity.ok(proyectoServicio.getProyectoPorId(id));
//    }

}
