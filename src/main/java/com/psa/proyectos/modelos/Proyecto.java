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
    private long legajo_líder;
    private int estado;

    public Proyecto (long código, String nombre, String descripción, long legajo_líder, int estado){
        this.código = código;
        this.nombre = nombre;
        this.descripción = descripción;
        this.legajo_líder = Proyecto.this.legajo_líder;
        this.estado = estado;
    }

    public Proyecto (String nombre, String descripción, long legajo_líder){
        this.nombre = nombre;
        this.descripción = descripción;
        this.legajo_líder = legajo_líder;
        this.estado = 0;
    }

    public int getEstado() {
        return estado;
    }

    public long getLegajoLíder() {
        return legajo_líder;
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

    public void setLegajo_líder(long legajo_líder) {
        this.legajo_líder = legajo_líder;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
