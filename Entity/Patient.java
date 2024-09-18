package com.HMSApp.Hospital.Management.Sysem.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private String Blood;
	private String age;
	private String pescription;
	private String dose;
	private String fees;
	private String urgency;
    
    
	
    public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Patient(long id, String name, String Blood, String age, String pescription, String dose, String fees,
			String urgency) {
		super();
		this.id = id;
		this.name = name;
		this. Blood = Blood;
		this.age = age;
		this.pescription = pescription;
		this.dose = dose;
		this.fees = fees;
		this.urgency = urgency;
	}
    
   
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBlood() {
		return Blood;
	}
	public void setBlood(String blood) {
		Blood = blood;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPescription() {
		return pescription;
	}
	public void setPescription(String pescription) {
		this.pescription = pescription;
	}
	public String getDose() {
		return dose;
	}
	public void setDose(String dose) {
		this.dose = dose;
	}
	public String getFees() {
		return fees;
	}
	
	public void setFees(String fees) {
		this.fees = fees;
	}
	public String getUrgency() {
		return urgency;
	}
	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", Blood=" + Blood + ", age=" + age + ", pescription="
				+ pescription + ", dose=" + dose + ", fees=" + fees + ", urgency=" + urgency + "]";
	}
    
    
    
	
	
}
