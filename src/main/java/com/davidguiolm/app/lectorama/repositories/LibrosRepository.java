package com.davidguiolm.app.lectorama.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davidguiolm.app.lectorama.entities.Libro;

public interface LibrosRepository extends JpaRepository<Libro, Integer> {

}
