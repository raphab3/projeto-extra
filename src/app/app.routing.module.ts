import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


import { AuthGuard } from './seguranca/auth.guard';
import { LoginComponent } from './seguranca/login/login.component';

import { NaoAutorizadoComponent } from './core/naoAutorizado';
import { CoreModule } from './core/core.module';
import { CalendarioComponent } from './core/base/dashboardGestao/calendario.component';
import { PaginaNaoEncontradaComponent } from './core/base/pagina-nao-encontrada/pagina-nao-encontrada.component';
import { ServidoresModule } from './core/ModuloCadastro/servidores/servidores.module';
import { AlunosModule } from './core/ModuloCadastro/alunos/alunos.module';
import { EventoModule } from './core/ModuloCadastro/eventos/evento.module';
import { DisciplinaModule } from './core/ModuloCadastro/disciplina/disciplina.module';
import { NucleosRegionaisModule } from './core/ModuloCadastro/nucleos-regionais/nucleos-regionais.module';
import { UnidadeEducacionalModule } from './core/ModuloCadastro/unidade-educacional/unidade-educacional.module';

const appRoutes: Routes = [

    // Cadastro Modulos
    {path: 'nucleos-regionais' , loadChildren : () =>  NucleosRegionaisModule },
    {path: 'unidades-educacionais' , loadChildren : () =>  UnidadeEducacionalModule },
    {path: 'servidores' , loadChildren : () =>  ServidoresModule },
    {path: 'alunos' , loadChildren : () =>  AlunosModule },
    {path: 'eventos' , loadChildren : () =>  EventoModule },
    {path: 'disciplinas' , loadChildren : () =>  DisciplinaModule },

  

    // Principal
    { path: 'login', component: LoginComponent},
    { path: 'dashboard',
      component: CalendarioComponent,
      canActivate: [AuthGuard]
    },
    { path: 'naoAutorizado', component: NaoAutorizadoComponent },
    { path: '', redirectTo: '/dashboard', pathMatch: 'full'},
    { path: '**', component: PaginaNaoEncontradaComponent },
  ];

  @NgModule({
    imports: [
      CoreModule,

      RouterModule.forRoot(
        appRoutes,
      )
    ],
    exports: [RouterModule]
  })

  export class AppRoutingModule {  }
