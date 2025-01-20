package com.ipartek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.model.Rol;
import com.ipartek.repository.RolRepository;

@Service
public class RolServiceImp implements RolService{

	@Autowired
	private RolRepository rolRepo;
	
	
	@Override
	public void insertarRol(Rol rol) {
		rolRepo.save(rol);
	}

	@Override
	public void insertarRol(String rol) {
		//insertarRol(new Rol(0, rol));
		rolRepo.save(new Rol(0, rol));
	}

	@Override
	public void borrarRolPorId(int id) {
		rolRepo.deleteById(id);
	}

	/**
	 * <p>PASARLE EL ROL CON EL ID Y EL NOMBRE DEL ROL</p>
	 * <p>SI NO SE HACE ASI; CREA UNO NUEVO</p>
	 */
	@Override
	public void modificarRol(Rol rol) {
		rolRepo.save(rol);
		
	}

	@Override
	public List<Rol> obtenerTodosRoles() {
		return rolRepo.findAll();
	}

	@Override
	public Rol obtenerRolPorId(int id) {
		return rolRepo.getReferenceById(id);
	}

}
