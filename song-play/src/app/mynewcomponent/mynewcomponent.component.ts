import { Component } from '@angular/core';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-mynewcomponent',
  templateUrl: './mynewcomponent.component.html',
  styleUrls: ['./mynewcomponent.component.css']
})
export class MynewcomponentComponent {
constructor(private login:LoginService){}


}
