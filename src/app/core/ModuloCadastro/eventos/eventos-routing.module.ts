import { EventoComponent } from './evento.component';
import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { AuthGuard } from 'src/app/seguranca/auth.guard';



const eventosRoutes: Routes = [

  { path: '',
    component: EventoComponent,
    canActivate: [AuthGuard],
    data: { roles: ['ROLE_ADMIN', 'ROLE_CADASTRA_EVENTO', 'ROLE_REMOVE_EVENTO'] }
  },

];
@NgModule({
    imports: [RouterModule.forChild(eventosRoutes)],
    exports: [RouterModule]
})
export class EventosRoutingModule {}
