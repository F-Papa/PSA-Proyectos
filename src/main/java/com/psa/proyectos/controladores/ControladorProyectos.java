package com.psa.proyectos.controladores;

import com.psa.proyectos.modelos.Proyecto;
import com.psa.proyectos.repositorios.RepositorioProyectos;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class    ControladorProyectos {

    private final RepositorioProyectos repositorio;

    ControladorProyectos(RepositorioProyectos repositorio){
        this.repositorio = repositorio;
    }

    //Demo de cómo hacer una POST Request desde Spring
    @GetMapping("/proyectos/demoPost")
    void crearProyectosPrueba() {
        final String uri = "http://localhost:8080/proyectos";

        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> data = new HashMap<>();
        data.put("nombre", "2FA Clientes");
        data.put("descripción", "2FA para Clientes en la página.");
        data.put("legajo_líder", "10");

        ResponseEntity<Void> response = restTemplate.postForEntity(uri, data, Void.class);

        if (response.getStatusCode() == HttpStatus.OK){
            System.out.println("Request Successful");
        } else {
            System.out.println("Request Failed");
        }
    }

    //Listar
    @GetMapping("/proyectos")
    List<Proyecto> listarTodosLosProyecto (){
        return repositorio.findAll();
    }

    //Buscar
    @GetMapping("proyectos/{id}")
    Proyecto uno(@PathVariable long código) throws Exception {
        return repositorio.findById(código)
                .orElseThrow(Exception::new);
    }

//    Actualizar
//    @PutMapping("/proyectos/{id}")
//    Proyecto reemplazar(@RequestBody Proyecto nuevoProyecto, @PathVariable long código) throws Exception {
//
//        return repositorio.findById(código).map(proyecto -> {
//            proyecto.setLegajo_líder(nuevoProyecto.getLegajoLíder());
//            proyecto.setDescripción(nuevoProyecto.getDescripción());
//            proyecto.setEstado(nuevoProyecto.getEstado());
//            proyecto.setNombre(nuevoProyecto.getNombre());
//            return repositorio.save(proyecto);
//        })
//            .orElseGet(() -> {
//                nuevoProyecto.setCódigo(código);
//                return repositorio.save(nuevoProyecto);
//            });
//    }

    //Eliminar
    @DeleteMapping("proyectos/{id}")
    void eliminar(@PathVariable long código){
        repositorio.deleteById(código);
    }

    //Crear
    @PostMapping("/proyectos")
    Proyecto nuevoProyecto(@RequestBody HashMap<String, String> data){
        String nombre = data.get("nombre");
        String descripción = data.get("descripción");
        long legajo_líder = Long.parseLong(data.get("legajo_líder"));

        System.out.println("Nombre: "+nombre);
        System.out.println("Descripción: "+descripción);
        System.out.println("Líder: "+legajo_líder);

        Proyecto proyecto = new Proyecto(nombre, descripción, legajo_líder);
        System.out.println("--------");
        System.out.println("Nombre: "+proyecto.getNombre());
        System.out.println("Descripción: "+proyecto.getDescripción());
        System.out.println("Líder: "+ proyecto.getLegajoLíder());
//        proyecto = new Proyecto("El nombre", "La Desc", 10);

//        Proyecto proyecto = new Proyecto("Nombre", "Desc", 10);
        return repositorio.save(proyecto);
    }

}
