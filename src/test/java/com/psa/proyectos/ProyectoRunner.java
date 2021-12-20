package com.psa.proyectos;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/feature/CreacionProyectoTestBDD.feature"
)

public class ProyectoRunner { }
