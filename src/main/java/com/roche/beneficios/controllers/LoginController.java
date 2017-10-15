package com.roche.beneficios.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/adm")
public class LoginController {
	@GetMapping("/")
	public String index() {
		return "redirect:/adm/login";
	}
	@GetMapping("/login")
	public String showLoginPage() {
		return "/start/index";
	}
}
