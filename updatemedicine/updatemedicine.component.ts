import { MedicineserviceService } from './../medicineservice.service';
import { Medicine } from './../medicine';
import { Component } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { AdminserviceService } from '../adminservice.service';

@Component({
  selector: 'app-updatemedicine',
  templateUrl: './updatemedicine.component.html',
  styleUrls: ['./updatemedicine.component.css']
})
export class UpdatemedicineComponent {

  
  id:number=0;
  medicine:Medicine = new Medicine();
  constructor(private Medicineservice:MedicineserviceService, private router:Router,private route:ActivatedRoute){}

 
  ngOnInit():void
  {
   this.id=this.route.snapshot.params['id'];
   this.Medicineservice.getMedicineById(this.id).subscribe(data=>{
    this.medicine=data

   })
  }

  onSubmit(){
    this.Medicineservice.Updatemedicine(this.id,this.medicine).subscribe(data=>{
      console.log(data);
      this.goToMedicine();
    })

  }

  goToMedicine()
  {
    this.router.navigate(['medicinelist']);
  }

  


}
