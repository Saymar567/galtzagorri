package com.ipartek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.model.Categoria;
import com.ipartek.repository.CategoriaRepository;

@Service
public class CategoriaServiceImp implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepo;

	@Override
	public void insertarCategoria(Categoria cat) {
		categoriaRepo.save(cat);
	}

	@Override
	public void insertarCategoria(String cat) {
		categoriaRepo.save(new Categoria(0, cat));
	}

	@Override
	public void borrarCategoriaPorId(int id) {
		categoriaRepo.deleteById(id);
	}

	@Override
	public void modificarCategoria(Categoria cat) {
		categoriaRepo.save(cat);
	}

	@Override
	public List<Categoria> obtenerTodasCategorias() {
		return categoriaRepo.findAll();
	}

	@Override
	public Categoria obtenerCategoriaPorId(int id) {
		return categoriaRepo.getReferenceById(id);
	}

}
