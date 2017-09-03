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
		
		
	
		MenuPrincipal MP = new MenuPrincipal();
		MP.subMenu(scanner,conexion);
		
		
		
		try {
			conexion.close();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
		
		
		scanner.close();

	}

}
