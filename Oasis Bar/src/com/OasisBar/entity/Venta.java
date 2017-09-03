package com.OasisBar.entity;

import java.util.Date;

public class Venta {
private int codigoVenta;
private Date fechaVenta;
private String NIT;
private double monto;

public Venta(int codigoVenta, Date fechaVenta,String NIT) {
	this.NIT = NIT;
	this.codigoVenta = codigoVenta;
	this.fechaVenta=fechaVenta;

}


public Venta(int codigoVenta, Date fechaVenta,String NIT,double monto) {
	this.NIT = NIT;
	this.codigoVenta = codigoVenta;
	this.fechaVenta=fechaVenta;
    this.monto=monto;
}


public Venta(String NIT) {
	
	this.NIT = NIT;
	

}

public Venta(int codigoVenta) {
	
	this.codigoVenta = codigoVenta;
	
}

public Venta(Date fechaVenta,String NIT) {
	
	this.fechaVenta=fechaVenta;
	this.NIT = NIT;

}
public Date getFechaVenta() {
	return fechaVenta;
}
public void setFechaVenta(Date fechaVenta) {
	this.fechaVenta = fechaVenta;
}
public int getCodigoVenta() {
	return codigoVenta;
}
public String getNIT() {
	return NIT;
}


public void setNIT(String nIT) {
	NIT = nIT;
}

public void setMonto(double monto) {
	this.monto = monto;
}



@Override
public String toString() {
	return "Venta [codigoVenta=" + codigoVenta + ", fechaVenta=" + fechaVenta + ", NIT=" + NIT + ", monto" + monto + "]";
}


}
