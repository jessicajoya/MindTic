package com.ciclo3.udea;

import com.ciclo3.udea.modelos.Empresa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;


@SpringBootApplication(exclude ={SecurityAutoConfiguration.class})
public class UdeaApplication {


	@GetMapping("/hello")
	public String hello(){
		return "hola mundo ";
	}

	@GetMapping("/test")
	public String test(){
		Empresa emp = new Empresa("nombre de la empresa", "dirección","tel 4554645","nit 231231434");
		emp.setNombre("set empresa");
		return emp.getNombre();
	}

	public static void main(String[] args) {
		SpringApplication.run(UdeaApplication.class, args);
		System.out.println("Hola mundo");
	}

}
