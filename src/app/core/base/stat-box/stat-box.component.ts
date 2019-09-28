import { Component, OnInit } from '@angular/core';
import { ServidoresService } from '../../ModuloCadastro/servidores/servidores.service';
import { AlunosService } from '../../ModuloCadastro/alunos/alunos.service';
import { UnidadeEducacionalService } from '../../ModuloCadastro/unidade-educacional/unidade-educacional.service';
import { EventosService } from '../../ModuloCadastro/eventos/EventosService';
import { Servidor } from '../../ModuloCadastro/servidores/servidor';
import { Aluno } from '../../ModuloCadastro/alunos/aluno';
import { UnidadeEducacional } from '../../ModuloCadastro/unidade-educacional/unidadeEducacional';
import { Evento } from '../../ModuloCadastro/eventos/evento';


@Component({
  selector: 'app-stat-box',
  templateUrl: './stat-box.component.html',
  styleUrls: ['./stat-box.component.scss']
})
export class StatBoxComponent implements OnInit {
  servidores = 0;
  alunos = 0;
  unidades = 0;
  eventos = 0;


  constructor(private servidorService: ServidoresService,
              private alunoService: AlunosService,
              private unidadeEducacionalService: UnidadeEducacionalService,
              private eventoService: EventosService) { }

  ngOnInit() {
    this.getAlunos();
    this.getServidores();
    this. getUnidades();
    this.getEventos();

  }


  getServidores() {
    this.servidorService.getServidores().subscribe((data:  Array<Servidor>) => {
      this.servidores = data.length;
    });
  }

  getAlunos() {
    this.alunoService.getAlunos().subscribe((data:  Array<Aluno>) => {
      this.alunos = data.length;
    });
  }

  getUnidades() {
    this.unidadeEducacionalService.getUnidades().subscribe((data:  Array<UnidadeEducacional>) => {
      this.unidades  =  data.length;
    });
  }

  getEventos() {
    this.eventoService.getEventos().subscribe((data:  Array<Evento>) => {
      this.eventos  =  data.length;
    });
  }

}
