import { Injectable } from '@angular/core';
import { Evento } from './evento';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { BuilderHttp } from 'src/app/seguranca/builder-http';
import { BehaviorSubject } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class EventosService {
  eventos: Evento[];
  eventosUrlApi: string;

  public emitirEventoCriado = new BehaviorSubject(this.eventos);

  constructor(private httpClient: HttpClient, private http: BuilderHttp) {
    this.eventosUrlApi = `${environment.apiUrl}/api/eventos`;
  }
  getEventos() {
    return this.httpClient.get(`${this.eventosUrlApi}`);
  }
  getEvento(id: number): Promise<Evento> {
    return this.getEventos()
      .toPromise()
      .then((eventos: Evento[]) => eventos.find(evento => evento.id === id));
  }
  adicionar(evento: any): Promise<any> {
    return this.http.post(`${this.eventosUrlApi}`, evento)
      .toPromise()
      .then(response => response);
  }
  excluir(id: number): Promise<void> {
    return this.http.delete(`${this.eventosUrlApi}/${id}`)
      .toPromise()
      .then(() => null);
  }
  atualizar(evento: any): Promise<any> {
    return this.http.put(`${this.eventosUrlApi}/${evento.id}`, evento)
      .toPromise()
      .then(response => response);
  }
}
