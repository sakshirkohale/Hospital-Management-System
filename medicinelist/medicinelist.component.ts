import { Router } from '@angular/router';
import { MedicineserviceService } from './../medicineservice.service';
import { Medicine } from './../medicine';
import { Component } from '@angular/core';
import { AdminserviceService } from '../adminservice.service';

@Component({
  selector: 'app-medicinelist',
  templateUrl: './medicinelist.component.html',
  styleUrls: ['./medicinelist.component.css']
})
export class MedicinelistComponent {

  medicine: Medicine[] = [];

  constructor(private Medicineservice:MedicineserviceService, private Router:Router ) {}

  ngOnInit(): void {
    this.gemedicine();
  }

  gemedicine(){
    this.Medicineservice.getAllMedicines().subscribe(data => {
      this.medicine=data;
    });
  }

  updatemedicine(id:number){
    this.Router.navigate(['updateMedicine', id]);
  }

  deletemedicine(id:number)
{
  this.Medicineservice.deletemedicine(id).subscribe(data => {
    this.gemedicine();
})
}



}
