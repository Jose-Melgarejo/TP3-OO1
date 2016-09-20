package test;
import incaa.*;

public class TestIncaa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Incaa incaa = new Incaa();
		Genero genero = new Genero(1,"Terror");
		Genero genero2 = new Genero(2,"Accion");
		Genero genero3 = new Genero(3,"Comedia");
		Genero genero4 = new Genero(4,"Drama");
		Genero genero5 = new Genero(5,"Ficcion");
		try{
			incaa.agregarPelicula("Chuky", genero);	
			incaa.agregarPelicula("Destino final", genero);	
			incaa.agregarPelicula("Duro de matar", genero2);	
			incaa.agregarPelicula("Scary Movie", genero3);	
			incaa.agregarPelicula("pelicula 1", genero4);
			incaa.agregarPelicula("I Robot", genero5);	
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println(incaa.traerPelicula(1));
		

	}

}
