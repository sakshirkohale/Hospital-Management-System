import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AdminserviceService {

  constructor() { }

  authenticate(username2:string, password2:string){
    if(username2 == "admin" && password2 == "123"){
      sessionStorage.setItem('username2', username2); //sessionStorage used to store temparary data
      return true;
    }else{
      alert("Wrong Credentials");
      return false;

    }

  }
  isuserLoggedIn(){
    console.log("user looged in successfull");
    let users= sessionStorage.getItem('username2');
    return !(users== null)
  }

  logout(){
    console.log("user looged out successfull");
    sessionStorage.removeItem('username2');
    
  }
}