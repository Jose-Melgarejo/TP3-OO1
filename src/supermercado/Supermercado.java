package supermercado;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {
	List<Producto> gondola;
	
	public Supermercado() {
		gondola = new ArrayList<Producto>();
	}
	
	public boolean agregarProducto(String producto, float precio) throws Exception {
		if (traerProducto(producto) != null) throw new Exception("El producto ya existe.");
		
		boolean resultado = true;
		int		id;
		if (gondola.isEmpty()) {
			id = 1;
		}else{
			id = gondola.get(gondola.size() - 1).getIdProducto() + 1;
		}
		gondola.add(new Producto(id, producto, precio));
		return resultado;
	}
	
	public Producto traerProducto(String producto) {
		Producto resultado = null;
		for (int i = 0; i < gondola.size() && resultado == null; i++) {
			if (gondola.get(i).getProducto().compareToIgnoreCase(producto) == 0) {
				resultado = gondola.get(i);
			}
		}
		return resultado;
	}
	
	public Producto traerProducto(int idProducto) {
		Producto resultado = null;
		for (int i = 0; i < gondola.size() && resultado == null; i++) {
			if (gondola.get(i).getIdProducto() == idProducto) {
				resultado = gondola.get(i);
			}
		}
		return resultado;
	}
	
	public boolean modificarProducto(Producto producto) throws Exception {
		if (traerProducto(producto.getIdProducto()) == null) throw new Exception("Error: no existe el producto.");
		
		boolean resultado = true;
		traerProducto(producto.idProducto).setProducto(producto.getProducto());;
		traerProducto(producto.idProducto).setPrecio(producto.getPrecio());;
		return resultado;
	}
	
	public boolean eliminarProducto (Producto producto) {
		return gondola.remove(producto);
	}
	
}
