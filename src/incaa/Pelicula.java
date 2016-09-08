package incaa;

public class Pelicula {
	private int    idPelicula = 0;
	private String Pelicula = "";
	
	public Pelicula(int idPelicula, String pelicula) {
		this.idPelicula = idPelicula;
		Pelicula = pelicula;
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
	
	
}
