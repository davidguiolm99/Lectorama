package com.davidguiolm.app.lectorama.services;

import java.util.List;

import com.davidguiolm.app.lectorama.services.exceptions.RegistroNotFoundException;

public interface CrudService<T> {

	public T consultar(Integer id) throws RegistroNotFoundException;
	public List<T> consultarTodos() throws RegistroNotFoundException;
	public T guardar(T registro);
	public void actualizar(T registro);
	public void eliminar(Integer id);
	
}
