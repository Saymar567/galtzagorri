package com.ipartek.service;

import java.util.List;

import com.ipartek.model.Rol;
import com.ipartek.model.Usuario;

public interface UsuarioService {

	
	public void insertarUsuario(Usuario usuario);
	public void insertarUsuario(int id, String usuario, String pass, int idRol, String Rol);
	
	public void borrarUsuarioPorId(int id);
	
	public void modificarUsuario(Usuario usuario);
	
	public List<Usuario> obtenerTodosUsuarios();
	
	public Usuario obtenerUsuarioPorId(int id);
	
	public Usuario comprobarUsuarioValido(String usu, String pass);

}
