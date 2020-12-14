package springmvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springmvc.entity.Pelicula;
import springmvc.repository.PeliculaRepository;

@Service
public class PeliculaServiceImpl implements PeliculaService {
	
	@Autowired
	private PeliculaRepository peliculaRepository;

	@Override
	@Transactional
	public List<Pelicula> consultaPeliculas(String director) {
		
		return this.peliculaRepository.getPeliculas(director);
	}

	@Override
	@Transactional
	public List<Pelicula> getPelicuas() {
		
		return this.peliculaRepository.findAll();
	}

	@Override
	@Transactional
	public void guardarPelicula(Pelicula pelicula) {
		this.peliculaRepository.save(pelicula);
		
	}

	@Override
	@Transactional
	public Pelicula getPelicula(int id) {
		
		Optional<Pelicula> optionalPelicula = this.peliculaRepository.findById(id);

		return optionalPelicula.get();
	}

	@Override
	@Transactional
	public void eliminarPelicula(int id) {
		
		this.peliculaRepository.deleteById(id);
		
	}

}
