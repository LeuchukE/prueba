package com.cuti.polideportivo;

public class CategoriaSocial {

	private int codigo;
	private String nombre;	

	public CategoriaSocial(int codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}	

	public String toString() {
		return this.nombre;
	}
}
