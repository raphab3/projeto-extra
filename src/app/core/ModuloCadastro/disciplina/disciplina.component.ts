import { Component, OnInit } from '@angular/core';
import { NucleoRegional } from '../nucleos-regionais/nucleoRegional';
import { NucleosServiceService } from '../nucleos-regionais/nucleos-service.service';
import { Title } from '@angular/platform-browser';
import { MessageService } from 'primeng/api';
import { ErrorHandlerService } from '../../error-handler.service';
import { AuthService } from 'src/app/seguranca/auth.service';

@Component({
  selector: 'app-disciplina',
  templateUrl: './disciplina.component.html',
  styleUrls: ['./disciplina.component.css']
})
export class DisciplinaComponent implements OnInit {

  nucleos: NucleoRegional[];


  values: string[];
  cols: any[];

  yearTimeout: any;


  constructor(private nucleoService: NucleosServiceService,
              private title: Title,
              private messageService: MessageService,
              private errorHandler: ErrorHandlerService,
              private auth: AuthService) { }

  ngOnInit() {

    this.buscarNucleos();


    this.title.setTitle('Nucleos Regionais | ABCData.databuilder.com.br');

    this.cols = [
      { field: 'nucleo', header: 'nucleo' },
      { field: 'responsavel', header: 'responsavel' }
    ];
  }

  buscarNucleos() {
    this.nucleoService.getNucleos().subscribe(nucleos => {
      this.nucleos = nucleos; });
  }

  // deletar(nome: string, id: number) {
  //   this.nucleoService.excluir(id)
  //   .then(() => {
  //     alert(`Núcleo ${nome} deletado com sucesso. id: ${id}`);
  //     // this.getNucleos();
  //   });
  // }

  onYearChange(event, dt) {
    if (this.yearTimeout) {
      clearTimeout(this.yearTimeout);
    }

    this.yearTimeout = setTimeout(() => {
      dt.filter(event.value, 'nucleo', 'responsavel');
    }, 250);
  }

}
