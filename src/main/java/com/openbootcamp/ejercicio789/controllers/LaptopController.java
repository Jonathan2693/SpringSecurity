package com.openbootcamp.ejercicio789.controllers;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openbootcamp.ejercicio789.entities.Laptop;
import com.openbootcamp.ejercicio789.repository.LaptopRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/laptop")
@ApiOperation(value = "Api de laptops")
public class LaptopController {

	private LaptopRepository laptopRepository;
	
	public LaptopController(@Autowired LaptopRepository laptopRepository) {
		this.laptopRepository = laptopRepository;
	}
	
	@GetMapping("/all")
	@ApiResponses(value = { @ApiResponse(message = "Respuesta correcta", code = 200) ,
							@ApiResponse(message = "No hay elementos encontrados", code = 204) 
							})
	public ResponseEntity<List<Laptop>> findAll(){
		List<Laptop> out = laptopRepository.findAll();
		return out.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(out);
	}
	
	@GetMapping("/{id}")
	@ApiResponses(value = { @ApiResponse(message = "Elemento encontrado", code = 200) ,
							@ApiResponse(message = "No hay elementos encontrados", code = 204) 
							})
	public ResponseEntity<Laptop> findOneById(@PathVariable("id") int id){
		Optional<Laptop> out = laptopRepository.findById(id);
		return out.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(out.get());
	}
	
	@PostMapping
	@ApiResponse(message = "Objeto creado correctamente", code = 200)
	public ResponseEntity<String> create(@RequestBody Laptop laptop) {
		laptopRepository.save(laptop);
		return ResponseEntity.ok("Objeto creado correctamente");
	}
	
	@PutMapping("/update")
	@ApiResponses(value = { @ApiResponse(message = "Objeto modificado correctamente", code = 200) ,
			@ApiResponse(message = "No hay elementos encontrados", code = 204) 
			})
	public ResponseEntity<String> update(@RequestBody Laptop laptop) {
		Optional<Laptop> out = laptopRepository.findById(laptop.getId());
		if(!out.isEmpty()) {
			laptopRepository.save(new Laptop(out.get().getId(),laptop.getMarca(),laptop.getMemoria()));
			return ResponseEntity.ok("Objeto modificado correctamente");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id){
		laptopRepository.deleteById(id);
		return ResponseEntity.ok("Elemento borrado correctamente");
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteAll(){
		laptopRepository.deleteAll();
		return ResponseEntity.ok("Elementos borrados correctamente");
	}
}
