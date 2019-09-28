import { MessageService } from 'primeng/components/common/messageservice';
import { Title } from '@angular/platform-browser';
import { Component, OnInit } from '@angular/core';
import { Evento } from './evento';
import { ActivatedRoute } from '@angular/router';
import { ErrorHandlerService } from 'src/app/core/error-handler.service';
import { EventosService } from './EventosService';


@Component({
  selector: 'app-evento',
  templateUrl: './evento.component.html',
  styleUrls: ['./evento.component.css']
})
export class EventoComponent implements OnInit {

  eventos: Evento[];
  evento = new Evento();

  editar = false;

  idAtual = 0;
  dataAtualStart = '';
  dataAtualEnd = '';

  cols: any[];
  pt: any;
  header: any;
  editable: boolean;
  data: any;
  backgroundColor = 'rgba(179,175,198,1)';

  display = false;

  yearTimeout: any;
  options: { defaultDate: string; header: { left: string; center: string; right: string; }; editable: boolean; };
  dateStart: string;
  dt: string;

    showDialog() {
        this.display = true;
    }

  constructor(private eventosService: EventosService,
              private router: ActivatedRoute,
              private messageService: MessageService,
              private errorHandler: ErrorHandlerService,
              private title: Title) {

    this.data = {
      labels: ['Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado', 'Domingo'],
      datasets: [
          {
              label: 'Frequência dos alunos',
              backgroundColor: 'rgba(179,181,198,0.2)',
              borderColor: 'rgba(179,181,198,1)',
              pointBackgroundColor: 'rgba(179,181,198,1)',
              pointBorderColor: '#fff',
              pointHoverBackgroundColor: '#fff',
              pointHoverBorderColor: 'rgba(179,181,198,1)',
              data: [100, 90, 85, 81, 56, 40, 0]
          },
          {
              label: 'Faltas',
              backgroundColor: 'rgba(255,99,132,0.2)',
              borderColor: 'rgba(255,99,132,1)',
              pointBackgroundColor: 'rgba(255,99,132,1)',
              pointBorderColor: '#fff',
              pointHoverBackgroundColor: '#fff',
              pointHoverBorderColor: 'rgba(255,99,132,1)',
              data: [0, 10, 15, 19, 44, 99, 100]
          }
      ]
  };
}

  ngOnInit() {

    this.title.setTitle('Eventos');

    this.header = {
    left: 'prev,next today',
    center: 'title',
    right: 'month,agendaWeek,agendaDay'
    };
    this.editable =  true;

    this.getEventos();

      this.pt = {
        firstDayOfWeek: 0,
        dayNames: ['Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado'],
        dayNamesShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb'],
        dayNamesMin: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb'],
        // tslint:disable-next-line:max-line-length
        monthNames: [ 'Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro' ],
        monthNamesShort: [ 'Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez' ],
        today: 'Hoje',
        allday: 'Todos os dias',
        clear: 'Limpar'
      };

      this.cols = [
        { field: 'title', header: 'title' },
        { field: 'start', header: 'start' },
        { field: 'end', header: 'end' }
      ];

  }

  getEventos() {
    this.eventosService.getEventos().subscribe((data:  Array<Evento>) => {
      this.eventos  =  data;
    });
  }

  onSubimit(formulario) {
    this.eventosService.adicionar(formulario.value)
    .then( () => {
      this.getEventos();
      // this.addSingle(); Mensagem
      this.messageService.add({severity: 'success', summary: 'Evento', detail: 'Criado com sucesso'});
      formulario.reset({});
    })
    .catch( erro => this.errorHandler.handle(erro));

  }

  deletar(id, title) {
      this.eventosService.excluir(id)
    .then(() => {
      this.getEventos();
    });
  }

  abriEditar(id, start, end) {
      this.editar = true;
      this.idAtual = id;
      this.dataAtualStart = start;
      this.dataAtualEnd = end;

  }

  atualizar(evento: Evento) {
    this.eventosService.atualizar(evento)
    .then(() => {
      this.getEventos();
      this.editar = false;
    });
  }

  onYearChange(event, dt) {
    if (this.yearTimeout) {
      clearTimeout(this.yearTimeout);
    }

    this.yearTimeout = setTimeout(() => {
      dt.filter(event.value, 'title', 'start', 'end');
    }, 250);
  }
}
