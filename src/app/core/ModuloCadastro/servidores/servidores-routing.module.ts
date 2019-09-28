import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ServidoresComponent } from './servidores.component';
import { AuthGuard } from 'src/app/seguranca/auth.guard';
import { FormServidoresComponent } from './form-servidores/form-servidores.component';
import { DetalheServidoresComponent } from './detalhe-servidores/detalhe-servidores.component';
import { EditarServidoresComponent } from './editar-servidores/editar-servidores.component';

const routes: Routes = [

  {
    path: '',
    component: ServidoresComponent,
    canActivate: [AuthGuard],
    data: { roles: ['ROLE_PESQUISA_SERVIDOR'] }
  },
  { path: 'novo',
    component: FormServidoresComponent,
    canActivate: [AuthGuard],
    data: { roles: ['ROLE_CADASTRA_SERVIDOR'] }
  },
  { path: 'detalhe/:id',
    component: DetalheServidoresComponent,
    canActivate: [AuthGuard],
    data: { roles: ['ROLE_PESQUISA_SERVIDOR'] }
  },
  { path: 'editar/:id',
    component: EditarServidoresComponent,
    canActivate: [AuthGuard],
    data: { roles: ['ROLE_PESQUISA_SERVIDOR'] }
  },


];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ServidoresRoutingModule { }
