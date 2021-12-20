package com.psa.proyectos;

import com.psa.proyectos.modelos.Tarea;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EstadoTareaSteps {

    @LocalServerPort
    private RestTemplate restTemplate = new RestTemplate();
    private String Url = "https://psa-proyectos-12.herokuapp.com/tareas";
    private long codigo_tarea;


    @Given("se seleccionó una tarea")
    public void seSeleccionóUnaTarea(long codigo_tarea) { this.codigo_tarea = codigo_tarea ; }

    @When("indica que desea conocer su estado")
    public void indicaQueDeseaConocerSuEstado() {
        String url = Url;
        List allProyecto = restTemplate.getForObject(url, List.class);
    }

    @Then("el sistema informa al usuario cuál es el estado de la misma")
    public void elSistemaInformaAlUsuarioCuálEsElEstadoDeLaMisma() {
        String url = Url+"/"+codigo_tarea;
        Map<String, String> urlParams = new HashMap<>(1);
        urlParams.put("id", String.valueOf(codigo_tarea));
        Tarea miTarea = restTemplate.getForObject(url, Tarea.class, urlParams);

        assertNotNull(miTarea.getEstado());
    }

}
