import { Component, OnInit } from '@angular/core';
import { Servidor } from './servidor';
import { ServidoresService } from './servidores.service';
import { LazyLoadEvent } from 'primeng/api';

@Component({
  selector: 'app-servidores',
  templateUrl: './servidores.component.html',
  styleUrls: ['./servidores.component.css']
})
export class ServidoresComponent implements OnInit {

  servidores: Servidor[];

  values: string[];
  cols: any[];

  yearTimeout: any;

  countServidores = 0;


  constructor(private servidorService: ServidoresService) { }

  ngOnInit() {
    this.getServidores();


    this.cols = [
      { field: 'nome', header: 'nome' },
      { field: 'funcao', header: 'funcao' },
      { field: 'lotacao', header: 'lotacao' },
      { field: 'telefone', header: 'telefone' }
    ];
  }

  getServidores() {
    this.servidorService.getServidores().subscribe((data:  Array<Servidor>) => {
      this.servidores  =  data;
    });
  }

  deletar(nome: string, id: number) {
    this.servidorService.excluir(id)
    .then(() => {
      alert(`Servidor ${nome} deletado com sucesso. id: ${id}`);
      this.getServidores();
    });
  }

  onYearChange(event, dt) {
    if (this.yearTimeout) {
      clearTimeout(this.yearTimeout);
    }

    this.yearTimeout = setTimeout(() => {
      dt.filter(event.value, 'nome', 'funcao', 'lotacao', 'telefone');
    }, 250);
  }

  // aoMudarPagina(event: LazyLoadEvent) {
  //     const pagina = event.first / event.rows;
  //     this.getServidores(pagina);
  // }

}
