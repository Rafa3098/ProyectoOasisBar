package com.OasisBar.Menú;

import java.util.Scanner;

import com.OasisBar.control.Conexion;

public class MenuPrincipal {
	public static int menu(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Menú Cliente" );
				System.out.println("2. Menú de insumos" );
				System.out.println("3. Menú de ventas" );
				System.out.println("4. Menú de bebidas" );
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

	public static void subMenu(Scanner leer, Conexion conexion) {
		boolean salir = false;
	
		while (!salir) {
			switch (menu(leer)) {
			case 0:
				salir = true;
				break;
			case 1:
                MenusCliente.menuCliente(leer, conexion);
				break;
			case 2:
				MenuInsumo.menuInsumo(leer, conexion);
				break;
			case 3:
                MenusVenta.menuVenta(leer, conexion);
				break;
			case 4:
               MenuBebida.menuTrago(leer, conexion);
				break;
			}
		}
	}
}
