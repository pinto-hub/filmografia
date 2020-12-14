package springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.SpringSessionContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.entity.Admin;
import springmvc.entity.Pelicula;
import springmvc.service.AdminService;
import springmvc.service.PeliculaService;

/**
 * Clase controladora de la aplicacion
 * @author Jepin
 *
 */
@Controller
@RequestMapping("/controlador")
public class Controlador {
	
	@Autowired
	private PeliculaService peliculaService;

	@Autowired
	private AdminService adminService;

	private List<String> directores = new ArrayList<>();

	private Admin session;
	
	/**
	 * Retorna la pagina principal
	 * @return
	 */
	@GetMapping("/paginaPrincipal")
	public String paginaPrincipal() {

		return "pagina-principal";
	}
	
	/**
	 * retorna la pagina de informacion
	 * @return
	 */
	@GetMapping("/paginaInfo")
	public String paginaInfo() {

		return "pagina-info";
	}
	
	/**
	 * retorna la pagina de consulta, limpiando la lista de directores que hubiera
	 * @return
	 */
	@GetMapping("/paginaConsulta")
	public String paginaConsulta() {
		
		if(!this.directores.isEmpty()) {
			this.directores.clear();			
		}


		return "pagina-consulta";
	}
	
	/**
	 * Metodo que recoge el nombre de un director introducido por el usuario, consulta a la base
	 * de datos y si existe muestra el listado de peliculas de dicho director y guarda el nombre en una
	 * lista
	 * @param director
	 * @param model
	 * @return
	 */
	@PostMapping("/consultaDirector")
	public String pruebaEmpleado(@RequestParam("director") String director, Model model) {

		List<Pelicula> peliculas = peliculaService.consultaPeliculas(director);
		if (!peliculas.isEmpty()) {

			model.addAttribute("peliculas", peliculas);

			if (!this.directores.contains(director)) {
				this.directores.add(director);
			}
		} else {
			model.addAttribute("error", "El director no se encuentra en la base de datos");
		}

		return "pagina-consulta";
	}
	
	/**
	 * Metodo que muestra la lista de directores que ha consultado el usuario
	 * @param model
	 * @return
	 */
	@GetMapping("/paginaDirectores")
	public String paginaDirectores(Model model) {

		if (!this.directores.isEmpty()) {

			model.addAttribute("directores", this.directores);

		} else {
			model.addAttribute("error", "No has hecho ninguna consulta o no has introducido un director que exista");
		}

		return "pagina-directores";
	}
	
	/**
	 * Metodo que retorna la pagina de login
	 * @return
	 */
	@GetMapping("/paginaLogin")
	public String login() {

		return "pagina-login";
	}
	
	/**
	 * Metodo que recoge los datos que ha introducido el usuario, si el usuario existe y la contraseña es correcta
	 * pasa a la pagina de administradores, si no es asi devuelve la pagina de login con un error
	 * @param name
	 * @param password
	 * @param model
	 * @return
	 */
	@PostMapping("/login")
	public String paginaLogin(@RequestParam("name") String name, @RequestParam("password") String password,
			Model model) {

		Admin tempAdmin = adminService.getAdmin(name);

		if (tempAdmin == null) {
			
			model.addAttribute("error", "El usuario introducido no existe");

			return "pagina-login";
		} else if (!tempAdmin.getPassword().contentEquals(password)) {

			model.addAttribute("error", "Contraseña incorrecta");

			return "pagina-login";
		} else {
			
			this.session = tempAdmin;
			
			return "redirect:/controlador/paginaAdmin";
		}

	}
	
	/**
	 * Metodo que retorna la pagina del admin
	 * @param model
	 * @return
	 */
	@GetMapping("/paginaAdmin")
	public String paginaAdmin(Model model) {

		model.addAttribute("admin", this.session);

		return "pagina-admin";
	}
	
	/**
	 * Metodo para desloguear al usuario y retorna la pagina de login con un mensaje
	 * @param model
	 * @return
	 */
	@GetMapping("/logout")
	public String logout(Model model) {

		this.session = null;
		
		model.addAttribute("logout", "La sesion se ha cerrado correctamente");

		return "pagina-login";
	}
	
	/**
	 * Metodo que retorna la lista de peliculas
	 * @param model
	 * @return
	 */
	@GetMapping("/paginaPeliculas")
	public String paginaPeliculas(Model model) {
		
		List<Pelicula> peliculas = peliculaService.getPelicuas();
		
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("admin", this.session);
		
		return "pagina-peliculas";
	}
	
	/**
	 * Metodo que retorna el formulario para insertar una pelicula
	 * @param model
	 * @return
	 */
	@GetMapping("/formularioPelicula")
	public String formularioPelicula(Model model) {
		
		Pelicula pelicula = new Pelicula();
		
		model.addAttribute("pelicula", pelicula);
		model.addAttribute("admin", this.session);
		
		return "formulario-pelicula";
	}
	
	/**
	 * Metodo que recoge el id de una pelicula al formulario para ser editada
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/actualizarPelicula")
	public String actualizarPelicula(@RequestParam("peliculaId") int id, Model model) {
		
		model.addAttribute("admin", this.session);
		Pelicula pelicula = this.peliculaService.getPelicula(id);
		model.addAttribute("pelicula", pelicula);

		return "formulario-pelicula";
	}
	
	/**
	 * Metodo que guarda o actualiza una pelicula
	 * @param pelicula
	 * @return
	 */
	@PostMapping("/guardarPelicula")
	public String guardarPelicula(@ModelAttribute("pelicula") Pelicula pelicula) {
		
		this.peliculaService.guardarPelicula(pelicula);
		
		return "redirect:/controlador/paginaPeliculas";
	}
	
	/**
	 * Metodo que recoge el id de una pelicula para eliminarla de la base de datos
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/eliminarPelicula")
	public String eliminarPelicula(@RequestParam("peliculaId") int id, Model model) {
		
		this.peliculaService.eliminarPelicula(id);

		return "redirect:/controlador/paginaPeliculas";
	}
	
	/**
	 * Metodo que retorna el formulario para guardar un admin
	 * @param model
	 * @return
	 */
	@GetMapping("/formularioAdmin")
	public String formularioAdmin(Model model) {
		
		Admin admin = new Admin();
		model.addAttribute("adminName", this.session);
		model.addAttribute("admin", admin);

		return "formulario-admin";
	}
	
	/**
	 * Metodo que guarda un admin en la base de datos
	 * @param admin
	 * @return
	 */
	@PostMapping("/guardarAdmin")
	public String guardarAdmin(@ModelAttribute("admin") Admin admin) {
		
		this.adminService.guardarAdmin(admin);
		
		return "redirect:/controlador/paginaAdmin";
	}

}
