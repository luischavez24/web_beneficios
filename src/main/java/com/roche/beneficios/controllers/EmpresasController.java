package com.roche.beneficios.controllers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.roche.beneficios.constants.ViewConstants;
import com.roche.beneficios.entity.Distrito;
import com.roche.beneficios.model.EmpresaModel;
import com.roche.beneficios.services.DistritoService;
import com.roche.beneficios.services.EmpresaService;

@Controller
@RequestMapping("/empresas")
public class EmpresasController {
	
	private static final Log LOG = LogFactory.getLog(EmpresasController.class);
	
	// Servicio que obtiene los métodos de acceso a la tabla Empresas
	@Autowired
	@Qualifier("empresaService")
	private EmpresaService empresaService;
	
	@Autowired
	@Qualifier("distritoService")
	private DistritoService distritoService;
	
	// Mapeo de la página principal del módulo empresas
	@GetMapping("/")
	public String index () {
		// Redireccion al controlador de busquedas con los campos vacios
		return "redirect:/empresas/search?campo&busq";
	}
	
	// Controlador de busquedas
	@GetMapping("/search")
	public String search(Model model,
			@RequestParam(name="busq", required = false) String busq, 
			@RequestParam(name="campo", required=false) String campo) {
		// Crea una lista para llenar los datos buscados
		List<EmpresaModel> listaModel = null;
		
		// Decide por que campo buscar
		switch(campo) {
			case "nc":
				listaModel = empresaService.findByNomComercial(busq);
				break;
			case "rs":
				listaModel = empresaService.findByRSocial(busq);
				break;
			case "RUC": default:
				listaModel = empresaService.findByRuc(busq);	
		}
		LOG.info("Enviando lista=" + listaModel);
		// Establece como atributo en el modelo de la pagina a la lista de empresas obtenida
		model.addAttribute("empresas", listaModel);
		return ViewConstants.LISTAR_EMPRESAS;
	}
	
	@GetMapping("/new")
	public String showFormRegistroEmpresa(Model model,
			@RequestParam(name="msj", required=false) String mensaje) {
		EmpresaModel empresa_reg = new EmpresaModel();
		model.addAttribute("msj", mensaje);
		model.addAttribute("empresa_reg", empresa_reg);
		model.addAttribute("distritos", distritoService.listarDistrito());
		
		LOG.info("Enviando objeto empresa_reg=" + empresa_reg);
		return ViewConstants.FORM_REGISTRO_EMPRESAS;
	}
	
	@PostMapping("/register")
	public String newEmpresa(@ModelAttribute(name="empresa_reg") EmpresaModel empresa, 
			@RequestParam(name="dist") int distrito) {
		Distrito miDistrito = new Distrito();
		miDistrito.setIdDistrito(distrito);
		empresa.setDistrito(miDistrito);
		LOG.info("Recibiendo objeto empresa=" + empresa);
		empresaService.addEmpresa(empresa);
		
		return "redirect:/empresas/new?msj";
	}
	
	@PostMapping("/delete")
	public String deleteEmpresa(@RequestParam String ruc) {
		empresaService.removeEmpresa(ruc);
		return "redirect:/empresas/search?campo&busq";
	}
}
