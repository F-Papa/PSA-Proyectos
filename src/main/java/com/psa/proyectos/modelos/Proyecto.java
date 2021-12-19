package com.psa.proyectos.modelos;
import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

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
    private Date fechaDeComienzo;

//    public Proyecto(){
//
//    }
//
//    public Proyecto(String nombre, String descripción, long legajoLíder, String fechaDeComienzo){
//        this.nombre = nombre;
//        this.descripción = descripción;
//        this.legajoLíder = legajoLíder;
//        if (fechaDeComienzo != null)
//        this.fechaDeComienzo = Date.valueOf(fechaDeComienzo);
//    }
//
//    public String getFechaDeComienzoString(){
//        return fechaDeComienzo.toString();
//    }

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

    public Date getFechaDeComienzo() {
        return fechaDeComienzo;
    }

    public void setFechaDeComienzo(Date fechaDeComienzo) {
        this.fechaDeComienzo = fechaDeComienzo;
    }

    public boolean esIgualA(Proyecto otroProyecto){
        boolean esIgual = true;

        if (!Objects.equals(this.nombre, otroProyecto.nombre))
            esIgual = false;

        if (this.estado != otroProyecto.estado)
            esIgual = false;

        if (!Objects.equals(this.descripción, otroProyecto.descripción))
            esIgual = false;

        if (this.legajoLíder != otroProyecto.legajoLíder)
            esIgual = false;

        if (this.fechaDeComienzo != null){
            if (this.fechaDeComienzo.compareTo(otroProyecto.fechaDeComienzo) != 0)
                esIgual = false;
        }
        else if (otroProyecto.fechaDeComienzo != null)
                esIgual = false;

        return esIgual;
    }
}
