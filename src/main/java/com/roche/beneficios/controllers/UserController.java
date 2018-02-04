package com.roche.beneficios.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.roche.beneficios.constants.ViewConstants;
import com.roche.beneficios.model.UserModel;
import com.roche.beneficios.services.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UserController {
	
	@Autowired
	@Qualifier("usuarioService")
	private UsuarioService usuarioService;
	@GetMapping("/new")
	public String mostrarFormularioReg(Model model) {
		model.addAttribute("usuario_reg", new UserModel());
		return ViewConstants.FORM_REGISTRO_USUARIOS;
	}
	@PostMapping("/registro")
	public String regitroUsuario(@ModelAttribute(name="usuario_reg") UserModel uModel) {
		uModel.setPassword(uModel.getUsername());
		uModel.setEnable(true);
		usuarioService.insertarUsuario(uModel);
		return "redirect:/empresas";
	}

}
