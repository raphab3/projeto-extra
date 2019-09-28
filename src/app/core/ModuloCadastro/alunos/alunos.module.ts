import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AlunosRoutingModule } from './alunos-routing.module';
import { AlunosComponent } from './alunos.component';
import { FormAlunosComponent } from './form-alunos/form-alunos.component';
import { EditarAlunosComponent } from './editar-alunos/editar-alunos.component';
import { DetalheAlunosComponent } from './detalhe-alunos/detalhe-alunos.component';

import { TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import { TooltipModule } from 'primeng/tooltip';
import { ToastModule } from 'primeng/toast';
import { FileUploadModule } from 'primeng/fileupload';
import { CalendarModule } from 'primeng/calendar';
import { InputTextModule } from 'primeng/inputtext';
import { DropdownModule } from 'primeng/dropdown';
import { NucleosServiceService } from '../nucleos-regionais/nucleos-service.service';
import { ServidoresService } from '../servidores/servidores.service';
import { AlunosService } from './alunos.service';
import { ConfirmationService, MessageService } from 'primeng/api';
import { EventosService } from '../eventos/EventosService';

@NgModule({
  declarations: [
    AlunosComponent,
    FormAlunosComponent,
    EditarAlunosComponent,
    DetalheAlunosComponent,
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    CalendarModule,
    TableModule,
    ButtonModule,
    TooltipModule,
    ToastModule,
    FileUploadModule,
    InputTextModule,
    DropdownModule,

    AlunosRoutingModule,
  ],
  exports: [],
    providers: [NucleosServiceService, ServidoresService, AlunosService, ConfirmationService, MessageService, EventosService],
})
export class AlunosModule { }
