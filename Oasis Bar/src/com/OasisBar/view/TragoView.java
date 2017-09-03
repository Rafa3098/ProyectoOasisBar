package com.OasisBar.view;

import java.util.ArrayList;
import java.util.Scanner;
import com.OasisBar.Menú.MenuBebida;
import com.OasisBar.control.Conexion;
import com.OasisBar.control.TragoCtrl;
import com.OasisBar.entity.Trago;
import com.OasisBar.entity.Venta;


public class TragoView {
	private Scanner scanner;
	private Trago trago;
	private Trago trago2;
	private TragoCtrl tragoCtrl;
	
	
	public  TragoView(Conexion conexion, Scanner scanner) {
	
		this.scanner = scanner;
		tragoCtrl = new  TragoCtrl(conexion);
		
	}

	public void insertar() {
		
		String nombre;
		double precioUnitario;
		String descripcion;
		String tipo;
		int cantidadInsumos;

		
		nombre = ReadTypes.leerCadena(scanner, "Ingrese el nombre: ");
		precioUnitario = ReadTypes.leerReal(scanner, "Ingrese el precio unitario: ");
		descripcion = ReadTypes.leerCadena(scanner, "Ingrese la descripción: ");
		tipo = ReadTypes.leerCadena(scanner, "Ingrese el tipo: ");
		cantidadInsumos=ReadTypes.leerEntero(scanner, "Ingrese la cantidad de insumos para la preparacion: ");
		trago = new Trago(nombre,precioUnitario,descripcion,tipo,cantidadInsumos);
		
		try {
			tragoCtrl.insert(trago);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
		
		try {
			trago2 = new Trago(tragoCtrl.CodigoltimoTrago(),cantidadInsumos);
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}
	
	public void listar() {
		ArrayList<Trago> tragos;

		try {
			tragos = tragoCtrl.list();
			for (int i = 0; i < tragos.size(); i++) {
				System.out.println(tragos.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}


	public void buscar(int codigoTrago) {
		trago = new Trago(codigoTrago);
		try {
			tragoCtrl.search(trago);
			if((trago.getNombre()==null) && (trago.getTipo()==null)){System.out.println("No existe una bebida con el codigo ingresado");
			System.out.println("Si desea ingresar la busqueda nuevamente presione 1");
			System.out.println("Presione cualquier otro numero para salir");
			int opcion=ReadTypes.leerEntero(scanner, "Ingrese la opción deseada: ");
			if(opcion==1){
				int codigo =ReadTypes.leerEntero(scanner,"Ingrese nuevamente el codigo de la bebida: ");
				this.buscar(codigo);}
			}
			else{System.out.println(trago);}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}


	public void actualizar() {
		int codigoTrago;
		this.listar();
		codigoTrago = ReadTypes.leerEntero(scanner, "Ingrese el codigo de trago a modificar: ");
		trago = new Trago(codigoTrago);
		try {
			tragoCtrl.search(trago);
			if((trago.getNombre()==null)){System.out.println("No existe una bebida con el codigo ingresado");
			System.out.println("Si desea ingresar el codigo nuevamente presione 1");
			System.out.println("Presione cualquier otro numero para salir");
			int opcion=ReadTypes.leerEntero(scanner, "Ingrese la opción deseada: ");
			if(opcion==1){
				int codigo =ReadTypes.leerEntero(scanner,"Ingrese nuevamente el codigo de la bebida: ");
				this.actualizar();}
			}
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}
		if (trago.getNombre()!=null){
		MenuBebida.menuModificar(scanner, trago);}

		try {
			tragoCtrl.update(trago);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	public Trago getTrago() {
		return trago2;
	}
	
	
	
	
	public void listarPreparacion(int codigotrago) {
		ArrayList<Trago> tragos;

		try {
			tragos = tragoCtrl.PreparacionTrago(codigotrago);
			for (int i = 0; i < tragos.size(); i++) {
				System.out.println(tragos.get(i).Preparacion());
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	
}
