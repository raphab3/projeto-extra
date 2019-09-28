import { Servidor } from './../../servidores/servidor';
import { Component, OnInit } from '@angular/core';
import { UnidadeEducacional } from '../unidadeEducacional';
import { UnidadeEducacionalService } from '../unidade-educacional.service';
import { Params, ActivatedRoute } from '@angular/router';
import { ServidoresService } from '../../servidores/servidores.service';

@Component({
  selector: 'app-editar-unidade',
  templateUrl: './editar-unidade.component.html',
  styleUrls: ['./editar-unidade.component.css']
})
export class EditarUnidadeComponent implements OnInit {

  unidade: UnidadeEducacional;
  servidores: Servidor[];
  servidor: Servidor;
  cols: any[];

  constructor(private unidadeService: UnidadeEducacionalService,
              private router: ActivatedRoute,
              private servidorService: ServidoresService ) { }


  ngOnInit() {

    this.unidade = new UnidadeEducacional();
    this.router.params.forEach(( params: Params) => {
        const id: number = +params['id'];
        this.unidadeService.getUnidade(id)
        .then((unidade: UnidadeEducacional) => {
          this.unidade = unidade;
        });
    });

    this.servidor = new Servidor();
    this.router.params.forEach(( params: Params) => {
        const id: number = +params['id'];
        this.servidorService.getServidor(id)
        .then((servidor: Servidor) => {
          this.servidor = servidor;
        });
    });

    this.getServidores();
    // tslint:disable-next-line:no-unused-expression
    console.log(this.servidor.id);
  this.cols = [
      { field: 'codigo', header: 'Matrícula' },
      { field: 'cpf', header: 'CPF' },
      { field: 'nome', header: 'Nome' },
      { field: 'funcao', header: 'Função' },
      { field: 'vinculo', header: 'Vinculo' }

  ];

  }
  atualizar(unidade: UnidadeEducacional) {
    this.unidadeService.atualizar(unidade)
    .then((c) => {
      console.log(`Unidade ${c.unidade} atualizado com sucesso!`);
    });
  }

  atualizarVinculo(id, servidor: Servidor) {
    this.servidorService.atualizarVinculo(id, servidor)
    .then((c) => {
      console.log(servidor);
    });
  }

  getServidores() {
    this.servidorService.getServidores().subscribe((data:  Array<Servidor>) => {
      this.servidores  =  data;
      console.log(this.servidores);
    });
  }

  excluir(id) {
    this.servidorService.excluir(id);
  }
}
