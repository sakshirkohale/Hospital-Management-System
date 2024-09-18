package com.HMSApp.Hospital.Management.Sysem.docLogin.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="medicine")
public class Medicine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String drugname;
	String stock;
	
	
	public Medicine() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Medicine(int id, String drugname, String stock) {
		super();
		this.id = id;
		this.drugname = drugname;
		this.stock = stock;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDrugname() {
		return drugname;
	}


	public void setDrugname(String drugname) {
		this.drugname = drugname;
	}


	public String getStock() {
		return stock;
	}


	public void setStock(String stock) {
		this.stock = stock;
	}


	@Override
	public String toString() {
		return "Medicine [id=" + id + ", drugname=" + drugname + ", stock=" + stock + "]";
	}
	
	
	
	
	

	
}
