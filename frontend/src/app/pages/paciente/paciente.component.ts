import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

import Swal from 'sweetalert2'

import { Paciente } from 'src/app/models/paciente';
import { PacienteService } from 'src/app/services/paciente.service';
import { HospitalService } from 'src/app/services/hospital.service';
import { Hospital } from 'src/app/models/hospital';

@Component({
  selector: 'app-paciente',
  templateUrl: './paciente.component.html',
  styleUrls: ['./paciente.component.scss']
})
export class PacienteComponent implements OnInit {

  paciente = new Paciente();
  hospitales: Hospital[]=[];
  id: any;

  constructor(private pacienteService: PacienteService,
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
          this.cargarPaciente(this.id);
      });
  }

  cargarPaciente(id: any) {
    this.pacienteService.cargar(id)
      .subscribe(paciente => this.paciente = paciente);
  }

  guardar(f: NgForm) {
    if ( !f.invalid ) {
    this.pacienteService.guardar(this.paciente)
      .subscribe(paciente => {
        if (paciente) {
          this.Toast.fire({
            icon: 'success',
            title: 'Paciente ' + this.paciente.nombre + ' Guadado con éxito'
          });
          this.router.navigate(['/lista-pacientes']);
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
    this.router.navigate(['/lista-pacientes']);
  }

}
