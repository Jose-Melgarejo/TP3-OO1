package supermercado2_jose;

import java.util.ArrayList;
import java.util.List;



public class AdmCliente {
	private List<Cliente> lstCliente = new ArrayList<Cliente>();

	public AdmCliente(List<Cliente> lstCliente) {
		super();
		this.lstCliente = lstCliente;
	}

	public List<Cliente> getLstCliente() {
		return lstCliente;
	}

	public void setLstCliente(List<Cliente> lstCliente) {
		this.lstCliente = lstCliente;
	}
	
	public boolean agregarCliente(String cliente, long dni, String direccion) throws Exception{
		int tam_lst, idCliente = 0;
		
		if (traerCliente(cliente) != null) throw new Exception("Error: La pelicula ya existe");
		
		tam_lst = this.lstCliente.size();
		if (tam_lst == 0) {
			idCliente = 1;
		}else{
			idCliente = this.lstCliente.get(tam_lst - 1).getIdCliente() + 1; 
		}
		this.lstCliente.add(new Cliente(idCliente,cliente,dni,direccion));

		return true;
		
	}
	private Cliente traerCliente(String nombre) {
		Cliente cliente = null;
		boolean stop = false;
		for (int i = 0; i < lstCliente.size() && !stop; i++) {
			if(lstCliente.get(i).getNombre() == nombre){
				stop = true;
				cliente = lstCliente.get(i);
			}
		}
					
		return cliente;
	}

	public Cliente traerCliente(int idCliente){
		Cliente cliente = null;
		boolean stop = false;
		for (int i = 0; i < lstCliente.size() && !stop; i++) {
			if(lstCliente.get(i).getIdCliente() == idCliente){
				stop = true;
				cliente = lstCliente.get(i);
			}
		}
					
		return cliente;
		
	}
	
	public boolean eliminarCliente(Cliente cliente) throws Exception{
		
		if(traerCliente(cliente.getIdCliente()) == null)throw new Exception("Error: No existe el cliente");
		
		return lstCliente.remove(cliente);
		
	}
}
