import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

import Swal from 'sweetalert2'

import { Especialidad } from 'src/app/models/especialidad';
import { EspecialidadService } from 'src/app/services/especialidad.service';

@Component({
  selector: 'app-especialidad',
  templateUrl: './especialidad.component.html',
  styleUrls: ['./especialidad.component.scss']
})
export class EspecialidadComponent implements OnInit {

  especialidad = new Especialidad();
  id: any;

  constructor(private especialidadService: EspecialidadService,
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
    this.especialidadService.cargar(id)
      .subscribe(especialidad => this.especialidad = especialidad);
  }

  guardar(f: NgForm) {
    if ( !f.invalid ) {
    this.especialidadService.guardar(this.especialidad)
      .subscribe(especialidad => {
        if (especialidad) {
          this.Toast.fire({
            icon: 'success',
            title: 'Especialidad ' + this.especialidad.nombre + ' Guadado con éxito'
          });
          this.router.navigate(['/lista-especialidades']);
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
    this.router.navigate(['/lista-especialidades']);
  }

}
