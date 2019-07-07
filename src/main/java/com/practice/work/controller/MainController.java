package com.practice.work.controller;

import com.practice.work.Exceptions.ResourceNotFoundException;
import com.practice.work.models.Books;
import com.practice.work.models.Issue;
import com.practice.work.models.Readers;
import com.practice.work.repos.IssueRepository;
import com.practice.work.service.BooksService;
import com.practice.work.service.IssueService;
import com.practice.work.service.ReadersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/lib")
public class MainController {
    @Autowired
    private BooksService booksServ;

    @Autowired
    private IssueRepository issueRepository;

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

    @PostMapping("/booksname")
    public List filter (@RequestParam String text){
        List<Books> books = booksServ.findByname(text);
        return books; //what return!!!
    }

    @PutMapping("/books/{id}")
    public  ResponseEntity<Books> updateBooks(@PathVariable(value = "id") Long booksId, @Valid @RequestBody Books booksDetails) throws ResourceNotFoundException {
        Books books = booksServ.findById(booksId).orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + booksId));
        books.setName(booksDetails.getName());
        books.setAuthor(booksDetails.getAuthor());
        books.setPublisher(booksDetails.getPublisher());
        books.setCity_pub(booksDetails.getCity_pub());
        books.setYear(booksDetails.getYear());
        //books.setId_book(booksDetails.getId_book());

        final Books updateBook = booksServ.save(books);
        return ResponseEntity.ok(updateBook);
    }

    @DeleteMapping("/books/{id}")
    public Map<String,Boolean> deleteBooks(@PathVariable(value = "id") Long booksId) throws ResourceNotFoundException {
        //Books books = booksServ.findById(booksId).orElseThrow(()-> new ResourceNotFoundException("Book not found for this id :: "  + booksId));
        booksServ.deleteById(booksId); //!!! must be books, not booksId
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


    @Autowired
    private IssueService issueServ;

    @GetMapping("/issue")
    public List<Issue> getAllIssue(){
        return issueServ.findAll();
    }

    @GetMapping("/issue/{id}")
    public ResponseEntity<Issue> getIssueById(@PathVariable(value = "id") Long issueId) throws ResourceNotFoundException {
        Issue issue = issueServ.findById(issueId).orElseThrow(() -> new ResourceNotFoundException("Issue not found for this id :: " + issueId));
        return ResponseEntity.ok().body(issue);
    }

    @PostMapping("/issue")
    public Issue createIssue(@Valid @RequestBody Issue issue)throws ResourceNotFoundException {

        Books book = booksServ.findById(issue.getBook().getId()).orElseThrow(() ->
                new ResourceNotFoundException("Book not found for this id ::" + issue.getBook().getId()));
        issue.setBook(book);

        Readers reader = readersServ.findById(issue.getReader().getId()).orElseThrow(() ->
                new ResourceNotFoundException("Reader not found for this id ::" + issue.getReader().getId()));
        issue.setReader(reader);

        return issueServ.save(issue);
    }

    @PutMapping("/issue/{id}")
    public  ResponseEntity<Issue> updateIssue(@PathVariable(value = "id") Long issueId, @Valid @RequestBody Issue issueDetails) throws ResourceNotFoundException {
        Issue issue = issueServ.findById(issueId).orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + issueId));
        issue.setId_rec(issueDetails.getId_rec());
        issue.setBook(issueDetails.getBook());  //foreign key
        issue.setReader(issueDetails.getReader());  //foreign key
        issue.setDate_in(issueDetails.getDate_in());
        issue.setDate_out(issueDetails.getDate_out());

        final Issue updateIssue = issueServ.save(issue);
        return ResponseEntity.ok(updateIssue);
    }

    @DeleteMapping("/issue/{id}")
    public Map<String,Boolean> deleteIssue(@PathVariable(value = "id") Long issueId) {
        issueServ.deleteById(issueId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @RequestMapping(value = "/issuebybook/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public List<Issue> getAllIssueByBook(@PathVariable(value = "id") final Long id) {
        List<Issue> allByBookId = issueServ.getAllByBookId(id);
        return allByBookId;
    }

    @RequestMapping(value = "/issuebyreader/{id}", method = RequestMethod.POST)
    public List<Issue> getAllIssueByReader(@PathVariable(value="id") final Long id) {
        List<Issue> allByReaderId = issueServ.getAllByReaderId(id);
        return allByReaderId;
    }

    @Autowired
    private ReadersService readersServ;

    @GetMapping("/readers")
    public List<Readers> getAllReaders(){
        return readersServ.findAll();
    }

    @GetMapping("/readers/{id}")
    public ResponseEntity<Readers> getReaderById(@PathVariable(value = "id") Long readerId) throws ResourceNotFoundException {
        Readers reader = readersServ.findById(readerId).orElseThrow(() -> new ResourceNotFoundException("Reader not found for this id :: " + readerId));
        return ResponseEntity.ok().body(reader);
    }

    @PostMapping("/readers")
    public Readers createReader(@Valid @RequestBody Readers reader){
        return readersServ.save(reader);
    }

    @PutMapping("/readers/{id}")
    public  ResponseEntity<Readers> updateReader(@PathVariable(value = "id") Long readerId, @Valid @RequestBody Readers readerDetails) throws ResourceNotFoundException {
        Readers reader = readersServ.findById(readerId).orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + readerId));
        reader.setId_card(readerDetails.getId_card());
        reader.setFl_name(readerDetails.getFl_name());
        reader.setAddress(readerDetails.getAddress());
        reader.setPhone(readerDetails.getPhone());

        final Readers updateReader = readersServ.save(reader);
        return ResponseEntity.ok(updateReader);
    }

    @DeleteMapping("/readers/{id}")
    public Map<String,Boolean> deleteReader(@PathVariable(value = "id") Long readerId) {
        readersServ.deleteById(readerId); //!!! must be books, not booksId
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


    @PostMapping("/readersname")
    public List filterReader (@RequestParam String name){
        List<Readers> reader = readersServ.findByfl_name(name);
        return reader;
    }
}
