import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import {FormsModule} from "@angular/forms";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import { HomeComponent } from './components/home/home.component';
import { NavigationBarComponent } from './components/navigation-bar/navigation-bar.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatButtonModule} from "@angular/material/button";
import {MatIconModule} from "@angular/material/icon";
import {MatCardModule} from "@angular/material/card";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {MatSelectModule} from "@angular/material/select";
import { MatOptionModule} from "@angular/material/core";
import { TennisPlayersComponent } from './components/tennis-players/tennis-players.component';
import { TennisCourtsComponent } from './components/tennis-courts/tennis-courts.component';
import { TimeslotsComponent } from './components/timeslots/timeslots.component';
import { MyProfileComponent } from './components/my-profile/my-profile.component';
import {MatListModule} from "@angular/material/list";
import {MatTableModule} from "@angular/material/table";
import {MatGridListModule} from "@angular/material/grid-list";
import { AddTennisPlayerComponent } from './components/add-tennis-player/add-tennis-player.component';
import { AddTennisCourtComponent } from './components/add-tennis-court/add-tennis-court.component';
import {TokenInterceptor} from "./services/token.interceptor";
import {MatDatepickerModule} from "@angular/material/datepicker";
import { AddTimeslotComponent } from './components/add-timeslot/add-timeslot.component';
import {MatSliderModule} from "@angular/material/slider";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    NavigationBarComponent,
    TennisPlayersComponent,
    TennisCourtsComponent,
    TimeslotsComponent,
    MyProfileComponent,
    AddTennisPlayerComponent,
    AddTennisCourtComponent,
    AddTimeslotComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        HttpClientModule,
        BrowserAnimationsModule,
        MatToolbarModule,
        MatButtonModule,
        MatIconModule,
        MatCardModule,
        MatFormFieldModule,
        MatInputModule,
        MatSelectModule,
        MatOptionModule,
        MatListModule,
        MatTableModule,
        MatGridListModule,
        MatDatepickerModule,
        MatSliderModule
    ],
  providers: [{ provide: HTTP_INTERCEPTORS, useClass: TokenInterceptor, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
