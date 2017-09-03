package com.OasisBar.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.OasisBar.Menú.MenuDetalleReceta;
import com.OasisBar.control.Conexion;
import com.OasisBar.control.DetalleRecetaCtrl;
import com.OasisBar.entity.DetalleReceta;
import com.OasisBar.entity.Trago;



public class DetalleRecetaView {
	private Scanner scanner;
	private Conexion conexion;
	private DetalleReceta detalleReceta;
	private DetalleRecetaCtrl detalleRecetaCtrl;
	private Trago trago;
	
	public  DetalleRecetaView(Conexion conexion, Scanner scanner) {
	
		this.scanner = scanner;
		this.conexion=conexion;
		detalleRecetaCtrl= new  DetalleRecetaCtrl(conexion);
		
	}


	

	public void insertar() {
	
		 int codigoInsumo;
		 int cantidadI;
         int codigotrago=trago.getCodigoTrago();
         int cantidadinsumos=trago.getCantidadInsumos();
         
         /*try {
			cantidadinsumos=detalleRecetaCtrl.CantidadInsumosUltimoTrago(trago.getCodigoTrago());
			System.out.println(cantidadinsumos);
		} catch (Throwable e1) {
			
			e1.printStackTrace();
		}*/
         System.out.println(cantidadinsumos);
         for (int c=0;c<cantidadinsumos;c++){
		InsumoView IV = new InsumoView (conexion,scanner);
		IV.listar();
		 codigoInsumo = ReadTypes.leerEntero(scanner, "Ingrese el codigo de insumo: ");
		 IV.buscar(codigoInsumo);
		 cantidadI = ReadTypes.leerEntero(scanner, "Ingrese la cantidad del insumo: ");
		
		 detalleReceta = new DetalleReceta(codigoInsumo,cantidadI,codigotrago);
		
		try {
			detalleRecetaCtrl.insert(detalleReceta);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
         }

	}
	

	public Trago getTrago() {
		return trago;
	}
	public void setTrago(Trago trago) {
		this.trago = trago;
	}




	public void listar() {
		ArrayList<DetalleReceta> detalleReceta;

		try {
			detalleReceta = detalleRecetaCtrl.list();
			for (int i = 0; i < detalleReceta.size(); i++) {
				System.out.println(detalleReceta.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}


	public void buscar(int codigoDR) {
		detalleReceta = new DetalleReceta(codigoDR);
		try {
			detalleRecetaCtrl.search(detalleReceta);
			System.out.println(detalleReceta);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}


	public void actualizar() {
		int codigoDR;
		
		 codigoDR = ReadTypes.leerEntero(scanner, "Ingrese el codigo de detalle de Receta a modificar: ");
		 detalleReceta = new DetalleReceta(codigoDR);
		try {
			detalleRecetaCtrl.search(detalleReceta);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenuDetalleReceta.menuModificar(scanner, detalleReceta);

		try {
			detalleRecetaCtrl.update(detalleReceta);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	
}	
	
	
	
	
	
	
	
	
/*public void stockNecesario(int cantidadStock,int cantidadPedida) {
		
		
		if(cantidadStock>=cantidadPedida){System.out.println("Si alcanza");}
		else {System.out.println("No alcanza");}
	}*/



