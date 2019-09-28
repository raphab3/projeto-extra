import { Component, OnInit } from '@angular/core';
import { Aluno } from '../aluno';
import { AlunosService } from '../alunos.service';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-editar-alunos',
  templateUrl: './editar-alunos.component.html',
  styleUrls: ['./editar-alunos.component.css']
})
export class EditarAlunosComponent implements OnInit {


  aluno: Aluno;

  constructor(private alunoService: AlunosService,
              private router: ActivatedRoute,
              ) { }

  ngOnInit() {
    this.aluno = new Aluno();
    this.router.params.forEach(( params: Params) => {
        const id: number = +params['id'];
        // console.log(id);
        this.alunoService.getAluno(id)
        .then((aluno: Aluno) => {
          this.aluno = aluno;
        });
    });


  }

  atualizar(aluno: Aluno) {
    aluno.dataUltimaAlteracao = new Date();
    this.alunoService.atualizar(aluno)
    .then((c) => {
      alert(`Aluno ${c.aluno} atualizado com sucesso!`);
    });
  }

}
