package com.OasisBar.entity;

public class DetalleVenta {
private int codigoDV;
private int codigoVenta;
private int codigoTrago;
private int cantidad;

public DetalleVenta(int codigoDV, int codigoVenta, int codigoTrago, int cantidad) {

	this.codigoDV = codigoDV;
	this.codigoVenta = codigoVenta;
	this.codigoTrago = codigoTrago;
	this.cantidad = cantidad;
}
public DetalleVenta(int codigoDV) {

	this.codigoDV = codigoDV;
}

public DetalleVenta(int codigoVenta,int codigoTrago, int cantidad) {
	this.codigoVenta=codigoVenta;
	this.codigoTrago = codigoTrago;
	this.cantidad = cantidad;
}
public int getCantidad() {
	return cantidad;
}
public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}
public int getCodigoDV() {
	return codigoDV;
}
public int getCodigoVenta() {
	return codigoVenta;
}
public int getCodigoTrago() {
	return codigoTrago;
}
public void setCodigoTrago(int codigoTrago) {
	this.codigoTrago = codigoTrago;
}
@Override
public String toString() {
	return "DetalleVenta [codigoDV=" + codigoDV + ", codigoVenta=" + codigoVenta + ", codigoTrago=" + codigoTrago
			+ ", cantidad=" + cantidad + "]";
}
public void setCodigoVenta(int codigoVenta) {
	this.codigoVenta = codigoVenta;
}



}
