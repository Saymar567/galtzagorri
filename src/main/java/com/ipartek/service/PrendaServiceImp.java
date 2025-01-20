package com.ipartek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.model.Categoria;
import com.ipartek.model.Prenda;
import com.ipartek.repository.PrendaRepository;

@Service
public class PrendaServiceImp implements PrendaService{

	
	@Autowired
	private PrendaRepository prendaRepo;
	@Override
	public void insertarPrenda(Prenda pre) {
		prendaRepo.save(pre);
		
	}

	@Override
	public void insertarPrenda(int id, String pre, double precio, 
			String talla, String foto, int idCat, String cat) {
		prendaRepo.save(new Prenda(id, pre, precio, talla, foto, 
				new Categoria(idCat, cat)));	
	}

	@Override
	public void borrarPrendaPorId(int id) {
		prendaRepo.deleteById(id);
		
	}

	@Override
	public void modificarPrenda(Prenda pre) {
		prendaRepo.save(pre);
	}

	@Override
	public List<Prenda> obtenerTodasPrendas() {
		return prendaRepo.findAll();
	}

	@Override
	public Prenda obtenerPrendaPorId(int id) {
		return prendaRepo.getReferenceById(id);
	}

}
