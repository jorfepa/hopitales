import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

import Swal from 'sweetalert2'

import { Especialidad } from 'src/app/models/especialidad';
import { EspecialidadService } from 'src/app/services/especialidad.service';
import { DoctorService } from 'src/app/services/doctor.service';
import { Doctor } from 'src/app/models/doctor';
import { DoctorEspecialidad } from 'src/app/models/doctor-especialidad';
import { DoctorEspecialidadService } from 'src/app/services/doctor-especialidad.service';

@Component({
  selector: 'app-doctor-especialidad',
  templateUrl: './doctor-especialidad.component.html',
  styleUrls: ['./doctor-especialidad.component.scss']
})
export class DoctorEspecialidadComponent implements OnInit {

  doctorEspecialidades: Especialidad[] = [];
  especialidades: Especialidad[] = [];
  especialidadesNoAsiganadas: Especialidad[] = [];
  doctor = new Doctor();
  id: any;
  pagina = 1;

  // Declaración para mensajes
  Toast = Swal.mixin({
    toast: true,
    position: 'top',
    showConfirmButton: false,
    timer: 3000
  });

  constructor(private especialidadService: EspecialidadService,
    private doctorService: DoctorService,
    private doctorEspecialidadService: DoctorEspecialidadService,
    private activatedRoute: ActivatedRoute) {
    activatedRoute.params.subscribe(params => {
      this.id = parseInt(params.id);
    });
  }

  ngOnInit() {
    this.cargarDoctor(this.id);
    this.cargarLista(this.id);
    this.cargarEspecialidades();
    this.cargarNoAsignadas(this.id);
  }

  cargarDoctor(id: any) {
    this.doctorService.cargar(id)
      .subscribe(doctor => {
        this.doctor = doctor
      });
  }

  cargarNoAsignadas(id: any) {
    this.especialidadService.cargarNoAsignadas(id)
      .subscribe(especialidadesNoAsiganadas => this.especialidadesNoAsiganadas = especialidadesNoAsiganadas);
  }

  cargarLista(id: any) {
    this.especialidadService.cargarPorDoctor(id)
      .subscribe(especialidad => this.doctorEspecialidades = especialidad);
  }

  cargarEspecialidades() {
    this.especialidadService.listar()
      .subscribe(especialidad => this.especialidades = especialidad);
  }

  async agregarEspecialidad() {

    let inputOptions = { 0: "" };

    this.especialidadesNoAsiganadas.forEach(e => {
      inputOptions[e.id] = e.nombre;
    });

    delete inputOptions['0'];

    await Swal.fire({
      title: 'Seleccione una Especialidad',
      input: 'select',
      inputOptions: inputOptions,
      confirmButtonColor: '#ED7D31',
      cancelButtonColor: '#5A6268',
      inputPlaceholder: 'Seleccionar',
      showCancelButton: true,
      inputValidator: (value) => {
        return new Promise((resolve) => {
          if (value) {
            resolve();
            let doctorEspecialidad = new DoctorEspecialidad();
            doctorEspecialidad.idDoctor = this.id;
            doctorEspecialidad.idEspecialidad = value;
            this.doctorEspecialidadService.guardar(doctorEspecialidad)
              .subscribe(doctorEspecialidad => {
                this.cargarLista(this.id);
                this.cargarNoAsignadas(this.id);
              })
          }else{
            resolve('Debe seleccionar una especialidad');
          }
        })
      }
    });
  }

  quitarEspecialidad(doctorEspecialidad: DoctorEspecialidad){
    Swal.fire({
      title: '¿Desea borrar el registro?',
      text: "Esta acción es irreversible!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#ED7D31',
      cancelButtonColor: '#5A6268',
      confirmButtonText: 'Si, Borrar!'
    }).then((result) => {
      if (result.value) {
        // Borrar registro
        this.doctorEspecialidadService.borrar(doctorEspecialidad.id).subscribe(resp => {
          this.cargarLista(this.id);
          this.cargarNoAsignadas(this.id);
          // Mensaje de confirmación
          this.Toast.fire({
            icon: 'info',
            title: 'Registro borrado con éxito!'
          });
        });
      }
    });
  }
}
