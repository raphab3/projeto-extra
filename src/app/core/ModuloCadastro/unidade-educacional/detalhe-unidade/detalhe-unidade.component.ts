import { Component, OnInit } from '@angular/core';
import { UnidadeEducacional } from '../unidadeEducacional';
import { UnidadeEducacionalService } from '../unidade-educacional.service';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-detalhe-unidade',
  templateUrl: './detalhe-unidade.component.html',
  styleUrls: ['./detalhe-unidade.component.css']
})
export class DetalheUnidadeComponent implements OnInit {

  unidade: UnidadeEducacional;
  constructor(private nucleosService: UnidadeEducacionalService,
              private router: ActivatedRoute ) { }

  ngOnInit() {
    console.log('on init');
    this.unidade = new UnidadeEducacional();
    this.router.params.forEach(( params: Params) => {
        const id: number = +params['id'];
        // console.log(id);
        this.nucleosService.getUnidade(id)
        .then((unidade: UnidadeEducacional) => {
          this.unidade = unidade;
        });
    });
  }

}
