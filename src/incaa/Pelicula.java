package incaa;

public class Pelicula {
	private int    idPelicula;
	private String Pelicula;
	private Genero genero;
	
	public Pelicula(int idPelicula, String pelicula,Genero genero) {
		setIdPelicula(idPelicula);
		setPelicula(pelicula);
		setGenero(genero);
		
	}

	public int getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public String getPelicula() {
		return Pelicula;
	}

	public void setPelicula(String pelicula) {
		Pelicula = pelicula;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	
}
