import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AlunosComponent } from './alunos.component';
import { FormAlunosComponent } from './form-alunos/form-alunos.component';
import { DetalheAlunosComponent } from './detalhe-alunos/detalhe-alunos.component';
import { EditarAlunosComponent } from './editar-alunos/editar-alunos.component';
import { AuthGuard } from 'src/app/seguranca/auth.guard';

const routes: Routes = [


  { path: '', component: AlunosComponent,
    canActivate: [AuthGuard],
    data: { roles: ['ROLE_PESQUISA_ESTUDANTE'] }
  },
  { path: 'novo', component: FormAlunosComponent,
  canActivate: [AuthGuard],
  data: { roles: ['ROLE_CADASTRA_ESTUDANTE'] }
  },
  { path: 'detalhe/:id', component: DetalheAlunosComponent,
    canActivate: [AuthGuard],
    data: { roles: ['ROLE_PESQUISA_ESTUDANTE'] }
  },
  { path: 'editar/:id', component: EditarAlunosComponent,
    canActivate: [AuthGuard],
    data: { roles: ['ROLE_EDITA_ESTUDANTE'] }
  }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AlunosRoutingModule { }
