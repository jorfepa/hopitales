import { map } from 'rxjs/operators';
import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";

import { Doctor } from '../models/doctor';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  constructor(private http: HttpClient) { }

  listar(){
    const url = '/Service/doctores';
    return this.http.get(url).pipe(map((resp: any) => {
      let lista: Doctor[] = <Doctor[]>resp
      return lista;
    }));
  }

  cargar(id: any){
    const url = '/Service/doctores/' + id;
    return this.http.get(url).pipe(map((resp:any) =>{
      let doctor = new Doctor();
      doctor = resp;
      return doctor;
    }));
  }

  guardar(doctor: Doctor) {
    const url = '/Service/doctores/';
    return this.http.post(url, doctor).pipe(map((resp: any) => {  
      if (resp){    
        let doctor = new Doctor();
        doctor = resp;
        return doctor;
      }
      else{
        return null;
      }
    }));
  }

  borrar(id: any) {
    const url = '/Service/doctores/' + id;
    return this.http.delete(url).pipe(map((resp: any) => {
      return true;
    }));
  }
}
