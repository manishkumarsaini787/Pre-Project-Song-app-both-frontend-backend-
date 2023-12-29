import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MatToolbarModule } from '@angular/material/toolbar';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ReactiveFormsModule } from '@angular/forms';
import  {HttpClientModule}  from '@angular/common/http';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ViewPlaylistComponent } from './view-playlist/view-playlist.component';

import { FormsModule } from '@angular/forms';
import { ViewSonginplaylistComponent } from './view-songinplaylist/view-songinplaylist.component';
import { RefreshComponent } from './refresh/refresh.component';
import { AdminComponent } from './admin/admin.component';
import { PropertyComponent } from './property/property.component';
import { MynewcomponentComponent } from './mynewcomponent/mynewcomponent.component';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    RegisterComponent,
    LandingPageComponent,
    DashboardComponent,
    ViewPlaylistComponent,
    ViewSonginplaylistComponent,
    RefreshComponent,
    AdminComponent,
    PropertyComponent,
    MynewcomponentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
