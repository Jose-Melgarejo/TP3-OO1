package listas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class TestListas {
	public static void main(String argv[]) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Vamos a llenar un ArrayList");
		
		List<String> lista = new ArrayList<String>();
		String elem = "";
		
		while(!(elem.equalsIgnoreCase("stop"))){
			System.out.println("Para finalizar tipear stop");
			elem = in.next();
			if (!(elem.equalsIgnoreCase("stop"))) lista.add(elem);
		}
		in.close();
		
		System.out.println("1) Impresion usando Foreach loop.");
		for (String s : lista) {
			System.out.println(s);
		}
		
		System.out.println("2) Impresion usando for loop with index");
		for (int p = 0; p < lista.size(); p++) {
			System.out.println(lista.get(p));
		}
		
		System.out.println("3) Impresion usando Iteration<tipo>");
		for (Iterator<String> iter = lista.iterator(); iter.hasNext();) {
			System.out.println(iter.next());
		}
	}
}
