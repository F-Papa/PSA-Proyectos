package com.psa.proyectos.modelos;
import javax.persistence.*;

@Entity
@Table(name="proyectos")
public class Proyecto {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long código;
    private String nombre;
    private String descripción;
    private long legajoLíder;
    private int estado;

    public int getEstado() {
        return estado;
    }

    public long getLegajoLíder() {
        return legajoLíder;
    }

    public String getNombre() {
        return nombre;
    }

    public long getCódigo() {
        return código;
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

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public void setLegajoLíder(long legajoLíder) {
        this.legajoLíder = legajoLíder;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
