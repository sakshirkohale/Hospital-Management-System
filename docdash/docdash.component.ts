import { DocauthguardService } from './../docauthguard.service';
import { PatientserviceService } from './../patientservice.service';
import { Router } from '@angular/router';

import { Component } from '@angular/core';
import { Patient } from '../patient';
import { DocautService } from '../docaut.service';

@Component({
  selector: 'app-docdash',
  templateUrl: './docdash.component.html',
  styleUrls: ['./docdash.component.css']
})
export class DocdashComponent {

  Patients: Patient[] = [];

  constructor(
    private Patientservice: PatientserviceService,
    private Router: Router,
    private docauth: DocautService 
  ) { }

  ngOnInit(): void {
    this.getpatient();
  }

  getpatient() {
    this.Patientservice.getAllPatients().subscribe(data => {
      this.Patients = data;
    });
  }

  delete(id: number) {
    this.Patientservice.deleteAppointment(id).subscribe(data => {
      console.log(data);
      this.getpatient();
    });
  }

  update(id: number) {
    this.Router.navigate(['updatepatient', id]);
  }

  view(id: number) {
    this.Router.navigate(['viewpatient', id]);
  }

  logout() {
    this.docauth.logout(); 
    this.Router.navigate(['home']);
  }
}
