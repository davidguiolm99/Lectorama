package com.davidguiolm.app.lectorama.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.davidguiolm.app.lectorama.entities.Autor;
import com.davidguiolm.app.lectorama.repositories.AutoresRepository;
import com.davidguiolm.app.lectorama.services.exceptions.RegistroNotFoundException;

@Service
public class AutoresService implements CrudService<Autor> {

	private AutoresRepository repository;

	@Autowired
	public AutoresService(AutoresRepository repository) {
		this.repository = repository;
	}

	@Override
	public Autor consultar(Integer id) throws RegistroNotFoundException {
		return repository.findById(id).orElseThrow(RegistroNotFoundException::new);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Autor> consultarTodos() throws RegistroNotFoundException {
		List<Autor> libros = repository.findAll();
		if(libros.isEmpty()) throw new RegistroNotFoundException();
		return libros;
	}

	@Override
	@Transactional(readOnly = true)
	public Autor guardar(Autor registro) {
		return repository.save(registro);
	}

	@Override
	@Transactional
	public void actualizar(Autor registro) {
		repository.saveAndFlush(registro);
		
	}

	@Override
	@Transactional
	public void eliminar(Integer id) {
		repository.deleteById(id);
	}

}
