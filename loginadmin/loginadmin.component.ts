import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AdminserviceService } from '../adminservice.service';

@Component({
  selector: 'app-loginadmin',
  templateUrl: './loginadmin.component.html',
  styleUrls: ['./loginadmin.component.css']
})
export class LoginadminComponent {
  username: string="";
  password: string="";

  invalidlogin=false;
 constructor(private Route:Router, private adminlog:AdminserviceService){};
  checklogin(){
    if(this.adminlog.authenticate(this.username, this.password)){
      this.Route.navigate(['admin']);
      this.invalidlogin=false;
    }else{
      this.invalidlogin=true;
      alert("Wrong Credentials");
      this.Route.navigate(['home']);
     

    }
  }
  


}
