import { map } from 'rxjs/operators';
import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";

import { Paciente } from '../models/paciente';

@Injectable({
  providedIn: 'root'
})
export class PacienteService {

  constructor(private http: HttpClient) { }

  listar(){
    const url = '/Service/pacientes';
    return this.http.get(url).pipe(map((resp: any) => {
      let lista: Paciente[] = <Paciente[]>resp
      return lista;
    }));
  }

  cargar(id: any){
    const url = '/Service/pacientes/' + id;
    return this.http.get(url).pipe(map((resp:any) =>{
      let paciente = new Paciente();
      paciente = resp;
      return paciente;
    }));
  }

  guardar(paciente: Paciente) {
    const url = '/Service/pacientes/';
    return this.http.post(url, paciente).pipe(map((resp: any) => {  
      if (resp){    
        let paciente = new Paciente();
        paciente = resp;
        return paciente;
      }
      else{
        return null;
      }
    }));
  }

  borrar(id: any) {
    const url = '/Service/pacientes/' + id;
    return this.http.delete(url).pipe(map((resp: any) => {
      return true;
    }));
  }
}
