package com.OasisBar.Menú;

import java.util.Scanner;

import com.OasisBar.control.Conexion;
import com.OasisBar.entity.Cliente;
import com.OasisBar.view.ClienteView;
import com.OasisBar.view.ReadTypes;



public class MenusCliente {
	
	public static int opcionesModificar(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Actualizar Nombre");
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


	public static void menuModificar(Scanner scanner, Cliente cliente) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Nombre anterior: ");
				System.out.println(cliente.getNombre());
				String nombre = ReadTypes.leerCadena(scanner, "Ingrese el nuevo valor de nombre: ");
				cliente.setNombre(nombre);
				break;
			}
		}
	}
	
	public static int opcionesCliente(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Ingresar cliente");
				System.out.println("2. Mostrar lista de clientes");
				System.out.println("3. Actualizar datos de cliente");
				System.out.println("4. Buscar cliente");
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


	public static void menuCliente(Scanner scanner, Conexion conexion) {
		boolean salir = false;
        ClienteView CV= new ClienteView(conexion,scanner);
		while (!salir) {
			switch (opcionesCliente(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.println("Inserte los datos del cliente: ");
				CV.insertar();
				break;
			case 2:
				System.out.println("Lista de clientes: ");
				CV.listar();
				break;
			case 3:
				System.out.println("Actualizar datos de cliente: ");
				CV.actualizar();
				break;
			case 4:
				System.out.println("Buscador de cliente");
				String codigo = ReadTypes.leerCadena(scanner,"Ingrese el NIT del cliente: ");
				CV.buscar(codigo);
				break;
			}
		}
	}
}
