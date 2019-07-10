import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateBooksComponent } from './create-books/create-books.component';
import { BooksDetailsComponent } from './books-details/books-details.component';
import { BooksListComponent } from './books-list/books-list.component';
import { HttpClientModule } from '@angular/common/http';
import { MainComponent } from './main/main.component';
import { ReadersComponent } from './readers/readers.component';
import { CommonModule } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    CreateBooksComponent,
    BooksDetailsComponent,
    BooksListComponent,
    MainComponent,
    ReadersComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    CommonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
