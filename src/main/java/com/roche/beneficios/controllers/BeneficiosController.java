package com.roche.beneficios.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/search/*")
public class BeneficiosController {
	
	@GetMapping("/")
	public ModelAndView index() {
		return new ModelAndView("/beneficios/index");
	}
}
