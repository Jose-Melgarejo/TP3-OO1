package supermercado_v2;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;


public class AdmCarrito {
	private List<Carrito> lstCarrito = new ArrayList<Carrito>();
	
	public AdmCarrito() {
		
	}
	public AdmCarrito(List<Carrito> lstCarrito) {
		super();
		this.lstCarrito = lstCarrito;
	}

	
	public boolean agregarCarrito(Carrito carrito) throws Exception {
			boolean result = false;
			int tam_lst, idCarrito = 0;	
			if (traerCarrito(carrito.getIdCarrito()) != null) throw new Exception("Error: El carrito ya existe");
			result = true;
			tam_lst = this.lstCarrito.size();
			if (tam_lst == 0) {
				idCarrito = 1;
			}else{
				idCarrito  = this.lstCarrito.get(tam_lst - 1).getIdCarrito() + 1; 
			}
			carrito.setIdCarrito(idCarrito);
			this.lstCarrito.add(carrito);
	
			return result;
	}
	public boolean agregarCarrito(GregorianCalendar fechaHora,Cliente cliente) throws Exception {
		boolean result = false;
		int tam_lst, idCarrito = 0;	
		if (traerCarrito(cliente,fechaHora) != null) throw new Exception("Error: El carrito ya existe");
		result = true;
		tam_lst = this.lstCarrito.size();
		if (tam_lst == 0) {
			idCarrito = 1;
		}else{
			idCarrito  = this.lstCarrito.get(tam_lst - 1).getIdCarrito() + 1; 
		}
		this.lstCarrito.add(new Carrito(idCarrito,fechaHora,cliente));

		return result;
		
	}
	private Carrito traerCarrito(Cliente cliente, GregorianCalendar fechaHora) {
		Carrito carrito = null;
		boolean stop = false;
		for (int i = 0; i < lstCarrito.size() && !stop; i++) {
			if(lstCarrito.get(i).getCliente() == cliente && lstCarrito.get(i).getFechaHora() == fechaHora){
				stop = true;
				carrito = lstCarrito.get(i);
			}
		}
		return carrito;
	}
	private Carrito traerCarrito(Cliente cliente) {
		Carrito carrito = null;
		boolean stop = false;
		for (int i = 0; i < lstCarrito.size() && !stop; i++) {
			if(lstCarrito.get(i).getCliente() == cliente){
				stop = true;
				carrito = lstCarrito.get(i);
			}
		}
		return carrito;
	}
	private Carrito traerCarrito(int idCarrito) {
		Carrito carrito = null;
		boolean stop = false;
		for (int i = 0; i < lstCarrito.size() && !stop; i++) {
			if(lstCarrito.get(i).getIdCarrito() == idCarrito){
				stop = true;
				carrito = lstCarrito.get(i);
			}
		}
		return carrito;
	}
	public boolean eliminarCarrito(Carrito carrito) throws Exception{
		
		if(traerCarrito(carrito.getIdCarrito()) == null)throw new Exception("Error: No existe el Carrito");
		
		return lstCarrito.remove(carrito);
		
	}
	public float calculatTotal(Cliente cliente){
		
		Carrito carrito = traerCarrito(cliente);	
		return carrito.calcularTotal();
		
		
	}
	public float calculatTotal(int  dniCliente){
		
		Carrito carrito = traerCarrito(traerCliente(dniCliente));	
		return carrito.calcularTotal();
		
		
	}

	private Cliente traerCliente(int dniCliente) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
