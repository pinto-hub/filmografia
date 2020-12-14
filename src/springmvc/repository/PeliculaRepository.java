package springmvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import springmvc.entity.Pelicula;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Integer>{
	
	@Query("FROM Pelicula WHERE director = ?1")
	public List<Pelicula> getPeliculas(String director);

}
