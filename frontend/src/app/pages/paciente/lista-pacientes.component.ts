import { Component, OnInit } from '@angular/core';
import { PacienteService } from 'src/app/services/paciente.service';
import { Paciente } from 'src/app/models/paciente';

import Swal from 'sweetalert2';
@Component({
  selector: 'app-lista-pacientes',
  templateUrl: './lista-pacientes.component.html',
  styleUrls: ['./lista-pacientes.component.scss']
})
export class ListaPacientesComponent implements OnInit {

  pacientes: Paciente[] = [];
  pacientesFiltro: Paciente[] = [];
  cargando = true;
  pagina = 1;
  terminoBuscado = '';
  tipoBusqueda = 1;
  fechaBuscada = null;

  // Declaración para mensajes
  Toast = Swal.mixin({
    toast: true,
    position: 'top',
    showConfirmButton: false,
    timer: 3000
  });

  constructor(private pacienteService: PacienteService) { }

  ngOnInit() {
    this.cargarLista();
  }

  cargarLista() {
    this.pacienteService.listar()
      .subscribe(pacientes => {
        this.pacientesFiltro = pacientes;
        this.pacientes = pacientes;
      });
    this.pagina = 1;
  }

  buscar() {
    if (this.tipoBusqueda == 1) {
      if (this.terminoBuscado.length <= 0) {
        this.pacientesFiltro = this.pacientes;
        this.pagina = 1;
        return;
      }

      this.pacientesFiltro = this.pacientes.filter(p => {
        if (p.nombre == null) p.nombre = '';
        if (p.apellido == null) p.apellido = '';
        return (p.nombre.toLocaleLowerCase().includes(this.terminoBuscado.toLocaleLowerCase()) ||
                p.apellido.toLocaleLowerCase().includes(this.terminoBuscado.toLocaleLowerCase()));
      });
    } else {
      if (this.fechaBuscada)
        this.pacientesFiltro = this.pacientes.filter(p => {
          return this.fechaBuscada == p.fechaNacimiento;
        });
    }
  }

  cambioBusqueda() {
    this.terminoBuscado = '';
    this.fechaBuscada = null;
    this.pacientesFiltro = this.pacientes;
  }

  borrar(paciente: Paciente) {
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
        this.pacienteService.borrar(paciente.id).subscribe(resp => {
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

}
