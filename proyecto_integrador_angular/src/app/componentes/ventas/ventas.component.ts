import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Ventas } from 'src/app/ventas';
import { VentasService } from 'src/app/ventas.service';


@Component({
  selector: 'app-ventas',
  templateUrl: './ventas.component.html',
  styleUrls: ['./ventas.component.css']
})
export class VentasComponent implements OnInit {

  ventas: Ventas[];
  venta: Ventas = new Ventas();

  // vendedores: Vendedor[];
  // vendedor: Vendedor = new Vendedor();

  constructor(private ventasServicio: VentasService, private router:Router) { }

  ngOnInit(): void {
    this.obtenerVentas();
  }

  guardarVenta(){
    this.ventasServicio.registrarVenta(this.venta).subscribe(dato => {
      console.log(dato);
      this.obtenerVentas();
    },error => console.log(error));
  }

  onSubmit(form: NgForm): void {
    console.log('Form values', form );
    this.guardarVenta();
  }

  private obtenerVentas(){
    this.ventasServicio.obtenerListaDeVentas().subscribe(dato => {
      this.ventas = dato;
      console.log(this.venta);
    })
  }

  // private obtenerVendedores(){
  //   this.vendedoresServicio.obtenerListaDeVendedores().subscribe(dato => {
  //     this.vendedores = dato;
  //     console.log(this.vendedor);
  //   })
  // }

}
