package com.psa.proyectos.modelos;
import javax.persistence.*;

@Entity
@Table(name="proyecto")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nombre;
    private String descripción;
    private int id_líder;
    private int estado;

    public Proyecto (Long id, String nombre, String descripción, int id_líder){
        this.id = id;
        this.nombre = nombre;
        this.descripción = descripción;
        this.id_líder = id_líder;
        this.estado = 0;
    }

    public int getEstado() {
        return estado;
    }

    public int getId_líder() {
        return id_líder;
    }

    public long getId() {
        return id;
    }

    public String getDescripción() {
        return descripción;
    }

}
