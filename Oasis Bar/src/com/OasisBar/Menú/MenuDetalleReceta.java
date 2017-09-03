package com.OasisBar.Menú;

import java.util.Scanner;

import com.OasisBar.entity.DetalleReceta;
import com.OasisBar.view.ReadTypes;

public class MenuDetalleReceta {
	public static int opcionesModificar(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Actualizar codigo de Insumo");
				System.out.println("0. Salir");
				System.out.println();

				opcion = scanner.nextInt();
				scanner.nextLine();

				if (opcion >= 0 && opcion <= 4) {
					return opcion;
				}

			} catch (java.util.InputMismatchException e) {
				System.out.println("Ingrese solo valores numéricos");
				System.out.println();
				scanner.nextLine();
			}
		}
	}


	public static void menuModificar(Scanner scanner, DetalleReceta detalleReceta) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Codigo de insumo anterior: ");
				System.out.println(detalleReceta.getCodigoInsumo());
				int codigo = ReadTypes.leerEntero(scanner, "Ingrese el nuevo codigo de insumo: ");
				detalleReceta.setCodigoInsumo(codigo);
				break;
			}
		}
	}
}
