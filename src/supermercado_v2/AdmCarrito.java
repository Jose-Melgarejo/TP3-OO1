package supermercado_v2;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import funciones.Funciones;


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
			carrito.setFechaHora(new GregorianCalendar());
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
	public Carrito traerCarrito(Cliente cliente, GregorianCalendar fechaHoraBuscada) {
		Carrito carrito = null;
		boolean stop = false;
		for (int i = 0; i < lstCarrito.size() && !stop; i++) {
			if(lstCarrito.get(i).getCliente() == cliente && Funciones.sonFechasYHorasIguales(lstCarrito.get(i).getFechaHora(), fechaHoraBuscada)){
				stop = true;
				carrito = lstCarrito.get(i);
			}
		}
		return carrito;
	}
	public List<Carrito> traerCarrito(Cliente cliente) throws Exception {
		List<Carrito> resultado = new ArrayList<Carrito>();
		for (int i = 0; i < lstCarrito.size(); i++) {
			if(lstCarrito.get(i).getCliente().getDni() == cliente.getDni()){
				resultado.add(lstCarrito.get(i));
			}
		}
		if (resultado.isEmpty()) throw new Exception("No hay carrito de este cliente");
		return resultado;
	}
	public Carrito traerCarrito(int idCarrito) {
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
	public float calculatTotal(Cliente cliente) throws Exception{
		float acumulador = 0;
		
		List<Carrito> carrito_cliente = traerCarrito(cliente);
		for (int i = 0; i < carrito_cliente.size(); i++) {
			acumulador += carrito_cliente.get(i).calcularTotal();
		}
		return acumulador;
	}
	public float calculatTotal(long dniCliente) throws Exception{
		float acumulador = 0;
		
		List<Carrito> carrito_cliente = traerCarrito(new Cliente(-1, "", dniCliente, ""));
		for (int i = 0; i < carrito_cliente.size(); i++) {
			acumulador += carrito_cliente.get(i).calcularTotal();
		}
		return acumulador;
	}
	

}
