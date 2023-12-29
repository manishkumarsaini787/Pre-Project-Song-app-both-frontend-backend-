import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { LoginService } from '../service/login.service';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements  OnInit{
  constructor(private fb:FormBuilder,private loginService:LoginService,private route:Router){}

  ngOnInit(): void {

  }
  userForm=this.fb.group({
    firstName: ['',[Validators.required,Validators.maxLength(8)]],
    lastName:['',[Validators.required,Validators.maxLength(8)]],
    email:['',[Validators.required, Validators.pattern(/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/)]],
    password:['',[Validators.required,Validators.maxLength(6)]]

  })

  get firstName() { return this.userForm.get("firstName") }

  get lastName() { return this.userForm.get("lastName") }
  get password() { return this.userForm.get("password") }
  get email() { return this.userForm.get("email") }


  registerCheck(){
    const user={
      firstName:this.userForm.value.firstName,
      lastName:this.userForm.value.lastName,
      email:this.userForm.value.email,
      password:this.userForm.value.password,
      playlist:[]

    }
    this.loginService.signUp(user).subscribe(
      response=>{
        alert(`${user.firstName} registered success....`);
        this.route.navigateByUrl("/login");

      },error=>{
      alert(" User Already Exists");
    }
    )

  }
}






