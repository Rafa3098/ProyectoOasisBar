package com.OasisBar.entity;

public class Insumo {
private int codigoInsumo;
private String nombre;
private double stockInsumo;
private String unidadM;
private String tipo;

public Insumo(int codigoInsumo, String nombre, double stockInsumo, String unidadM, String tipo) {

	this.codigoInsumo = codigoInsumo;
	this.nombre = nombre;
	this.stockInsumo = stockInsumo;
	this.unidadM = unidadM;
	this.tipo = tipo;
}

public Insumo(int codigoInsumo) {

	this.codigoInsumo = codigoInsumo;

}

public Insumo(String nombre, double stockInsumo, String unidadM, String tipo) {

	this.nombre = nombre;
	this.stockInsumo = stockInsumo;
	this.unidadM = unidadM;
	this.tipo = tipo;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public double getStockInsumo() {
	return stockInsumo;
}

public void setStockInsumo(double stockInsumo) {
	this.stockInsumo = stockInsumo;
}

public String getUnidadM() {
	return unidadM;
}

public void setUnidadM(String unidadM) {
	this.unidadM = unidadM;
}

public String getTipo() {
	return tipo;
}

public void setTipo(String tipo) {
	this.tipo = tipo;
}

public int getCodigoInsumo() {
	return codigoInsumo;
}

@Override
public String toString() {
	return "Insumo [codigoInsumo=" + codigoInsumo + ", nombre=" + nombre + ", stockInsumo=" + stockInsumo + ", unidadM="
			+ unidadM + ", tipo=" + tipo + "]";
}



}
