package com.OasisBar.Menú;

import java.util.Scanner;

import com.OasisBar.control.Conexion;
import com.OasisBar.entity.Trago;
import com.OasisBar.view.DetalleRecetaView;
import com.OasisBar.view.InsumoView;
import com.OasisBar.view.ReadTypes;
import com.OasisBar.view.TragoView;

public class MenuBebida {
	public static int opcionesModificar(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Actualizar Nombre");
				System.out.println("2. Actualizar Descripción");
				System.out.println("3. Actualizar Precio");
				System.out.println("4. Actualizar Tipo de bebida");
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


	public static void menuModificar(Scanner scanner, Trago tragos) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Nombre anterior: ");
				System.out.println(tragos.getNombre());
				String nombre = ReadTypes.leerCadena(scanner, "Ingrese el nuevo valor de nombre: ");
				tragos.setNombre(nombre);
				break;
			case 2:
				System.out.print("Descripcion anterior: ");
				System.out.println(tragos.getDescripcion());
				String descripcion = ReadTypes.leerCadena(scanner, "Ingrese la nueva descripción: ");
				tragos.setDescripcion(descripcion);;
				break;
			case 3:
				System.out.print("Precio anterior: ");
				System.out.println(tragos.getPrecio());
				double precio = ReadTypes.leerEntero(scanner, "Ingrese el nuevo precio: ");
				tragos.setPrecio(precio);;
				break;
			case 4:
				System.out.print("Tipo de bebida anterior: ");
				System.out.println(tragos.getTipo());
				String tipo = ReadTypes.leerCadena(scanner, "Ingrese el nuevo tipo de bebidae: ");
				tragos.setTipo(tipo);
				break;
				
			}
		}
	}
	
	
	public static int opcionesTrago(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Ingresar nueva bebida");
				System.out.println("2. Mostrar lista de bebidas");
				System.out.println("3. Actualizar datos de bebida");
				System.out.println("4. Buscar bebida");
				System.out.println("5. Mostrar preparación de bebida");
				System.out.println("0. Salir");
				System.out.println();

				opcion = scanner.nextInt();
				scanner.nextLine();

				if (opcion >= 0 && opcion <= 5) {
					return opcion;
				}

			} catch (java.util.InputMismatchException e) {
				System.out.println("Ingrese solo valores numéricos");
				System.out.println();
				scanner.nextLine();
			}
		}
	}


	public static void menuTrago(Scanner scanner, Conexion conexion) {
		boolean salir = false;
        TragoView CV= new TragoView(conexion,scanner);
        DetalleRecetaView DRT=new DetalleRecetaView(conexion,scanner);
		while (!salir) {
			switch (opcionesTrago(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
		        InsumoView Ins = new InsumoView(conexion,scanner);
		        System.out.println("Inserte los datos de la bebida: ");
				CV.insertar();
				DRT.setTrago(CV.getTrago());
				DRT.insertar();
				break;
			case 2:
				System.out.println("Lista de bebidas: ");
				CV.listar();
				break;
			case 3:
				System.out.println("Actualizar datos de bebida: ");
				CV.actualizar();
				break;
			case 4:
				System.out.println("Buscador de bebidas");
				int codigo = ReadTypes.leerEntero(scanner,"Ingrese el codigo de la bebida: ");
				CV.buscar(codigo);
				break;	
			case 5:
				System.out.println("Preparación de bebidas");
				CV.listar();
				int codigotrago= ReadTypes.leerEntero(scanner, "Ingrese el codigo del trago a preparar: ");
				CV.buscar(codigotrago);
				CV.listarPreparacion(codigotrago);
				break;
			}
		}
	}
}
