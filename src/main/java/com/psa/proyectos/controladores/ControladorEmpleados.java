package com.psa.proyectos.controladores;


import com.psa.proyectos.modelos.Empleado;
import com.psa.proyectos.modelos.Proyecto;
import com.psa.proyectos.repositorios.RepositorioEmpleados;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class ControladorEmpleados {

    private RepositorioEmpleados repositorio;

    ArrayList<Empleado> empleados = new ArrayList<>();

    //Listar
    @GetMapping("/empleados")
    List<Empleado> listarTodosLosEmpleados (){
        return repositorio.findAll();
    }

    //Buscar
    @GetMapping("empleados/{legajo}")
    Empleado uno(@PathVariable long legajo) throws Exception {
        return repositorio.findById(legajo)
                .orElseThrow(() -> new Exception());
    }

//    Actualizar
//    @PutMapping("/empleado/{id}")
//    Proyecto reemplazar(@RequestBody Empleado nuevoEmpleado, @PathVariable long legajo);


    //Eliminar
    @DeleteMapping("empleados/{legajo}")
    void eliminar(@PathVariable long legajo){
        repositorio.deleteById(legajo);
    }

    //Crear
    @PostMapping("/empleados")
    Empleado crear(@RequestBody HashMap<String, String> data){

        String nombre   = data.get("nombre");
        int legajo      = Integer.parseInt(data.get("legajo"));
        float salario   = Float.parseFloat(data.get("salario"));

        Empleado empleado = new Empleado(legajo, nombre, salario);
        return repositorio.save(empleado);
    }

}
