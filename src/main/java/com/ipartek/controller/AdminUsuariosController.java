package com.ipartek.controller;





import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ipartek.model.Usuario;
import com.ipartek.service.RolService;
import com.ipartek.service.UsuarioService;

@Controller
public class AdminUsuariosController {
	
	@Autowired
	private UsuarioService usuarioServ;
	
	@Autowired
	private RolService rolServ;
	
	@RequestMapping("/AdminUsuariosGuardar")
	public String guardarUsuario (Model model, 
			@ModelAttribute("obj_usuario") Usuario obj_usuario) {
		
			String PassEncriptada = DigestUtils.sha256Hex(obj_usuario.getPass());
			
			obj_usuario.setPass(PassEncriptada);
			
			usuarioServ.insertarUsuario(obj_usuario);
		
		return "redirect:/MenuAdminUsuarios";
	}
	
	@RequestMapping("/AdminUsuariosBorrar")
	public String borrarUsuario (Model model, @RequestParam(value="id") int id) {
		
		usuarioServ.borrarUsuarioPorId(id);
		
		return "redirect:/MenuAdminUsuarios";
	
	}
	
	@RequestMapping("/AdminUsuariosFrmModificar")
	public String frmModificarUsuario (Model model, @RequestParam(value="id") int id) {
		
		Usuario user=usuarioServ.obtenerUsuarioPorId(id);
		user.setPass("");
		
		
		model.addAttribute("obj_usuario",user );
		model.addAttribute("listaRoles", rolServ.obtenerTodosRoles());
		return "frm_modificar_usuario";
	
	}
	
	@RequestMapping("/AdminUsuariosModificar")
	public String modificarUsuario(Model model, 
			@ModelAttribute("obj_usuario") Usuario obj_usuario) {
		
		Usuario usrTemp=usuarioServ.obtenerUsuarioPorId(obj_usuario.getId());
		
		if (obj_usuario.getPass()=="") {
			//modificar en la BD con la contraseña vieja
			obj_usuario.setPass(usrTemp.getPass());
			
			usuarioServ.modificarUsuario(obj_usuario);
		}else {
			//modificar en la BD con la contraseña nueva, pero encriptandola
			String passSinEncr=obj_usuario.getPass();
		
			String PassEncriptada = DigestUtils.sha256Hex(passSinEncr);
			
			obj_usuario.setPass(PassEncriptada);
			
			usuarioServ.modificarUsuario(obj_usuario);
		
		}
		
		
		return "redirect:/MenuAdminUsuarios";
	}

}
