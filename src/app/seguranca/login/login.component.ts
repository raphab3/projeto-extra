import { MessageService } from 'primeng/api';
import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { ErrorHandlerService } from 'src/app/core/error-handler.service';
import { JwtHelperService } from '@auth0/angular-jwt';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  checked = false;
  jwtPayload: any;

  constructor(private auth: AuthService,
    private errorHandler: ErrorHandlerService,
    private messageService: MessageService,
    private router: Router,
    ) { }

    ngOnInit() {
      document.querySelector('body').className = 'hold-transition skin-blue-light fixed sidebar-collapse';
    }

  login(usuario: string, senha: string) {
    this.auth.login(usuario, senha)
      .then(() => {
          this.auth.sideBarShow = true;
          this.router.navigate(['/dashboard']);
        })
        .catch( erro => this.errorHandler.handle(erro));
    }
  }



