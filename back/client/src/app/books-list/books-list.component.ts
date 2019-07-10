import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Books } from '../books';
import { BooksService } from '../books.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-books-list',
  templateUrl: './books-list.component.html',
  styleUrls: ['./books-list.component.css']
})

export class BooksListComponent implements OnInit {

  book = new Books();
  books: Observable<Books[]>;

  public formGroup: FormGroup = new FormGroup({
   _name: new FormControl('', [
      Validators.minLength(4),
      Validators.maxLength(40),
      Validators.required]),
   _author: new FormControl('', [
      Validators.minLength(2),
      Validators.maxLength(40),
      Validators.required]),
   _year: new FormControl('', [
      Validators.pattern('[0-9]|[1-9][0-9]|[1-9][0-9][0-9]|[1-9][0-9][0-9][0-9]|200\d|201[1-9]')
      ]),
   _publisher: new FormControl(''),
   _pub_city: new FormControl('')
  });

  public formGroupUpdate: FormGroup = new FormGroup({
    _nameUpdate: new FormControl(' ', [
       Validators.minLength(4),
       Validators.maxLength(40),
       Validators.required]),
    _authorUpdate: new FormControl(' ', [
       Validators.minLength(2),
       Validators.maxLength(40),
       Validators.required]),
    _yearUpdate: new FormControl(' ', [
       Validators.pattern('[0-9]|[1-9][0-9]|[1-9][0-9][0-9]|[1-9][0-9][0-9][0-9]|200\d|201[1-9]')
       ]),
    _publisherUpdate: new FormControl(' '),
    _pub_cityUpdate: new FormControl(' '),
    _idUpdate: new FormControl(' ')
   });

  constructor(private booksService: BooksService) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData(){
    this.books = this.booksService.getBooksList();
  }

  prepareData( book: Books) {
    if (book.name!=null) { 
      this.formGroupUpdate.get('_nameUpdate').setValue(book.name);
    }
    if (book.author!=null) { 
      this.formGroupUpdate.get('_authorUpdate').setValue(book.author);
    }
    if (book.year!=null) { 
      this.formGroupUpdate.get('_yearUpdate').setValue(book.year);;
    }
    if (book.publisher!=null) { 
      this.formGroupUpdate.get('_publisherUpdate').setValue(book.publisher);
    }
    if (book.city_pub=null) { 
      this.formGroupUpdate.get('_pub_cityUpdate').setValue(book.city_pub);
    }
    
    this.formGroupUpdate.get('_idUpdate').setValue(book.id);
    
  }

  deleteBooks(id: number) {
    this.booksService.deleteBooks(id)
      .subscribe(data => {
        console.log(data);
        this.reloadData();      
      }, 
      error => console.log(error));
      this.reloadData();
  }

  createBook () {
    console.log("button was click!")
    this.book.name = this.formGroup.get('_name').value;
    this.book.author = this.formGroup.get('_author').value;
    this.book.year = this.formGroup.get('_year').value;
    this.book.publisher = this.formGroup.get('_publisher').value;
    this.book.city_pub = this.formGroup.get('_pub_city').value;

    this.booksService.createBooks(this.book)
      .subscribe(data => console.log(data), error => console.log(error));
    this.book = new Books();
    this.reloadData();
  }

  updateBook() {

    console.log("update btn was clicked")
    this.book.name = this.formGroupUpdate.get('_nameUpdate').value;
    console.log(this.book.name)
    this.book.author = this.formGroupUpdate.get('_authorUpdate').value;
    console.log(this.book.author)
    this.book.year = this.formGroupUpdate.get('_yearUpdate').value;
    console.log(this.book.year)
    this.book.publisher = this.formGroupUpdate.get('_publisherUpdate').value;
    console.log(this.book.publisher)
    this.book.city_pub = this.formGroupUpdate.get('_pub_cityUpdate').value;
    console.log(this.book.city_pub)
    this.book.id = this.formGroupUpdate.get('_idUpdate').value;
    console.log(this.book.id)

    this.booksService.updateBooks(this.book)
      .subscribe(data => console.log(data), error => console.log(error));

    this.book = new Books();
    this.reloadData();

  }



}
