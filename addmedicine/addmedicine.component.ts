import { Router } from '@angular/router';
import { Medicine } from './../medicine';
import { Component } from '@angular/core';
import { MedicineserviceService } from '../medicineservice.service';
import { AdminserviceService } from '../adminservice.service';

@Component({
  selector: 'app-addmedicine',
  templateUrl: './addmedicine.component.html',
  styleUrls: ['./addmedicine.component.css']
})
export class AddmedicineComponent {

  medicine: Medicine=new Medicine();
  constructor(private medicineservice:MedicineserviceService,private router:Router, private AdminserviceService:AdminserviceService){}

  onSubmit() {
    this.savemedicine();
  }

  savemedicine() {
    this.medicineservice.createMedicine(this.medicine).subscribe(
      data => {
        console.log(data);
        this.gotomedicine();
      },
      error => console.error('Error creating medicine:', error)
    );
  }

  gotomedicine() {
    this.router.navigate(['/medicinelist']);
  }

  logout(){
    this.AdminserviceService.logout();
    this.router.navigate(['home']);
  
  }
}



