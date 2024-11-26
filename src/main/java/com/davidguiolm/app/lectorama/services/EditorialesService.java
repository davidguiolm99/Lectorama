package com.davidguiolm.app.lectorama.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.davidguiolm.app.lectorama.entities.Editorial;
import com.davidguiolm.app.lectorama.repositories.EditorialesRepository;
import com.davidguiolm.app.lectorama.services.exceptions.RegistroNotFoundException;

@Service
public class EditorialesService implements CrudService<Editorial> {

	private EditorialesRepository repository;

	@Autowired
	public EditorialesService(EditorialesRepository repository) {
		this.repository = repository;
	}

	@Override
	public Editorial consultar(Integer id) throws RegistroNotFoundException {
		return repository.findById(id).orElseThrow(RegistroNotFoundException::new);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Editorial> consultarTodos() throws RegistroNotFoundException {
		List<Editorial> libros = repository.findAll();
		if(libros.isEmpty()) throw new RegistroNotFoundException();
		return libros;
	}

	@Override
	@Transactional(readOnly = true)
	public Editorial guardar(Editorial registro) {
		return repository.save(registro);
	}

	@Override
	@Transactional
	public void actualizar(Editorial registro) {
		repository.saveAndFlush(registro);
		
	}

	@Override
	@Transactional
	public void eliminar(Integer id) {
		repository.deleteById(id);
	}

}
