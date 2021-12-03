package com.psa.proyectos.repositorios;

import com.psa.proyectos.modelos.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioProyectos extends JpaRepository<Proyecto, Long> {

}
