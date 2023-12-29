import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-property',
  templateUrl: './property.component.html',
  styleUrls: ['./property.component.css']
})
export class PropertyComponent {
  constructor(private fb:FormBuilder){}
pageTitle:String="Binding in Angular"
btnstatus:boolean=false;

changetitle(){
this.pageTitle="binding";
}

userForm= new FormGroup({
  "name":new FormGroup('')
})

}
