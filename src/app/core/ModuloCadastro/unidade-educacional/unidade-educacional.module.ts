import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UnidadeEducacionalRoutingModule } from './unidade-educacional-routing.module';
import { TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import { TooltipModule } from 'primeng/tooltip';
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
import { UnidadeEducacionalComponent } from './unidade-educacional.component';
import { FormUnidadeComponent } from './form-unidade/form-unidade.component';
import { EditarUnidadeComponent } from './editar-unidade/editar-unidade.component';
import { DetalheUnidadeComponent } from './detalhe-unidade/detalhe-unidade.component';

@NgModule({
  declarations: [
    UnidadeEducacionalComponent,
    FormUnidadeComponent,
    EditarUnidadeComponent,
    DetalheUnidadeComponent,
  ],
  imports: [
    CommonModule,
    // BrowserAnimationsModule,
    TableModule,
    ButtonModule,
    TooltipModule,
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

    // rotas
    UnidadeEducacionalRoutingModule
  ]
})
export class UnidadeEducacionalModule { }
