package com.psa.proyectos;

import com.psa.proyectos.modelos.Proyecto;

import io.cucumber.java.en.*;
import io.cucumber.junit.Cucumber;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RunWith(Cucumber.class)
public class AsignarLiderSteps {

    Proyecto proyecto = new Proyecto();
    Proyecto proyectoEsperado;
    private int legajoLider;
    int miEstado;
    String url = "https://psa-proyectos-12.herokuapp.com/proyectos";
    RestTemplate resTemplate = new RestTemplate();

    @Given("existe un proyecto")
    public void existeUnProyecto() {
        Assert.assertNotNull(proyecto);
    }

    @But("no tiene lider")
    public void noTieneLider() {
        Assert.assertEquals(0, proyecto.getLegajoLíder());
    }

    @When("indica que desea agregarlo en forma de lider {int}")
    public void indicaQueDeseaAgregarloEnFormaDeLider(int legajoLider) {
        this.legajoLider = legajoLider;
        proyecto.setNombre("SistemaDeInscripcion");
        proyecto.setLegajoLíder(legajoLider);
        ResponseEntity<Proyecto> response = resTemplate.postForEntity(url, proyecto, Proyecto.class);
        this.proyectoEsperado = response.getBody();
        this.miEstado = response.getStatusCodeValue();
    }

    @Then("el sistema agrega al usuario seleccionado al proyecto en forma de lider")
    public void elSistemaAgregaAlUsuarioSeleccionadoAlProyectoEnFormaDeLider() {
        Assert.assertEquals(proyecto.getLegajoLíder(), legajoLider);
        resTemplate.delete( url+ "/" + proyectoEsperado.getCódigo());
    }

    @And("el sistema le informa al usuario")
    public void elSistemaLeInformaAlUsuario() { Assert.assertEquals(200, miEstado); }

    @And("el sistema le informa a quién lo agrego del exito")
    public void elSistemaLeInformaAQuiénLoAgregoDelExito() {Assert.assertEquals(200, miEstado); }

    @And("tiene lider")
    public void tieneLider(){ Assert.assertNotNull(proyecto.getLegajoLíder()); }

    @Then("el sistema le informa a quién lo agrego que el proyecto ya tiene lider")
    public void elSistemaLeInformaAQuiénLoAgregoQueElProyectoYaTieneLider() {
        Assert.assertEquals(200, miEstado);
        resTemplate.delete( url+ "/" + proyectoEsperado.getCódigo());
    }

}
