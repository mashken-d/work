import { Component, OnInit } from '@angular/core';
import { Books } from '../books';
import { BooksService } from '../books.service';

@Component({
  selector: 'app-create-books',
  templateUrl: './create-books.component.html',
  styleUrls: ['./create-books.component.css']
})
export class CreateBooksComponent implements OnInit {
  book: Books = new Books();
  submitted = false;

  constructor(private bookService: BooksService) { }

  ngOnInit() {
  }

  newBooks(): void {
    this.submitted = false;
    this.book =new Books();
  }

  save() {
    this.bookService.createBooks(this.book)
      .subscribe(data => console.log(data), error => console.log(error));
    this.book = new Books();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  } 
}
