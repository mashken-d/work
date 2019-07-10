import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BooksListComponent } from './books-list/books-list.component';
import { CreateBooksComponent } from './create-books/create-books.component';
import { MainComponent } from './main/main.component';
import { ReadersComponent } from './readers/readers.component';


const routes: Routes = [
  { path: '', redirectTo: 'lib', pathMatch: 'full'},
  { path: 'lib', component: MainComponent }, 
  { path: 'lib/books', component: BooksListComponent },
  { path: 'lib/books/:id', component: CreateBooksComponent }, //get and pur request to api!
  { path: 'lib/booksadd', component: CreateBooksComponent },
  {path: 'lib/readers', component: ReadersComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
