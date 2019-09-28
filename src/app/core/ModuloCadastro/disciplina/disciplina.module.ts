import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TableModule } from 'primeng/table';
import {ToastModule} from 'primeng/toast';
import { ButtonModule } from 'primeng/button';




import { DisciplinaRoutingModule } from './disciplina-routing.module';
import { DisciplinaComponent } from './disciplina.component';

@NgModule({
  declarations: [DisciplinaComponent],
  imports: [
    CommonModule,
    DisciplinaRoutingModule,
    TableModule,
    ToastModule,
    ButtonModule
  ]
})
export class DisciplinaModule { }
