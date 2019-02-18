package empresa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Util {
	public static String introducirCadena() {
		String cadena="";
		InputStreamReader entrada =new InputStreamReader(System.in);
		BufferedReader teclado= new BufferedReader(entrada);
		try {
			cadena=teclado.readLine();
		}
		catch(IOException e) {
			System.out.println("Error al introducir datos");
		}
		return cadena;
	}
	public static String introducirCadena(String mensaje) {
		String cadena="";
		InputStreamReader entrada =new InputStreamReader(System.in);
		BufferedReader teclado= new BufferedReader(entrada);
		System.out.println(mensaje);
		try {
			cadena=teclado.readLine();
		}
		catch(IOException e) {
			System.out.println("Error al introducir datos");
		}
		return cadena;
	}
	
	public static int leerInt(String mensaje) {
		int numero = 0;
		boolean error;
		System.out.println(mensaje);
		do {
			error=false;
			try {
				numero=Integer.parseInt(introducirCadena());	
			}
			catch(NumberFormatException e) {
				System.out.println("Error, el dato no es numérico. Introduce de nuevo: ");
				error=true;
			}
		}while(error);
		return numero;
	}
	
	public static int leerInt(String mensaje, int x, int y) {
		int numero=x;
		boolean error;
		System.out.println(mensaje);
		do {
			error=false;
			try {
				numero=Integer.parseInt(introducirCadena());	
			}
			catch(NumberFormatException e) {
				System.out.println("Error, el dato no es numérico. Introduce de nuevo: ");
				error=true;
			}
			if (numero<x || numero>y) {
				System.out.println("Error, dato fuera de rango. Introduce de nuevo: ");
				error=true;
			}
		}while(error);
		return numero;
	}
	
	public static float leerFloat(String mensaje) {
		float numero = 0;
		boolean error;
		System.out.println(mensaje);
		do {
			error=false;
			try {
				numero=Float.parseFloat(introducirCadena());
			}
			catch(NumberFormatException e) {
				System.out.println("Error, el dato no es numérico. Introduce de nuevo: ");
				error=true;
			}
		}while(error);
		return numero;
	}
	
	public static float leerFloat(String mensaje, float x, float y) {
		float numero=x;
		boolean error;
		System.out.println(mensaje);
		do {
			error=false;
			try {
				numero=Float.parseFloat(introducirCadena());	
			}
			catch(NumberFormatException e) {
				System.out.println("Error, el dato no es numérico. Introduce de nuevo: ");
				error=true;
			}
			if (numero<x || numero>y) {
				System.out.println("Error, dato fuera de rango. Introduce de nuevo: ");
				error=true;
			}
		}while(error);
		return numero;
	}
}