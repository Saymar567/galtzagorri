package com.ipartek.service;

import java.util.List;

import com.ipartek.model.Prenda;

public interface PrendaService {
	public void insertarPrenda(Prenda pre);
	public void insertarPrenda(int id, String pre, double precio, String talla, String foto, int idCat, String cat);
	
	public void borrarPrendaPorId(int id);
	
	public void modificarPrenda(Prenda pre);
	
	public List<Prenda> obtenerTodasPrendas();
	
	public Prenda obtenerPrendaPorId(int id);
	
	
}
