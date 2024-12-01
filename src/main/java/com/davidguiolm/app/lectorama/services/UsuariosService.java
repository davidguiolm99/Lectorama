package com.davidguiolm.app.lectorama.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.davidguiolm.app.lectorama.entities.Usuario;
import com.davidguiolm.app.lectorama.repositories.UsuariosRepository;
import com.davidguiolm.app.lectorama.services.exceptions.RegistroNotFoundException;

@Service
public class UsuariosService implements CrudService<Usuario> {

	 private UsuariosRepository repository;

	 @Autowired
	 public UsuariosService(UsuariosRepository repository) {
		 this.repository = repository;
	 }
	
	@Override
	@Transactional(readOnly = true)
	public Usuario consultar(Integer id) throws RegistroNotFoundException {
		return repository.findById(id).orElseThrow(RegistroNotFoundException::new);
	}
	
	@Transactional(readOnly = true)
	public Usuario consultarPorNombreUsuarioPassword(Usuario usuario) throws RegistroNotFoundException {
		return repository.findByNombreUsuarioAndPassword(usuario.getNombreUsuario(), usuario.getPassword())
				.orElseThrow(() -> new RegistroNotFoundException("No existe un usuario con esas credenciales"));

	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> consultarTodos() throws RegistroNotFoundException {
		List<Usuario> usuarios = repository.findAll();
		if(usuarios.isEmpty()) throw new RegistroNotFoundException();
		return usuarios;
	}

	@Override
	@Transactional
	public Usuario guardar(Usuario registro) {
		return repository.save(registro);
		
	}

	@Override
	@Transactional
	public void actualizar(Usuario registro) {
		repository.saveAndFlush(registro);
		
	}

	@Override
	@Transactional
	public void eliminar(Integer id) {
		repository.deleteById(id);
		
	}

}
