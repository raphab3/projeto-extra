import { BrowserModule } from '@angular/platform-browser';
import { HttpModule } from '@angular/http';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';



import { TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import { TooltipModule } from 'primeng/tooltip';
import { CardModule } from 'primeng/card';
import { SliderModule } from 'primeng/slider';
import { SelectButtonModule } from 'primeng/selectbutton';
import { MultiSelectModule } from 'primeng/multiselect';
import { InputTextModule } from 'primeng/inputtext';
import { ScheduleModule } from 'primeng/schedule';
import {ChipsModule} from 'primeng/chips';
import {ConfirmDialogModule} from 'primeng/confirmdialog';
import {ConfirmationService, MessageService} from 'primeng/api';
import {MessagesModule} from 'primeng/messages';
import {MessageModule} from 'primeng/message';
import {ToastModule} from 'primeng/toast';
import {FileUploadModule} from 'primeng/fileupload';
import {PanelModule} from 'primeng/panel';
import {FieldsetModule} from 'primeng/fieldset';
import {AccordionModule} from 'primeng/accordion';
import {DialogModule} from 'primeng/dialog';
import {CalendarModule} from 'primeng/calendar';
import {InputTextareaModule} from 'primeng/inputtextarea';
import {CheckboxModule} from 'primeng/checkbox';
import { EventosService } from '../eventos/EventosService';
import { NucleosRegionaisComponent } from './nucleos-regionais.component';
import { FormNucleosComponent } from './form-nucleos/form-nucleos.component';
import { DetalheNucleosComponent } from './detalhe-nucleos/detalhe-nucleos.component';
import { EditarNucleosComponent } from './editar-nucleos/editar-nucleos.component';
import { NucleosRegionaisRoutingModule } from './nucleos-regionais.routing.module';
import { NucleosServiceService } from './nucleos-service.service';
import { ServidoresService } from '../servidores/servidores.service';
import { AlunosService } from '../alunos/alunos.service';
import { DropdownModule } from 'primeng/dropdown';



@NgModule({
    declarations: [
        NucleosRegionaisComponent,
        FormNucleosComponent,
        DetalheNucleosComponent,
        EditarNucleosComponent,
    ],
    imports: [
        CommonModule,
        TableModule,
        ButtonModule,
        TooltipModule,
        FormsModule,
        ReactiveFormsModule,
        DropdownModule,
        MultiSelectModule,
        InputTextModule,
        ScheduleModule,
        HttpClientModule,
        CalendarModule,
        ChipsModule,
        ConfirmDialogModule,
        MessagesModule,
        MessageModule,
        ToastModule,
        FileUploadModule,
        PanelModule,
        FieldsetModule,
        AccordionModule,

        // rotas
        NucleosRegionaisRoutingModule,
    ],
    exports: [],
    providers: [NucleosServiceService, ServidoresService, AlunosService, ConfirmationService, MessageService, EventosService],
})

export class NucleosRegionaisModule {}

