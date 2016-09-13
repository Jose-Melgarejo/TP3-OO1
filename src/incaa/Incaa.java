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

	public void agregarPelicula(String pelicula,Genero genero) throws Exception{
		int tam_catalogo, id;
		
		if (traerPelicula(pelicula) == null) throw new Exception("Error: La pelicula ya existe");
		
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
		boolean  stop = false;
		
		for (int i = 0; i < catalogo.size() && !stop; i++) {
			stop = true;
			resultado = catalogo.get(i);
		}	
		return resultado;
	}
	
	public Pelicula traerPelicula(String titulo) {
		Pelicula resultado = null;
		boolean stop = false;
		
		for (int i = 0; i < catalogo.size() && !stop; i++) {
			if (catalogo.get(i).getPelicula().compareToIgnoreCase(titulo) == 0) {
				stop = true;
				resultado = catalogo.get(i);
			}
		}
		return resultado;
	}
	public List<Pelicula> traerPelicula(Genero genero) {
		List<Pelicula> resultado = new ArrayList<Pelicula>();
		
		for (Pelicula p: this.catalogo) {
			if (p.getGenero() == genero) {
				resultado.add(p);
			}
		}
		return resultado;
	}
	
}
