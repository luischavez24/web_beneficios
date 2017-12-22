package com.roche.beneficios.controllers;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.roche.beneficios.constants.ViewConstants;
import com.roche.beneficios.model.ContactoModel;
import com.roche.beneficios.model.EmpresaModel;
import com.roche.beneficios.services.ContactosService;
import com.roche.beneficios.services.EmpresaService;

@Controller
@RequestMapping("/contactos")
public class ContactosController {

	private static final Log LOG = LogFactory.getLog(ContactosController.class);

	@Autowired
	@Qualifier("contactosService")
	private ContactosService contactosService;

	// Servicio que obtiene los métodos de acceso a la tabla Empresas
	@Autowired
	@Qualifier("empresaService")
	private EmpresaService empresaService;

	@GetMapping("")
	public String index() {
		LOG.info("Redirigiendo a la página principal");
		// Redireccion al controlador de busquedas con los campos vacios
		return "redirect:/contactos/search";
	}

	@GetMapping("/search")
	public String search(Model model, @RequestParam(name = "busq", required = false) String busq,
			@RequestParam(name = "filtro", required = false) EmpresaModel filtro) {

		// Crea una lista para llenar los datos buscados

		List<ContactoModel> listaModel = null;

		LOG.info(filtro);

		if (filtro != null) {
			LOG.info("Filtro de empresa activado=" + filtro.getNombreComercial());
			if (busq != null) {
				LOG.info("Nombre de Empleado='" + busq + "'");
				listaModel = contactosService.listAllByFullNameAndEmpresa(busq, filtro);
			} else {
				listaModel = contactosService.listContactosByEmpresa(filtro);
			}

		} else if (busq != null) {
			LOG.info("Nombre de Empleado='" + busq + "'");
			listaModel = contactosService.listAllByFullName(busq);
		} else {
			LOG.info("Busqueda sin filtros");
			listaModel = contactosService.listContactos();
		}

		model.addAttribute("contactos", listaModel);
		model.addAttribute("empresas", empresaService.listarEmpresas());

		return ViewConstants.LISTAR_CONTACTOS;

	}

	@GetMapping("/new")
	public String showFormRegistroContacto(Model model, @RequestParam(name = "msj", required = false) String mensaje) {

		ContactoModel contactoModel = new ContactoModel();

		model.addAttribute("msj", mensaje);

		model.addAttribute("contacto_reg", contactoModel);

		model.addAttribute("empresas", empresaService.listarEmpresas());

		LOG.info("Enviando objeto contacto_reg=" + contactoModel);

		return ViewConstants.FORM_REGISTRO_CONTACTOS;
	}
	
	@GetMapping("/detalles")
	public String details(@RequestParam(name="cod_empresa", required = true) int codEmpresa, 
			@RequestParam(name="id_contacto", required = true) int idContacto, Model model) {
		
		ContactoModel contacto = contactosService.findContacto(idContacto, codEmpresa);
		
		LOG.info("Contacto Selecccionado = " + contacto.getBeneficios().size());
		
		LOG.info("Empresa del contato = " + contacto.getEmpresa());
		
		model.addAttribute("contacto", contacto);
		
		return ViewConstants.DETALLE_CONTACTO;
	
	}

	@PostMapping("/register")
	public String newContacto(@ModelAttribute(name = "contacto_reg") ContactoModel contacto) {

		LOG.info("Recibiendo objeto contacto=" + contacto);

		contactosService.addContacto(contacto);

		return "redirect:/contactos/new?msj";

	}
	
	@GetMapping("/actualizar")
	public String actualizarContacto(@RequestParam(name="cod_empresa", required = true) int codEmpresa, 
			@RequestParam(name="id_contacto", required = true) int idContacto, Model model) {
		
		ContactoModel contactoModel = contactosService.findContacto(idContacto, codEmpresa);
		
		LOG.info("Enviando contacto a modificar " + contactoModel + " " + contactoModel.getIdContacto() + "," + contactoModel.getCodEmpresa());
		
		model.addAttribute("contacto_mod", contactoModel);
		
		LOG.info("Cargando empresas");
		
		model.addAttribute("empresas", empresaService.listarEmpresas());
		
		return ViewConstants.FORM_ACTUALIZAR_CONTACTOS;
		
	}
	
	@PostMapping("/modify")
	public String modifyContacto(@ModelAttribute(name="contacto_mod") ContactoModel contacto) {
		
		LOG.info("Actualizando objeto " + contacto + " " + contacto.getIdContacto() + "," + contacto.getCodEmpresa());
		
		contactosService.updateContacto(contacto);
		
		return "redirect:/contactos";
		
	}
	
	@PostMapping("/delete")
	public String deleteContacto(@RequestParam(name="id_contacto") int idContacto,
			@RequestParam(name="cod_empresa") int codEmpresa) {
		
		LOG.info("IdContacto=" + idContacto);
		LOG.info("CodEmpresa=" + codEmpresa);
		
		int resultado  = contactosService.removeContacto(idContacto, codEmpresa);
		
		LOG.info("Contacto removido " + resultado);
		
		return "redirect:/contactos";
		
	}
	
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ModelAndView sqlIntegrityException(final DataIntegrityViolationException e) {
		
		LOG.error("Integrity Exception");
		
		ModelAndView model = new ModelAndView(ViewConstants.INTEGRITY_EXCEPTION);
		
		model.addObject("exception", e.getMessage());
		
		return model;
	}
	
}
