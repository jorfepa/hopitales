import { Component, OnInit } from '@angular/core';
import { EspecialidadService } from 'src/app/services/especialidad.service';
import { Especialidad } from 'src/app/models/especialidad';

import Swal from 'sweetalert2';

@Component({
  selector: 'app-lista-especialidades',
  templateUrl: './lista-especialidades.component.html',
  styleUrls: ['./lista-especialidades.component.scss']
})
export class ListaEspecialidadesComponent implements OnInit {

  especialidades: Especialidad[]=[];
  cargando = true;
  pagina = 1;

  // Declaración para mensajes
  Toast = Swal.mixin({
    toast: true,
    position: 'top',
    showConfirmButton: false,
    timer: 3000
  });

  constructor(private especialidadService: EspecialidadService) { }

  ngOnInit() {
    this.cargarLista();
  }

  cargarLista(){    
    this.especialidadService.listar()
      .subscribe(especialidades=>this.especialidades = especialidades);
      this.pagina=1;
  }

  buscar(termino: string) {

  }

  borrar(especialidad: Especialidad) {
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
        this.especialidadService.borrar(especialidad.id).subscribe(resp => {
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
