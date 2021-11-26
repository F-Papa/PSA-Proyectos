package com.psa.proyectos.servicios;

import com.psa.proyectos.modelos.Proyecto;
import com.psa.proyectos.repositorios.ProyectoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoServicio {

    @Autowired
    private ProyectoRepositorio proyectoRepositorio;

    public Proyecto crear(Proyecto proyecto){
        return proyectoRepositorio.save(proyecto);
    }

    public List<Proyecto> getProyectos(){
        return proyectoRepositorio.findAll();
    }

    public void eliminar(Proyecto proyecto){
        proyectoRepositorio.delete(proyecto);
    }

    public Proyecto getProyectoPorId(long id){
        return proyectoRepositorio.getById(id);
    }
}
