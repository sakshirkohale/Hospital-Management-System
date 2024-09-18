import { DocautService } from './../docaut.service';
import { Route, Router } from '@angular/router';
import { Component } from '@angular/core';

@Component({
  selector: 'app-logindoct',
  templateUrl: './logindoct.component.html',
  styleUrls: ['./logindoct.component.css']
})
export class LogindoctComponent {

  username: string="";
  password: string="";

  invalidlogin=false;
 constructor(private Route:Router, private Docautservice:DocautService){};
  checklogin(){
    if(this.Docautservice.authenticate(this.username, this.password)){
      this.Route.navigate(['docdash']);
      this.invalidlogin=false;
    }else{
      this.invalidlogin=true;
      alert("Wrong Credentials");
      this.Route.navigate(['home']);
     

    }

  }

}
