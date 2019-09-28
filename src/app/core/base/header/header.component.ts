import { LogoutService } from './../../../seguranca/logout.service';
import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/seguranca/auth.service';
import { Router } from '@angular/router';
import { ErrorHandlerService } from './../../error-handler.service';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

 mostrarMenu = false;

 items: MenuItem[];


 constructor(private auth: AuthService,
              private logoutService: LogoutService,
              private errorHandler: ErrorHandlerService,
              private router: Router) {}

 ngOnInit() {
  document.querySelector('body').className = 'hold-transition skin-blue-light fixed';
  this.items = [
    {label: 'Nível de acesso', icon: 'pi pi-refresh', command: () => {
        // this.update();
    }},
    {label: 'Setup UE', icon: 'pi pi-cog', routerLink: ['/']}
];

 }

 logout() {
   this.logoutService.logout()
   .then(() => {
      this.router.navigate(['/login']);
   })
   .catch( erro => this.errorHandler.handle(erro));
 }

}
