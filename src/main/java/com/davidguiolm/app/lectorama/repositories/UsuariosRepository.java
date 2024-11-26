package com.davidguiolm.app.lectorama.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davidguiolm.app.lectorama.entities.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

}
