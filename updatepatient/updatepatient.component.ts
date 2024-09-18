import { ActivatedRoute, Router } from '@angular/router';
import { PatientserviceService } from '../patientservice.service';
import { Patient } from './../patient';
import { Component } from '@angular/core';
import { AdminserviceService } from '../adminservice.service';

@Component({
  selector: 'app-updatepatient',
  templateUrl: './updatepatient.component.html',
  styleUrls: ['./updatepatient.component.css']
})
export class UpdatepatientComponent {

  id:number=0;
  patient:Patient = new Patient();
  constructor(private Patientservice:PatientserviceService, private router:Router,private route:ActivatedRoute){}

 
  ngOnInit():void
  {
   this.id=this.route.snapshot.params['id'];
   this.Patientservice.getpatientById(this.id).subscribe(data=>{
    this.patient=data

   })
  }

  onSubmit(){
    this.Patientservice.updatepatient(this.id,this.patient).subscribe(data=>{
      console.log(data);
      this.goToPatient();
    })

  }

  goToPatient()
  {
    this.router.navigate(['docdash']);
  }

 

}
     