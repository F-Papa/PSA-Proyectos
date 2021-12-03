package com.psa.proyectos.repositorios;

import com.psa.proyectos.modelos.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioEmpleados extends JpaRepository<Empleado, Long> {
}
