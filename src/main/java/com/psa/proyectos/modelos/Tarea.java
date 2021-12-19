package com.psa.proyectos.modelos;
import javax.persistence.*;
import java.time.Duration;
import java.util.Objects;

@Entity
@Table(name="tareas")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long código;
    private String nombre;
    private String descripción;
    private int duraciónEstimada;
    private int estado;
    private long códigoProyecto;
    private long asignadaAEmpleado;

    public int getEstado() {
        return estado;
    }

    public long getCódigoProyecto() {
        return códigoProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDuraciónEstimada() {
        return duraciónEstimada;
    }

    public long getCódigo() {
        return código;
    }

    public long getAsignadaAEmpleado() {
        return asignadaAEmpleado;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setCódigo(long código) {
        this.código = código;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setCódigoProyecto(long códigoProyecto) {
        this.códigoProyecto = códigoProyecto;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public void setDuraciónEstimada(int duraciónEstimada) {
        this.duraciónEstimada = duraciónEstimada;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAsignadaAEmpleado(long asignadaAEmpleado) {
        this.asignadaAEmpleado = asignadaAEmpleado;
    }

    public boolean esIgual(Tarea otraTarea) {
        boolean esIgual = true;

        if (this.nombre.compareTo(otraTarea.nombre) != 0)
            esIgual = false;

        if (this.estado != otraTarea.estado)
            esIgual = false;

        if (!Objects.equals(this.descripción, otraTarea.descripción))
            esIgual = false;

        if (this.asignadaAEmpleado != otraTarea.asignadaAEmpleado)
            esIgual = false;

        if (this.duraciónEstimada != otraTarea.duraciónEstimada)
            esIgual = false;

        return esIgual;
    }
}
