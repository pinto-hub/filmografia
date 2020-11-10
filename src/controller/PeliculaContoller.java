package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdministradorDao;
import dao.PeliculaDao;
import modelo.Administrador;
import modelo.Pelicula;

@WebServlet("/peliculaControlador")
public class PeliculaContoller extends HttpServlet {

	private List<String> directores = new ArrayList<>();
	private PeliculaDao peliculaDao = new PeliculaDao();
	private AdministradorDao administradorDao = new AdministradorDao();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getParameter("accion") != null) {

			String accion = req.getParameter("accion");
			switch (accion) {
			case "info":
				req.getRequestDispatcher("/WEB-INF/view/info.jsp").forward(req, resp);
				break;
			case "consulta":
				req.getRequestDispatcher("/WEB-INF/view/consulta.jsp").forward(req, resp);
				break;
			case "finalizar":
				listaDirectores(req, resp);
				break;
			case "reset":
				this.directores.clear();
				req.getRequestDispatcher("/WEB-INF/view/consulta.jsp").forward(req, resp);
				break;
			case "login":
				this.directores.clear();
				req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
				break;
			case "mantenimiento":
				listaPeliculas(req, resp);
				break;
			case "editar":
				seleccionarPelicula(req, resp);
				break;
			case "eliminar":
				eliminarPelicula(req, resp);
				break;
			}
		} else {
			req.getRequestDispatcher("inicio.jsp").forward(req, resp);
		}

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getParameter("accion") != null) {
			String accion = req.getParameter("accion");

			switch (accion) {
			case "consulta":
				buscarPeliculas(req, resp);
				break;
			case "login":
				login(req, resp);
				break;
			case "insertar":
				insertarPelicula(req, resp);
				break;
			case "editar":
				editarPelicula(req, resp);
				break;
			case "insertarAdmin":
				insertarAdministrador(req, resp);
				break;
			}
		}
	}

	public void buscarPeliculas(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nombre = req.getParameter("director").toLowerCase();
		List<Pelicula> peliculas = peliculaDao.buscarPeliculas(nombre);

		if (peliculas.isEmpty()) {
			req.setAttribute("error", "ERROR: El director introducido no esta en la base de datos");
			req.getRequestDispatcher("/WEB-INF/view/consulta.jsp").forward(req, resp);
		} else {

			if (this.directores.isEmpty()) {
				this.directores.add(nombre);
			}

			if (!this.directores.contains(nombre)) {
				this.directores.add(nombre);
			}

			req.setAttribute("peliculas", peliculas);
			req.setAttribute("director", nombre);

			req.getRequestDispatcher("/WEB-INF/view/lista-usuario.jsp").forward(req, resp);
		}

	}

	public void listaDirectores(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("directores", this.directores);
		req.getRequestDispatcher("/WEB-INF/view/lista-directores.jsp").forward(req, resp);

	}

	public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nombre = req.getParameter("usuario");
		String pass = req.getParameter("pass");
		Administrador admin = administradorDao.selectAdmin(nombre);

		if (admin == null) {
			req.setAttribute("error", "ERROR: Este administrador no existe en la base de datos");
			req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
		} else if (!admin.getPass().equals(pass)) {
			req.setAttribute("error", "ERROR: Password incorrecta");
			req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
		} else {
			req.setAttribute("nombre", admin.getNombre());
			req.getRequestDispatcher("/WEB-INF/view/inicio-admin.jsp").forward(req, resp);
		}
	}

	public void listaPeliculas(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Pelicula> peliculas = peliculaDao.lista();

		if (peliculas.isEmpty()) {
			req.setAttribute("error", "ERROR: No hay peliculas en la base de datos");
			req.getRequestDispatcher("/WEB-INF/view/lista-admin.jsp").forward(req, resp);
		} else {
			req.setAttribute("peliculas", peliculas);
			req.getRequestDispatcher("WEB-INF/view/lista-admin.jsp").forward(req, resp);
		}

	}

	public void insertarPelicula(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String director = req.getParameter("director");
		String titulo = req.getParameter("titulo");
		String fecha = req.getParameter("fecha");

		Pelicula pelicula = new Pelicula(director, titulo, fecha);

		peliculaDao.insertarPelicula(pelicula);

		listaPeliculas(req, resp);

	}

	public void seleccionarPelicula(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		Pelicula pelicula = peliculaDao.seleccionarPelicula(id);

		req.setAttribute("pelicula", pelicula);

		req.getRequestDispatcher("WEB-INF/view/editar-pelicula.jsp").forward(req, resp);

	}

	public void editarPelicula(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String director = req.getParameter("director");
		String titulo = req.getParameter("titulo");
		String fecha = req.getParameter("fecha");

		Pelicula pelicula = new Pelicula(id, director, titulo, fecha);

		peliculaDao.editarPelicula(pelicula);

		listaPeliculas(req, resp);

	}

	public void eliminarPelicula(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		peliculaDao.eliminarPelicula(id);

		listaPeliculas(req, resp);

	}

	public void insertarAdministrador(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String usuarioActual = req.getParameter("usuarioActual");
		String user = req.getParameter("admin");
		String pass = req.getParameter("pass");

		Administrador admin = administradorDao.selectAdmin(user);

		if (admin != null) {
			req.setAttribute("nombre", usuarioActual);
			req.setAttribute("error", "ERROR: Ya existe este administrador en la base datos");
			req.getRequestDispatcher("/WEB-INF/view/inicio-admin.jsp").forward(req, resp);

		} else {
			admin = new Administrador(user, pass);
			administradorDao.insertarAdministrador(admin);
			req.setAttribute("nombre", usuarioActual);
			req.setAttribute("correcto", "Usuario introducido correctamente");
			req.getRequestDispatcher("/WEB-INF/view/inicio-admin.jsp").forward(req, resp);
		}

	}

}
