import { Servidor } from './servidor';
import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { of, Observable, throwError } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { BuilderHttp } from 'src/app/seguranca/builder-http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ServidoresService {

  servidores: Servidor[];

  API_AWS = 'http://abcdata-ui2.s3-website-sa-east-1.amazonaws.com';
  API_URL_SERVIDORES: string;
  API_URL_CEP = 'https://viacep.com.br/ws';

  servidoresURL: string;

  constructor(private httpClient: HttpClient, private http: BuilderHttp) {
    this.API_URL_SERVIDORES = `${environment.apiUrl}/api/servidores`;
   }

  urlUploadAnexo(): string {
      return `${this.API_AWS}/anexo`;
  }

  getServidores() {
    return  this.httpClient.get(`${this.API_URL_SERVIDORES}`);
  }

  getServidor(id: number): Promise<Servidor> {
    return this.getServidores()
    .toPromise()
    .then((servidores: Servidor[]) => servidores.find(servidor => servidor.id === id));
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

  adicionar(servidor: any): Promise<any> {
      return  this.http.post(`${this.API_URL_SERVIDORES}/`, servidor)
        .toPromise()
        .then(response => response);
  }

  excluir(id: number): Promise<void> {
      return  this.http.delete(`${this.API_URL_SERVIDORES}/${id}`)
        .toPromise()
        .then(() => null);
  }

  atualizar(servidor: any): Promise<any> {
      return this.http.put(`${this.API_URL_SERVIDORES}/${servidor.id}`, servidor)
        .toPromise()
        .then(response => response);
  }

  atualizarVinculo(serdivorID, servidor: any): Promise<any> {
    return this.http.put(`${this.API_URL_SERVIDORES}/${serdivorID}`, servidor)
        .toPromise()
        .then(response => response);
  }


}
