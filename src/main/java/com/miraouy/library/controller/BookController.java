package com.miraouy.library.controller;


import com.miraouy.library.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import com.miraouy.library.service.BookService;
import com.miraouy.library.Dtos.ShelfCurrentLoansResponse;
import java.util.List;

//@CrossOrigin("http://localhost:3000")
@CrossOrigin("*")

@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/secure/currentloans")
    public List<ShelfCurrentLoansResponse> currentLoans(String email)
        throws Exception
    {
        return bookService.currentLoans(email);
    }

    @GetMapping("/secure/currentloans/count")
    public int currentLoansCount( String userEmail) {
        return bookService.currentLoansCount(userEmail);
    }
    @GetMapping("/all")
    public List<Book> findAll( String userEmail) {
            return bookService.findAll();
    }
    @GetMapping("/all/title")
    public Page<Book> findByTitle(@RequestParam String title,@RequestParam int page,@RequestParam int size) {
        Pageable pageable= PageRequest.of(page, size);
        return bookService.findByTitle(title,pageable);
    }

    @GetMapping("/secure/ischeckedout/byuser")
    public Boolean checkoutBookByUser(String userEmail, @RequestParam Long bookId) {
        return bookService.checkoutBookByUser(userEmail, bookId);
    }

    @PutMapping("/secure/checkout")
    public Book checkoutBook (@RequestParam String userEmail, @RequestParam Long bookId) throws Exception {
        return bookService.checkoutBook(userEmail, bookId);
    }
    @GetMapping("/{id}")
    public Book checkoutBook ( @PathVariable Long id) throws Exception {
        return bookService.checkoutBook(id);
    }
    @PutMapping("/secure/return")
    public void returnBook(String userEmail,@RequestParam Long bookId) throws Exception {
        bookService.returnBook(userEmail, bookId);
    }

    @PutMapping("/secure/renew/loan")
    public void renewLoan( String userEmail,
                          @RequestParam Long bookId) throws Exception {
        bookService.renewLoan(userEmail, bookId);
    }

}












