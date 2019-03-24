package com.stir.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Inventory {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String price;
	private String quantity;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="vendor_inventory", joinColumns=@JoinColumn(name="vendor_id", referencedColumnName="id"),
	inverseJoinColumns=@JoinColumn(name="inventory_id", referencedColumnName="id"))
	private List<Vendor> vendor;
	
	public List<Vendor> getVendor() {
		return vendor;
	}
	public void setVendor(List<Vendor> vendor) {
		this.vendor = vendor;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Inventory [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	
}
