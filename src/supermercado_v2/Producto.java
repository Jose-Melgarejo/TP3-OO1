package supermercado_v2;

public class Producto {
	private int 	idProducto;
	private String	producto;
	private float	precio;
	
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
	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", producto=" + producto + ", precio=" + precio + "]";
	}
	
}
