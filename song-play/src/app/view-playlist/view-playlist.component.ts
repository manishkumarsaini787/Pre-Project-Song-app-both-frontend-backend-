import { Component, OnInit } from '@angular/core';
import { LoginService } from '../service/login.service';
import { SongService } from '../service/song.service';

@Component({
  selector: 'app-view-playlist',
  templateUrl: './view-playlist.component.html',
  styleUrls: ['./view-playlist.component.css']
})
export class ViewPlaylistComponent implements OnInit{
  viewComponent:boolean=false;

  playlists:any=[];
  songs:any=[];

  constructor(private login:LoginService,private song:SongService ){}
  ngOnInit(): void {``
   this.login.getPlaylist().subscribe(
    {
      next:data=>
      {
        console.log(data);
        this.playlists=data;
      }
     }
   )
  }
  viewSongs(playlist:any){
    // console.info(playlist);
    this.song.viewSongsInPlaylist(playlist).subscribe(
      {
        next:data=>
        {
          // console.log(data);
            this.songs=data;
        }
      }
    )
 }
  componentToggle(){
    this.viewComponent=!this.viewComponent;
  }
}
