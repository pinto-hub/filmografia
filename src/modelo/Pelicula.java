package modelo;

public class Pelicula {
	
	private int id;
	private String director;
	private String titulo;
	private String fecha;
	
	public Pelicula() {
		
	}
	
	public Pelicula(String director, String titulo, String fecha) {
		this.director = director;
		this.titulo = titulo;
		this.fecha = fecha;
	}
	
	

	public Pelicula(int id, String director, String titulo, String fecha) {
		this.id = id;
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
}
