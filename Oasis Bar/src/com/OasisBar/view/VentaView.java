package com.OasisBar.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.OasisBar.Menú.MenusVenta;
import com.OasisBar.control.Conexion;
import com.OasisBar.control.VentaCtrl;
import com.OasisBar.entity.Venta;


public class VentaView {

	
	private Scanner scanner;
	private  Venta Venta;
	private VentaCtrl VentaCtrl;
	private Conexion conexion;
	

	public VentaView(Conexion conexion, Scanner scanner) {
	
		this.scanner = scanner;
		VentaCtrl = new  VentaCtrl(conexion);
		this.conexion = conexion;
		
	}

	public void insertar() {
		
		String NIT;
		Date fechaVenta;

		NIT = ReadTypes.leerCadena(scanner, "Ingrese el NIT: ");
		ClienteView cV=new ClienteView(conexion,scanner);
		boolean c=cV.buscarParaVenta(NIT);
		if(c==true){
		fechaVenta = new Date();
	

		
			Venta = new Venta(fechaVenta,NIT);
			
		     
		try {
			VentaCtrl.insert(Venta);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Venta = new Venta(VentaCtrl.CodultimaVenta());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		}
		else if(c==false){System.out.println("La venta no puede continuar debido a que no se tiene el NIT del cliente"); this.insertar();}

	}
	
	public void listar() {
		ArrayList<Venta> Ventas;

		try {
			Ventas = VentaCtrl.list();
			for (int i = 0; i < Ventas.size(); i++) {
				System.out.println(Ventas.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	
	public void buscar(String NIT) {
		
		Venta.setNIT(NIT);
		try {
			VentaCtrl.search(Venta);
			System.out.println(Venta);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}



	/*public void actualizar() {
		String NIT;
		
		NIT = ReadTypes.leerCadena(scanner, "Ingrese el NIT de la Venta a modificar: ");
		Venta.setNIT(NIT);
		try {
			VentaCtrl.search(Venta);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenusVenta.menuModificar(scanner, Venta);

		try {
			VentaCtrl.update(Venta);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}*/

	public Venta getVenta() {
		return Venta;
	}
	
	
	

	
}
