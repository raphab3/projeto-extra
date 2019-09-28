import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/seguranca/auth.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {

  mostrarMenu = false;

  constructor(private auth: AuthService) {}

  ngOnInit() {
    // this.authService.mostrarMenuESideBarEmitter.subscribe(
    //    mostrar => this.mostrarMenu = mostrar
    // );
  }

}
