import { MessageService } from 'primeng/api';
import { BuilderHttp } from './builder-http';
import { AuthService } from './auth.service';

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoginComponent } from './login/login.component';
import { CheckboxModule } from 'primeng/checkbox';
import {FormsModule, ReactiveFormsModule } from '@angular/forms';
import { InputTextModule } from 'primeng/inputtext';
import { JwtModule } from '@auth0/angular-jwt';
import { environment } from 'src/environments/environment';
import { SegurancaRoutingModule } from './seguranca-routing.module';
import { AuthGuard } from './auth.guard';

import {ToastModule} from 'primeng/toast';
import { ErrorHandlerService } from '../core/error-handler.service';
import { LogoutService } from './logout.service';

export function tokenGetter() {
  return localStorage.getItem('token');
}


@NgModule({

  declarations: [ LoginComponent ],
  imports: [
    CommonModule,
    CheckboxModule,
    ReactiveFormsModule,
    FormsModule,
    InputTextModule,

    SegurancaRoutingModule,

    ToastModule,

    JwtModule.forRoot({
      config: {
        tokenGetter: tokenGetter,
        whitelistedDomains: environment.tokenWhitelistedDomains,
        blacklistedRoutes: environment.tokenBlacklistedRoutes
      }
    }),
  ],
  exports: [LoginComponent],
  providers: [AuthService, AuthGuard, MessageService, ErrorHandlerService, LogoutService, ToastModule],
})
export class SegurancaModule { }



