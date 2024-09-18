package com.HMSApp.Hospital.Management.Sysem.docLogincontroller;

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
import com.HMSApp.Hospital.Management.Sysem.docLogin.entity.Medicine;
import com.HMSApp.Hospital.Management.Sysem.docLoginRepository.MedicineRepository;
import com.HMSApp.Hospital.Management.Sysem.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api/v3")
@CrossOrigin(origins = "http://localhost:4200/")
public class MedicineController {
	
	@Autowired
	MedicineRepository medicinerepository;
	
	@PostMapping("/medicines")
	public Medicine createMedicine(@RequestBody Medicine medicine)
	{
		return medicinerepository.save(medicine);
	}
	
	@GetMapping("/medicines")
	public List<Medicine> getAllmedicine()
	{
		return medicinerepository.findAll();
	}
	
	@GetMapping("/medicines/{id}")
	public ResponseEntity<Medicine> getPatientById(@PathVariable int id) throws AttributeNotFoundException
	{
		Medicine medicine= medicinerepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Medicine not exist with Id"+id));
		return ResponseEntity.ok(medicine);
		
	} 

	@DeleteMapping("/medicines/{id}")
	public ResponseEntity<Map<String,Boolean>>deleteMedicine(@PathVariable int id)
	{
		Medicine medicine= medicinerepository.findById(id).orElseThrow(()->new ResourceNotFoundException("medicine not exist with Id"+id));

		medicinerepository.delete(medicine);
		Map<String,Boolean>response=new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	
	@PutMapping("/medicines/{id}")
	public ResponseEntity<Medicine> UpdatePatient(@PathVariable int id, @RequestBody Medicine medicinedetails)
	{
		Medicine medicine= medicinerepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Medicine not exist with Id"+id));
	
		medicine.setDrugname(medicinedetails.getDrugname());
		medicine.setStock(medicinedetails.getStock());
		
	
	    Medicine savedMedicine=medicinerepository.save(medicine);
	    
	    return ResponseEntity.ok(savedMedicine);
	}
	
	

	
}
