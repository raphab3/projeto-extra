import { Component, OnInit } from '@angular/core';
import { MessageService, Message } from 'primeng/api';
import { Cep } from '../../cep';
import { AlunosService } from '../alunos.service';
import { Aluno } from '../aluno';

@Component({
  selector: 'app-form-alunos',
  templateUrl: './form-alunos.component.html',
  styleUrls: ['./form-alunos.component.css']
})
export class FormAlunosComponent implements OnInit {

  dadosCep: Cep[];
  date: Date;
  dataCadastro: String;
  pt: any;
  disabled = true;
  msgs: Message[] = [];
  formulario = new Cep;
  uploadedFiles: any[] = [];

  alunos: Aluno[];
  aluno = new Aluno();


  filiacao = [
    {label: '', value: null},
    {label: 'Pai/Mãe', value: 1},
    {label: 'Apenas Pai', value: 2},
    {label: 'Apenas Mãe', value: 3},
    {label: 'Não Declarar', value: 4},
];

  showTransitionOptions = '300ms ease-out';

  hideTransitionOptions = '250ms ease-in';

  constructor(private alunoService: AlunosService,
        private messageService: MessageService) {}

    ngOnInit() {

      this.date = new Date();
      const dia = this.date.getUTCDate();
      const mes = this.date.getMonth() + 1;
      const ano = this.date.getFullYear();
      this.dataCadastro = `${dia}-${mes}-${ano}`;

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

      formulario.value.dataCadastro = this.dataCadastro;
      this.aluno.dataUltimaAlteracao = this.date;
      this.alunoService.adicionar(formulario.value)
      .then( () => {
        this.addSingle();
        formulario.reset({date: new Date()});
      });

    }

    clear() {
      this.msgs = [];
    }

    limpar(formulario) {
      formulario.form.patchValue({

    dataCadastro: new Date(),
    // Dados Pessoais
    nome: null,
    dataNascimento: new Date(),
    genero: null,
    etinia: null,
    paisDeOrigem: null,
    estadoDeOrigem: null,
    municipioDeOrigem: null,
    filiacaoMae: null,
    filiacaoPai: null,

    // Dados Escolares
    nomeEnsino: null,
    nomeSerie: null,
    nomeTurma: null,
    nomeTurno: null,
    nomeResponsavel: null,

    // Endereço
    cep: null,
    logradouro: null,
    complemento: null,
    bairro: null,
    cidade: null,
    uf: null,
    numero: null,
    distrito: null,
    zonaResidencial: null,

    // contatdo
    telefone: null,
    telefoneRespon: null,
    email: null,
      });
    }

    addSingle() {
      this.messageService.add({severity: 'success', summary: 'Novo Aluno', detail: 'Criado com sucesso'});
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
        this.alunoService.consultaCEP(cep)
        .toPromise()
        .then(dados => {
            console.log(dados);
            this.preencher(formulario, dados);
        }).catch(() => {
         cep = '';
         formulario = '';
        });
    }

  //   onUpload(event) {
  //     for (const file of event.files) {
  //         this.uploadedFiles.push(file);
  //         console.log(event);
  //     }

  //     this.messageService.add({severity: 'info', summary: 'File Uploaded', detail: ''});
  // }

  // onFileSelect(event) {
  //   console.log(event);

  antesUploadAnexo(event) {
    event.xhr.setRequestHeader('Authorization', 'Bearer ' + localStorage.getItem('token'));
  }

  get urlUploadAnexo() {
    return this.alunoService.urlUploadAnexo();
  }

}
