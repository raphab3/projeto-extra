import { NucleoRegional } from './nucleoRegional';
import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { AuthService } from 'src/app/seguranca/auth.service';
import { MessageService } from 'primeng/api';
import { NucleosServiceService } from './nucleos-service.service';
import { ErrorHandlerService } from 'src/app/core/error-handler.service';



@Component({
  selector: 'app-nucleos-regionais',
  templateUrl: './nucleos-regionais.component.html',
  styleUrls: ['./nucleos-regionais.component.css']
})
export class NucleosRegionaisComponent implements OnInit {

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
