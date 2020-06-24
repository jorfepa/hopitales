import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

import Swal from 'sweetalert2'

import { Nota } from 'src/app/models/nota';
import { NotaService } from 'src/app/services/nota.service';
import { PacienteService } from 'src/app/services/paciente.service';
import { Paciente } from 'src/app/models/paciente';
import { DoctorService } from 'src/app/services/doctor.service';
import { Doctor } from 'src/app/models/doctor';

@Component({
  selector: 'app-historial',
  templateUrl: './historial.component.html',
  styleUrls: ['./historial.component.scss']
})
export class HistorialComponent implements OnInit {

  notas: Nota[] = [];
  doctores: Doctor[] = [];
  paciente = new Paciente();
  id: any;
  pagina = 1;

  constructor(private notaService: NotaService,
    private pacienteService: PacienteService,
    private doctorService: DoctorService,
    private activatedRoute: ActivatedRoute) {
    activatedRoute.params.subscribe(params => {
      this.id = parseInt(params.id);
    });
  }

  ngOnInit() {
    this.cargarPaciente(this.id);
    this.cargarLista(this.id);
    this.cargarDoctores();
  }

  cargarPaciente(id: any) {
    this.pacienteService.cargar(id)
      .subscribe(paciente => {
        this.paciente = paciente
      });
  }

  cargarLista(id: any) {
    this.notaService.cargarPorPaciente(id)
      .subscribe(notas => this.notas = notas);
  }

  cargarDoctores() {
    this.doctorService.listar()
      .subscribe(doctores => this.doctores = doctores);
  }

  async crearNota() {
    const { value: valores } = await Swal.fire({
      title: 'Crear Nota de Visita',
      showCancelButton: true,
      confirmButtonColor: '#ED7D31',
      cancelButtonColor: '#5A6268',
      html:
        '<label>Fecha de Visita</label><input type=date id="swal-input1" class="swal2-input">' +
        '<label>Descripción</label><input id="swal-input2" class="swal2-input">',
      focusConfirm: false,
      preConfirm: () => {
        return [
          (<HTMLInputElement>document.getElementById('swal-input1')).value,
          (<HTMLInputElement>document.getElementById('swal-input2')).value
        ]
      }
    });

    if (valores)
      if ((valores[0].length > 0) && (valores[1].trim().length > 0)) {
        let nota = new Nota();
        nota.idPaciente = this.id;
        nota.fecha = new Date(valores[0]);
        nota.descripcion = valores[1];

        let inputOptions = { 0: "" };

        this.doctores.forEach(e => {
          inputOptions[e.id] = e.nombre + ' ' + e.apellido;
        });

        delete inputOptions['0'];

        await Swal.fire({
          title: 'Seleccione un Doctor',
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
                nota.idDoctor = value;
                this.notaService.guardar(nota)
                  .subscribe(_nota => {
                    nota = _nota
                    this.cargarLista(this.id);
                  });

              } else {
                resolve('Debe seleccionar una especialidad');
              }
            })
          }
        });
      }
      else {
        Swal.fire({ icon: 'error', title: "Error", text: "Debe introducir Fecha y la Descripción" });
      }
  }

}
