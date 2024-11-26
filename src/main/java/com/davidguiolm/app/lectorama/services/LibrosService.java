package com.davidguiolm.app.lectorama.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.davidguiolm.app.lectorama.entities.Libro;
import com.davidguiolm.app.lectorama.repositories.LibrosRepository;
import com.davidguiolm.app.lectorama.services.exceptions.RegistroNotFoundException;

@Service
public class LibrosService implements CrudService<Libro> {
	
	private LibrosRepository repository;

	@Autowired
	public LibrosService(LibrosRepository repository) {
		this.repository = repository;
	}

	@Override
	public Libro consultar(Integer id) throws RegistroNotFoundException {
		return repository.findById(id).orElseThrow(RegistroNotFoundException::new);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Libro> consultarTodos() throws RegistroNotFoundException {
		List<Libro> libros = repository.findAll();
		if(libros.isEmpty()) throw new RegistroNotFoundException();
		return libros;
	}

	@Override
	@Transactional(readOnly = true)
	public Libro guardar(Libro registro) {
		return repository.save(registro);
	}

	@Override
	@Transactional
	public void actualizar(Libro registro) {
		repository.saveAndFlush(registro);
		
	}

	@Override
	@Transactional
	public void eliminar(Integer id) {
		repository.deleteById(id);
	}

}
