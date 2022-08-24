import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import {FormsModule, ReactiveFormsModule} from "@angular/forms";

import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { HeaderComponent } from './componentes/header/header.component';
import { SliderComponent } from './componentes/slider/slider.component';
import { NosotrosComponent } from './componentes/nosotros/nosotros.component';
import { EncortrarMascotasComponent } from './componentes/encortrar-mascotas/encortrar-mascotas.component';
import { FooterComponent } from './componentes/footer/footer.component';
import { VendedoresComponent } from './componentes/vendedores/vendedores.component';
import { RegistroComponent } from './componentes/registro/registro.component';
import { BusquedaFiltroComponent } from './componentes/busqueda-filtro/busqueda-filtro.component';
import { MascotasComponent } from './componentes/mascotas/mascotas.component';
import { HomeComponent } from './componentes/home/home.component';
import { from } from 'rxjs';
import { HttpClientModule } from '@angular/common/http';



const routes:Routes = [
  {path:'encortrar-mascotas', component:EncortrarMascotasComponent},
  {path:'slider', component:SliderComponent},
  {path:'vendedor', component:VendedoresComponent},
  {path:'registro', component:RegistroComponent},
  {path:'slider', component:SliderComponent},
  {path:'home', component:HomeComponent},
  {path:'mascotas', component:MascotasComponent},
  {path:'nosotros', component:NosotrosComponent},
  {path:'filtro', component:BusquedaFiltroComponent},
  {path:'', redirectTo: '/home', pathMatch: 'full'}
]

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SliderComponent,
    NosotrosComponent,
    EncortrarMascotasComponent,
    FooterComponent,
    VendedoresComponent,
    RegistroComponent,
    MascotasComponent,
    BusquedaFiltroComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
