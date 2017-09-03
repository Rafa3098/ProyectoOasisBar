package com.OasisBar.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.OasisBar.Menú.MenusCliente;
import com.OasisBar.control.ClienteCtrl;
import com.OasisBar.control.Conexion;

import com.OasisBar.entity.Cliente;
import com.OasisBar.view.ReadTypes;


public class ClienteView {

	
	private Scanner scanner;
	private Cliente cliente;
	private ClienteCtrl clienteCtrl;
	
	
	public ClienteView(Conexion conexion, Scanner scanner) {
	
		this.scanner = scanner;
		clienteCtrl = new  ClienteCtrl(conexion);
		
	}

	public void insertar() {
		String NIT;
		String nombre;

		NIT = ReadTypes.leerCadena(scanner, "Ingrese el NIT: ");
		nombre = ReadTypes.leerCadena(scanner, "Ingrese el nombre: ");
		
		cliente = new Cliente(NIT,nombre);
		
		try {
			clienteCtrl.insert(cliente);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
	
	public void listar() {
		ArrayList<Cliente> clientes;

		try {
			clientes = clienteCtrl.list();
			for (int i = 0; i < clientes.size(); i++) {
				System.out.println(clientes.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}


	public void buscar(String NIT) {
		cliente = new Cliente(NIT);
		try {
			clienteCtrl.search(cliente);
			if(cliente.getNombre()==null){System.out.println("Cliente no registrado");
			System.out.println("Si desea registrar al cliente presione 1");
			System.out.println("Si desea ingresar el NIT nuevamente presione 2");
			System.out.println("Presione cualquier otro numero para salir");
			int opcion=ReadTypes.leerEntero(scanner, "Ingrese la opción deseada: ");
			if(opcion==1){
			this.insertar();}
			else if(opcion==2){
				String NIT2 =ReadTypes.leerCadena(scanner,"Ingrese nuevamente el NIT del cliente: ");
				this.buscar(NIT2);}
			}
			
			else {System.out.println(cliente);}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}


	public void actualizar() {
		String NIT;
		this.listar();
		NIT = ReadTypes.leerCadena(scanner, "Ingrese el NIT del cliente a modificar: ");
		cliente = new Cliente(NIT);
		try {
			clienteCtrl.search(cliente);
			if(cliente.getNombre()==null){System.out.println("Cliente no registrado");
			System.out.println("Si desea registrar al cliente presione 1");
			System.out.println("Si desea ingresar el NIT nuevamente presione 2");
			System.out.println("Presione cualquier otro numero para salir");
			int opcion=ReadTypes.leerEntero(scanner, "Ingrese la opción deseada: ");
			
			if(opcion==1){
			this.insertar();}
			else if(opcion==2){
				this.actualizar();}
			}
			
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}
		if(cliente.getNombre()!=null)
		{MenusCliente.menuModificar(scanner, cliente);}

		try {
			clienteCtrl.update(cliente);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	
	
	
	public boolean buscarParaVenta(String NIT) {
		boolean f=true;
		cliente = new Cliente(NIT);
		try {
			clienteCtrl.search(cliente);
			if(cliente.getNombre()==null){System.out.println("Cliente no registrado");
			System.out.println("Si desea registrar al cliente presione 1");
			System.out.println("Si desea ingresar el NIT nuevamente presione 2");
			System.out.println("Presione cualquier otro numero para salir");
			int opcion=ReadTypes.leerEntero(scanner, "Ingrese la opción deseada: ");
			if(opcion==1){
			this.insertar();}
			else if(opcion==2){
				String NIT2 =ReadTypes.leerCadena(scanner,"Ingrese nuevamente el NIT del cliente: ");
				this.buscar(NIT2);}
			else{f=false;}
			}
			
			else {System.out.println(cliente);}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
		return f;
	}
}
