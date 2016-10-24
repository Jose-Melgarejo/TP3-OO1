package test;

import supermercado_v2.*;

public class TestSupermercado_v2 {

	public static void main(String[] args) {
		//Creo supermercado
		final Supermercado supe = new supermercado_v2.Supermercado();

		//Agrego Productos
		try{
			supe.getAdmProducto().agregarProducto("Coca-Cola", (float)41.5);
			supe.getAdmProducto().agregarProducto("Alfajor", (float)8.7);
			supe.getAdmProducto().agregarProducto("Galletita", (float)14.2);
			supe.getAdmProducto().agregarProducto("Papas Fritas", (float)22.9);
			supe.getAdmProducto().agregarProducto("Helado", (float)30.4);
			supe.getAdmProducto().agregarProducto("Caramelo", (float)0.75);
			//error producto existente
			supe.getAdmProducto().agregarProducto("Alfajor", (float)1);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		//Traigo Productos
		System.out.println("\nAgregar y Traer prodctos:");
		System.out.println(supe.getAdmProducto().traerProducto("Alfajor"));
		System.out.println(supe.getAdmProducto().traerProducto(3));
		
		//Eliminar Productos
		System.out.println("\nEliminarProductos:\nTraigo Helado");
		System.out.println(supe.getAdmProducto().traerProducto("Helado"));
		System.out.println("Elimino Helado.");
		supe.getAdmProducto().eliminarProducto(supe.getAdmProducto().traerProducto("Helado"));
		System.out.println("Intento traer helado");
		System.out.println(supe.getAdmProducto().traerProducto("Helado"));
		
		//Agregar Cliente
		System.out.println("\nAgregar cliente:");
		try {
			supe.getAdmCliente().agregarCliente("Carmen Perez", 16358965, "Las Araucraias 1029");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
