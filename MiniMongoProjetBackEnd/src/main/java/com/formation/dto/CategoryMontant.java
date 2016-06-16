package com.formation.dto;

public class CategoryMontant {

	private String category;
	private String montant;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getMontant() {
		return montant;
	}
	public void setMontant(String montant) {
		this.montant = montant;
	}
	@Override
	public String toString() {
		return "CategoryMontant [category=" + category + ", montant=" + montant
				+ "]";
	}
	
	
}
