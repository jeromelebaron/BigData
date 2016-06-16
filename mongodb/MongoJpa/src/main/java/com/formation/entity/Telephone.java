package com.formation.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Telephone {
	
	private String lieu;
	private String numero;
	
	public String getLieu() {
		return lieu;
	}
	public String getNumero() {
		return numero;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Telephone(String lieu, String numero) {
		super();
		this.lieu = lieu;
		this.numero = numero;
	}
	public Telephone() {
		super();
	}
	@Override
	public String toString() {
		return "Telephone [lieu=" + lieu + ", numero=" + numero + "]";
	}
	
	
	
	

}
