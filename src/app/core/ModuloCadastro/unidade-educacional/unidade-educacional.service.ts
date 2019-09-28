import { Injectable } from '@angular/core';
import { UnidadeEducacional } from './unidadeEducacional';
import { HttpClient } from '@angular/common/http';
import { of } from 'rxjs';
import { environment } from 'src/environments/environment';
import { BuilderHttp } from 'src/app/seguranca/builder-http';

@Injectable({
  providedIn: 'root'
})
export class UnidadeEducacionalService {

  unidades: UnidadeEducacional[];


  API_URL_UNIDADES: string;
  API_URL_TESTE = 'http://databuilder.com.br:8080';
  API_URL_CEP = 'https://viacep.com.br/ws';

  constructor(private httpClient: HttpClient, private http: BuilderHttp) {
    this.API_URL_UNIDADES = `${environment.apiUrl}/api/unidadeseducacionais`;
    // this.API_URL_UNIDADES = `http://localhost:3000/unidades-educacionais`;

  }


  getServidores() {
    return  this.httpClient.get(`${this.API_URL_UNIDADES}`);
  }


  getUnidades() {
    return  this.httpClient.get(`${this.API_URL_UNIDADES}`);
  }



  getUnidade(id: number): Promise<UnidadeEducacional> {
    return this.getUnidades()
    .toPromise()
    .then((unidades: UnidadeEducacional[]) => unidades.find(unidade => unidade.id === id));
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

  adicionar(unidade: any): Promise<any> {
      return  this.http.post(`${this.API_URL_UNIDADES}/`, unidade)
        .toPromise()
        .then(response => response);
  }

  excluir(id: number): Promise<void> {
      return  this.http.delete(`${this.API_URL_UNIDADES}/${id}`)
        .toPromise()
        .then(() => null);
  }

  atualizar(unidade: any): Promise<any> {
      return this.http.put(`${this.API_URL_UNIDADES}/${unidade.id}`, unidade)
        .toPromise()
        .then(response => response);
  }
}
