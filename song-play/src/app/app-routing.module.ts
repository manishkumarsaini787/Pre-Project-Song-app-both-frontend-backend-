import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ViewPlaylistComponent } from './view-playlist/view-playlist.component';
import { AuthGuard } from './service/auth.guard';
import { RefreshComponent } from './refresh/refresh.component';
import { AdminComponent } from './admin/admin.component';


const routes: Routes = [
  {path:'login',
  component:LoginComponent
},
  {path:'register',
  component:RegisterComponent
},
  {path:'dashboard',
  canActivate:[AuthGuard],
  component:DashboardComponent
},
  {path:'refresh',
  component:RefreshComponent
},
  {path:'playlist',
  canActivate:[AuthGuard],
  component:ViewPlaylistComponent
},
{path:'admin',
component:AdminComponent},

  {path:'**',
  component:DashboardComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
