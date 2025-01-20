package com.ipartek.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.model.Usuario;
import com.ipartek.service.UsuarioService;

@Controller
public class AdminController {
	
	@Autowired
	private UsuarioService usuarioServ;
	
	@RequestMapping("/Login")
	public String cargarLogin(Model model) {
		model.addAttribute("obj_usuario", new Usuario());
		return "login";
	}
	
	@RequestMapping("/ComprobarLogin")
	public String verificarLogin(Model model, 
			@ModelAttribute("obj_usuario") Usuario obj_usuario) {
		
		obj_usuario.setPass(DigestUtils.sha256Hex(obj_usuario.getPass()));
		
		Usuario UsrTemp=usuarioServ.comprobarUsuarioValido(
				obj_usuario.getUsuario(),
				obj_usuario.getPass()
				);
		
		
		if (UsrTemp!=null) {
			return "redirect:/MenuAdminRopa";
		}else {
			return "login";
		}
		
	}

}
