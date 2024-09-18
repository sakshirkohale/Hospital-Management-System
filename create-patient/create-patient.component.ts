import { PatientserviceService } from './../patientservice.service';
import { Patient } from './../patient';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AdminserviceService } from '../adminservice.service';

@Component({
  selector: 'app-create-patient',
  templateUrl: './create-patient.component.html',
  styleUrls: ['./create-patient.component.css']
})
export class CreatePatientComponent {
  patient: Patient = new Patient();

  constructor(private Patientservice: PatientserviceService, private router: Router, private AdminserviceService:AdminserviceService) {}

  onSubmit() {
    this.savepatient();
  }

  savepatient() {
    this.Patientservice.CreatePatient(this.patient).subscribe(
      data => {
        console.log(data);
        this.gotopatient();
      },
      error => console.error('Error creating patient:', error)
    );
  }

  gotopatient() {
    this.router.navigate(['/docdash']);
  }

  logout(){
    this.AdminserviceService.logout();
    this.router.navigate(['home']);
  
  }
}
