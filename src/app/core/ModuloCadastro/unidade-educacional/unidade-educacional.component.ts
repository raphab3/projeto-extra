import { UnidadeEducacionalService } from './unidade-educacional.service';
import { Component, OnInit } from '@angular/core';
import { UnidadeEducacional } from './unidadeEducacional';
import { AuthService } from 'src/app/seguranca/auth.service';

@Component({
  selector: 'app-unidade-educacional',
  templateUrl: './unidade-educacional.component.html',
  styleUrls: ['./unidade-educacional.component.css']
})
export class UnidadeEducacionalComponent implements OnInit {

  unidades: UnidadeEducacional[];

  values: string[];
  cols: any[];

  yearTimeout: any;


  constructor(private unidadeEducacionalService: UnidadeEducacionalService,
              private auth: AuthService) { }

  ngOnInit() {
    this.getUnidades();

    this.cols = [
      { field: 'nucleo', header: 'nucleo' },
      { field: 'diretor', header: 'diretor' },
      { field: 'viceDiretor', header: 'viceDiretor' }
    ];
  }

  public  getUnidades() {
    this.unidadeEducacionalService.getUnidades().subscribe((data:  Array<UnidadeEducacional>) => {
      this.unidades  =  data;
      // console.log(data);
    });
  }

  deletar(nome: string, id: number) {
    this.unidadeEducacionalService.excluir(id)
    .then(() => {
      alert(`Unidade ${nome} deletad com sucesso. id: ${id}`);
      this.getUnidades();
    });
  }

  onYearChange(event, dt) {
    if (this.yearTimeout) {
      clearTimeout(this.yearTimeout);
    }

    this.yearTimeout = setTimeout(() => {
      dt.filter(event.value, 'nucleo', 'diretor', 'viceDiretor');
    }, 250);
  }

}





