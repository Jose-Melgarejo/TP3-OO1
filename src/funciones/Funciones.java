package funciones;

import java.util.Calendar;
import java.lang.Character;
import java.util.GregorianCalendar;

public class Funciones {
	public static String convertirString (int numero) {
		return String.valueOf(numero);
	}
	
	public static double convertirDoble (int numero) {	
		return ((double)(numero));
	}
	
	public static void imprimirArreglo(int[] array) {
		int i;
		for (i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	public static void imprimirArreglo(double[][] array) {
		int i, j;
		
		for (i = 0; i < array.length; i++) {
			for (j = 0; j < array[0].length; j++) {
				System.out.print("["+array[i][j]+"]");
			}
			System.out.print("\n");
		}
	}
	
	public static boolean esBisiesto (int anio) {
		boolean resultado;
		
		if (((anio % 4 == 0) && (anio % 100 != 0)) || (anio % 400 == 0)) {
			resultado = true;
		}else{
			resultado = false;
		}
		return resultado;
	}
	
	public static int traerAnio (GregorianCalendar fecha) {
		return fecha.get(Calendar.YEAR);
	}
	
	public static int traerMes (GregorianCalendar fecha) {
		return fecha.get(Calendar.MONTH) + 1;
	}
	
	public static int traerDia (GregorianCalendar fecha) {
		return fecha.get(Calendar.DAY_OF_MONTH);
	}
	
	public static int traerCantDiasDeUnMes (int anio, int mes) {
		boolean bisiesto = Funciones.esBisiesto(anio);
		int		max_dias = 31;
		
		if (mes >= 1 && mes <= 12) {
			if (mes == 4 || mes == 6 || mes == 9 || mes == 11){
				max_dias = 30;
			}
			if (mes == 2) {
				if (bisiesto) {
					max_dias = 29;
				}else{
					max_dias = 28;
				}
			}
		}else{
			max_dias = -1;
		}
		return max_dias;
	}
	
	public static boolean esFechaValida(int anio, int mes, int dia) {
		boolean resultado = true;
		int		max_dias = traerCantDiasDeUnMes(anio, mes);
		
		if (dia < 1 || dia > max_dias) {
			resultado = false;
		}
		return resultado;
	}
	
	public static GregorianCalendar traerFecha(int anio, int mes, int dia, int horas, int minutos, int segundos){
		return new GregorianCalendar(anio, mes - 1, dia, horas, minutos, segundos);
	}
	
	public static GregorianCalendar traerFecha(int anio, int mes, int dia) {
		return new GregorianCalendar(anio, mes - 1, dia);
	}
	
	//Parametro de la fecha es "DD/MM/AAAA"
	public static GregorianCalendar traerFecha(String fecha) {
		String[] date = new String[3];
		
		date = fecha.split("[/]+");
		return traerFecha(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
	}
	
	public static String traerFechaCorta(GregorianCalendar fecha) {
		return (traerDia(fecha) + "/" + traerMes(fecha) + "/" + traerAnio(fecha));
	}
	
	public static String traerFechaCortaHora(GregorianCalendar fecha) {
		return (traerDia(fecha) + "/" + traerMes(fecha) + "/" + traerAnio(fecha) + " " + fecha.get(Calendar.HOUR_OF_DAY) + ":" + fecha.get(Calendar.MINUTE) + ":" + fecha.get(Calendar.SECOND));
	}
	
	public static GregorianCalendar traerFechaProximo(GregorianCalendar fecha, int dias) {
		GregorianCalendar resultado = fecha;
		resultado.add(Calendar.DAY_OF_MONTH, dias);
		return resultado;
	}
	
	public static boolean esDiaHabil (GregorianCalendar fecha) {
		return (fecha.get(Calendar.DAY_OF_WEEK) > 1) && (fecha.get(Calendar.DAY_OF_WEEK) < 7);
	}
	
	public static String traerDiaDeLaSemana (GregorianCalendar fecha) {
		String resultado;
		switch(fecha.get(Calendar.DAY_OF_WEEK)) {
			case 1:
				resultado = "Domingo";
				break;
			case 2:
				resultado = "Lunes";
				break;
			case 3:
				resultado = "Martes";
				break;
			case 4:
				resultado = "Miercoles";
				break;
			case 5:
				resultado = "Jueves";
				break;
			case 6:
				resultado = "Viernes";
				break;
			case 7:
				resultado = "Sabado";
				break;
			default:
				resultado = "null";
		}
		return resultado;
	}
	
	public static String traerMesEnLetras (GregorianCalendar fecha) {
		String resultado;
		
		switch (fecha.get(Calendar.MONTH)) {
			case 0:
				resultado = "Enero";
				break;
			case 1:
				resultado = "Febrero";
				break;
			case 2:
				resultado = "Marzo";
				break;
			case 3:
				resultado = "Abril";
				break;
			case 4:
				resultado = "Mayo";
				break;
			case 5:
				resultado = "Junio";
				break;
			case 6:
				resultado = "Julio";
				break;
			case 7:
				resultado = "Agosto";
				break;
			case 8:
				resultado = "Septiembre";
				break;
			case 9:
				resultado = "Octubre";
				break;
			case 10:
				resultado = "Noviembre";
				break;
			case 11:
				resultado = "Diciembre";
				break;
			default:
				resultado = "null";
		}
		return resultado;
	}
	
	public static String traerFechaLarga(GregorianCalendar fecha) {
		return (traerDiaDeLaSemana(fecha) + " " + traerDia(fecha) + " de " + traerMesEnLetras(fecha) + " del " + traerAnio(fecha));
	}
	
	public static boolean sonFechasIguales (GregorianCalendar fecha1, GregorianCalendar fecha2) {
		return ((traerAnio(fecha1) == traerAnio(fecha2)) && (traerMes(fecha1) == traerMes(fecha2)) && (traerDia(fecha1) == traerDia(fecha2)));
	}
	
	public static boolean sonFechasHorasIguales (GregorianCalendar fecha1, GregorianCalendar fecha2) {
		return ((fecha1.get(Calendar.HOUR_OF_DAY) == fecha2.get(Calendar.HOUR_OF_DAY)) && (fecha1.get(Calendar.MINUTE) == fecha2.get(Calendar.MINUTE)) && (fecha1.get(Calendar.SECOND) == fecha2.get(Calendar.SECOND)));
	}
	
	public static boolean sonFechasYHorasIguales (GregorianCalendar fecha1, GregorianCalendar fecha2) {
		return (sonFechasIguales(fecha1, fecha2) && sonFechasHorasIguales(fecha1, fecha2));
	}
	
	public static double diferenciaFechaEnHoras(GregorianCalendar fechaInicio, GregorianCalendar fechaFin){
		return (fechaFin.getTimeInMillis() - fechaInicio.getTimeInMillis()) / 1000.0 / 3600.0;
	}
	
	public static double aproximar2Decimal (double valor) {
		return Math.rint(valor*100)/100;
	}
	
	public static boolean esNumero(char c) {		
		return Character.isDigit(c);
	}
	
	public static boolean esLetra(char c) {
		return Character.isLetter(c);
	}
	
	public static boolean esCadenaNros(String cadena) {
		int		i;
		boolean	resp = true;
		
		for(i = 0; i < cadena.length(); i++){
			if(!esNumero(cadena.toCharArray()[i])) {
				resp = false;
			}			
		}
		
		return resp;
	}
	
	public static boolean esCadenaLetras(String cadena){
		int		i;
		boolean	resp = true;
		
		for(i = 0; i < cadena.length(); i++){
			if(!esLetra(cadena.toCharArray()[i])) {
				resp = false;
			}			
		}
		
		return resp;		
	}
	
	public static double calcularCoseno(double angulo){
		return Math.cos(angulo);
	}
	
	public static double calcularSeno(double angulo){
		return Math.sin(angulo);
	}
	
	public static double calcularArcoSeno(double angulo){
		return Math.asin(angulo);
	}
	
	public static double calcularPotencia(double base, double exponente){
		return Math.pow(base, exponente);
	}
	
	public static double calcularRaizCuadrada(double x){
		return Math.sqrt(x);
	}
	
	public static double getPi(){
		return Math.PI;
	}
}
