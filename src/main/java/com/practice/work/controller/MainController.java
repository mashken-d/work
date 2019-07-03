package com.practice.work.controller;

import com.practice.work.Exceptions.ResourceNotFoundException;
import com.practice.work.models.Books;
import com.practice.work.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MainController {
    @Autowired
    private BooksService booksServ;

    @GetMapping("/books")
    public List<Books> getAllBooks(){
        return booksServ.findAll();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Books> getBooksById(@PathVariable(value = "id") Long booksId) throws ResourceNotFoundException {
        Books book = booksServ.findById(booksId).orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + booksId));
        return ResponseEntity.ok().body(book);
    }

    @PostMapping("/books")
    public Books createBooks(@Valid @RequestBody Books books){
        return booksServ.save(books);
    }

    @PutMapping("/books/{id}")
    public  ResponseEntity<Books> updateBooks(@PathVariable(value = "id") Long booksId, @Valid @RequestBody Books booksDetails) throws ResourceNotFoundException {
        Books books = booksServ.findById(booksId).orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + booksId));
        books.setName(booksDetails.getName());
        books.setAuthor(booksDetails.getAuthor());
        books.setPublisher(booksDetails.getPublisher());
        books.setCity_pub(booksDetails.getCity_pub());
        books.setYear(booksDetails.getYear());
        books.setId_book(booksDetails.getId_book());

        final Books updateBook = booksServ.save(books);
        return ResponseEntity.ok(updateBook);
    }

    @DeleteMapping("/books/{id}")
    public Map<String,Boolean> deleteBooks(@PathVariable(value = "id") Long booksId) throws ResourceNotFoundException {
        Books books = booksServ.findById(booksId).orElseThrow(()-> new ResourceNotFoundException("Book not found for this id :: "  + booksId));
        booksServ.deleteById(booksId); //!!! must be books, not booksId
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;

    }

}
