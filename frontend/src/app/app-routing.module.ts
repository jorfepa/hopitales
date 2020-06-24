import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DoctorComponent } from './pages/doctor/doctor.component';
import { ListaDoctoresComponent } from './pages/doctor/lista-doctores.component';
import { PacienteComponent } from './pages/paciente/paciente.component';
import { ListaPacientesComponent } from './pages/paciente/lista-pacientes.component';
import { EspecialidadComponent } from './pages/especialidad/especialidad.component';
import { ListaEspecialidadesComponent } from './pages/especialidad/lista-especialidades.component';
import { HospitalComponent } from './pages/hospital/hospital.component';
import { ListaHospitalesComponent } from './pages/hospital/lista-hospitales.component';
import { HistorialComponent } from './pages/historial/historial.component';
import { DoctorEspecialidadComponent } from './pages/especialidad/doctor-especialidad.component';


const routes: Routes = [
  {path: '', component: ListaHospitalesComponent, data: {tittle: 'Lista de Hospitales'}},
  {path: 'hospital/:id', component: HospitalComponent, data: {tittle: 'Editar Hospital'}},
  {path: 'lista-hospitales', component: ListaHospitalesComponent, data: {tittle: 'Lista de Hospitales'}},
  {path: 'doctor/:id', component: DoctorComponent, data: {tittle: 'Editar Doctor'}},
  {path: 'lista-doctores', component: ListaDoctoresComponent, data: {tittle: 'Lista de Doctores'}},
  {path: 'paciente/:id', component: PacienteComponent, data: {tittle: 'Editar Paciente'}},
  {path: 'lista-pacientes', component: ListaPacientesComponent, data: {tittle: 'Lista de Pacientes'}},
  {path: 'especialidad/:id', component: EspecialidadComponent, data: {tittle: 'Editar Especialidad'}},
  {path: 'lista-especialidades', component: ListaEspecialidadesComponent, data: {tittle: 'Lista de Especialidades'}},
  {path: 'historial/:id', component: HistorialComponent, data: {tittle: 'Historial de visitas'}},
  {path: 'doctor-especialidad/:id', component: DoctorEspecialidadComponent, data: {tittle: 'Lista de Especialidades del Doctor'}},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
