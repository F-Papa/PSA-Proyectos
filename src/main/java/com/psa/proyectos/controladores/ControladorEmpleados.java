package com.psa.proyectos.controladores;

import com.psa.proyectos.modelos.Empleado;
import com.psa.proyectos.repositorios.RepositorioTareas;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("empleados")
public class ControladorEmpleados {

    //Listar empleados
    @GetMapping()
    ResponseEntity<List<Empleado>> listarTodosLosProyecto (){
        String url = "http://psa-recursos-2021-2c.herokuapp.com/api/worker";
        RestTemplate restTemplate = new RestTemplate();
        List<Empleado> resultado = restTemplate.getForObject(url, List.class);
        return ResponseEntity.status(200).body(resultado);
    }
}
