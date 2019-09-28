import { Component, OnInit } from '@angular/core';
import { Cep } from '../../cep';
import { Message } from '@angular/compiler/src/i18n/i18n_ast';
import { UnidadeEducacionalService } from '../unidade-educacional.service';
import { MessageService, SelectItem } from 'primeng/api';
import { UnidadeEducacional } from '../unidadeEducacional';
import { Servidor } from '../../servidores/servidor';
import { ServidoresService } from '../../servidores/servidores.service';

@Component({
  selector: 'app-form-unidade',
  templateUrl: './form-unidade.component.html',
  styleUrls: ['./form-unidade.component.css']
})
export class FormUnidadeComponent implements OnInit {


  unidades: UnidadeEducacional[];
  servidores: Servidor[];
  unidade: UnidadeEducacional;

  dadosCep: Cep[];


  date: Date;
  data: String;
  pt: any;
  disabled = true;
  msgs: Message[] = [];

  formulario = new Cep;

  showTransitionOptions = '300ms ease-out';

  hideTransitionOptions = '250ms ease-in';


    cols: any[];

    brands: SelectItem[];

    colors: SelectItem[];

    yearFilter: number;

    yearTimeout: any;

  constructor(private unidadeService: UnidadeEducacionalService,
    private servidorService: ServidoresService,
    private messageService: MessageService) { }

    ngOnInit() {

      this.date = new Date();
      const dia = this.date.getUTCDate();
      const mes = this.date.getMonth() + 1;
      const ano = this.date.getFullYear();
      this.data = `${dia}-${mes}-${ano}`;

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


      this.getServidores();

      this.brands = [
        { label: 'All Brands', value: null },
        { label: 'Audi', value: 'Audi' },
        { label: 'BMW', value: 'BMW' },
        { label: 'Fiat', value: 'Fiat' },
        { label: 'Honda', value: 'Honda' },
        { label: 'Jaguar', value: 'Jaguar' },
        { label: 'Mercedes', value: 'Mercedes' },
        { label: 'Renault', value: 'Renault' },
        { label: 'VW', value: 'VW' },
        { label: 'Volvo', value: 'Volvo' }
    ];

    this.colors = [
        { label: 'White', value: 'White' },
        { label: 'Green', value: 'Green' },
        { label: 'Silver', value: 'Silver' },
        { label: 'Black', value: 'Black' },
        { label: 'Red', value: 'Red' },
        { label: 'Maroon', value: 'Maroon' },
        { label: 'Brown', value: 'Brown' },
        { label: 'Orange', value: 'Orange' },
        { label: 'Blue', value: 'Blue' }
    ];

    this.cols = [
        { field: 'id', header: '#' },
        { field: 'nome', header: 'Nome' },
        { field: 'funcao', header: 'Função' },
        { field: 'cadastrar', header: 'Cadastrar' }
    ];

    }


    onSubimit(formulario) {

      formulario.value.data = this.data;
      this.unidadeService.adicionar(formulario.value)
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
        nomeUnidade: null,
        data: new Date(),
        cep: null,
        endereco: null,
        complemento: null,
        numero: null,
        bairro: null,
        cidade: null,
        uf: null,
        playGround: null,
        biblioteca: null,
        refeitorio: null,
        quadraEsportiva: null,
        salaLeitura: null,
        campoFutebol: null,
        laboratorioDeCiencias: null,
        laboratorioDeInformatica: null,
        laboratorioDeRobotica: null,
        salaDiretoria: null,
        salaProfessores: null,
        salaAtendimentoEspecial: null,
        cozinha: null,
        sanitarioForaPredio: null,
        sanitarioDentroPredio: null,
        cols: null
      });
    }


    addSingle() {
      this.messageService.add({severity: 'success', summary: 'Nova Unidade', detail: 'Criada com sucesso'});
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
        this.unidadeService.consultaCEP(cep)
        .toPromise()
        .then(dados => {
            console.log(dados);
            this.preencher(formulario, dados);
        }).catch(() => {
         cep = '';
         formulario = '';
        });
    }

    getServidores() {
      this.servidorService.getServidores().subscribe((data:  Array<Servidor>) => {
        this.servidores  =  data;
        console.log(data);
      });
    }


    onYearChange(event, dt) {
      if (this.yearTimeout) {
          clearTimeout(this.yearTimeout);
      }

      this.yearTimeout = setTimeout(() => {
          dt.filter(event.value, 'year', 'gt');
      }, 250);

    }
  }
