import { HttpClientModule } from '@angular/common/http';
import { ErrorHandlerService } from './core/error-handler.service';
import { NgModule} from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';

import { AppRoutingModule } from './app.routing.module';
import { CoreModule } from './core/core.module';
import { ToastModule } from 'primeng/toast';
import { ToastyModule } from 'ng2-toasty';

import {SidebarModule} from 'primeng/sidebar';
import { AuthService } from './seguranca/auth.service';
import { BuilderHttp } from './seguranca/builder-http';
import { AuthGuard } from './seguranca/auth.guard';
import { MessageService, ConfirmationService } from 'primeng/api';
import { BrowserModule } from '@angular/platform-browser';


@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    ToastyModule.forRoot(),
    SidebarModule,
    HttpClientModule,
    // HttpModule,

    // Modules
    AppRoutingModule,
    CoreModule,


  ],
  providers: [ErrorHandlerService, AuthService, ErrorHandlerService, BuilderHttp,
              AuthGuard, MessageService, ConfirmationService
  ],
  bootstrap: [AppComponent],
  exports: [ToastModule]
})
export class AppModule { }
