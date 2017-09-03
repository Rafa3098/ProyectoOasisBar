package com.OasisBar.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.OasisBar.Menú.MenuPrincipal;
import com.OasisBar.control.Conexion;
import com.OasisBar.entity.Insumo;



public class Pantalla {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Conexion conexion = new Conexion();
		
		ClienteView cV= new ClienteView(conexion,scanner);
		
		DetalleRecetaView drv= new DetalleRecetaView(conexion,scanner);
		InsumoView iv= new InsumoView(conexion,scanner);
		TragoView tv = new TragoView(conexion,scanner);
		
	
		/*tv.listar();
		int codigo = ReadTypes.leerEntero(scanner, " ");
		TR.buscar(codigo);*/
		//RecetaTragoView rtv=new RecetaTragoView(conexion,scanner);
		/*TragoView tv = new TragoView(conexion,scanner);
		tv.listar();*/
		
		//VentaView vv = new VentaView(conexion,scanner);
		//vv.buscar("12345");
		
		MenuPrincipal MP = new MenuPrincipal();
		MP.subMenu(scanner,conexion);
		
		
		/*VentaView vV= new VentaView(conexion,scanner);
		DetalleVentaView dVV= new DetalleVentaView(conexion,scanner);
		vV.insertar();
		dVV.setVenta(vV.getVenta());
		dVV.insertar();*/
		/*
		iv.listar();
		tv.listar();
		rtv.listar();
		drv.listar();*/
		/*TragoView CV= new TragoView(conexion,scanner);
        
        DetalleRecetaView DRT=new DetalleRecetaView(conexion,scanner);
        InsumoView Ins = new InsumoView(conexion,scanner);
        System.out.println("Inserte los datos de la bebida: ");
		CV.insertar();
		System.out.println("Inserte los datos para la preparación: ");
		TR.insertar();
		System.out.println(TR.getRecetatrago2());
		int c = TR.getRecetatrago2().getCantidadDetalles();
		for(int i=0; i<c; i++){
			DRT.setRecetatrago(TR.getRecetatrago2());
		System.out.println("Inserte los datos del insumo a utilizar: ");
		Ins.listar();
			DRT.insertar();}
		//drv.buscar(2);*/
		
		try {
			conexion.close();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
		
		
		scanner.close();

	}

}
