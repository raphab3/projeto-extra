import { Title } from '@angular/platform-browser';
import { Component, OnInit } from '@angular/core';
import { Evento } from '../../ModuloCadastro/eventos/evento';
import { EventosService } from '../../ModuloCadastro/eventos/EventosService';



@Component({
  selector: 'app-calendario',
  templateUrl: './calendario.component.html',
  styleUrls: ['./calendario.component.css']
})
export class CalendarioComponent implements OnInit {

  eventos: Evento[];
  header: any;
  data: any;
  backgroundColor = 'rgba(179,175,198,1)';
  options: any;


  constructor(private eventosService: EventosService,
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

    this.title.setTitle('ABCDATA | Prefeitura Municipal de Penedo');

    this.getEventos();
    // selectable: true,
    this.options = {
      defaultDate: '2017-02-01',
      header: {
          left: 'prev,next',
          center: 'title',
          right: 'month,agendaWeek,agendaDay'
      },
      editable: false
  };

  }

  getEventos() {
    this.eventosService.getEventos().subscribe((data:  Array<Evento>) => {
      this.eventos  =  data;
    });
  }

}
