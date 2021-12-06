package com.psa.proyectos.modelos;

public class Empleado {

    private long legajo;
    private String nombre;
    private float salario;


    public float getSalario() {
        return salario;
    }

    public long getLegajo() {
        return legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLegajo(long legajo) {
        this.legajo = legajo;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
}
