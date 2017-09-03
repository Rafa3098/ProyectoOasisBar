package com.OasisBar.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.OasisBar.entity.Cliente;



public class ClienteCtrl implements Control<Cliente>{
	
	private Conexion conexion;
	
	public ClienteCtrl (Conexion conexion) {
		this.conexion = conexion;
	}

	
	public ArrayList<Cliente> list() throws Throwable {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		ResultSet rs;
		String NIT;
		String nombre;

		conexion.SQL("Select * from cliente"); 

		rs = conexion.resultSet();

		while (rs.next()) {
			NIT = rs.getString("NIT");
			nombre = rs.getString("nombre");
			clientes.add(new Cliente(NIT, nombre));
		}

		return clientes;

	}


	public void insert(Cliente cliente) throws Throwable {

		conexion.SQL("Insert into cliente(NIT,nombre) VALUES(?,?)");
		conexion.preparedStatement().setString(1, cliente.getNIT());
		conexion.preparedStatement().setString(2, cliente.getNombre());
		conexion.CUD();

	}

	
	public void search(Cliente cliente) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from cliente where NIT=?");
		conexion.preparedStatement().setString(1, cliente.getNIT());
		rs = conexion.resultSet();

		while (rs.next()) {

			cliente.setNombre(rs.getString("nombre"));
		}

		rs.close();

	}


	public void update(Cliente cliente) throws Throwable {
		String nombre;
		String NIT;
		if (cliente != null) {
			nombre = cliente.getNombre();
			NIT = cliente.getNIT();

			conexion.SQL("Update cliente set nombre = ? where NIT=?");
			conexion.preparedStatement().setString(1, nombre);
			conexion.preparedStatement().setString(2, NIT);
			conexion.CUD();
		}
	}

	
}
