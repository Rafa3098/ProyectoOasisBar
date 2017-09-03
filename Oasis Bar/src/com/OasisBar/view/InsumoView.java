package com.OasisBar.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.OasisBar.Menú.MenuBebida;
import com.OasisBar.Menú.MenuInsumo;
import com.OasisBar.control.Conexion;
import com.OasisBar.control.InsumoCtrl;
import com.OasisBar.control.TragoCtrl;
import com.OasisBar.entity.Insumo;
import com.OasisBar.entity.Trago;

public class InsumoView {
	private Scanner scanner;
	private Insumo insumo;
	private InsumoCtrl insumoCtrl;
	
	
	public  InsumoView(Conexion conexion, Scanner scanner) {
	
		this.scanner = scanner;
		insumoCtrl = new  InsumoCtrl(conexion);
		
	}

	public void insertar() {
		
		String nombre;
		double stockInsumo;
		String unidadM;
		String tipo;

		
		nombre = ReadTypes.leerCadena(scanner, "Ingrese el nombre: ");
		unidadM = ReadTypes.leerCadena(scanner, "Ingrese la unidad de medidad para el stock: ");
		stockInsumo = ReadTypes.leerReal(scanner, "Ingrese la cantidad en stock: ");
		tipo = ReadTypes.leerCadena(scanner, "Ingrese el tipo: ");
		insumo = new Insumo(nombre,stockInsumo,unidadM,tipo);
		
		try {
			insumoCtrl.insert(insumo);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
	
	public void listar() {
		ArrayList<Insumo> insumo;

		try {
			insumo = insumoCtrl.list();
			for (int i = 0; i < insumo.size(); i++) {
				System.out.println(insumo.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}


	public void buscar(int codigoinsumo) {
		insumo = new Insumo(codigoinsumo);
		try {
			insumoCtrl.search(insumo);
			if((insumo.getNombre()==null) && (insumo.getTipo()==null)){System.out.println("Insumo no registrado");
			System.out.println("Si desea registrar el Insumo presione 1");
			System.out.println("Si desea ingresar la busqueda nuevamente presione 2");
			int opcion=ReadTypes.leerEntero(scanner, "Ingrese la opción deseada: ");
			if(opcion==1){
			this.insertar();}
			else if(opcion==2){
				int codigo =ReadTypes.leerEntero(scanner,"Ingrese nuevamente el codigo del insumo: ");
				this.buscar(codigo);}
			else if (opcion!=1 && opcion!=2){int codigo2 =ReadTypes.leerEntero(scanner,"Tiene que ingresar un codigo que exista!!: "); this.buscar(codigo2);}
			}
			else{System.out.println(insumo);}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}


	public void actualizar() {
		int codigoInsumo;
		this.listar();
		codigoInsumo = ReadTypes.leerEntero(scanner, "Ingrese el codigo de insumo a modificar: ");
		insumo = new Insumo(codigoInsumo);
		try {
			insumoCtrl.search(insumo);
			if((insumo.getNombre()==null)){System.out.println("Insumo no registrado");
			System.out.println("Si desea registrar el Insumo presione 1");
			System.out.println("Si desea ingresar el codigo nuevamente presione 2");
			System.out.println("Presione cualquier otro numero para salir");
			int opcion=ReadTypes.leerEntero(scanner, "Ingrese la opción deseada: ");
			if(opcion==1){
			this.insertar();}
			else if(opcion==2){
				int codigo =ReadTypes.leerEntero(scanner,"Ingrese nuevamente el codigo del insumo: ");
				this.actualizar();}
			}
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}
        
		if (insumo.getNombre()!=null){
		MenuInsumo.menuModificar(scanner, insumo);}

		try {
			 insumoCtrl.update( insumo);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
}
