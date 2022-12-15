package com.openbootcamp.ejercicio789;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.openbootcamp.ejercicio789.entities.Laptop;
import com.openbootcamp.ejercicio789.repository.LaptopRepository;

@SpringBootApplication
public class Ejercicio789Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Ejercicio789Application.class, args);
		Laptop laptop = new Laptop("Asus", "128 HDD");
		LaptopRepository laptopRepository = context.getBean(LaptopRepository.class);
		laptopRepository.save(laptop);
	}

}
