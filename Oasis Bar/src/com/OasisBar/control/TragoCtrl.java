package com.OasisBar.control;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.OasisBar.entity.Trago;
import com.OasisBar.entity.Venta;



public class TragoCtrl implements Control<Trago>{
	
	private Conexion conexion;
	
	public TragoCtrl (Conexion conexion) {
		this.conexion = conexion;
	}

	
	public ArrayList<Trago> list() throws Throwable {
		ArrayList<Trago> tragos = new ArrayList<Trago>();
		ResultSet rs;
		
		int codigoTrago;
		String nombre;
		double precioUnitario;
		String descripcion;
		String tipo;
		int cantidadInsumos;

		conexion.SQL("Select * from trago"); 

		rs = conexion.resultSet();

		while (rs.next()) {
			
			codigoTrago = rs.getInt("codigoTrago");
			nombre = rs.getString("nombre");
			precioUnitario = rs.getDouble("precioUnitario");
			descripcion = rs.getString("descripcion");
			tipo = rs.getString("tipo");
			cantidadInsumos=rs.getInt("cantidadInsumos");
			tragos.add(new Trago(codigoTrago,nombre,precioUnitario,descripcion,tipo,cantidadInsumos));
		}

		return tragos;

	}


	public void insert(Trago tragos) throws Throwable {

		conexion.SQL("Insert into trago(codigoTrago,nombre,precioUnitario,descripcion,tipo,cantidadInsumos) VALUES(?,?,?,?,?,?)");
		conexion.preparedStatement().setInt(1, tragos.getCodigoTrago());
		conexion.preparedStatement().setString(2, tragos.getNombre());
		conexion.preparedStatement().setDouble(3, tragos.getPrecio());
		conexion.preparedStatement().setString(4, tragos.getDescripcion());
		conexion.preparedStatement().setString(5, tragos.getTipo());
		conexion.preparedStatement().setInt(6, tragos.getCantidadInsumos());
		
		conexion.CUD();

	}

	
	public void search(Trago tragos) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from  trago where Codigotrago=?");
		conexion.preparedStatement().setInt(1, tragos.getCodigoTrago());
		rs = conexion.resultSet();

		while (rs.next()) {

			tragos.setNombre(rs.getString("nombre"));
			tragos.setDescripcion(rs.getString("descripcion"));
			tragos.setPrecio(rs.getDouble("precioUnitario"));
			tragos.setTipo(rs.getString("tipo"));
			tragos.setCantidadInsumos(rs.getInt("cantidadInsumos"));
		}

		rs.close();

	}


	public void update(Trago tragos) throws Throwable {
		int codigoTrago;
		String nombre;
		double precioUnitario;
		String descripcion;
		String tipo;
		int cantidadInsumos;

		if (tragos != null) {
			codigoTrago = tragos.getCodigoTrago();
			nombre = tragos.getNombre();
			precioUnitario=tragos.getPrecio();
			descripcion=tragos.getDescripcion();
			tipo = tragos.getTipo();
			cantidadInsumos=tragos.getCantidadInsumos();

			conexion.SQL("Update trago set tipo=?,nombre=?,descripcion=?,precioUnitario=?,cantidadinsumos=? where codigotrago=?");
			conexion.preparedStatement().setString(1, tragos.getTipo());
			conexion.preparedStatement().setString(2, tragos.getNombre());
			conexion.preparedStatement().setString(3, tragos.getDescripcion());
			conexion.preparedStatement().setDouble(4, tragos.getPrecio());
			conexion.preparedStatement().setInt(5, tragos.getCodigoTrago());
			conexion.preparedStatement().setInt(6, tragos.getCantidadInsumos());
			conexion.CUD();
		}
	}

	
	
public int CodigoltimoTrago() throws Throwable {
		
        ResultSet rs;
        int resultado=0;
		conexion.SQL("Select trago.codigotrago from trago order by codigotrago desc limit 1");
		rs=conexion.resultSet();
		while (rs.next()){
			resultado=rs.getInt("codigotrago");
		}
		rs.close();
		return resultado;
	}
	





public ArrayList<Trago> PreparacionTrago(int codigotrago) throws Throwable {
	ArrayList<Trago> tragos = new ArrayList<Trago>();
	ResultSet rs;
	
	String nombre;
	double cantidadinsumo;
	String nombreinsumo;
	String unidadmedida;
	int codigoinsumo;
	conexion.SQL("select trago.nombre,detallereceta.cantidadinsumo,insumo.unidadmedida,insumo.nombre,insumo.codigoinsumo from trago inner join detallereceta on detallereceta.codigotrago=trago.codigotrago inner join insumo on insumo.codigoinsumo=detallereceta.codigoinsumo where trago.codigotrago=? order by insumo.codigoinsumo "); 
	conexion.preparedStatement().setInt(1, codigotrago);
	rs = conexion.resultSet();

	while (rs.next()) {
		
		nombre = rs.getString("trago.nombre");
		cantidadinsumo = rs.getDouble("cantidadinsumo");
		nombreinsumo = rs.getString("insumo.nombre");
		unidadmedida = rs.getString("unidadmedida");
		codigoinsumo=rs.getInt("insumo.codigoinsumo");
		tragos.add(new Trago(nombre,cantidadinsumo,unidadmedida,nombreinsumo,codigoinsumo));
	}

	return tragos;

}



}
