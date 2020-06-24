import { map } from 'rxjs/operators';
import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";

import { Especialidad } from '../models/especialidad';

@Injectable({
  providedIn: 'root'
})
export class EspecialidadService {

  constructor(private http: HttpClient) { }

  listar(){
    const url = '/Service/especialidades';
    return this.http.get(url).pipe(map((resp: any) => {
      let lista: Especialidad[] = <Especialidad[]>resp
      return lista;
    }));
  }

  cargar(id: any){
    const url = '/Service/especialidades/' + id;
    return this.http.get(url).pipe(map((resp:any) =>{
      let especialidad = new Especialidad();
      especialidad = resp;
      return especialidad;
    }));
  }

  cargarPorDoctor(id: any){
    const url = '/Service/especialidades/doctor/' + id;
    return this.http.get(url).pipe(map((resp:any) =>{
      let lista: Especialidad[] = <Especialidad[]>resp;
      return lista;
    }));
  }

  cargarNoAsignadas(id: any){
    const url = '/Service/especialidades/sin/doctor/' + id;
    return this.http.get(url).pipe(map((resp:any) =>{
      let lista: Especialidad[] = <Especialidad[]>resp;
      return lista;
    }));
  }

  guardar(especialidad: Especialidad) {
    const url = '/Service/especialidades/';
    return this.http.post(url, especialidad).pipe(map((resp: any) => {  
      if (resp){    
        let especialidad = new Especialidad();
        especialidad = resp;
        return especialidad;
      }
      else{
        return null;
      }
    }));
  }

  borrar(id: any) {
    const url = '/Service/especialidades/' + id;
    return this.http.delete(url).pipe(map((resp: any) => {
      return true;
    }));
  }
}
