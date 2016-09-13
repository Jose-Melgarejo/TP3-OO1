package incaa;

import java.util.ArrayList;
import java.util.List;

public class Incaa {
	private List<Pelicula> catalogo = new ArrayList<Pelicula>();

	public Incaa(List<Pelicula> catalogo) {
		this.catalogo = catalogo;
	}

	public List<Pelicula> getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(List<Pelicula> catalogo) {
		this.catalogo = catalogo;
	}
	
	private boolean existePelicula(String titulo) {
		boolean resultado = false;
		
		for (int i = 0; i < catalogo.size() && !resultado; i++) {
			if (catalogo.get(i).getPelicula().compareToIgnoreCase(titulo) == 0) {
				resultado = true;
			}
		}

		return resultado;
	}

	public void agregarPelicula(String pelicula,Genero genero) throws Exception{
		int tam_catalogo, id;
		
		if (existePelicula(pelicula)) throw new Exception("Error: La pelicula ya existe");
		
		tam_catalogo = this.catalogo.size();
		if (tam_catalogo == 0) {
			id = 1;
		}else{
			id = this.catalogo.get(tam_catalogo - 1).getIdPelicula() + 1; 
		}
		this.catalogo.add(new Pelicula(id,pelicula,genero));
	}
	
	public Pelicula traerPelicula(int id) {
		Pelicula resultado = null;
		
		for (Pelicula p: this.catalogo) {
			if (p.getIdPelicula() == id) {
				resultado = p;
			}
		}
	
		return resultado;
	}
	public Pelicula traerPelicula(String pelicula) {
		Pelicula resultado = null;
		
		for (Pelicula p: this.catalogo) {
			if (p.getPelicula() == pelicula) {
				resultado = p;
			}
		}
		return resultado;
	}
	public Pelicula traerPelicula(Genero genero) {
		Pelicula resultado = null;
		
		for (Pelicula p: this.catalogo) {
			if (p.getGenero() == genero) {
				resultado = p;
			}
		}
		return resultado;
	}
	
}
