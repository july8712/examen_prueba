import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Vendedor } from 'src/app/vendedor';
import { VendedoresService } from 'src/app/vendedores.service';

// interface ContactForm {
//   nombre: "string";
//   email: "string";
//   mensaje: "string";
// }

@Component({
  selector: 'app-vendedores',
  templateUrl: './vendedores.component.html',
  styleUrls: ['./vendedores.component.css']
})
export class VendedoresComponent implements OnInit {

  vendedores: Vendedor[];
  vendedor: Vendedor = new Vendedor();

  // persona = {
  //   nombre: "",
  //   email: "",
  //   mensaje: ""
  // }

  constructor(private vendedoresServicio: VendedoresService, private router:Router) {
  }

  ngOnInit(): void {
    this.obtenerVendedores();
  }

  guardarVendedor(){
    this.vendedoresServicio.registrarVendedor(this.vendedor).subscribe(dato => {
      console.log(dato);
      this.obtenerVendedores();
    },error => console.log(error));
  }



  onSubmit(form: NgForm): void {
    console.log('Form values', form );
    this.guardarVendedor();

  }

  private obtenerVendedores(){
    this.vendedoresServicio.obtenerListaDeVendedores().subscribe(dato => {
      this.vendedores = dato;
      console.log(this.vendedor);
    })
  }

}

// registrarForm() {
//     this.persona.nombre = this.crearCuenta.value.nombre;
//     this.persona.apellido = this.crearCuenta.value.apellido;
//     this.persona.LELCDNI = this.crearCuenta.value.LELCDNI;
//     this.persona.email = this.crearCuenta.value.email;
//     this.persona.password = this.crearCuenta.value.password;
//     console.log("Se ha creado un usuario de manera válida");
//     console.log(this.persona);
//     this.crearCuenta.reset();
//   }
