package com.example.gasolinera;

import controlador.GasController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import surtidores.Coche;

import java.security.Principal;

@SpringBootApplication
public class GasolineraApplication {

	public static void main(String[] args) {
		GasController gasController= new GasController();
		gasController.Principal();
	}

}
