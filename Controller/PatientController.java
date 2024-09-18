package com.HMSApp.Hospital.Management.Sysem.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HMSApp.Hospital.Management.Sysem.Entity.Patient;
import com.HMSApp.Hospital.Management.Sysem.Repository.PatientRepository;
import com.HMSApp.Hospital.Management.Sysem.docLogin.entity.Appointment;
import com.HMSApp.Hospital.Management.Sysem.exception.ResourceNotFoundException;

import aj.org.objectweb.asm.Attribute;
import jakarta.persistence.criteria.CriteriaBuilder.In;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200/")
public class PatientController {
	
	@Autowired
	private PatientRepository patientrepository ;
	
	@RequestMapping("/check")
	public String docheck()
	{
		return "Welcome in Hospital Management System";
	}
	
	@PostMapping("/patients")
	public Patient CreatePatient(@RequestBody Patient patient)
	{
		return patientrepository.save(patient);
	}

	@GetMapping("/patients")
	public List<Patient> getPatient()
	{
		return patientrepository.findAll();
	}
	

	@GetMapping("/patients/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable long id) throws AttributeNotFoundException
	{
		Patient patient= patientrepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Patient not exist with Id"+id));
		return ResponseEntity.ok(patient);
		
	}
	
	@DeleteMapping("/patients/{id}")
	public ResponseEntity<Map<String,Boolean>>deletepatient(@PathVariable long id)
	{
		Patient patient= patientrepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Patient not exist with Id"+id));

		patientrepository.delete(patient);
		Map<String,Boolean>response=new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	
	@PutMapping("/patients/{id}")
	public ResponseEntity<Patient> UpdatePatient(@PathVariable long id, @RequestBody Patient patientdetails)
	{
		Patient patient= patientrepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Patient not exist with Id"+id));
		
		patient.setName(patientdetails.getName());
		patient.setAge(patientdetails.getAge());
		patient.setBlood(patientdetails.getBlood());
		patient.setDose(patientdetails.getDose());
		patient.setFees(patientdetails.getFees());
		patient.setPescription(patientdetails.getPescription());
		patient.setUrgency(patientdetails.getUrgency());
	
	    Patient saavedpatient=patientrepository.save(patient);
	    
	    return ResponseEntity.ok(saavedpatient);
	}
	
	
}
