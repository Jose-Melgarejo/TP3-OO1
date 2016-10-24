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
			supe.getAdmProducto().agregarProducto("Chicle", (float)1);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		//Traigo Productos
		System.out.println(supe.getAdmProducto().traerProducto("Alfajor"));
		System.out.println(supe.getAdmProducto().traerProducto(3));
		

	}

}
