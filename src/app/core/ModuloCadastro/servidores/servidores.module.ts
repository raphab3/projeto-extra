import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ServidoresRoutingModule } from './servidores-routing.module';
import { ServidoresComponent } from './servidores.component';
import { EditarServidoresComponent } from './editar-servidores/editar-servidores.component';
import { FormServidoresComponent } from './form-servidores/form-servidores.component';
import { DetalheServidoresComponent } from './detalhe-servidores/detalhe-servidores.component';
import { TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import { TooltipModule } from 'primeng/tooltip';
import { CardModule } from 'primeng/card';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SliderModule } from 'primeng/slider';
import { DropdownModule } from 'primeng/dropdown';
import { SelectButtonModule } from 'primeng/selectbutton';
import { MultiSelectModule } from 'primeng/multiselect';
import { InputTextModule } from 'primeng/inputtext';
import { ScheduleModule } from 'primeng/schedule';
import { HttpClientModule } from '@angular/common/http';
import { CalendarModule } from 'primeng/calendar';
import { HttpModule } from '@angular/http';
import { ChipsModule } from 'primeng/chips';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { MessagesModule } from 'primeng/messages';
import { MessageModule } from 'primeng/message';
import { ToastModule } from 'primeng/toast';
import { FileUploadModule } from 'primeng/fileupload';
import { PanelModule } from 'primeng/panel';
import { FieldsetModule } from 'primeng/fieldset';
import { AccordionModule } from 'primeng/accordion';
import { DialogModule } from 'primeng/dialog';
import { InputTextareaModule } from 'primeng/inputtextarea';
import { CheckboxModule } from 'primeng/checkbox';

@NgModule({
  declarations: [
    ServidoresComponent,
    EditarServidoresComponent,
    FormServidoresComponent,
    DetalheServidoresComponent,
  ],
  imports: [
    CommonModule,
    TableModule,
    ButtonModule,
    TooltipModule,
    CardModule,
    FormsModule,
    ReactiveFormsModule,
    SliderModule,
    DropdownModule,
    SelectButtonModule,
    MultiSelectModule,
    InputTextModule,
    ScheduleModule,
    HttpClientModule,
    CalendarModule,
    HttpModule,
    ChipsModule,
    ConfirmDialogModule,
    MessagesModule,
    MessageModule,
    ToastModule,
    FileUploadModule,
    PanelModule,
    FieldsetModule,
    AccordionModule,
    DialogModule,
    InputTextareaModule,
    CheckboxModule,

    // Rotas
    ServidoresRoutingModule
  ]
})
export class ServidoresModule { }
