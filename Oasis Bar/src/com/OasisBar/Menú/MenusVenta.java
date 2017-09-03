package com.OasisBar.Menú;

import java.util.Date;
import java.util.Scanner;

import com.OasisBar.control.Conexion;
import com.OasisBar.entity.Venta;
import com.OasisBar.view.DetalleVentaView;
import com.OasisBar.view.InsumoView;
import com.OasisBar.view.ReadTypes;
import com.OasisBar.view.VentaView;


public class MenusVenta {
	public static int opcionesModificar(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Actualizar FechaVenta");
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


	public static void menuModificar(Scanner scanner, Venta venta) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Fecha de venta anterior anterior: ");
				System.out.println(venta.getFechaVenta());
				Date fecha = ReadTypes.leerFecha(scanner, "Ingrese el nuevo valor de fecha: ");
				venta.setFechaVenta(fecha);;
				break;
			}
		}
	}
	
	
	public static int opcionesVenta(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Ingresar venta");
				System.out.println("2. Mostrar lista de ventas realizadas");
				System.out.println("3. Buscar ventas hechas por un cliente");
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


	public static void menuVenta(Scanner scanner, Conexion conexion) {
		boolean salir = false;
		VentaView vV= new VentaView(conexion,scanner);
		DetalleVentaView dVV= new DetalleVentaView(conexion,scanner);
        InsumoView CV= new InsumoView(conexion,scanner);
		while (!salir) {
			switch (opcionesVenta(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.println("Ingrese la nueva venta: ");
				vV.insertar();
				dVV.setVenta(vV.getVenta());
				dVV.insertar();
				break;
			case 2:
				System.out.println("Lista de ventas realizadas: ");
				vV.listar();
				break;
			case 3:
				System.out.println("Buscador de compras por cliente");
				String codigo = ReadTypes.leerCadena(scanner,"Ingrese el NIT del cliente: ");
				vV.listarPcliente(codigo);;
				break;
			}
		}
	}
}
