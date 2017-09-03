package com.OasisBar.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.OasisBar.entity.Insumo;
import com.OasisBar.entity.Trago;

public class InsumoCtrl implements Control<Insumo>{
private Conexion conexion;
	
	public InsumoCtrl (Conexion conexion) {
		this.conexion = conexion;
	}

	
	public ArrayList<Insumo> list() throws Throwable {
		ArrayList<Insumo> insumo = new ArrayList<Insumo>();
		ResultSet rs;
		
		int codigoInsumo;
		String nombre;
		double stockInsumo;
		String unidadM;
		String tipo;

		conexion.SQL("Select * from Insumo"); 

		rs = conexion.resultSet();

		while (rs.next()) {
			
			codigoInsumo = rs.getInt("codigoInsumo");
			nombre = rs.getString("nombre");
			stockInsumo = rs.getDouble("stockInsumo");
			unidadM = rs.getString("unidadMedida");
			tipo = rs.getString("tipo");
			insumo.add(new Insumo(codigoInsumo,nombre,stockInsumo,unidadM,tipo));
		}

		return insumo;

	}


	public void insert(Insumo insumo) throws Throwable {

		conexion.SQL("Insert into insumo(codigoInsumo,nombre,stockInsumo,unidadMedida,tipo) VALUES(?,?,?,?,?)");
		conexion.preparedStatement().setInt(1, insumo.getCodigoInsumo());
		conexion.preparedStatement().setString(2, insumo.getNombre());
		conexion.preparedStatement().setDouble(3, insumo.getStockInsumo());
		conexion.preparedStatement().setString(4, insumo.getUnidadM());
		conexion.preparedStatement().setString(5, insumo.getTipo());
	
		conexion.CUD();

	}

	
	public void search(Insumo insumo) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from  insumo where codigoInsumo=?");
		conexion.preparedStatement().setInt(1, insumo.getCodigoInsumo());
		rs = conexion.resultSet();

		while (rs.next()) {

			insumo.setNombre(rs.getString("nombre"));
			insumo.setUnidadM(rs.getString("unidadmedida"));
			insumo.setStockInsumo(rs.getDouble("stockinsumo"));
			insumo.setTipo(rs.getString("tipo"));
		}

		rs.close();

	}


	public void update(Insumo insumo) throws Throwable {
		int codigoInsumo;
		String nombre;
		double stockInsumo;
		String unidadM;
		String tipo;

		if (insumo != null) {
			codigoInsumo = insumo.getCodigoInsumo();
			nombre = insumo.getNombre();
			stockInsumo = insumo.getStockInsumo();
			unidadM = insumo.getUnidadM();
			tipo = insumo.getTipo();

			conexion.SQL("Update insumo set tipo=?,nombre=?,unidadMedida=?,stockInsumo=? where codigoinsumo=?");
			conexion.preparedStatement().setString(1, insumo.getTipo());
			conexion.preparedStatement().setString(2, insumo.getNombre());
			conexion.preparedStatement().setString(3, insumo.getUnidadM());
			conexion.preparedStatement().setDouble(4, insumo.getStockInsumo());
			conexion.preparedStatement().setInt(5, insumo.getCodigoInsumo());
			conexion.CUD();
		}
	}
	
public double StockDisponible(int codigoInsumo) throws Throwable {
		
		ResultSet rs;
		Insumo Ins=new Insumo(codigoInsumo);
		this.search(Ins);
		conexion.SQL("select insumo.stockinsumo from insumo where codigoinsumo=?");
		conexion.preparedStatement().setDouble(1,codigoInsumo);
		
		rs = conexion.resultSet();

		while (rs.next()) {

			Ins.setStockInsumo(rs.getDouble("stockinsumo"));
	
		}

		rs.close();
		return Ins.getStockInsumo();
		
	
}


public void StockUpdate(double d,double c,int b) throws Throwable {
	

	conexion.SQL("update insumo inner join detallereceta on detallereceta.codigoinsumo=insumo.codigoinsumo inner join trago on trago.codigotrago=detallereceta.codigotrago inner join detalleventa on detalleventa.codigotrago=trago.codigotrago set insumo.stockinsumo=insumo.stockinsumo-(?*?) where insumo.stockinsumo>=(?*?) and insumo.codigoinsumo=? ");
	conexion.preparedStatement().setDouble(1, d);
	conexion.preparedStatement().setDouble(2, c);
	conexion.preparedStatement().setDouble(3,d );
	conexion.preparedStatement().setDouble(4,c);
	conexion.preparedStatement().setDouble(5,b);
	conexion.CUD();
	

}
}
