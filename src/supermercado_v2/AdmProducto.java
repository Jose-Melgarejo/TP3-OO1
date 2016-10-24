package supermercado_v2;

import java.util.ArrayList;
import java.util.List;

public class AdmProducto {
	private List<Producto> lstProducto = new ArrayList<Producto>();
	public AdmProducto() {
		
	}
	public AdmProducto(List<Producto> lstProducto) {
		this.lstProducto = lstProducto;
	}

	public List<Producto> getLstProducto() {
		return lstProducto;
	}

	public void setLstProducto(List<Producto> lstProducto) {
		this.lstProducto = lstProducto;
	}

	public boolean eliminarProducto(Producto producto) {
		// TODO Auto-generated method stub
		
		return lstProducto.remove(producto);
	}

	public boolean agregarProducto(String producto, float precio) throws Exception{
		int tam_lst, idProducto = 0;
		
		if (traerProducto(producto) != null) throw new Exception("Error: el producto ya existe");
		
		tam_lst = this.lstProducto.size();
		if (tam_lst == 0) {
			idProducto = 1;
		}else{
			idProducto = this.lstProducto.get(tam_lst - 1).getIdProducto() + 1; 
		}
		this.lstProducto.add(new Producto(idProducto, producto,precio));

		return true;
		
	}
	public Producto traerProducto(String productoNombre){
		Producto producto = null;
		boolean  stop = false;
		
		for (int i = 0; i < lstProducto.size() && !stop; i++) {
			if(lstProducto.get(i).getProducto() == productoNombre){
				stop = true;
				producto = lstProducto.get(i);
			}
		}
		
	
		
		return producto;
	}
	public Producto traerProducto(int idProducto){
		Producto producto = null;
		boolean  stop = false;
		
		for (int i = 0; i < lstProducto.size() && !stop; i++) {
			if(lstProducto.get(i).getIdProducto() == idProducto){
				stop = true;
				producto = lstProducto.get(i);
			}
		}
		
	
		
		return producto;
	}
	
	
}
