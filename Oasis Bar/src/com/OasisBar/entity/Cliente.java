package com.OasisBar.entity;

public class Cliente {
	
	private String NIT;
	private String nombre;

	
	public Cliente(String NIT, String nombre) {
		this.NIT = NIT;
		this.nombre = nombre;

	}
	
	public Cliente(String NIT) {
		this.NIT = NIT;

	}

	public String getNIT() {
		return NIT;
	}

	public void setNIT(String nIT) {
		NIT = nIT;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Cliente [NIT=" + NIT + ", nombre=" + nombre + "]";
	}
	

}
