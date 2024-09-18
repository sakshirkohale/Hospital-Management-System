import { AdminserviceService } from './../adminservice.service';
import { Patient } from '../patient';
import { PatientserviceService } from './../patientservice.service';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-dash',
  templateUrl: './admin-dash.component.html',
  styleUrls: ['./admin-dash.component.css']
})
export class AdminDashComponent {

  Patients:Patient[] = [];
  constructor(private Patientservice:PatientserviceService, private AdminserviceService:AdminserviceService,private router:Router) { }
 
  ngOnInit(): void {
    this.getpatient();
  }
  getpatient(){
    this.Patientservice.getAllPatients().subscribe(data => {
      this.Patients=data;
    });
  }

  delete(id:number){
    this.Patientservice.deleteAppointment(id).subscribe(data=>{
      console.log(data);
      this.getpatient();
  

  })
}

logout(){
  this.AdminserviceService.logout();
  this.router.navigate(['home']);

}
}
