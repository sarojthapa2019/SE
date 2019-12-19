package edu.mum.cs.cs425.codesamples.elibrary.service.impl;

import edu.mum.cs.cs425.codesamples.elibrary.model.Book;
import edu.mum.cs.cs425.codesamples.elibrary.repository.BookRepository;
import edu.mum.cs.cs425.codesamples.elibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository repository;

    @Override
    public List<Book> getAllBooks() {
        return (List<Book>)repository.findAll();
    }

    @Override
    public Book saveBook(Book book) {
        return repository.save(book);
    }

    @Override
    public Book getBookById(Integer bookId) {
        return repository.findById(bookId).orElse(null);
    }

    @Override
    public void deleteBookById(Integer bookId) {
        repository.deleteById(bookId);
    }

    @Override
    public List<Book> searchBooks(String searchString) {
        if(containsDecimalPoint(searchString) && isMoney(searchString)) {
            return repository.findAllByOverdueFeeEquals(Double.parseDouble(searchString));

        } else if(isDate(searchString)) {
            return repository.findAllByDatePublishedEquals(LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE));
        } else {
            return repository.findAllByIsbnContainingOrTitleContainingOrPublisherContainingOrderByTitle(searchString, searchString, searchString);
        }
    }

    private boolean isMoney(String searchString) {
        boolean isParseableAsMoney = false;
        try {
            Double.parseDouble(searchString);
            isParseableAsMoney = true;
        } catch(Exception ex) {
            if(ex instanceof ParseException) {
                isParseableAsMoney = false;
            }
        }
        return isParseableAsMoney;
    }

    private boolean isDate(String searchString) {
        boolean isParseableAsDate = false;
        try {
            LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE);
            isParseableAsDate = true;
        } catch(Exception ex) {
            if(ex instanceof DateTimeParseException) {
                isParseableAsDate = false;
            }
        }
        return isParseableAsDate;
    }

    private boolean containsDecimalPoint(String searchString) {
        return searchString.contains(".");
    }
}
