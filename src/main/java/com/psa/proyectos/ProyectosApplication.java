package com.psa.proyectos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ProyectosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectosApplication.class, args);
	}

}

//@RestController
//class HolaMundo {
//
//	@GetMapping("/")
//	String HolaMundo(){
//		return "Hola, Mundo";
//	}
//}