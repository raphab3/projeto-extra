import { Component, OnInit } from '@angular/core';
import { Aluno } from './aluno';
import { AlunosService } from './alunos.service';

@Component({
  selector: 'app-alunos',
  templateUrl: './alunos.component.html',
  styleUrls: ['./alunos.component.css']
})
export class AlunosComponent implements OnInit {

  alunos: Aluno[];

  values: string[];
  cols: any[];

  yearTimeout: any;


  constructor(private alunoService: AlunosService ) { }

  ngOnInit() {
    this.getAlunos();
  }

  getAlunos() {
    this.alunoService.getAlunos().subscribe((data:  Array<Aluno>) => {
      this.alunos  =  data;
    });
  }

  // deletar(nome: string, id: number) {
  //   this.alunoService.excluir(id)
  //   .then(() => {
  //     alert(`Servidor ${nome} deletado com sucesso. id: ${id}`);
  //     this.getAlunos();
  //   });
  // }

  onYearChange(event, dt) {
    if (this.yearTimeout) {
      clearTimeout(this.yearTimeout);
    }

    this.yearTimeout = setTimeout(() => {
      dt.filter(event.value, 'nome', 'ensino', 'serie', 'turma');
    }, 250);
  }

}
