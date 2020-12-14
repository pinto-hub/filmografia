package springmvc.entity;

import javax.persistence.*;

/**
 * Clase entidad pelicula
 * @author Jepin
 *
 */
@Entity
@Table(name = "pelicula")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "director")
    private String director;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "fecha")
    private String fecha;

    public Pelicula() {

    }

	public Pelicula(String director, String titulo, String fecha) {
		super();
		this.director = director;
		this.titulo = titulo;
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", director=" + director + ", titulo=" + titulo + ", fecha=" + fecha + "]";
	}

    
    
    
}
