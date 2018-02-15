package com.roche.beneficios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.roche.beneficios.constants.ViewConstants;
import com.roche.beneficios.model.BeneficioModel;
import com.roche.beneficios.services.BeneficiosService;
import com.roche.beneficios.services.CategoriasService;

@Controller
@RequestMapping("/beneficios")
public class BeneficiosController {
	@Autowired
	@Qualifier("beneficiosService")
	private BeneficiosService beneficiosService;
	
	@Autowired
	@Qualifier("categoriasService")
	private CategoriasService categoriasService;
	
	@GetMapping("")
	public String index() {
		return "redirect:/beneficios/search";
	}
	@GetMapping({"/search", "/search/{categoria}"})
	public String search(Model model, @PathVariable(name="categoria", required = false) String categoria) {
		List<BeneficioModel> listaBeneficios;
		
		if (categoria == null) {
			categoria = "todos";
			listaBeneficios = beneficiosService.listarBeneficios();
		} else {
			listaBeneficios = beneficiosService.listarBeneficios(categoria);
		}
		
		model.addAttribute("selectNavItem", "beneficios");
		model.addAttribute("ctgActual", categoria);
		model.addAttribute("lista_beneficios", listaBeneficios);
		model.addAttribute("categorias", categoriasService.listarCategorias());
		
		return ViewConstants.LISTAR_BENEFICIOS;
	}
	
}
