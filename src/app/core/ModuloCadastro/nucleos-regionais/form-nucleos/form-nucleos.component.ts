import { NucleoRegional } from './../nucleoRegional';
import { Component, OnInit, Input } from '@angular/core';
import { NucleosServiceService } from '../nucleos-service.service';
import { Message, MessageService, SelectItem } from 'primeng/api';
import { Cep } from '../../cep';
import { ErrorHandlerService } from 'src/app/core/error-handler.service';


@Component({
  selector: 'app-form-nucleos',
  templateUrl: './form-nucleos.component.html',
  styleUrls: ['./form-nucleos.component.css'],

})
export class FormNucleosComponent implements OnInit {

  nucleos: NucleoRegional[];

  nucleo: NucleoRegional;

  dadosCep: Cep[];

  zonas: SelectItem[];


  dataCadastro: Date;
  data: string;
  pt: any;
  disabled = true;
  msgs: Message[] = [];

  formulario = new Cep;

  showTransitionOptions = '300ms ease-out';

  hideTransitionOptions = '250ms ease-in';

  constructor(private nucleoService: NucleosServiceService,
    private messageService: MessageService,
    private errorHandler: ErrorHandlerService) {
      this.zonas = [
        {label: 'Zona', value: null},
        {label: 'Urbana', value: {id: 1, name: 'Urbana', code: 'UB'}},
        {label: 'Rural', value: {id: 2, name: 'Rural', code: 'RU'}},
    ];
    }

    ngOnInit() {

      this.dataCadastro = new Date();
      console.log('dataCadastro  ' + this.dataCadastro);
      const dia = this.dataCadastro.getUTCDate();
      const mes = this.dataCadastro.getMonth() + 1;
      const ano = this.dataCadastro.getFullYear();
      const hora = this.dataCadastro.getHours();
      const min = this.dataCadastro.getMinutes();
      this.data = `${dia}/${mes}/${ano} ${hora}:${min}`;

      console.log(this.data);

      this.pt = {
        firstDayOfWeek: 0,
        dayNames: ['Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado'],
        dayNamesShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb'],
        dayNamesMin: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb'],
        // tslint:disable-next-line:max-line-length
        monthNames: [ 'Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro' ],
        monthNamesShort: [ 'Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez' ],
        today: 'Hoje',
        clear: 'Limpar'
      };

    }


    onSubimit(formulario) {

      formulario.value.dataCadastro = this.data;
      console.log(formulario.value.dataCadastro);
      this.nucleoService.adicionar(formulario.value)
      .then( () => {
        this.messageService.add({severity: 'success', summary: 'Novo Núcleo', detail: 'Criado com sucesso'});
        formulario.reset({dataCadastro: new Date()});
        console.log(this.dataCadastro);
      })
      .catch(erro => this.errorHandler.handle(erro));
    }

    clear() {
      this.msgs = [];
    }

    limpar(formulario) {
      formulario.form.patchValue({
        nucleo: null,
        responsavel: null,
        datacadastro: new Date(),
        cep: null,
        endereco: null,
        complemento: null,
        numero: null,
        bairro: null,
        cidade: null,
        uf: null
      });
    }

    preencher(formulario, dadosCep) {
      formulario.form.patchValue({
        endereco: dadosCep.logradouro,
        complemento: dadosCep.complemento,
        bairro: dadosCep.bairro,
        cidade: dadosCep.localidade,
        uf: dadosCep.uf
      });
    }
    // tslint:disable-next-line:no-shadowed-variable
    consultaCep(cep: any, formulario) {
        this.nucleoService.consultaCEP(cep)
        .toPromise()
        .then(dados => {
            console.log(dados);
            this.preencher(formulario, dados);
        }).catch(() => {
         cep = '';
         formulario = '';
        });
    }
}
