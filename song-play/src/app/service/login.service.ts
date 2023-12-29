import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  loginStatus:boolean=false;

  constructor(private httpClient:HttpClient) { }

  baseUrl:string="http://localhost:1829/user/";

  signUpUrl:string="http://localhost:63300/spotify/user/addUser"

  signUp(signUpData:any){
    return this.httpClient.post(this.signUpUrl,signUpData);
}
logIn(loginData:any){
  return this.httpClient.post(this.baseUrl+"login",loginData);
}
isLogedin(){
  this.loginStatus=true;
}
isLogedout(){
  this.loginStatus=false;
}
addSongToPlaylist(song:any,playlistName:any){
  return this.httpClient.post(`http://localhost:63300/spotify/user/addToPlaylist/${localStorage.getItem('email')}/${playlistName}`,song);
}
getPlaylist(){
  const headers = new HttpHeaders({
    'Content-Type'  : 'application/json',
    'Authorization' : `Bearer ${localStorage.getItem('Token')}`                 //create header
  });
 return this.httpClient.get('http://localhost:63300/spotify/user/playlist', {   headers });    // send header
}
createPlayslist(playlist:any){
  return this.httpClient.post(`http://localhost:63300/spotify/user/createplaylist/${localStorage.getItem('email')}`,playlist);

}




}
