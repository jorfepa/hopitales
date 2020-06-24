import { Component, OnInit } from '@angular/core';
import { DoctorService } from 'src/app/services/doctor.service';
import { Doctor } from 'src/app/models/doctor';

import Swal from 'sweetalert2';
import { VisitaService } from 'src/app/services/visita.service';
import { Visita } from 'src/app/models/visita';
@Component({
  selector: 'app-lista-doctores',
  templateUrl: './lista-doctores.component.html',
  styleUrls: ['./lista-doctores.component.scss']
})
export class ListaDoctoresComponent implements OnInit {

  doctores: Doctor[] = [];
  doctoresFiltro: Doctor[] = [];
  doctor = new Doctor();
  visitas: Visita[] = [];
  cargando = true;
  pagina = 1;
  terminoBuscado = '';
  tipoBusqueda = 1;
  fechaBuscada = null;
  paginaVisita = 1;
  mostrarModal = false;

  // Declaración para mensajes
  Toast = Swal.mixin({
    toast: true,
    position: 'top',
    showConfirmButton: false,
    timer: 3000
  });

  constructor(private doctorService: DoctorService,
    private visitaService: VisitaService) { }

  ngOnInit() {
    this.cargarLista();
  }

  cargarLista() {
    this.doctorService.listar()
      .subscribe(doctores => {
        this.doctoresFiltro = doctores;
        this.doctores = doctores;
      });
    this.pagina = 1;
  }

  buscar() {
    if (this.tipoBusqueda == 1) {
      if (this.terminoBuscado.length <= 0) {
        this.doctoresFiltro = this.doctores;
        this.pagina = 1;
        return;
      }

      this.doctoresFiltro = this.doctores.filter(p => {
        if (p.nombre == null) p.nombre = '';
        if (p.apellido == null) p.apellido = '';
        return (p.nombre.toLocaleLowerCase().includes(this.terminoBuscado.toLocaleLowerCase()) ||
                p.apellido.toLocaleLowerCase().includes(this.terminoBuscado.toLocaleLowerCase()));
      });
    } else {
      if (this.fechaBuscada)
        this.doctoresFiltro = this.doctores.filter(p => {
          return this.fechaBuscada == p.fechaNacimiento;
        });
    }
  }

  cambioBusqueda() {
    this.terminoBuscado = '';
    this.fechaBuscada = null;
    this.doctoresFiltro = this.doctores;
  }

  borrar(doctor: Doctor) {
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
        this.doctorService.borrar(doctor.id).subscribe(resp => {
          this.cargarLista();
          // Mensaje de confirmación
          this.Toast.fire({
            icon: 'info',
            title: 'Registro borrado con éxito!'
          });
        });
      }
    });
  }

  mostrarVisitas(doctor: Doctor) {
    this.paginaVisita = 1;
    this.doctorService.cargar(doctor.id)
      .subscribe(doctor => this.doctor = doctor);
    this.visitaService.cargarPorDoctor(doctor.id)
      .subscribe(visitas => this.visitas = visitas);
    this.mostrarModal = true
  }

}
