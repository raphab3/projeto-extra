import { Aluno } from './aluno';
import { Injectable } from '@angular/core';
import { of } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { BuilderHttp } from 'src/app/seguranca/builder-http';

@Injectable({
  providedIn: 'root'
})
export class AlunosService {

  alunos: Aluno[];

  API_AWS = 'http://abcdata-ui2.s3-website-sa-east-1.amazonaws.com';
  API_URL_CEP = 'https://viacep.com.br/ws';
  API_ALUNOS: string;

  constructor(private httpClient: HttpClient, private http: BuilderHttp) {
    this.API_ALUNOS = `${environment.apiUrl}/api/estudantes`;
  }

  urlUploadAnexo(): string {
      return `${this.API_AWS}/anexo`;
  }

  getAlunos() {
    return  this.httpClient.get(`${this.API_ALUNOS}`);
  }

  getAluno(id: number): Promise<Aluno> {
    return this.getAlunos()
    .toPromise()
    .then((alunos: Aluno[]) => alunos.find(aluno => aluno.id === id));
  }


  atualizar(aluno: any): Promise<any> {
    return this.http.put(`${this.API_ALUNOS}/`, aluno)
      .toPromise()
      .then(response => response);
}

adicionar(aluno: any): Promise<any> {
  return  this.http.post(`${this.API_ALUNOS}/`, aluno)
    .toPromise()
    .then(response => response);
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

  // adicionar(servidor: any): Promise<any> {
  //     return  this.http.post(`${this.API_URL}/servidores/`, servidor)
  //       .toPromise()
  //       .then(response => response.json);
  // }

  // excluir(id: number): Promise<void> {
  //     return  this.http.delete(`${this.API_URL}/servidores/${id}`)
  //       .toPromise()
  //       .then(() => null);
  // }

  // atualizar(servidor: any): Promise<any> {
  //     return this.http.put(`${this.API_URL}/servidores/${servidor.id}`, servidor)
  //       .toPromise()
  //       .then(response => response.json);
  // }

}
