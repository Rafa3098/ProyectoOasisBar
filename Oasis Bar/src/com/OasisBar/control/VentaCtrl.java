package com.OasisBar.control;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.OasisBar.entity.Venta;



public class VentaCtrl implements Control<Venta>{
	
	private Conexion conexion;
	
	public VentaCtrl (Conexion conexion) {
		this.conexion = conexion;
	}

	
	public ArrayList<Venta> list() throws Throwable {
		ArrayList<Venta> ventas = new ArrayList<Venta>();
		ResultSet rs;
		String NIT;
		Date fechaVenta;
		int codigoVenta;
        double monto;
		//conexion.SQL("Select * from venta"); 
		conexion.SQL("select venta.codigoventa,venta.fechaventa,venta.NIT,sum(detalleventa.cantidad*trago.preciounitario) as 'monto' from venta inner join detalleventa on detalleventa.codigoventa =venta.codigoventa inner join trago on trago.codigotrago=detalleventa.codigotrago group by venta.codigoventa");
		rs = conexion.resultSet();

		while (rs.next()) {
			NIT = rs.getString("NIT");
			fechaVenta = rs.getDate("fechaVenta");
			codigoVenta = rs.getInt("codigoVenta");
			monto=rs.getDouble("monto");
			ventas.add(new Venta(codigoVenta,fechaVenta,NIT,monto));
		}

		return ventas;

	}


	public void insert(Venta ventas) throws Throwable {

		conexion.SQL("Insert into venta(codigoVenta,fechaVenta,NIT) VALUES(?,?,?)");
		conexion.preparedStatement().setInt(1, ventas.getCodigoVenta());
		conexion.preparedStatement().setDate(2, new java.sql.Date ( ventas.getFechaVenta().getTime()));
		conexion.preparedStatement().setString(3, ventas.getNIT());
		conexion.CUD();

	}

	
	public void search(Venta ventas) throws Throwable {

		/*ResultSet rs;

		conexion.SQL("select venta.fechaventa,venta.NIT,sum(detalleventa.cantidad*trago.preciounitario) as 'monto' from venta inner join detalleventa on detalleventa.codigoventa =venta.codigoventa inner join trago on trago.codigotrago=detalleventa.codigotrago where NIT=? group by venta.codigoventa");
		conexion.preparedStatement().setString(1, ventas.getNIT());
		rs = conexion.resultSet();

		while (rs.next()) {

			ventas.setFechaVenta((java.util.Date) rs.getDate("fechaVenta"));
			ventas.setNIT(rs.getString("NIT"));
			ventas.setMonto(rs.getDouble("monto"));
		}

		rs.close();*/

	}
	public ArrayList<Venta> listarVentasPorCliente(String Nit) throws Throwable {
		ArrayList<Venta> ventas = new ArrayList<Venta>();
		ResultSet rs;
		String NIT;
		Date fechaVenta;
		int codigoVenta;
        double monto; 
        conexion.SQL("select venta.codigoventa,venta.fechaventa,venta.NIT,sum(detalleventa.cantidad*trago.preciounitario) as 'monto' from venta inner join detalleventa on detalleventa.codigoventa =venta.codigoventa inner join trago on trago.codigotrago=detalleventa.codigotrago where NIT=? group by venta.codigoventa");
		conexion.preparedStatement().setString(1, Nit);
		rs = conexion.resultSet();

		while (rs.next()) {
			NIT = rs.getString("NIT");
			fechaVenta = rs.getDate("fechaVenta");
			codigoVenta = rs.getInt("codigoVenta");
			monto=rs.getDouble("monto");
			ventas.add(new Venta(codigoVenta,fechaVenta,NIT,monto));
		}

		return ventas;

	}
    
	public void update(Venta ventas) throws Throwable {
		String NIT;
		Date fechaVenta;
		int codigoVenta;

		if (ventas != null) {
			codigoVenta = ventas.getCodigoVenta();
			NIT = ventas.getNIT();
			fechaVenta=ventas.getFechaVenta();

			conexion.SQL("Update ventas set fechaVenta=?,NIT = ? where codigoVenta=?");
			conexion.preparedStatement().setDate(1, (java.sql.Date) fechaVenta);
			conexion.preparedStatement().setInt(3, codigoVenta);
			conexion.preparedStatement().setString(2, NIT);
			conexion.CUD();
		}
	}

   public int CodultimaVenta() throws Throwable {
		
        ResultSet rs;
        int resultado=0;
		conexion.SQL(" Select venta.codigoventa from venta order by codigoventa desc limit 1");
		rs=conexion.resultSet();
		while (rs.next()){
			resultado=rs.getInt("codigoVenta");
		}
		rs.close();
		return resultado;
	}
}
