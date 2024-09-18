package com.HMSApp.Hospital.Management.Sysem.docLogin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="appointments")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	String name;
	String age;
	String symptoms;
	int number;
	
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment(int id, String name, String age, String symptoms, int number) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.symptoms = symptoms;
		this.number = number;
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", name=" + name + ", age=" + age + ", symptoms=" + symptoms + ", number="
				+ number + "]";
	}
	
	
}
