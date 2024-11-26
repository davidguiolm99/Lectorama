package com.davidguiolm.app.lectorama.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.davidguiolm.app.lectorama.entities.Genero;
import com.davidguiolm.app.lectorama.repositories.GenerosRepository;
import com.davidguiolm.app.lectorama.services.exceptions.RegistroNotFoundException;

@Service
public class GenerosService implements CrudService<Genero> {

	private GenerosRepository repository;

	@Autowired
	public GenerosService(GenerosRepository repository) {
		this.repository = repository;
	}

	@Override
	public Genero consultar(Integer id) throws RegistroNotFoundException {
		return repository.findById(id).orElseThrow(RegistroNotFoundException::new);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Genero> consultarTodos() throws RegistroNotFoundException {
		List<Genero> libros = repository.findAll();
		if(libros.isEmpty()) throw new RegistroNotFoundException();
		return libros;
	}

	@Override
	@Transactional(readOnly = true)
	public Genero guardar(Genero registro) {
		return repository.save(registro);
	}

	@Override
	@Transactional
	public void actualizar(Genero registro) {
		repository.saveAndFlush(registro);
		
	}

	@Override
	@Transactional
	public void eliminar(Integer id) {
		repository.deleteById(id);
	}

}
