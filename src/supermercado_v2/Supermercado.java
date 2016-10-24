package supermercado_v2;

public class Supermercado {
	private AdmProducto admProducto;
	private AdmCliente  admCliente;
	private AdmCarrito	admCarrito;

	public Supermercado() {

		this.admProducto = new AdmProducto();
		this.admCliente = new AdmCliente();
		this.admCarrito = new AdmCarrito();
	}

	public AdmProducto getAdmProducto() {
		return admProducto;
	}

	public void setAdmProducto(AdmProducto admProducto) {
		this.admProducto = admProducto;
	}

	public AdmCliente getAdmCliente() {
		return admCliente;
	}

	public void setAdmCliente(AdmCliente admCliente) {
		this.admCliente = admCliente;
	}

	public AdmCarrito getAdmCarrito() {
		return admCarrito;
	}

	public void setAdmCarrito(AdmCarrito admCarrito) {
		this.admCarrito = admCarrito;
	}

	
}
