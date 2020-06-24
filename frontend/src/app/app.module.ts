import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NgxPaginationModule } from 'ngx-pagination';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';

import { HospitalComponent } from "./pages/hospital/hospital.component";
import { ListaHospitalesComponent } from "./pages/hospital/lista-hospitales.component";
import { PacienteComponent } from './pages/paciente/paciente.component';
import { ListaPacientesComponent } from './pages/paciente/lista-pacientes.component';
import { ListaDoctoresComponent } from './pages/doctor/lista-doctores.component';
import { DoctorComponent } from './pages/doctor/doctor.component';
import { EspecialidadComponent } from './pages/especialidad/especialidad.component';
import { ListaEspecialidadesComponent } from './pages/especialidad/lista-especialidades.component';
import { HistorialComponent } from './pages/historial/historial.component';
import { DoctorEspecialidadComponent } from './pages/especialidad/doctor-especialidad.component';

@NgModule({
  declarations: [
    AppComponent,
    HospitalComponent,
    ListaHospitalesComponent,
    PacienteComponent,
    ListaPacientesComponent,
    ListaDoctoresComponent,
    DoctorComponent,
    EspecialidadComponent,
    ListaEspecialidadesComponent,
    HistorialComponent,
    DoctorEspecialidadComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
