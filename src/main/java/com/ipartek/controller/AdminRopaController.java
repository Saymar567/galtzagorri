package com.ipartek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ipartek.model.Prenda;
import com.ipartek.service.CategoriaService;
import com.ipartek.service.PrendaService;

@Controller
public class AdminRopaController {
	
	@Autowired
	private PrendaService PrendaServ;
	
	@Autowired
	private CategoriaService categoriaServ;
	
	@RequestMapping("/AdminPrendaGuardar")
	public String adminPrendaGuardar(Model model, 
			@ModelAttribute("obj_prenda") Prenda prenda ) {
		
		PrendaServ.insertarPrenda(prenda);
		
		return "redirect:/MenuAdminRopa";
		
	}
	
	
	
	@RequestMapping("/AdminPrendaBorrar")
	public String adminPrendaBorrar(Model model, @RequestParam(value="id") int id) {
		
		PrendaServ.borrarPrendaPorId(id);
		
		return "redirect:/MenuAdminRopa";
	}
	
	

	@RequestMapping("/AdminPrendaFrmModificar")
	public String adminPrendaFrmModificar(Model model, @RequestParam(value="id") int id) {
		
		model.addAttribute("obj_prenda",PrendaServ.obtenerPrendaPorId(id) ) ;
		model.addAttribute("listaCategorias", categoriaServ.obtenerTodasCategorias() ) ;
		
		return "frm_modificar_ropa";
	}
	
	
	@RequestMapping("/AdminPrendaModificar")
	public String adminPrendaModificar(Model model, 
			@ModelAttribute("obj_prenda") Prenda prenda ) {
		
		PrendaServ.insertarPrenda(prenda);
		
		return "redirect:/MenuAdminRopa";
		
		
	}
	
	
	
	

}
