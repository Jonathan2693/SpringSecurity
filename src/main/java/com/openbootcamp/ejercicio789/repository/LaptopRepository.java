package com.openbootcamp.ejercicio789.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openbootcamp.ejercicio789.entities.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Integer> {

}
