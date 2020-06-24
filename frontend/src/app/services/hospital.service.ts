import { map } from 'rxjs/operators';
import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";

import { Hospital } from '../models/hospital';

@Injectable({
  providedIn: 'root'
})
export class HospitalService {

  constructor(private http: HttpClient) { }

  listar(){
    const url = '/Service/hospitales';
    return this.http.get(url).pipe(map((resp: any) => {
      let lista: Hospital[] = <Hospital[]>resp
      return lista;
    }));
  }

  cargar(id: any){
    const url = '/Service/hospitales/' + id;
    return this.http.get(url).pipe(map((resp:any) =>{
      let hospital = new Hospital();
      hospital = resp;
      return hospital;
    }));
  }

  guardar(hospital: Hospital) {
    const url = '/Service/hospitales/';
    return this.http.post(url, hospital).pipe(map((resp: any) => {  
      if (resp){    
        let hospital = new Hospital();
        hospital = resp;
        return hospital;
      }
      else{
        return null;
      }
    }));
  }

  borrar(id: any) {
    const url = '/Service/hospitales/' + id;
    return this.http.delete(url).pipe(map((resp: any) => {
      return true;
    }));
  }
}
