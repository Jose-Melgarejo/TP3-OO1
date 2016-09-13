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
		
		for (Pelicula p : this.catalogo) {
			if (p.getPelicula() == titulo) {
				resultado = true;
			}
		}
		return resultado;
	}

	
	public void agregarPelicula(String pelicula,Genero genero) throws Exception{
		if (existePelicula(pelicula)) throw new Exception("Error: La pelicula ya existe");
		int id = this.catalogo.size()+1;
		this.catalogo.add(new Pelicula(id,pelicula,genero));
	}
	
	public Pelicula traerPelicula(int id) throws Exception{
		Pelicula resultado = null;
		
		for (Pelicula p: this.catalogo) {
			if (p.getIdPelicula() == id) {
				resultado = p;
			}
		}
		if (resultado == null) throw new Exception("Error: No existe la pelicula");
		return resultado;
	}
}
