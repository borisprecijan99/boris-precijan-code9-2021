import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./components/login/login.component";
import {RegisterComponent} from "./components/register/register.component";
import {HomeComponent} from "./components/home/home.component";
import {TennisPlayersComponent} from "./components/tennis-players/tennis-players.component";
import {TennisCourtsComponent} from "./components/tennis-courts/tennis-courts.component";
import {TimeslotsComponent} from "./components/timeslots/timeslots.component";
import {MyProfileComponent} from "./components/my-profile/my-profile.component";
import {AuthGuard} from "./guards/auth.guard";

const routes: Routes = [
  { path: "", redirectTo: "home", pathMatch: "full" },
  { path:'login', component: LoginComponent},
  { path:'register', component: RegisterComponent },
  { path: "home", component: HomeComponent },
  { path: "players", component: TennisPlayersComponent },
  { path: "courts", component: TennisCourtsComponent },
  { path: "timeslots", component: TimeslotsComponent },
  { path: "profile", component: MyProfileComponent, canActivate: [AuthGuard] },
  { path: "**", component: HomeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
