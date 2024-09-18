import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AppointmentserviceService } from '../appointmentservice.service';
import { Appointment } from './../appointment';
import { Component } from '@angular/core';
import { AdminserviceService } from '../adminservice.service';

@Component({
  selector: 'app-appointment-dash',
  templateUrl: './appointment-dash.component.html',
  styleUrls: ['./appointment-dash.component.css']
})
export class AppointmentDashComponent {

  appointment:Appointment[]=[];
  constructor(private Appointmentservice:AppointmentserviceService,private AdminserviceService:AdminserviceService,private router: Router){}

  ngOnInit():void{
    this.getAppointment();
  }

  getAppointment()
  {
     this.Appointmentservice.getAllAppointments().subscribe(data=>{

       this.appointment=data
     });
  }

  delete(id:number){
    this.Appointmentservice.deleteAppointment(id).subscribe(data=>{
      console.log(data);
      this.getAppointment();
  

  })
}

logout(){
  this.AdminserviceService.logout();
  this.router.navigate(['home']);

}
}
