import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import {FormsModule, ReactiveFormsModule} from "@angular/forms";

import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { HeaderComponent } from './componentes/header/header.component';
import { VentasComponent } from './componentes/ventas/ventas.component';
import { FooterComponent } from './componentes/footer/footer.component';
import { VendedoresComponent } from './componentes/vendedores/vendedores.component';
import { BusquedaFiltroComponent } from './componentes/busqueda-filtro/busqueda-filtro.component';
import { ProductosComponent } from './componentes/productos/productos.component';

import { from } from 'rxjs';
import { HttpClientModule } from '@angular/common/http';




const routes:Routes = [
  {path:'ventas', component:VentasComponent},
  {path:'vendedor', component:VendedoresComponent},
  {path:'productos', component:ProductosComponent},
  {path:'filtro', component:BusquedaFiltroComponent},
  {path:'', redirectTo: '/home', pathMatch: 'full'}
]

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    VentasComponent,
    FooterComponent,
    VendedoresComponent,
    ProductosComponent,
    BusquedaFiltroComponent


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
