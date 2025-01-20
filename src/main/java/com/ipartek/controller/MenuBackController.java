package com.ipartek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.model.Prenda;
import com.ipartek.model.Usuario;
import com.ipartek.service.CategoriaService;
import com.ipartek.service.PrendaService;
import com.ipartek.service.RolService;
import com.ipartek.service.UsuarioService;

@Controller
public class MenuBackController {
	
	@Autowired
	private CategoriaService categoriaServ;
	
	@Autowired
	private RolService rolServ;
	
	@Autowired
	private UsuarioService usuarioServ;
	
	@Autowired
	private PrendaService prendaServ;
	
	@RequestMapping("/MenuAdminRopa")
	public String cargarAdminRopa(Model model) {
		model.addAttribute("obj_prenda",new Prenda());
		model.addAttribute("listaCategorias", categoriaServ.obtenerTodasCategorias());
		model.addAttribute("listaPrendas", prendaServ.obtenerTodasPrendas());
		return "admin_ropa";
	}
	
	@RequestMapping("/MenuAdminCategorias")
	public String cargarAdminCategorias() {
		return "admin_categorias";
	}
	
	@RequestMapping("/MenuAdminUsuarios")
	public String cargarAdminUsuarios(Model model) {
		
	model.addAttribute("obj_usuario",new Usuario());	
	model.addAttribute("listaRoles", rolServ.obtenerTodosRoles());
	model.addAttribute("listaUsuarios",usuarioServ.obtenerTodosUsuarios());
	
	
		return "admin_usuarios";
	}
	

}
