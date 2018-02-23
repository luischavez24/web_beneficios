package com.roche.beneficios.controllers;

import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.roche.beneficios.constants.ViewConstants;
import com.roche.beneficios.converter.ConsideracionConverter;
import com.roche.beneficios.model.BeneficioModel;
import com.roche.beneficios.model.CarouselBeneficiosModel;
import com.roche.beneficios.services.BeneficiosService;
import com.roche.beneficios.services.CarouselBeneficiosService;
import com.roche.beneficios.services.CategoriasService;
import com.roche.beneficios.services.ContactosService;
import com.roche.beneficios.utils.ImageConvertor;

@Controller
@RequestMapping("/beneficios")
public class BeneficiosController {
	private static final Log LOG = LogFactory.getLog(BeneficiosController.class);
	@Autowired
	@Qualifier("beneficiosService")
	private BeneficiosService beneficiosService;
	
	@Autowired
	@Qualifier("categoriasService")
	private CategoriasService categoriasService;
	
	@Autowired
	@Qualifier("contactosService")
	private ContactosService contactosService;
	
	@Autowired
	@Qualifier("carouselBeneficiosService")
	private CarouselBeneficiosService carouselBeneficiosService;
	
	@Autowired
	@Qualifier("consideracionConverter")
	private ConsideracionConverter consideracionConverter;
	@Autowired
	@Qualifier("imageConvertor")
	private ImageConvertor imageConvertor;
	

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
		List<CarouselBeneficiosModel> carouselBeneficios =  carouselBeneficiosService.listarItems();
		LOG.info("Carousel=" + carouselBeneficios);
		model.addAttribute("carousel_beneficios", carouselBeneficios);
		return ViewConstants.LISTAR_BENEFICIOS;
	}
	
	@GetMapping("/details")
	public String details(Model model,
			@RequestParam(name="nroBeneficio") int nroBeneficio) {
		
		BeneficioModel beneficio = beneficiosService.findByNroBeneficio(nroBeneficio);
		LOG.info("Enviando beneficio=" + beneficio);
		model.addAttribute("beneficio", beneficio);
		return ViewConstants.DETALLE_BENEFICIOS;
	}
	
	@GetMapping("/new")
	public String newBeneficio(Model model, @RequestParam(name="msj", required=false) String msj) {
		model.addAttribute("selectNavItem", "beneficios");
		model.addAttribute("beneficio", new BeneficioModel());
		model.addAttribute("categorias", categoriasService.listarCategorias());
		model.addAttribute("contactos", contactosService.listContactos());
		model.addAttribute("msj", msj);
		
		return ViewConstants.FORM_REGISTRO_BENEFICIOS;
	}
	
	@PostMapping("/register")
	public String register(Model model,
		@ModelAttribute("beneficio") BeneficioModel beneficio,
		@RequestParam(name = "imagen_beneficio") MultipartFile imagenBeneficio,
		@RequestParam(name = "imagen_demo") MultipartFile imagenDemo) {
		
		try {
			beneficio.setImagen(imagenBeneficio.getBytes());
			beneficio.setTipoImagen(imagenBeneficio.getContentType());
			beneficio.setImgPromo(imagenDemo.getBytes());
			beneficio.setTipoImgPromo(imagenDemo.getContentType());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Beneficio
		LOG.info("--Beneficio=" + beneficio);
		beneficio.getConsideraciones().forEach((c)->LOG.info(c.getNroBeneficio()));
		beneficiosService.insertarBeneficio(beneficio);
		
		model.addAttribute("selectNavItem", "beneficios");
		
		return "redirect:/beneficios/new?msj";
	}
	
	@GetMapping("/actualizar/{nroBeneficio}")
	public String newBeneficio(Model model, 
			@RequestParam(name="msj", required=false) String msj, 
			@PathVariable("nroBeneficio") int nroBeneficio) {
		
		model.addAttribute("selectNavItem", "beneficios");
		model.addAttribute("beneficio", beneficiosService.findByNroBeneficio(nroBeneficio));
		model.addAttribute("categorias", categoriasService.listarCategorias());
		model.addAttribute("contactos", contactosService.listContactos());
		model.addAttribute("msj", msj);
		
		return ViewConstants.FORM_ACTUALIZAR_BENEFICIOS;
	}
	@PostMapping("/modify")
	public String modifyBeneficio(Model model,
			@ModelAttribute("beneficio") BeneficioModel beneficio,
			/*@RequestParam(name="consideraciones") String[] consideraciones,*/
			@RequestParam(name = "imagen_beneficio") MultipartFile imagenBeneficio,
			@RequestParam(name = "imagen_demo") MultipartFile imagenDemo) {
		
		try {
			if(imagenBeneficio.getBytes() != null 
					&& !imagenBeneficio.getContentType().equals("application/octet-stream")) {
				beneficio.setImagen(imagenBeneficio.getBytes());
				beneficio.setTipoImagen(imagenBeneficio.getContentType());
				LOG.info("Nombre de imagen=" + imagenBeneficio.getOriginalFilename());
			}
			
			if(imagenDemo.getBytes() != null 
					&& !imagenDemo.getContentType().equals("application/octet-stream")) {
				beneficio.setImgPromo(imagenDemo.getBytes());
				beneficio.setTipoImgPromo(imagenDemo.getContentType());
				LOG.info("Nombre de imagen=" + imagenDemo.getOriginalFilename());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		LOG.info("Actualizando objeto=" + beneficio);
		
		beneficiosService.actualizarBeneficio(beneficio);
		
		LOG.info("Objecto actualizado");
		
		return "redirect:/beneficios/search"; 
		
	}
}
