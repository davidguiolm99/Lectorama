package com.davidguiolm.app.lectorama.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davidguiolm.app.lectorama.entities.Autor;

public interface AutoresRepository extends JpaRepository<Autor, Integer> {

}
