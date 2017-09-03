package com.OasisBar.Menú;

import java.util.Scanner;

import com.OasisBar.control.Conexion;
import com.OasisBar.entity.Insumo;
import com.OasisBar.entity.Trago;
import com.OasisBar.view.ClienteView;
import com.OasisBar.view.InsumoView;
import com.OasisBar.view.ReadTypes;

public class MenuInsumo {
	public static int opcionesModificar(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Actualizar Stock");
				System.out.println("2. Actualizar Nombre");
				System.out.println("3. Actualizar Unidad de medida");
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


	public static void menuModificar(Scanner scanner, Insumo insumo) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Stock anterior: ");
				System.out.println(insumo.getStockInsumo());
				double insumos = ReadTypes.leerReal(scanner, "Ingrese el nuevo valor del stock: ");
				insumo.setStockInsumo(insumos);
				break;
			case 2:
				System.out.print("Nombre anterior: ");
				System.out.println(insumo.getNombre());
				String nombre = ReadTypes.leerCadena(scanner, "Ingrese el nuevo valor de nombre: ");
				insumo.setNombre(nombre);
				break;
			case 3:
				System.out.print("Unidad de medida anterior: ");
				System.out.println(insumo.getUnidadM());
				String unidadM = ReadTypes.leerCadena(scanner, "Ingrese la nueva unidad de medida: ");
				insumo.setUnidadM(unidadM);
				break;
			}
		}
	}
	
	
	
	public static int opcionesInsumo(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Ingresar insumo");
				System.out.println("2. Mostrar lista de insumos");
				System.out.println("3. Actualizar datos de insumo");
				System.out.println("4. Buscar insumo");
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


	public static void menuInsumo(Scanner scanner, Conexion conexion) {
		boolean salir = false;
        InsumoView CV= new InsumoView(conexion,scanner);
		while (!salir) {
			switch (opcionesInsumo(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.println("Inserte los datos del insumo: ");
				CV.insertar();
				break;
			case 2:
				System.out.println("Lista de insumos: ");
				CV.listar();
				break;
			case 3:
				System.out.println("Actualizar datos de insumo: ");
				CV.actualizar();
				break;
			case 4:
				System.out.println("Buscador de insumo");
				int codigo = ReadTypes.leerEntero(scanner,"Ingrese el codigo del insumo: ");
				CV.buscar(codigo);
				break;
			}
		}
	}
}
