package com.psa.proyectos.modelos;

import javax.persistence.*;

@Entity
@Table(name="empleados")
public class Empleado {

    @Id
    private long legajo;

    private String nombre;
    private float salario;

    public Empleado(long legajo, String nombre, float salario){
        this.legajo = legajo;
        this.nombre = nombre;
        this.salario = salario;
    }

    public float getSalario() {
        return salario;
    }

    public long getLegajo() {
        return legajo;
    }

    public String getNombre() {
        return nombre;
    }
}
