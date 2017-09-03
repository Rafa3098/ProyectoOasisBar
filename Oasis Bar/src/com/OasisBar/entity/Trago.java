package com.OasisBar.entity;

public class Trago {
private int codigoTrago;
private String nombre;
private double precio;
private String descripcion;
private String tipo;
private int cantidadInsumos;
private String nombreinsumo;
private double cantidadinsumo;
private String unidadmedida;
private int codigoinsumo;

public Trago(int codigoTrago, String nombre, double precio, String descripcion, String tipo,int cantidadInsumos) {

	this.codigoTrago = codigoTrago;
	this.nombre = nombre;
	this.precio = precio;
	this.descripcion = descripcion;
	this.tipo = tipo;
	this.cantidadInsumos = cantidadInsumos;

}

public Trago(String nombre,double cantidadinsumo,String unidadmedida, String nombreinsumo,int codigoinsumo) {

	
	this.nombre = nombre;
	this.unidadmedida=unidadmedida;
	this.cantidadinsumo = cantidadinsumo;
	this.nombreinsumo=nombreinsumo;
	this.codigoinsumo=codigoinsumo;

}

public Trago(double precio,String nombre,String descripcion, String tipo,int cantidadInsumos) {

	this.nombre = nombre;
	this.precio = precio;
	this.descripcion = descripcion;
	this.tipo = tipo;
	this.cantidadInsumos = cantidadInsumos;
}

public Trago(int codigoTrago) {

	this.codigoTrago = codigoTrago;

}

public int getCodigoinsumo() {
	return codigoinsumo;
}

public void setCodigoinsumo(int codigoinsumo) {
	this.codigoinsumo = codigoinsumo;
}

public Trago(int codigoTrago, int cantidadinsumos) {

	this.codigoTrago = codigoTrago;
	this.cantidadInsumos=cantidadinsumos;

}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public double getPrecio() {
	return precio;
}

public void setPrecio(double precio) {
	this.precio = precio;
}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

public String getTipo() {
	return tipo;
}

public void setTipo(String tipo) {
	this.tipo = tipo;
}

public int getCodigoTrago() {
	return codigoTrago;
}


public int getCantidadInsumos() {
	return cantidadInsumos;
}


public void setCantidadInsumos(int cantidadInsumos) {
	this.cantidadInsumos = cantidadInsumos;
}


public String getNombreinsumo() {
	return nombreinsumo;
}

public void setNombreinsumo(String nombreinsumo) {
	this.nombreinsumo = nombreinsumo;
}

public double getCantidadinsumo() {
	return cantidadinsumo;
}

public void setCantidadinsumo(double cantidadinsumo) {
	this.cantidadinsumo = cantidadinsumo;
}

public String getUnidadmedida() {
	return unidadmedida;
}

public void setUnidadmedida(String unidadmedida) {
	this.unidadmedida = unidadmedida;
}

@Override
public String toString() {
	return "Trago [codigoTrago=" + codigoTrago + ", nombre=" + nombre + ", precio=" + precio + ", descripcion="
			+ descripcion + ", tipo=" + tipo + ", cantidadInsumos=" + cantidadInsumos + "]";
}

public String Preparacion(){
	
	return "Trago [Nombre=" + nombre + ", cantidad de insumo: " + cantidadinsumo + "  " + unidadmedida + ", nombre de insumo="
			+ nombreinsumo + "]";
}



}
