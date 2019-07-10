import { Component, OnInit, Input } from '@angular/core';
import { Books } from '../books';
import { BooksService } from '../books.service';
import { BooksListComponent } from '../books-list/books-list.component';

@Component({
  selector: 'app-books-details',
  templateUrl: './books-details.component.html',
  styleUrls: ['./books-details.component.css']
})
export class BooksDetailsComponent implements OnInit {
  @Input() book: Books;

  constructor(private bookService: BooksService, private listComponent: BooksListComponent) { }

  ngOnInit() {
  }

}
