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
			supe.getAdmCliente().agregarCliente("Gustavo Boido", 24577219, "Las Magnolias 740");
			supe.getAdmCliente().agregarCliente("Juan Suarez", 38123654, "Colon 10295");
			supe.getAdmCliente().agregarCliente("Carolina Denia", 94856214, "Sarmiento 82");
			supe.getAdmCliente().agregarCliente("Carla Rodriguez", 40121857, "Boedo 1300");
			//Cliente (DNI) repetido.
			supe.getAdmCliente().agregarCliente("Juan Perez", 16358965, "Junin 940");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//Traer Cliente
		System.out.println("\nTraer Cliente:");
		System.out.println(supe.getAdmCliente().traerCliente(1));
		System.out.println(supe.getAdmCliente().traerCliente((long)40121857));
		//Traer DNI inexistente
		System.out.println("\nDni inexistente:");
		System.out.println(supe.getAdmCliente().traerCliente((long)41121857));
		//Borrar Cliente
		System.out.println("Borro 40121857");
		try {
			supe.getAdmCliente().eliminarCliente(supe.getAdmCliente().traerCliente((long)40121857));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Intento traer devuelta 40121857");
		System.out.println(supe.getAdmCliente().traerCliente((long)40121857));
		
	}

}
