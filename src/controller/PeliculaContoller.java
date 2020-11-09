package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PeliculaDao;
import modelo.Pelicula;

@WebServlet("/peliculaControlador")
public class PeliculaContoller extends HttpServlet {
	
	public List<String> directores = new ArrayList<>();

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
				listaPeliculas(req, resp);
				break;
			case "login":
				
				break;
			case "insertar":
				
				break;

			}
		}
	}
	
	public void listaPeliculas(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("director");
		PeliculaDao peliculaDao = new PeliculaDao();
		
		List<Pelicula> peliculas = peliculaDao.list(nombre);
		
			if(peliculas.isEmpty()) {
				req.setAttribute("error", "El director introducido no esta en la base de datos");
				req.getRequestDispatcher("/WEB-INF/view/consulta.jsp").forward(req, resp);
			} else {
				
				if(this.directores.isEmpty()) {
					this.directores.add(nombre);
				}
				
				if(!this.directores.contains(nombre)) {
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
	
	public void login(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		
		req.getParameter("usuario");
		
		
	}
	

}
