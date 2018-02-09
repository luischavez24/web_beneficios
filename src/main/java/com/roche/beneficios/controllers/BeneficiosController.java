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

@Controller
@RequestMapping("/beneficios")
public class BeneficiosController {
	@Autowired
	@Qualifier("beneficiosService")
	private BeneficiosService beneficiosService;
	
	@GetMapping("")
	public String index() {
		return "redirect:/beneficios/search";
	}
	@GetMapping("/search")
	public String search(Model model) {
		
		List<BeneficioModel> listaBeneficios = beneficiosService.listarBeneficios();
		
		System.out.println(listaBeneficios);
		model.addAttribute("lista_beneficios", listaBeneficios);
		
		return ViewConstants.LISTAR_BENEFICIOS;
	}
	
}
