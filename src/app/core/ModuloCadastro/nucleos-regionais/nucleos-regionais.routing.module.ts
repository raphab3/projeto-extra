import { NgModule } from '@angular/core';
import { NucleosRegionaisComponent } from './nucleos-regionais.component';
import { FormNucleosComponent } from './form-nucleos/form-nucleos.component';
import { DetalheNucleosComponent } from './detalhe-nucleos/detalhe-nucleos.component';
import { EditarNucleosComponent } from './editar-nucleos/editar-nucleos.component';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/seguranca/auth.guard';



const nucleosRegionaisRoutes: Routes = [

  {
    path: '',
    component: NucleosRegionaisComponent,
    canActivate: [AuthGuard],
    data: { roles: ['ROLE_PESQUISA_NUCLEO'] }
  },
  { path: 'novo',
    component: FormNucleosComponent,
    canActivate: [AuthGuard],
    data: { roles: ['ROLE_CADASTRA_NUCLEO'] }
  },
  { path: 'detalhe/:id',
    component: DetalheNucleosComponent,
    canActivate: [AuthGuard],
    data: { roles: ['ROLE_PESQUISA_NUCLEO'] }
  },
  { path: 'editar/:id',
    component: EditarNucleosComponent,
    canActivate: [AuthGuard],
    data: { roles: ['ROLE_PESQUISA_NUCLEO'] }
  },

];
@NgModule({
    imports: [
      RouterModule.forChild(nucleosRegionaisRoutes)
    ],
    exports: [RouterModule]
})
export class NucleosRegionaisRoutingModule {}
