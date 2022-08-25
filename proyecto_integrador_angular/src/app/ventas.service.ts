import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Ventas } from './ventas';


@Injectable({
  providedIn: 'root'
})
export class VentasService {
// esta url trae todos los mensajes del backend
  private baseURL = "http://localhost:8080/";
  // httpClient: any;

  constructor(private httpClient : HttpClient) { }

  // Con este método obtengo los usuarios
  obtenerListaDeVentas():Observable<Ventas[]>{
    return this.httpClient.get<Ventas[]>(`${this.baseURL}vendedor`);
  }

  //método para guardar una consulta
  registrarVenta(venta:Ventas) : Observable<Object>{
    return this.httpClient.post(`${this.baseURL}venta`, venta);
  }

}
