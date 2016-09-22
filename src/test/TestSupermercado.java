package test;
import java.util.GregorianCalendar;
import supermercado.*;


public class TestSupermercado {

	public static void main(String[] args) {
		//Creo Supermercado
		Supermercado sup = new supermercado.Supermercado();
		try {
			//Intento cargar algunos items a la gondola.
			sup.agregarProducto("Papas Fritas", (float) 25.8);
			sup.agregarProducto("Caramelo", (float) 1.75);
			sup.agregarProducto("Alfajor", (float) 12);
			sup.agregarProducto("Coca-Cola", (float) 15);
			sup.agregarProducto("Chocolate", (float) 22);
			sup.agregarProducto("Twistos", (float) 18);
			sup.agregarProducto("Marroc", (float) 1.5);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//La coca aumenta a 16
		Producto coca = new Producto(sup.traerProducto("Coca-Cola").getIdProducto(), "Coca-Cola", (float) 16);
		try {
			sup.modificarProducto(coca);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		//borrar alfajor
		//sup.eliminarProducto(sup.traerProducto("Alfajor"));
		
		//Creo un carrito con el id 0 y la fecha y hora actual.
		Carrito car = new Carrito(0, new GregorianCalendar());
		
		//Agrego 2 alfajores.
		car.agregarItem(sup.traerProducto("Alfajor"), 2);
		//Calculo Subtotal, cantidad y precio unitario
		float subtotal = car.traerItem("Alfajor").calcularSubTotal();
		int cantidad = car.traerItem("Alfajor").getCantidad();
		float punitario = car.traerItem("Alfajor").getProducto().getPrecio();
		System.out.println("Alfajor (" + punitario + ") x " + cantidad + " _____ " + subtotal);
		
		//Agrego 1 coca
		car.agregarItem(sup.traerProducto("Coca-Cola"), 1);
		subtotal = car.traerItem("Coca-Cola").calcularSubTotal();
		cantidad = car.traerItem("Coca-Cola").getCantidad();
		punitario = car.traerItem("Coca-Cola").getProducto().getPrecio();
		System.out.println("Coca-Cola (" + punitario + ") x " + cantidad + " _____ " + subtotal);
		
		//Agrego 5 Caramelos
		car.agregarItem(sup.traerProducto("Caramelo"), 5);
		
		//saco 2 caramelos.
		try {
			car.eliminarItem(sup.traerProducto("Caramelo"), 2);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		//Calculo el subtotal
		subtotal = car.traerItem("Caramelo").calcularSubTotal();
		cantidad = car.traerItem("Caramelo").getCantidad();
		punitario = car.traerItem("Caramelo").getProducto().getPrecio();
		System.out.println("Caramelo (" + punitario + ") x " + cantidad + " _____ " + subtotal);

		//Calculo Total
		System.out.println("Total: ___ " + car.calcularTotal());
		
	}

}
