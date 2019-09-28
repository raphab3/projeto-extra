import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UnidadeEducacionalComponent } from './unidade-educacional.component';
import { AuthGuard } from 'src/app/seguranca/auth.guard';
import { FormUnidadeComponent } from './form-unidade/form-unidade.component';
import { DetalheUnidadeComponent } from './detalhe-unidade/detalhe-unidade.component';
import { EditarUnidadeComponent } from './editar-unidade/editar-unidade.component';

const routes: Routes = [

  { path: '',
  component: UnidadeEducacionalComponent,
  canActivate: [AuthGuard],
  data: { roles: ['ROLE_PESQUISA_UNIDADE_EDUCACIONAL'] }
},
{ path: 'novo',
  component: FormUnidadeComponent,
  canActivate: [AuthGuard],
  data: { roles: ['ROLE_CADASTRA_UNIDADE_EDUCACIONAL'] }
},
{ path: 'detalhe/:id',
  component: DetalheUnidadeComponent,
  canActivate: [AuthGuard],
  data: { roles: ['ROLE_PESQUISA_UNIDADE_EDUCACIONAL'] }
},
{ path: 'editar/:id',
  component: EditarUnidadeComponent,
  canActivate: [AuthGuard],
  data: { roles: ['ROLE_PESQUISA_UNIDADE_EDUCACIONAL'] }
},

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UnidadeEducacionalRoutingModule { }
