package com.davidguiolm.app.lectorama.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "libros")
public class Libro {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	@Column(name = "titulo")
	protected String titulo;
	@Column(name = "num_paginas")
	protected Integer numPaginas;
	
	@ManyToMany(mappedBy = "libros", cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH}, fetch = FetchType.LAZY)
	protected List<Usuario> lectores;
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH}, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_autor")
	protected Autor autor;
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH}, fetch = FetchType.EAGER)
	@JoinTable(name = "libros_generos",
			joinColumns = @JoinColumn(name = "id_libro"),
			inverseJoinColumns = @JoinColumn(name = "id_genero")
	)
	protected List<Genero> generos;
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH}, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_editorial")
	protected Editorial editorial;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Integer getNumPaginas() {
		return numPaginas;
	}
	public void setNumPaginas(Integer numPaginas) {
		this.numPaginas = numPaginas;
	}
	public List<Usuario> getLectores() {
		return lectores;
	}
	public void setLectores(List<Usuario> lectores) {
		this.lectores = lectores;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public List<Genero> getGeneros() {
		return generos;
	}
	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}
	public Editorial getEditorial() {
		return editorial;
	}
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	
	public void addGenero(Genero genero) {
		if(generos == null) {
			generos = new ArrayList<>();
		}
		generos.add(genero);
	}
}
