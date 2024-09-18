import { PatientserviceService } from './../patientservice.service';
import { Component } from '@angular/core';
import { Patient } from '../patient';
import { ActivatedRoute, Router } from '@angular/router';
import { AdminserviceService } from '../adminservice.service';

@Component({
  selector: 'app-viewpatient',
  templateUrl: './viewpatient.component.html',
  styleUrls: ['./viewpatient.component.css']
})
export class ViewpatientComponent {

  
  id: number=0;
  patient: Patient =new Patient();
  constructor(private route:ActivatedRoute,private router:Router, private Patientservice:PatientserviceService){}


  ngOnInit():void
  {
   this.id=this.route.snapshot.params['id'];
   this.Patientservice.getpatientById(this.id).subscribe(data=>{
    this.patient=data

   })
  }
 
}
