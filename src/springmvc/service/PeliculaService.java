package springmvc.service;

import java.util.List;

import springmvc.entity.Pelicula;

public interface PeliculaService {
	
	public List<Pelicula> consultaPeliculas(String director);
	public List<Pelicula> getPelicuas();
	public void guardarPelicula(Pelicula pelicula);
	public Pelicula getPelicula(int id);
	public void eliminarPelicula(int id);

}
