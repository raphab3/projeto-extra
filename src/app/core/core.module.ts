import { AuthService } from './../seguranca/auth.service';
import { LogoutService } from './../seguranca/logout.service';
import { AuthGuard } from './../seguranca/auth.guard';
import { BuilderHttp } from './../seguranca/builder-http';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {ToastaModule} from 'ngx-toasta';
import { RouterModule } from '@angular/router';
import { MessageService, ConfirmationService } from 'primeng/api';

import { ScheduleModule } from 'primeng/schedule';
import { ChartModule } from 'primeng/chart';
import { ErrorHandlerService } from './error-handler.service';
import { SegurancaModule } from '../seguranca/seguranca.module';
import { NaoAutorizadoComponent } from './naoAutorizado';
import {ButtonModule} from 'primeng/button';

import {SidebarModule} from 'primeng/sidebar';

import {SplitButtonModule} from 'primeng/splitbutton';
import {CalendarModule} from 'primeng/calendar';
import { CalendarioComponent } from './base/dashboardGestao/calendario.component';
import { HeaderComponent } from './base/header/header.component';
import { MenuComponent } from './base/menu/menu.component';
import { FooterComponent } from './base/footer/footer.component';
import { StatBoxComponent } from './base/stat-box/stat-box.component';
import { PaginaNaoEncontradaComponent } from './base/pagina-nao-encontrada/pagina-nao-encontrada.component';



@NgModule({
  declarations: [
    CalendarioComponent,
    HeaderComponent,
    MenuComponent,
    FooterComponent,
    StatBoxComponent,
    PaginaNaoEncontradaComponent,
    NaoAutorizadoComponent,
  ],
  imports: [
    CommonModule,
    // BrowserAnimationsModule,
    ScheduleModule,
    ChartModule,
    RouterModule,
    SidebarModule,
    CalendarModule,
    SplitButtonModule,
    ButtonModule,

    // Modulos
    SegurancaModule,

    ToastaModule.forRoot(),


  ],

  providers: [
    ErrorHandlerService, BuilderHttp, AuthGuard, MessageService, LogoutService, ConfirmationService,
    AuthService
  ],
  exports: [CalendarioComponent, HeaderComponent, MenuComponent, FooterComponent, StatBoxComponent,
            ToastaModule, SegurancaModule, NaoAutorizadoComponent]
})
export class CoreModule { }
