import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

import Swal from 'sweetalert2'

import { Hospital } from 'src/app/models/hospital';
import { HospitalService } from 'src/app/services/hospital.service';

@Component({
  selector: 'app-hospital',
  templateUrl: './hospital.component.html',
  styleUrls: ['./hospital.component.scss']
})
export class HospitalComponent implements OnInit {

  hospital = new Hospital();
  id: any;

  constructor(private hospitalService: HospitalService,
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
    if (this.id > 0)
      this.cargar(this.id);
  }

  cargar(id: any) {
    this.hospitalService.cargar(id)
      .subscribe(hospital => this.hospital = hospital);
  }

  guardar(f: NgForm) {
    if ( !f.invalid ) {
    this.hospitalService.guardar(this.hospital)
      .subscribe(hospital => {
        if (hospital) {
          this.Toast.fire({
            icon: 'success',
            title: 'Hospital ' + this.hospital.nombre + ' Guadado con éxito'
          });
          this.router.navigate(['/lista-hospitales']);
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
    this.router.navigate(['/lista-hospitales']);
  }

}
