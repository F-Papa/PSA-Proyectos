package com.psa.proyectos;

import com.psa.proyectos.modelos.Proyecto;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ProyectoSteps {

    Proyecto proyecto = new Proyecto();
    Proyecto proyectoEsperado;
    int miEstado;

    @Given("el usuario ingreso la informacion obligatoria")
    public void el_usuario_ingreso_la_informacion_obligatoria_sistema_de_inscripcion(String nombre) {
        proyecto.setNombre(nombre);
    }

    @When("indica que desea crear el proyecto")
    public void  que_el_usuario_quiere_crear_el_proyecto(){
        if( proyecto.getNombre() != "no_ingresado" ){
            String url = "https://psa-proyectos-12.herokuapp.com/proyectos";
            RestTemplate resTemplate = new RestTemplate();
            ResponseEntity<Proyecto> response = resTemplate.postForEntity(url, proyecto, Proyecto.class);
            this.proyectoEsperado = response.getBody();
            this.miEstado = response.getStatusCodeValue();
        }
    }

    @Then("El sistema crea el proyecto con la información ingresada y notifica al usuario.")
    public void el_sistema_crea_el_proyecto_con_la_información_ingresada_y_notifica_al_usuario() {
        Assert.assertEquals(200, miEstado);
    }

    @Given("que el usuario no ingresó la información obligatoria: Nombre del proyecto")
    public void que_el_usuario_no_ingresó_la_información_obligatoria_nombre_del_proyecto(String nombre) {
        proyecto.setNombre(nombre);
    }

    @Then("El sistema no crea el proyecto e informa al usuario que debe ingresar la información obligatoria.")
    public void el_sistema_no_crea_el_proyecto_e_informa_al_usuario_que_debe_ingresar_la_información_obligatoria() throws IOException {
            URL url = new URL("https://psa-proyectos-12.herokuapp.com/proyectos/00000");
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            int statusCode = http.getResponseCode();
            Assert.assertEquals(404, statusCode);
    }

    @Given("que el usuario ingresó además de la obligatoria la información opcional, {string} , {int} , {int}")
    public void que_el_usuario_ingresó_además_de_la_obligatoria_la_información_opcional_descripción_líder_y_fecha_de_comienzo(String nombre, long legajoLider, int estado) {
        proyecto.setNombre(nombre);
        proyecto.setLegajoLíder(legajoLider);
        proyecto.setEstado(estado);
    }
}
