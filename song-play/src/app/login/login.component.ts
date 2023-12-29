import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { LoginService } from '../service/login.service';
import {  Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent   {
  constructor(private loginService:LoginService,private route:Router){}
  data:any;
  email:any="";

  userForm=new FormGroup({
    "email":new FormControl(''),
    "password":new FormControl('')

  })

  loginCheck(){
    this.email=this.userForm.value.email;

    this.loginService.logIn(this.userForm.value).subscribe(
      response=>{
        this.data=response;
        alert(`${this.email} login success....`);
        this.loginService.isLogedin();
        localStorage.setItem("email",this.email);
        localStorage.setItem("loginstatus","true");
        localStorage.setItem("Token",this.data.Token);
        this.route.navigateByUrl("/dashboard");
      },error=>{
      alert("invalid user");
    }
    )

  }
}
//`Song ${song.name} is added `
