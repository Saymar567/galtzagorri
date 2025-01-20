package com.ipartek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.model.Rol;
import com.ipartek.model.Usuario;
import com.ipartek.repository.UsuarioRepository;

@Service
public class UsuarioServiceImp implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepo;

	@Override
	public void insertarUsuario(Usuario usuario) {
		usuarioRepo.save(usuario);
	}

	@Override
	public void insertarUsuario(int id, String usuario, String pass, int idRol, String Rol) {
		usuarioRepo.save(new Usuario(id, usuario, pass, new Rol(idRol, Rol)));
	}

	@Override
	public void borrarUsuarioPorId(int id) {
		usuarioRepo.deleteById(id);

	}
	
	/**
	 * <b><p>PASARLE EL USUARIO CON EL ID Y TODOS LOS DATOS</p>
	 * <p>SI NO SE HACE ASI; CREA UNO NUEVO</p></b>
	 */
	@Override
	public void modificarUsuario(Usuario usuario) {
		usuarioRepo.save(usuario);
	}

	@Override
	public List<Usuario> obtenerTodosUsuarios() {	
		return usuarioRepo.findAll();
	}


	@Override
	public Usuario obtenerUsuarioPorId(int id) {
		return usuarioRepo.getReferenceById(id);
	}

	@Override
	public Usuario comprobarUsuarioValido(String usu, String pass) {
		return usuarioRepo.validarUsuario(usu, pass);
	}

}
