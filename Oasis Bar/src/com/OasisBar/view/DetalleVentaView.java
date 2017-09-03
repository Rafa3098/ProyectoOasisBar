package com.OasisBar.view;

import java.util.ArrayList;
import java.util.Scanner;


import com.OasisBar.Menú.MenuDetalle;
import com.OasisBar.control.Conexion;
import com.OasisBar.control.DetalleRecetaCtrl;
import com.OasisBar.control.DetalleVentaCtrl;
import com.OasisBar.entity.DetalleReceta;
import com.OasisBar.entity.DetalleVenta;
import com.OasisBar.entity.Venta;
import com.OasisBar.view.ReadTypes;


public class DetalleVentaView {
	private Scanner scanner;
	private Conexion conexion;
	private DetalleVenta detalleventa;
	private DetalleVentaCtrl detalleVentaCtrl;
	private DetalleRecetaCtrl detalleRecetaCtrl;
	private Venta venta;
	private TragoView Tv;
	
	public  DetalleVentaView(Conexion conexion, Scanner scanner) {
	
		this.scanner = scanner;
		detalleVentaCtrl= new  DetalleVentaCtrl(conexion);
		this.conexion = conexion;
	}


	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public void insertar() {
		
		int opcion;
		do { 
		 int codigoVenta=venta.getCodigoVenta();
		 int codigoTrago;
		 int cantidad;
         TragoView Tv = new TragoView(conexion,scanner);
		 Tv.listar();
		 codigoTrago = ReadTypes.leerEntero(scanner, "Ingrese el codigo de trago: ");
		 cantidad = ReadTypes.leerEntero(scanner, "Ingrese la cantidad: ");
		
		 detalleventa = new DetalleVenta(codigoVenta,codigoTrago,cantidad);
		
		 
		 
		 
		try {
			detalleVentaCtrl.insert(detalleventa);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Si desea agregar mas productos a la compra presione 1");
		System.out.println("Si desea finalizar  a la compra presione cualquier otro número");
		opcion=ReadTypes.leerEntero(scanner, "Ingrese la opción deseada: ");
	
	
	}
	while(opcion==1);

	}
	
	public void listar() {
		ArrayList<DetalleVenta> detalleventa;

		try {
			detalleventa = detalleVentaCtrl.list();
			for (int i = 0; i < detalleventa.size(); i++) {
				System.out.println(detalleventa.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}


	public void buscar(int codigoDV) {
		detalleventa = new DetalleVenta(codigoDV);
		try {
			detalleVentaCtrl.search(detalleventa);
			System.out.println(detalleventa);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}


	public void actualizar() {
		int codigoDV;
		
		 codigoDV = ReadTypes.leerEntero(scanner, "Ingrese el codigo de detalle de venta a modificar: ");
		 detalleventa = new DetalleVenta(codigoDV);
		try {
			detalleVentaCtrl.search(detalleventa);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenuDetalle.menuModificar(scanner, detalleventa);

		try {
			detalleVentaCtrl.update(detalleventa);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	
public void stockNecesario(int cantidadStock,int cantidadPedida) {
		
		
		if(cantidadStock>=cantidadPedida){System.out.println("Si alcanza");}
		else {System.out.println("No alcanza");}
	}

	public DetalleVenta getDetalleVenta() {
		return detalleventa;
	}
	
}
