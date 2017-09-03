package com.OasisBar.entity;

public class DetalleReceta {
private int codigoDR;
private int codigoInsumo;
private double cantidadInsumo;
private int codigoTrago;


public DetalleReceta(int codigoDR, int codigoInsumo, double cantidadInsumo, int codigoTrago) {

	this.codigoDR = codigoDR;
	this.codigoInsumo = codigoInsumo;
	this.cantidadInsumo = cantidadInsumo;
	this.codigoTrago = codigoTrago;
}







public DetalleReceta(int codigoDR) {

	this.codigoDR = codigoDR;
	
}

public DetalleReceta(int codigoInsumo, double cantidadInsumo, int codigoTrago) {

	this.codigoInsumo = codigoInsumo;
	this.cantidadInsumo = cantidadInsumo;
	this.codigoTrago = codigoTrago;
}

public int getCodigoInsumo() {
	return codigoInsumo;
}

public void setCodigoInsumo(int codigoInsumo) {
	this.codigoInsumo = codigoInsumo;
}

public double getCantidadInsumo() {
	return cantidadInsumo;
}

public void setCantidadInsumo(double cantidadInsumo) {
	this.cantidadInsumo = cantidadInsumo;
}


public int getCodigoDR() {
	return codigoDR;
}


public int getCodigoTrago() {
	return codigoTrago;
}







public void setCodigoTrago(int codigoTrago) {
	this.codigoTrago = codigoTrago;
}







@Override
public String toString() {
	return "DetalleReceta [codigoDR=" + codigoDR + ", codigoInsumo=" + codigoInsumo + ", cantidadInsumo="
			+ cantidadInsumo + ", codigoRT=" + codigoTrago + "]";
}

}
