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
		System.out.println("\ntraer pelicula por id\n");
		System.out.println(incaa.traerPelicula(3).toString());
		
		
		System.out.println("\ntraer pelicula por nombre\n");
		System.out.println(incaa.traerPelicula("Duro de matar").toString());
		//
		System.out.println("\ntraer lista de peliculas por genero\n");
		for (int i = 0;i < incaa.traerPelicula(genero).size();i++){
		
			System.out.println(incaa.traerPelicula(genero).get(i).toString());
		}
		
		//borrar pelicula 
		if(incaa.borrarPelicula(incaa.traerPelicula("pelicula 1"))){
			System.out.println("Pelicula Borrada");
		}else{
			System.out.println("Pelicula no encontrada");
		}
			
		Pelicula pelimodifica = new Pelicula (99, "Chuky2", genero);
		pelimodifica.setIdPelicula(incaa.traerPelicula("Chuky").getIdPelicula());
		try{
			incaa.modificarPelicula(pelimodifica);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println("Pelicula modificada\n"+incaa.traerPelicula(1));
		
		
	}

}
