import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from './seguranca/login/usuario';
import { AuthService } from './seguranca/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  mostrarFundo = false;
  private usuario: Usuario = new Usuario();
  checked = false;

 constructor(private router: Router, private authService: AuthService) { }

 exibirNavBar() {
   if ( this.router.url !== '/login') {
        this.mostrarFundo = true;
   } else {
    this.mostrarFundo = false;
   }
    return this.router.url !== '/login';
 }



}
