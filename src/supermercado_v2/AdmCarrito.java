package supermercado2_jose;

import java.util.ArrayList;
import java.util.List;


public class AdmCarrito {
	private List<Carrito> lstCarrito = new ArrayList<Carrito>();

	public AdmCarrito(List<Carrito> lstCarrito) {
		super();
		this.lstCarrito = lstCarrito;
	}

	public List<Carrito> getLstCarrito() {
		return lstCarrito;
	}

	public void setLstCarrito(List<Carrito> lstCarrito) {
		this.lstCarrito = lstCarrito;
		
	}
	public boolean agregarCarrito(Carrito carrito)

}
