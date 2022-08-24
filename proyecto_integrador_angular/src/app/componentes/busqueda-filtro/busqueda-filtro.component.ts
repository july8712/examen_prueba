import { Component, OnInit } from '@angular/core';

declare function buscar():any;

@Component({
  selector: 'app-busqueda-filtro',
  templateUrl: './busqueda-filtro.component.html',
  styleUrls: ['./busqueda-filtro.component.css']
})
export class BusquedaFiltroComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  busqueda(){buscar()}
}
