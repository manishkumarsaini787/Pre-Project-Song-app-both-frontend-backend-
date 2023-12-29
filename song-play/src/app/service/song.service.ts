import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SongService {

  constructor(private httpClient:HttpClient) { }



  songsUrl:string="http://localhost:63300/song/getall"

  getSongs(){
    return this.httpClient.get(this.songsUrl);
}

viewSongsInPlaylist(playlist:any){
  return this.httpClient.get(`http://localhost:63300/spotify/user/viwSonginplaylist/${localStorage.getItem('email')}/${playlist}`);

}
deleteplaylist(playlistName:any){
  return this.httpClient.delete(`http://localhost:63300/spotify/user/delete/${localStorage.getItem('email')}/${playlistName}`);
}

}

