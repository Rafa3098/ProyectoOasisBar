package com.OasisBar.control;

import java.sql.ResultSet;
import java.util.ArrayList;
import com.OasisBar.entity.DetalleReceta;
import com.OasisBar.entity.DetalleVenta;


public class DetalleRecetaCtrl implements Control<DetalleReceta>{
	
	private Conexion conexion;
	
	public DetalleRecetaCtrl (Conexion conexion) {
		this.conexion = conexion;
	}

	
	public ArrayList<DetalleReceta> list() throws Throwable {
		ArrayList<DetalleReceta> detalleReceta = new ArrayList<DetalleReceta>();
		ResultSet rs;
		
		 int codigoDR;
		 int codigoInsumo;
		 double cantidadInsumo;
		 int codigoTrago;


		conexion.SQL("Select * from detallereceta"); 

		rs = conexion.resultSet();

		while (rs.next()) {
			
			codigoDR = rs.getInt("codigodetallereceta");
			codigoInsumo = rs.getInt("codigoinsumo");
			codigoTrago = rs.getInt("codigotrago");
			cantidadInsumo = rs.getInt("cantidadinsumo");
			detalleReceta.add(new DetalleReceta(codigoDR,codigoInsumo,cantidadInsumo,codigoTrago));
		}

		return detalleReceta;

	}


	public void insert(DetalleReceta detalleReceta) throws Throwable {

		conexion.SQL("Insert into detallereceta(codigoDetalleReceta,codigoInsumo,cantidadInsumo,codigoTrago) VALUES(?,?,?,?)");
		conexion.preparedStatement().setInt(1, detalleReceta.getCodigoDR());
		conexion.preparedStatement().setInt(2, detalleReceta.getCodigoInsumo());
		conexion.preparedStatement().setDouble(3, detalleReceta.getCantidadInsumo());
		conexion.preparedStatement().setInt(4, detalleReceta.getCodigoTrago());
		conexion.CUD();

	}

	
	public void search(DetalleReceta detalleReceta) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from  detalleReceta where CodigodetalleReceta=?");
		conexion.preparedStatement().setInt(1, detalleReceta.getCodigoDR());
		rs = conexion.resultSet();

		while (rs.next()) {

			detalleReceta.setCodigoInsumo(rs.getInt("codigoinsumo"));
			detalleReceta.setCantidadInsumo(rs.getInt("cantidadinsumo"));
			detalleReceta.setCodigoTrago(rs.getInt("codigoTrago"));
			
		}

		rs.close();

	}


	public void update(DetalleReceta detalleReceta) throws Throwable {
		
		int codigoDR;
		 int codigoInsumo;
		 double cantidadInsumo;
		 int codigoTrago;


		if (detalleReceta != null) {
			codigoDR = detalleReceta.getCodigoDR();
			codigoInsumo = detalleReceta.getCodigoInsumo();
			cantidadInsumo=detalleReceta.getCantidadInsumo();
			codigoTrago=detalleReceta.getCodigoTrago();

			conexion.SQL("Update trago set codigoTrago=?,codigoinsumo=?,cantidadinsumo=? where codigodetallereceta=?");
			conexion.preparedStatement().setInt(1, detalleReceta.getCodigoDR());
			conexion.preparedStatement().setInt(2, detalleReceta.getCodigoInsumo());
			conexion.preparedStatement().setDouble(3, detalleReceta.getCodigoInsumo());
			conexion.preparedStatement().setInt(4, detalleReceta.getCodigoTrago());
			conexion.CUD();
		}
	}

public int CodigoTragoUltimoDetalle(DetalleReceta detallereceta) throws Throwable{
		
		ResultSet rs;
		conexion.SQL("select detallereceta.codigotrago from trago inner join detallereceta on detallereceta.codigotrago=trago.codigotrago order by  detallereceta.codigodetallereceta DESC  limit 1");
		rs=conexion.resultSet();
		while (rs.next()) {

			detallereceta.setCodigoTrago((rs.getInt("codigotrago")));	
		}

		rs.close();
		return detallereceta.getCodigoTrago();
		
	}

public int CantidadInsumosUltimoTrago(int codigotrago) throws Throwable{
	int resultado=0;
	ResultSet rs;
	conexion.SQL("Select trago.cantidadinsumos  from trago inner join detalleventa on detalleventa.codigotrago=trago.codigotrago where trago.codigotrago=?");
	conexion.preparedStatement().setInt(1, codigotrago);
	rs=conexion.resultSet();
	while (rs.next()) {

		resultado=((rs.getInt("cantidadinsumos")));	
	}

	rs.close();
	return resultado;
	
}
/*public int CantidadInsumosUltimoTrago(DetalleReceta detallereceta) throws Throwable {
	
    ResultSet rs;
	conexion.SQL("select trago.cantidadinsumos from trago order where codigotrago=?");
	conexion.preparedStatement().setInt(1, detallereceta.getCodigoTrago());
	rs=conexion.resultSet();
	while (rs.next()) {

		int cantidadInsumos=
	}
	System.out.println("La cantidad es: ");
	System.out.println(detallereceta.getCantidadInsumo());
	rs.close();
	return detallereceta.getCantidadInsumo();

}
	
	/*public ArrayList<DetalleReceta> InsumosdePreparacion(int codigoreceta) throws Throwable {
		ArrayList<DetalleReceta> detalleReceta = new ArrayList<DetalleReceta>();
		ResultSet rs;
		
		 int codigoInsumo;
		 double cantidadInsumo;
		 int codigoRT;


		conexion.SQL("select detallereceta.codigoinsumo,detallereceta.cantidadinsumo,detallereceta.codigoreceta from detallereceta where detallereceta.codigoreceta=?"); 
		conexion.preparedStatement().setInt(1, codigoreceta);
		rs = conexion.resultSet();

		while (rs.next()) {

			codigoInsumo = rs.getInt("codigoinsumo");
			codigoRT = rs.getInt("codigoreceta");
			cantidadInsumo = rs.getInt("cantidadinsumo");
			detalleReceta.add(new DetalleReceta(codigoInsumo,cantidadInsumo,codigoRT));
		}

		return detalleReceta;

	}*/
	
	
}
