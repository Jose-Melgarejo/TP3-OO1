package supermercado;

public class Producto {
	int 	idProducto;
	String	producto;
	float	precio;
	
	public Producto(int idProducto, String producto, float precio) {
		setIdProducto(idProducto);
		setProducto(producto);
		setPrecio(precio);
	}

	public int getIdProducto() {
		return idProducto;
	}

	public String getProducto() {
		return producto;
	}

	public float getPrecio() {
		return precio;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	
}
