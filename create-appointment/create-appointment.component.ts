import { Router } from '@angular/router';
import { AppointmentserviceService } from '../appointmentservice.service';
import { Appointment } from './../appointment';
import { Component } from '@angular/core';
import { AdminserviceService } from '../adminservice.service';

@Component({
  selector: 'app-create-appointment',
  templateUrl: './create-appointment.component.html',
  styleUrls: ['./create-appointment.component.css']
})
export class CreateAppointmentComponent {

  appointment: Appointment = new Appointment();

  constructor(private appointmentService: AppointmentserviceService, private router: Router, private AdminserviceService:AdminserviceService) {}

  onSubmit() {
    this.saveAppointment();
  }

  saveAppointment() {
    this.appointmentService.CreateAppointment(this.appointment).subscribe(
      data => {
        console.log(data);
        this.gotoAppointment();
      },
      error => console.error('Error creating appointment:', error)
    );
  }

  gotoAppointment() {
    this.router.navigate(['/appointment']);
  }

  logout(){
    this.AdminserviceService.logout();
    this.router.navigate(['home']);
  
  }
}
