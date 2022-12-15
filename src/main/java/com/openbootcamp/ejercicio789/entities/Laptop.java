package com.openbootcamp.ejercicio789.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="laptops")
@ApiModel(description = "Entidad modelo de la API Laptops")
public class Laptop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(name = "id",required = true, value = "Id automático")
	private int id;
	@ApiModelProperty(name = "marca",required = true, value = "Marca de Laptop")
	private String marca;
	@ApiModelProperty(name = "memoria",required = true, value = "Memoria de disco")
	private String memoria;
	
	public Laptop() {
	}
	
	public Laptop(String marca, String memoria) {
		this.marca = marca;
		this.memoria = memoria;
	}
	
	public Laptop(int id ,String marca, String memoria) {
		this.id = id;
		this.marca = marca;
		this.memoria = memoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMemoria() {
		return memoria;
	}

	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}

	@Override
	public String toString() {
		return "Laptop [id=" + id + ", marca=" + marca + ", memoria=" + memoria + "]";
	}
	
	
}

