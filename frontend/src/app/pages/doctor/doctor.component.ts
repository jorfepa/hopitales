import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

import Swal from 'sweetalert2'

import { Doctor } from 'src/app/models/doctor';
import { DoctorService } from 'src/app/services/doctor.service';
import { HospitalService } from 'src/app/services/hospital.service';
import { Hospital } from 'src/app/models/hospital';

@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.scss']
})
export class DoctorComponent implements OnInit {

  doctor = new Doctor();
  hospitales: Hospital[]=[];
  id: any;

  constructor(private doctorService: DoctorService,
              private hospitalService: HospitalService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
    activatedRoute.params.subscribe(params => {
      this.id = parseInt(params.id);
    });
  }

  // Declaración de mensajes
  Toast = Swal.mixin({
    toast: true,
    position: 'top',
    showConfirmButton: false,
    timer: 3000
  });

  ngOnInit() {
    this.cargar();    
  }

  cargar(){
    this.hospitalService.listar()
      .subscribe(hospitales=>{        
        this.hospitales = hospitales;
        if (this.id > 0)
          this.cargarDoctor(this.id);
      });
  }

  cargarDoctor(id: any) {
    this.doctorService.cargar(id)
      .subscribe(doctor => this.doctor = doctor);
  }

  guardar(f: NgForm) {
    if ( !f.invalid ) {
    this.doctorService.guardar(this.doctor)
      .subscribe(doctor => {
        if (doctor) {
          this.Toast.fire({
            icon: 'success',
            title: 'Doctor ' + this.doctor.nombre + ' Guadado con éxito'
          });
          this.router.navigate(['/lista-doctores']);
        }
        else{
          this.Toast.fire({
            icon: 'error',
            title: 'Error al Guardar'
          });
        }
      });
    }else{
      Swal.fire({
        icon: 'error',
        title: 'Error en Fomulario',
        text: 'Verifique todos los datos para continuar!',
        confirmButtonColor: '#ED7D31'
      });
    }
  }

  cancelar(f: NgForm) {
    this.router.navigate(['/lista-doctores']);
  }

}
