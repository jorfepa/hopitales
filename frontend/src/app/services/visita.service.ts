import { map } from 'rxjs/operators';
import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";

import { Visita } from '../models/visita';

@Injectable({
  providedIn: 'root'
})
export class VisitaService {

  constructor(private http: HttpClient) { }

  cargarPorPaciente(id: any){
    const url = '/Service/visitas/paciente/' + id;
    return this.http.get(url).pipe(map((resp:any) =>{
      let lista: Visita[] = <Visita[]>resp;
      return lista;
    }));
  }

  cargarPorDoctor(id: any){
    const url = '/Service/visitas/doctor/' + id;
    return this.http.get(url).pipe(map((resp:any) =>{
      let lista: Visita[] = <Visita[]>resp;
      return lista;
    }));
  }
}
