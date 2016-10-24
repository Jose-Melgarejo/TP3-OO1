package supermercado_v2;

public class Cliente {
	private int idCliente;
	private String nombre;
	private long dni;
	private String direccion;
	public Cliente(int idCliente, String nombre, long dni, String direccion) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.dni = dni;
		this.direccion = direccion;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public long getDni() {
		return dni;
	}
	public void setDni(long dni) {
		this.dni = dni;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", dni=" + dni + ", direccion=" + direccion
				+ "]";
	}
	
	
	

}
