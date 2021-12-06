package com.psa.proyectos.modelos;
import javax.persistence.*;
import java.sql.Time;
import java.time.Duration;

@Entity
@Table(name="tareas")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long código;
    private String nombre;
    private String descripción;
    private Duration horasEstimadas;
    private int estado;
    private long códigoProyecto;
    private long AsignadaAEmpleado;

    public int getEstado() {
        return estado;
    }

    public long getCódigoProyecto() {
        return códigoProyecto;
    }

    public Duration getHorasEstimadas() {
        return horasEstimadas;
    }

    public String getNombre() {
        return nombre;
    }

    public long getCódigo() {
        return código;
    }

    public long getAsignadaAEmpleado() {
        return AsignadaAEmpleado;
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

    public void setHorasEstimadas(Duration horasEstimadas) {
        this.horasEstimadas = horasEstimadas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAsignadaAEmpleado(long asignadaAEmpleado) {
        AsignadaAEmpleado = asignadaAEmpleado;
    }
}
