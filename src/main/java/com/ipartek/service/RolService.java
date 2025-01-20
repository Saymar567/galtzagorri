package com.ipartek.service;

import java.util.List;

import com.ipartek.model.Rol;

public interface RolService {
	
	public void insertarRol(Rol rol);
	public void insertarRol(String rol);
	
	public void borrarRolPorId(int id);
	
	public void modificarRol(Rol rol);
	
	public List<Rol> obtenerTodosRoles();
	
	public Rol obtenerRolPorId(int id);
	

}
