package com.ipartek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuFrontController {
	
	@RequestMapping("/MenuMujer")
	public String cargarRopaMujer() {
		return "index";
	}
	
	@RequestMapping("/MenuHombre")
	public String cargarRopaHombre() {
		return "hombre";
	}
	
	@RequestMapping("/MenuInfantil")
	public String cargarRopaInfantil() {
		return "infantil";
	}
}
