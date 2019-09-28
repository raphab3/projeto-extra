import { Component, OnInit } from '@angular/core';
import { Params, ActivatedRoute } from '@angular/router';
import { NucleosServiceService } from '../nucleos-service.service';
import { NucleoRegional } from '../nucleoRegional';
import { ErrorHandlerService } from 'src/app/core/error-handler.service';
import { MessageService } from 'primeng/api';

@Component({
  selector: 'app-editar-nucleos',
  templateUrl: './editar-nucleos.component.html',
  styleUrls: ['./editar-nucleos.component.css']
})
export class EditarNucleosComponent implements OnInit {

  nucleo: NucleoRegional;
  constructor(private nucleoService: NucleosServiceService,
              private router: ActivatedRoute,
              private messageService: MessageService,
              private errorHandler: ErrorHandlerService ) { }

  ngOnInit() {
    this.nucleo = new NucleoRegional();
    this.router.params.forEach(( params: Params) => {
        const id: number = +params['id'];
        this.nucleoService.getNucleo(id)
        .then((nucleo: NucleoRegional) => {
          this.nucleo = nucleo;
        });
    });
  }

  atualizar(nucleo: NucleoRegional) {
    this.nucleoService.atualizar(nucleo)
    .then( () => {
      this.messageService.add({severity: 'success', summary: 'Núcleo', detail: 'Atualizado com sucesso'});
    })
  .catch(erro => {
      this.errorHandler.handle(erro);
    });
  }
}


