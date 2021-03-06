package supermercado_v2;

import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
	private  int 				idCarrito;
	private  GregorianCalendar	fechaHora;
	private  List<ItemCarrito>	lstItem;
	private  Cliente			cliente;
	
	public Carrito() {
		
	}
	public Carrito(int idCarrito, GregorianCalendar fechaHora,Cliente cliente) {
		lstItem = new ArrayList<ItemCarrito>();
		setIdCarrito(idCarrito);
		setFechaHora(fechaHora);
		setCliente(cliente);
	}
	public Carrito(int idCarrito, GregorianCalendar fechaHora,Cliente cliente, Producto producto, int cantidad) {
		lstItem = new ArrayList<ItemCarrito>();
		setIdCarrito(idCarrito);
		setFechaHora(fechaHora);
		setCliente(cliente);
		agregarItem(producto, cantidad);
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getIdCarrito() {
		return idCarrito;
	}
	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}
	public GregorianCalendar getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(GregorianCalendar fechaHora) {
		this.fechaHora = fechaHora;
	}
	
	public ItemCarrito traerItem(String producto) {
		ItemCarrito resultado = null;
		for (int i = 0; i < lstItem.size() && resultado == null; i++) {
			if (lstItem.get(i).getProducto().getProducto().compareToIgnoreCase(producto) == 0) {
				resultado = lstItem.get(i);
			}
		}
		return resultado;
	}
	
	public boolean agregarItem(Producto producto, int cantidad) {
		boolean resultado = true;
		int		idItem;
		if (traerItem(producto.getProducto()) == null) {
			if (lstItem.isEmpty()) {
				idItem = 1;
			}else{
				idItem = lstItem.get(lstItem.size() - 1).getIdItem() + 1;  
			}
			lstItem.add(new ItemCarrito(idItem, producto, cantidad));
		}else{
			traerItem(producto.getProducto()).setCantidad(traerItem(producto.getProducto()).getCantidad() + cantidad);
		}
		return resultado;
	}
	
	public boolean eliminarItem (Producto producto, int cantidad) throws Exception{
		if (traerItem(producto.getProducto()) == null) throw new Exception("Error: no se encuentra el item.");
		boolean resultado = false;
		if (traerItem(producto.getProducto()).getCantidad() <= cantidad) {
			for(int i = 0; i < lstItem.size() && !resultado; i++) {
				if (lstItem.get(i).getProducto().getProducto().compareToIgnoreCase(producto.getProducto()) == 0) {
					resultado = true;
					lstItem.remove(i);
				}
			}
		}else{
			traerItem(producto.getProducto()).setCantidad(traerItem(producto.getProducto()).getCantidad() - cantidad);
		}
		return resultado;
	}
	
	public float calcularTotal() {
		float resultado = 0;
		for (ItemCarrito item : lstItem) {
			resultado += item.calcularSubTotal();
		}
		return resultado;
	}
}
