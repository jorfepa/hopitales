import { map } from 'rxjs/operators';
import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";

import { DoctorEspecialidad } from '../models/doctor-especialidad';

@Injectable({
  providedIn: 'root'
})
export class DoctorEspecialidadService {

  constructor(private http: HttpClient) { }

  guardar(doctorEspecialidad: DoctorEspecialidad) {
    const url = '/Service/doctor_especialidades/';
    return this.http.post(url, doctorEspecialidad).pipe(map((resp: any) => {  
      if (resp){    
        let doctorEspecialidad = new DoctorEspecialidad();
        doctorEspecialidad = resp;
        return doctorEspecialidad;
      }
      else{
        return null;
      }
    }));
  }

  borrar(id: any) {
    const url = '/Service/doctor_especialidades/' + id;
    return this.http.delete(url).pipe(map((resp: any) => {
      return true;
    }));
  }
}
