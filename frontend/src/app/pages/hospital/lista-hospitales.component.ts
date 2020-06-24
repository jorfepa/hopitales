import { Component, OnInit } from '@angular/core';
import { HospitalService } from 'src/app/services/hospital.service';
import { Hospital } from 'src/app/models/hospital';

import Swal from 'sweetalert2';

@Component({
  selector: 'app-lista-hospitales',
  templateUrl: './lista-hospitales.component.html',
  styleUrls: ['./lista-hospitales.component.scss']
})
export class ListaHospitalesComponent implements OnInit {

  hospitales: Hospital[] = [];
  hospitalesFiltro: Hospital[] = [];
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

  constructor(private hospitalService: HospitalService) { }

  ngOnInit() {
    this.cargarLista();
  }

  cargarLista() {
    this.hospitalService.listar()
      .subscribe(hospitales => {
        this.hospitalesFiltro = hospitales;
        this.hospitales = hospitales;
      });
    this.pagina = 1;
  }

  buscar() {
    if (this.tipoBusqueda == 1) {
      if (this.terminoBuscado.length <= 0) {
        this.hospitalesFiltro = this.hospitales;
        this.pagina = 1;
        return;
      }

      this.hospitalesFiltro = this.hospitales.filter(p => {
        if (p.nombre == null) p.nombre = '';
        return p.nombre.toLocaleLowerCase().includes(this.terminoBuscado.toLocaleLowerCase());
      });
    } else {
      if (this.fechaBuscada)
        this.hospitalesFiltro = this.hospitales.filter(p => {
          return this.fechaBuscada == p.fechaCreacion;
        });
    }
  }

  cambioBusqueda() {
    this.terminoBuscado = '';
    this.fechaBuscada = null;
    this.hospitalesFiltro = this.hospitales;
  }

  borrar(hospital: Hospital) {
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
        this.hospitalService.borrar(hospital.id).subscribe(resp => {
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
