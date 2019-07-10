import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Readers } from './readers';

@Injectable({
  providedIn: 'root'
})
export class ReadersService {

  private readUrl = '//localhost:8080/lib/readers';

  constructor(private http: HttpClient) { }

  getReaders(id:number): Observable<Object> {
    return this.http.get(`${this.readUrl}/${id}`);
  }

  createReaders(readers: Object): Observable<Object> {
    return this.http.post(`${this.readUrl}`, readers);
  }

  updateReaders(value: Readers): Observable<Object> {
    return this.http.put(`${this.readUrl}/${value.id}`, value)
  }

  deleteReaders(id:number): Observable<any> {
    return this.http.delete(`${this.readUrl}/${id}`, {responseType: 'text'});
  }

  getReadersList(): Observable<any> {
    return this.http.get(`${this.readUrl}`);
  }

}
