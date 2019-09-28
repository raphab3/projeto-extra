import { ActivatedRoute, Params } from '@angular/router';
import { NucleosServiceService } from './../nucleos-service.service';
import { Component, OnInit } from '@angular/core';
import { NucleoRegional } from '../nucleoRegional';

@Component({
  selector: 'app-detalhe-nucleos',
  templateUrl: './detalhe-nucleos.component.html',
  styleUrls: ['./detalhe-nucleos.component.css']
})
export class DetalheNucleosComponent implements OnInit {

  nucleo: NucleoRegional;

  constructor(private nucleosService: NucleosServiceService,
              private router: ActivatedRoute ) { }

  ngOnInit() {
    this.nucleo = new NucleoRegional();
    this.router.params.forEach(( params: Params) => {
        const id: number = +params['id'];
        // console.log(id);
        this.nucleosService.getNucleo(id)
        .then((nucleo: NucleoRegional) => {
          this.nucleo = nucleo;
        });
    });

    console.log(this.nucleo.responsavel);
  }

}
