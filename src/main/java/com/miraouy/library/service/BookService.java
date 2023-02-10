package com.miraouy.library.service;

import com.miraouy.library.Dtos.ShelfCurrentLoansResponse;
import com.miraouy.library.entity.Book;
import com.miraouy.library.entity.Checkout;
import com.miraouy.library.entity.History;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public interface BookService {
    public Book checkoutBook (String userEmail, Long bookId) throws Exception ;
    public Book checkoutBook ( Long bookId) throws Exception ;

    public Boolean checkoutBookByUser(String userEmail, Long bookId) ;
    List<Book> findAll();
    public int currentLoansCount(String userEmail) ;
    public Page<Book> findByTitle(String title, Pageable pageRequest) ;

    public List<ShelfCurrentLoansResponse> currentLoans(String userEmail) throws Exception;

    public void returnBook (String userEmail, Long bookId) throws Exception ;
    public void renewLoan(String userEmail, Long bookId) throws Exception ;
}
