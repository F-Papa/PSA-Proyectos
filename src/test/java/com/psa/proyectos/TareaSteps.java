package com.psa.proyectos;

import com.psa.proyectos.modelos.Tarea;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class TareaSteps {

    Tarea tarea = new Tarea();
    Tarea tareaEsperada;
    int miEstado;

    @Given("que el usuario ingresó la información obligatoria: nombre de la tarea")
    public void queElUsuarioIngresóUnNombreParaLaTarea(String nombre) {
        tarea.setNombre(nombre);
    }

    @And("el proyecto al que pertenecerá")
    public void elProyectoAlQuePertenecerá(long codigo_proyecto) { tarea.setCódigoProyecto(codigo_proyecto); }

    @When("el usuario indica que desea crearla")
    public void elUsuarioIndicaQueDeseaCrearla() {
        if( tarea.getNombre() != "no_ingresado" ) {
            String url = "https://psa-proyectos-12.herokuapp.com/tareas";
            RestTemplate resTemplate = new RestTemplate();
            ResponseEntity<Tarea> response = resTemplate.postForEntity(url, tarea, Tarea.class);
            this.tareaEsperada = response.getBody();
            this.miEstado = response.getStatusCodeValue();
        } else {
            miEstado = 404;
        }
    };

    @Then("el sistema registra la tarea")
    public void elSistemaRegistraLaTarea() {
        Assert.assertEquals(200, miEstado);
    }

    @And("la vincula al proyecto ingresado")
    public void laVinculaAlProyectoIngresado(long codigo_proyecto) {
        Assert.assertEquals(tarea.getCódigoProyecto(), codigo_proyecto);
    }

    @And("informa a quienes fueron agregados")
    public void informaAQuienesFueronAgregados() {
        Assert.assertEquals(200, miEstado);
    }

    @And("informa a quien la creo del exito")
    public void informaAQuienLaCreoDelExito() {
        Assert.assertEquals(200, miEstado);
    }

    @But("no el proyecto al que pertenecerá")
    public void noElProyectoAlQuePertenecerá(String nombre_proyecto) {
        tarea.setNombre(nombre_proyecto);
    }

    @Then("El sistema no registra la tarea e informa al usuario que debe ingresar la información obligatoria")
    public void elSistemaNoRegistraLaTarea() throws IOException {
        URL url = new URL("https://psa-proyectos-12.herokuapp.com/tareas/00000");
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        int statusCode = http.getResponseCode();
        Assert.assertEquals(404, statusCode);
    }

    @And("informa a quien la creo de la nesesidad de vincularla a un proyecto")
    public void informaAQuienLaCreoDeLaNesesidadDeVincularlaAUnProyecto() { }


    @Given("que el usuario ingresó además de la obligatoria la información opcional: {string} , {int} , {int}, {string}")
    public void que_el_usuario_ingresó_además_de_la_obligatoria_la_información_opcional_empleado_asignado_duración_estimada_y_descripción(
            String nombre, int empleado, int duracion_estimada,  String descripcion) {
            tarea.setNombre(nombre);
            tarea.setAsignadaAEmpleado(empleado);
            tarea.setDuraciónEstimada(duracion_estimada);
            tarea.setDescripción(descripcion);
    }

    @Then("El sistema registra la tarea con la información ingresada y notifica al usuario")
    public void el_sistema_registra_la_tarea_con_la_información_ingresada_y_notifica_al_usuario() {
            Assert.assertEquals(200, miEstado);
    }

}
