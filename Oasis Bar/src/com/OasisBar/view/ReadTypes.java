package com.OasisBar.view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ReadTypes {

	public static Date leerFecha(Scanner scanner, String msg) {
		Date fecha;
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		while (true) {
			System.out.print(msg);
			try {
				fecha = formato.parse(scanner.nextLine());
				return fecha;
			} catch (ParseException e) {
				System.out.println("Error en el formato de fecha");
			}
		}
	}

	public static java.sql.Date cASqlDate (java.util.Date uDate) {
		return new java.sql.Date(uDate.getTime());
        
    }
	
	public static int leerEntero(Scanner scanner, String msg) {
		int numero = 0;

		while (true) {
			System.out.print(msg);
			try {
				numero = scanner.nextInt();
				scanner.nextLine();
				return numero;
			} catch (java.util.InputMismatchException e) {
				scanner.nextLine();
				System.out.println(" ERROR EN FORMATO NUMÉRICO!! ");
			}
		}
	}
	
	public static double leerReal(Scanner scanner, String msg) {
		double numero = 0;

		while (true) {
			System.out.print(msg);
			try {
				numero = scanner.nextDouble();
				scanner.nextLine();
				return numero;
			} catch (java.util.InputMismatchException e) {
				scanner.nextLine();
				System.out.println(" ERROR EN FORMATO NUMÉRICO!! ");
			}
		}
	}
	
	public static String leerCadena(Scanner scanner, String msg) {
		String cadena = "";

		while (true) {
			System.out.print(msg);
			try {
				cadena = scanner.nextLine();
				return cadena;
			} catch (java.util.InputMismatchException e) {
				System.out.println("ERROR EN FORMATO DE CADENA!!");
			}
		}
	}
}
