import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';
import { Books } from './books';

@Injectable({
  providedIn: 'root'
})

export class BooksService {
  private bookUrl = '//localhost:8080/lib/books'; //lib/books !!!
  private bookAdd = '//localhost:8080/lib/booksadd';

  constructor(private http: HttpClient) {}

  getBooks(id: number): Observable<Object> {
    return this.http.get(`${this.bookUrl}/${id}`);
  }

  getAll(): Observable<any> {
    return this.http.get(this.bookUrl);
  }

  createBooks(books: Object): Observable<Object> {
    return this.http.post(`${this.bookAdd}`, books);
  }

  updateBooks(value: Books): Observable<Object> {
    return this.http.put(`${this.bookUrl}/${value.id}`, value);
  }

  deleteBooks(id: number): Observable<any> {
    return this.http.delete(`${this.bookUrl}/${id}`, {responseType: 'text'});
  }

  getBooksList(): Observable<any> {
    return this.http.get(`${this.bookUrl}`);
  }
}
