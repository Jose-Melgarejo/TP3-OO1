package supermercado_v2;

public class ItemCarrito {
	int			idItem;
	Producto 	producto;
	int			cantidad;
	
	public ItemCarrito(int idItem, Producto producto, int cantidad) {
		setIdItem(idItem);
		setProducto(producto);
		setCantidad(cantidad);
	}
	public int getIdItem() {
		return idItem;
	}
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public float calcularSubTotal() {
		float resultado;
		resultado = cantidad * getProducto().getPrecio();
		return resultado;
	}
	
}
