package com.OasisBar.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.OasisBar.entity.DetalleVenta;
import com.OasisBar.entity.Trago;


public class DetalleVentaCtrl implements Control<DetalleVenta>{
	
	private Conexion conexion;
	private TragoCtrl tragoCtrl;
	private InsumoCtrl insumoCtrl;
	
	public DetalleVentaCtrl (Conexion conexion) {
		this.conexion = conexion;
	}

	
	public ArrayList<DetalleVenta> list() throws Throwable {
		ArrayList<DetalleVenta> detalleVenta = new ArrayList<DetalleVenta>();
		ResultSet rs;
		
		 int codigoDV;
		 int codigoVenta;
		 int codigoTrago;
		 int cantidad;


		conexion.SQL("Select * from detalleVenta"); 

		rs = conexion.resultSet();

		while (rs.next()) {
			
			codigoDV = rs.getInt("codigodetalleventa");
			codigoVenta = rs.getInt("codigoventa");
			codigoTrago = rs.getInt("codigotrago");
			cantidad = rs.getInt("cantidad");
			detalleVenta.add(new DetalleVenta(codigoDV,codigoVenta,codigoTrago,cantidad));
		}

		return detalleVenta;

	}


	public void insert(DetalleVenta detalleventa) throws Throwable {
  
		boolean f=true;
		ArrayList<Trago> tragos;
	     tragos=tragoCtrl.PreparacionTrago(detalleventa.getCodigoTrago());
			
			for (int i = 0; i < tragos.size(); i++) {
				double a=tragos.get(i).getCantidadinsumo();
				double c;
				c=a*detalleventa.getCantidad();
				if(c>insumoCtrl.StockDisponible(tragos.get(i).getCodigoinsumo())){f=false;}
			}
		
	    if(f==true){
		conexion.SQL("Insert into detalleventa(codigodetalleventa,codigotrago,codigoventa,cantidad) VALUES(?,?,?,?)");
		conexion.preparedStatement().setInt(1, detalleventa.getCodigoDV());
		conexion.preparedStatement().setInt(2, detalleventa.getCodigoTrago());
		conexion.preparedStatement().setInt(3, detalleventa.getCodigoVenta());
		conexion.preparedStatement().setInt(4, detalleventa.getCantidad());
		conexion.CUD();
	    }
		

	}

	
	public void search(DetalleVenta detalleventa) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from  detalleventa where Codigodetalleventa=?");
		conexion.preparedStatement().setInt(1, detalleventa.getCodigoDV());
		rs = conexion.resultSet();

		while (rs.next()) {

			detalleventa.setCodigoVenta(rs.getInt("codigoventa"));
			detalleventa.setCodigoTrago(rs.getInt("codigotrago"));
			detalleventa.setCantidad(rs.getInt("cantidad"));
			
		}

		rs.close();

	}


	public void update(DetalleVenta detalleventa) throws Throwable {
		
		int codigoDV;
		 int codigoVenta;
		 int codigoTrago;
		 int cantidad;

		if (detalleventa != null) {
			codigoDV = detalleventa.getCodigoDV();
			codigoVenta = detalleventa.getCodigoVenta();
			codigoTrago=detalleventa.getCodigoTrago();
			cantidad=detalleventa.getCantidad();

			conexion.SQL("Update trago set codigoventa=?,cantidad=?,codigotrago=? where codigodetalleventa=?");
			conexion.preparedStatement().setInt(1, detalleventa.getCodigoVenta());
			conexion.preparedStatement().setInt(2, detalleventa.getCantidad());
			conexion.preparedStatement().setInt(4, detalleventa.getCodigoDV());
			conexion.preparedStatement().setInt(3, detalleventa.getCodigoTrago());
			conexion.CUD();
		}
	}

	public int CodigoTragoUltimoDetalle(DetalleVenta detalleventa) throws Throwable{
		
		ResultSet rs;
		conexion.SQL("select detalleventa.codigotrago from venta inner join detalleventa on detalleventa.codigoventa=venta.codigoventa inner join trago on trago.codigotrago=detalleventa.codigotrago order by  detalleventa.codigodetalleventa DESC  limit 1");
		rs=conexion.resultSet();
		while (rs.next()) {

			detalleventa.setCodigoTrago((rs.getInt("codigotrago")));	
		}

		rs.close();
		return detalleventa.getCodigoTrago();
		
	}
	
	
	
	public int CantidadultimoDetalle(DetalleVenta detalleVenta) throws Throwable {
		
	    ResultSet rs;
		conexion.SQL("select detalleventa.cantidad from detalleventa order by  detalleventa.codigodetalleventa DESC limit 1");
		rs=conexion.resultSet();
		while (rs.next()) {

			detalleVenta.setCantidad((rs.getInt("cantidad")));
			
		}
		System.out.println("La cantidad es: ");
		System.out.println(detalleVenta.getCantidad());
		rs.close();
		return detalleVenta.getCantidad();
	
}
	
	
}