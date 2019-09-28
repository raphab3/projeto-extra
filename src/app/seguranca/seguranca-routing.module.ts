import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { LoginComponent } from './login/login.component';


const segurancaRoutes: Routes = [

  { path: 'login', component: LoginComponent},

];
@NgModule({
    imports: [RouterModule.forChild(segurancaRoutes)],
    exports: [RouterModule]
})
export class SegurancaRoutingModule { }
