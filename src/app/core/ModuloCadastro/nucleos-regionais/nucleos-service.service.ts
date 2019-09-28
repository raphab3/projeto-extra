// import { Http } from '@angular/http';
import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { of } from 'rxjs/internal/observable/of';
// import { AuthHttp } from 'angular2-jwt';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/throw';
import { NucleoRegional } from './nucleoRegional';
import { environment } from 'src/environments/environment';
import * as moment from 'moment';
import { BuilderHttp } from 'src/app/seguranca/builder-http';


@Injectable({
  providedIn: 'root'
})
export class NucleosServiceService {

  nucleos: NucleoRegional[];
  nucleo: NucleoRegional;

  nucleosUrlAPI: string;

  API_URL_CEP = 'https://viacep.com.br/ws';

  constructor(private httpClient: HttpClient, private http: BuilderHttp) {
    this.nucleosUrlAPI = `${environment.apiUrl}/api/nucleos`;
    // this.nucleosUrlAPI = `http://localhost:3000/nucleos-regionais`;

  }

  getNucleos() {
    return this.http.get<NucleoRegional[]>(this.nucleosUrlAPI);
}

  getNucleo(id: number): Promise<NucleoRegional> {
    return this.getNucleos()
    .toPromise()
    .then((nucleos: NucleoRegional[]) => nucleos.find(nucleo => nucleo.id === id));
  }

  consultaCEP(cep: string) {

    // console.log(cep);

    // Nova variável "cep" somente com dígitos.
    cep = cep.replace(/\D/g, '');

    // Verifica se campo cep possui valor informado.
    if (cep !== '') {
      // Expressão regular para validar o CEP.
      const validacep = /^[0-9]{8}$/;

      // Valida o formato do CEP.
      if (validacep.test(cep)) {
        return this.httpClient.get(`${this.API_URL_CEP}/${cep}/json`);
      }
    }

    return of({});
  }

  adicionar(nucleo: NucleoRegional): Promise<NucleoRegional> {
    return this.http.post<NucleoRegional>(this.nucleosUrlAPI, nucleo)
      .toPromise();
  }

  // excluir(id: number): Promise<void> {
  //     return  this.http.delete(`${this.API_URL}/nucleos-regionais/${id}`)
  //       .toPromise()
  //       .then(() => null);
  // }

  atualizar(nucleo: NucleoRegional): Promise<NucleoRegional> {
    return this.http.put<NucleoRegional>(`${this.nucleosUrlAPI}/${nucleo.id}`, nucleo)
      .toPromise();
  }

}
