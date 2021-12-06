package com.psa.proyectos.repositorios;

import com.psa.proyectos.modelos.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioTareas extends JpaRepository<Tarea, Long> {
}
