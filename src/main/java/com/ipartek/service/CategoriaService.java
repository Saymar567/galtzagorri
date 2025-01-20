package com.ipartek.service;

import java.util.List;

import com.ipartek.model.Categoria;

public interface CategoriaService {

	public void insertarCategoria(Categoria cat);
	public void insertarCategoria(String cat);
	
	public void borrarCategoriaPorId(int id);
	
	public void modificarCategoria(Categoria cat);
	
	public List<Categoria> obtenerTodasCategorias();
	
	public Categoria obtenerCategoriaPorId(int id);
	
}
