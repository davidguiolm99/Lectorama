package com.davidguiolm.app.lectorama.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davidguiolm.app.lectorama.entities.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

	Optional<Usuario> findByNombreUsuarioAndPassword(String nombreUsuario, String password);
	
}
