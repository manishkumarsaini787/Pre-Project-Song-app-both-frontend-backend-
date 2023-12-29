import { Component, OnInit } from '@angular/core';
import { SongService } from '../service/song.service';
import { LoginService } from '../service/login.service';
import { Router } from '@angular/router';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private song: SongService, private log: LoginService, private router: Router) { }
  selectedOptionValue: string = "";
  loginStatus: boolean = false;
  email: any = localStorage.getItem("email")

  showCreateplayList: boolean = false;
  songs: any = [];
  playlists: any = [];


  playlist = new FormGroup({
    "playlist": new FormControl(''),

  })


  ngOnInit(): void {
    this.loginStatus = this.log.loginStatus;
    this.log.getPlaylist().subscribe(
      {
        next: data => {
          this.playlists = data;
          console.log(data);

        }
      }
    )

    this.song.getSongs().subscribe({
      
      next: data => {
        console.log(data);
        this.songs = data;
      }

    })


  }


  logout() {
    localStorage.setItem("email", "");
    localStorage.setItem("Token", "");
    this.log.isLogedout();
    alert("Succesfull loggedout");
    localStorage.setItem("loginstatus", "");
    this.router.navigateByUrl("/login");
  }

  play() {
    alert("song is playing")
  }

  createplaylist() {
    const playlist = {
      name: this.playlist.value.playlist,                   //be attri
      songs: []
    }

    this.log.createPlayslist(playlist).subscribe(
      {
        next: data => {
          console.log(data);
        }
      }


    );
    alert(`playlist is created by name :${this.playlist.value.playlist}`)
    this.showCreateplayList = !this.showCreateplayList;

    this.router.navigateByUrl("/refresh");

  }
  addSong(song: any) {
    // console.log(this.selectedOptionValue);
    // console.log(song);
    this.log.addSongToPlaylist(song, this.selectedOptionValue).subscribe(
      {
        next: data => {
          alert(`Song Added in ${this.selectedOptionValue}`)

        },error:err=>{
          alert("song already added")
        }

      }
    );

  }
}
