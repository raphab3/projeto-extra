import { HttpModule } from '@angular/http';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import { TooltipModule } from 'primeng/tooltip';
import { SliderModule } from 'primeng/slider';
import { DropdownModule } from 'primeng/dropdown';
import { InputTextModule } from 'primeng/inputtext';
import { ScheduleModule } from 'primeng/schedule';
import {ConfirmDialogModule} from 'primeng/confirmdialog';
import {MessagesModule} from 'primeng/messages';
import {MessageModule} from 'primeng/message';
import {ToastModule} from 'primeng/toast';
import {FileUploadModule} from 'primeng/fileupload';
import {PanelModule} from 'primeng/panel';
import {FieldsetModule} from 'primeng/fieldset';
import {DialogModule} from 'primeng/dialog';
import {CalendarModule} from 'primeng/calendar';
import { EventoComponent } from './evento.component';
import { EventosRoutingModule } from './eventos-routing.module';

@NgModule({
    declarations: [
        EventoComponent
    ],
    imports: [
        CommonModule,
        TableModule,
        ButtonModule,
        TooltipModule,
        FormsModule,
        ReactiveFormsModule,
        SliderModule,
        DropdownModule,
        InputTextModule,
        ScheduleModule,
        HttpClientModule,
        CalendarModule,
        ConfirmDialogModule,
        MessagesModule,
        MessageModule,
        ToastModule,
        FileUploadModule,
        PanelModule,
        FieldsetModule,
        DialogModule,
        HttpModule,

        // rotas
        EventosRoutingModule,
    ],
    providers: [
      ],
      exports: []

})
export class EventoModule {}
