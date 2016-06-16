package com.formation.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import org.hibernate.annotations.GenericGenerator;

@Entity
@NamedNativeQuery(
name = "USCustomers",
query = "db.Customer.find({'country': 'Senegal'})",
resultClass = Customer.class )
public class Customer {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	private String country;
	private String name;
	@OneToMany(mappedBy = "customerFK", fetch = FetchType.EAGER)
	private List<Item> items;
	
	@Embedded
	private Adresse adresse =new Adresse();
	

    @ElementCollection
    @OrderColumn(name = "orderNo")
	Set<Telephone> telephones = new HashSet<>();

	public Set<Telephone> getTelephones() {
		return telephones;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	public void setTelephones(Set<Telephone> telephones) {
		this.telephones = telephones;
	}


	public Customer() { }

	
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresses(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", country=" + country + ", name=" + name + "]";
	}
	
	// Getter/Setters 
	
	

}
