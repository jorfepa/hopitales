import { map } from 'rxjs/operators';
import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";

import { Nota } from '../models/nota';

@Injectable({
  providedIn: 'root'
})
export class NotaService {

  constructor(private http: HttpClient) { }

  cargarPorPaciente(id: any){
    const url = '/Service/notas/paciente/' + id;
    return this.http.get(url).pipe(map((resp:any) =>{
      let lista: Nota[] = <Nota[]>resp
      return lista;
    }));
  }

  guardar(nota: Nota) {
    const url = '/Service/notas/';
    return this.http.post(url, nota).pipe(map((resp: any) => {  
      if (resp){    
        let nota = new Nota();
        nota = resp;
        return nota;
      }
      else{
        return null;
      }
    }));
  }
}
