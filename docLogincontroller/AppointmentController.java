package com.HMSApp.Hospital.Management.Sysem.docLogincontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HMSApp.Hospital.Management.Sysem.docLogin.entity.Appointment;
import com.HMSApp.Hospital.Management.Sysem.docLoginRepository.AppointmentRepository;
import com.HMSApp.Hospital.Management.Sysem.exception.ResourceNotFoundException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/v2")
@CrossOrigin(origins = "http://localhost:4200/")
public class AppointmentController {
	
	@Autowired
	AppointmentRepository appointmentrepo;
	
	@PostMapping("/appoinments")
	public Appointment createAppointment(@RequestBody Appointment appointment)
	{
		return appointmentrepo.save(appointment);
	}
	
	@GetMapping("/appoinments")
	public List<Appointment> getAllAppointment() {
		return appointmentrepo.findAll();
	}
	
	@DeleteMapping("/appoinments/{id}")
	public ResponseEntity<Map<String,Boolean>>deleteEmployee(@PathVariable int id)
	{
		Appointment appointment= appointmentrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Appointment not exist with Id"+id));

		appointmentrepo.delete(appointment);
		Map<String,Boolean>response=new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	

}
