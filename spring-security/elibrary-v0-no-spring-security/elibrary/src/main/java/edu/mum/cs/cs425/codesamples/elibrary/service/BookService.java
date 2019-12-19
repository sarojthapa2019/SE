package edu.mum.cs.cs425.codesamples.elibrary.service;

import edu.mum.cs.cs425.codesamples.elibrary.model.Book;

import java.util.List;

public interface BookService {

    public abstract List<Book> getAllBooks();
    public abstract Book saveBook(Book book);
    public abstract Book getBookById(Integer bookId);
    public abstract void deleteBookById(Integer bookId);
    public abstract List<Book> searchBooks(String searchString);

}
