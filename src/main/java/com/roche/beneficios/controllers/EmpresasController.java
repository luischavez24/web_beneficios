package com.roche.beneficios.controllers;

import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.roche.beneficios.constants.ViewConstants;
import com.roche.beneficios.exceptions.BusquedaNulaException;
import com.roche.beneficios.model.EmpresaModel;
import com.roche.beneficios.services.DistritoService;
import com.roche.beneficios.services.EmpresaService;
import com.roche.beneficios.utils.ImageConvertor;

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
	
	@Autowired
	@Qualifier("imageConvertor")
	private ImageConvertor imageConvertor;
	
	// Mapeo de la página principal del módulo contactos
	@GetMapping("")
	public String index () {
		// Redireccion al controlador de busquedas con los campos vacios
		return "redirect:/empresas/search";
		
	}
	
	// Controlador de busquedas
	@GetMapping("/search")
	public String search(Model model,
			@RequestParam(name="busq", required = false) String busq, 
			@RequestParam(name="campo", required=false) String campo,
			@RequestParam(name="msj", required = false) String mensaje) {
		
		model.addAttribute("selectNavItem", "empresas");
		model.addAttribute("msj", mensaje);
		
		LOG.info("Eliminacion realizada=" + mensaje);
		
		// Crea una lista para llenar los datos buscados
		List<EmpresaModel> listaModel = null;
		
		if(busq == null || campo == null) {
			listaModel = empresaService.listarEmpresas();
			
			LOG.info("Enviando lista=" + listaModel);
			
			// Establece como atributo en el modelo de la pagina a la lista de empresas obtenida
			
			model.addAttribute("empresas", listaModel);
			
			return ViewConstants.LISTAR_EMPRESAS;
			
			
		} else {
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
			
			return ViewConstants.LISTAR_EMPRESAS_BUSQ;
		}
		
	}
	
	@GetMapping("/new")
	public String showFormRegistroEmpresa(Model model,
			@RequestParam(name="msj", required=false) String mensaje) {
		
		EmpresaModel empresa_reg = new EmpresaModel();
		
		model.addAttribute("selectNavItem", "empresas");
		
		model.addAttribute("msj", mensaje);
		
		model.addAttribute("empresa_reg", empresa_reg);
		
		model.addAttribute("distritos", distritoService.listarDistrito());
		
		LOG.info("Enviando objeto empresa_reg=" + empresa_reg);
		
		return ViewConstants.FORM_REGISTRO_EMPRESAS;
	}
	
	@GetMapping("/detalles/{codEmpresa}")
	public String details(@PathVariable int codEmpresa, Model model) throws BusquedaNulaException {
		
		EmpresaModel empresa = empresaService.findByCodEmpresa(codEmpresa);
		if(empresa == null) {
			throw new BusquedaNulaException();
		}

	    model.addAttribute("imagen_empresa", imageConvertor.convertToBase64(empresa.getImagen()));
	    model.addAttribute("tipo_imagen", empresa.getTipoImagen());
		LOG.info("Empresa Selecccionada = " + empresa.getContactos().size());
		model.addAttribute("empresa", empresa);
		
		
		return ViewConstants.DETALLE_EMPRESA;
	
	}
	
	@PostMapping("/register")
	public String newEmpresa(@ModelAttribute(name="empresa_reg") EmpresaModel empresa, 
			@RequestParam(name = "imagen_empresa") MultipartFile imagenEmpresa) {
		
		try {
			empresa.setImagen(imagenEmpresa.getBytes());
			empresa.setTipoImagen(imagenEmpresa.getContentType());
			LOG.info("Nombre de imagen=" + imagenEmpresa.getOriginalFilename());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOG.info("Recibiendo objeto empresa=" + empresa);
		
		empresaService.addEmpresa(empresa);
		
		return "redirect:/empresas/new?msj";
		
	}
	
	@GetMapping("/delete/{ruc}")
	public String deleteModalEmpresa(Model model, @PathVariable String ruc) 
			throws BusquedaNulaException{
		
		EmpresaModel currentEmpresa = empresaService.findOneByRuc(ruc);
		
		if(currentEmpresa == null) {
			LOG.error("No se encontro la empresa con ruc = " + ruc);
			throw new BusquedaNulaException();
		}
		
		LOG.info("Abriendo modal para empresa = " + currentEmpresa);
		
		model.addAttribute("currentEmpresa", currentEmpresa);
		return ViewConstants.ELIMINAR_EMPRESA;
	}
	
	@PostMapping("/delete")
	public String deleteEmpresa(@RequestParam String ruc) {
		
		LOG.info("Empresa a remover con RUC=" + ruc);
		
		empresaService.removeEmpresa(ruc);
		
		LOG.info("Empresa removida");
		
		return "redirect:/empresas/search?msj=1";
		
	}
	
	@GetMapping("/actualizar/{rucEmpresa}")
	public String actualizarEmpresa(@PathVariable String rucEmpresa, Model model) throws BusquedaNulaException {
		
		EmpresaModel empresa = empresaService.findOneByRuc(rucEmpresa);
		
		if(empresa == null) {
			throw new BusquedaNulaException();
		}
		
		LOG.info("Enviando empresa a modificar " + empresa);
		
		model.addAttribute("empresa_mod", empresa);
		
		LOG.info("Cargando distritos");
		
		model.addAttribute("distritos", distritoService.listarDistrito());

	    model.addAttribute("imagen_empresa",imageConvertor.convertToBase64(empresa.getImagen()));
	    
	    model.addAttribute("tipo_imagen", empresa.getTipoImagen());
	    
		LOG.info("Empresa Selecccionada = " + empresa.getContactos().size());
		
		return ViewConstants.FORM_ACTUALIZAR_EMPRESAS;
		
	}
	
	@PostMapping("/modify")
	public String modifyEmpresa(@ModelAttribute(name="empresa_mod") EmpresaModel empresa,
			@RequestParam(name="imagen_empresa") MultipartFile imagenEmpresa) {
		
		try {
			if(imagenEmpresa.getBytes() != null 
					&& !imagenEmpresa.getContentType().equals("application/octet-stream")) {
				empresa.setImagen(imagenEmpresa.getBytes());
				empresa.setTipoImagen(imagenEmpresa.getContentType());
				LOG.info("Nombre de imagen=" + imagenEmpresa.getOriginalFilename());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		LOG.info("Actualizando objeto=" + empresa);
		
		empresaService.updateEmpresa(empresa);
		
		return "redirect:/empresas/search?msj=2";
		
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ModelAndView sqlIntegrityException(final DataIntegrityViolationException e) {
		
		LOG.error("Integrity Exception");
		
		ModelAndView model = new ModelAndView(ViewConstants.INTEGRITY_EXCEPTION);
		
		model.addObject("exception", e.getMessage());
		
		model.addObject("direccion_retorno", "/empresas/new");
		
		return model;
	}
	
	@ExceptionHandler(BusquedaNulaException.class)
	public ModelAndView sqlIntegrityException(final BusquedaNulaException e) {
		
		LOG.error("Not match exception");
		
		ModelAndView model = new ModelAndView(ViewConstants.BUSQUEDA_NULA_EXCEPTION);
		
		model.addObject("exception", e.getMessage());
		
		model.addObject("direccion_retorno", "/empresas");
		
		return model;
	}
}
