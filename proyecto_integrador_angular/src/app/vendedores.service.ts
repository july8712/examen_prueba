import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Vendedor } from './vendedor';

@Injectable({
  providedIn: 'root'
})
export class VendedoresService {
  // esta url trae todos los mensajes del backend
  private baseURL = "http://localhost:8080/";
  // httpClient: any;

  constructor(private httpClient : HttpClient) { }

  // Con este método obtengo los usuarios
  obtenerListaDeVendedores():Observable<Vendedor[]>{
    return this.httpClient.get<Vendedor[]>(`${this.baseURL}vendedor`);
  }

  //método para guardar una consulta
  registrarVendedor(usuario:Vendedor) : Observable<Object>{
    return this.httpClient.post(`${this.baseURL}vendedores`, Vendedor);
  }
}
