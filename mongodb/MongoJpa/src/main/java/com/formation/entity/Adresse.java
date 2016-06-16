package com.formation.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
	
	private int num;
	private String rue;
	private String ville;
	private int zip;
	
	public Adresse() {
		super();
	}

	public Adresse(int num, String rue, String ville, int zip) {
		super();
		this.num = num;
		this.rue = rue;
		this.ville = ville;
		this.zip = zip;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Adresse [num=" + num + ", rue=" + rue + ", ville=" + ville + ", zip=" + zip + "]";
	}
	
}
