package com.roche.beneficios.controllers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.roche.beneficios.constants.ViewConstants;
import com.roche.beneficios.model.ContactoModel;
import com.roche.beneficios.services.ContactosService;

@Controller
@RequestMapping("/contactos")
public class ContactosController {
	
	private static final Log LOG = LogFactory.getLog(ContactosController.class);

	@Autowired
	@Qualifier("contactosService")
	private ContactosService contactosService;
	
	@GetMapping("")
	public String index () {
		LOG.info("Redirigiendo a la página principal");
		// Redireccion al controlador de busquedas con los campos vacios
		return "redirect:/contactos/search?campo";
	}
	
	
	@GetMapping("/search")
	public String search(Model model,
			@RequestParam(name="busq", required = false) String busq) {
		
		// Crea una lista para llenar los datos buscados
		
		List<ContactoModel> listaModel = null;
		
		listaModel = contactosService.listContactos();
		
		model.addAttribute("contactos", listaModel);
		
		return ViewConstants.LISTAR_CONTACTOS;
		
	}
}
