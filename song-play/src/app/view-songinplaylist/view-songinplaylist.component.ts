import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-view-songinplaylist',
  templateUrl: './view-songinplaylist.component.html',
  styleUrls: ['./view-songinplaylist.component.css']
})
export class ViewSonginplaylistComponent implements OnInit {
ngOnInit(): void {
//  console.log(this.songs)
}


@Input()
songs:any=[]


play(){
  alert("song is playing....");
}


}
