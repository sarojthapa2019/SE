package edu.mum.cs.cs425.codesamples.elibrary.controller;

import edu.mum.cs.cs425.codesamples.elibrary.model.Book;
import edu.mum.cs.cs425.codesamples.elibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = {"/elibrary/secured/services/book/list","/secured/services/book/list"})
    public ModelAndView listBooks() {
        ModelAndView modelAndView = new ModelAndView();
        List<Book> books = bookService.getAllBooks();
        modelAndView.addObject("books", books);
        modelAndView.addObject("searchString", "");
        modelAndView.addObject("booksCount", books.size());
        modelAndView.setViewName("secured/services/book/list");
        return modelAndView;
    }

    @GetMapping(value = {"/elibrary/secured/services/book/new"})
    public String displayNewBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "secured/services/book/new";
    }

    @PostMapping(value = {"/elibrary/secured/services/book/new"})
    public String addNewBook(@Valid @ModelAttribute("book") Book book,
                                     BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/services/book/new";
        }
        book = bookService.saveBook(book);
        return "redirect:/elibrary/secured/services/book/list";
    }

    @GetMapping(value = {"/elibrary/secured/services/book/edit/{bookId}"})
    public String editBook(@PathVariable Integer bookId, Model model) {
        Book book = bookService.getBookById(bookId);
        if (book != null) {
            model.addAttribute("book", book);
            return "secured/services/book/edit";
        }
        return "book/list";
    }

    @PostMapping(value = {"/elibrary/secured/services/book/edit"})
    public String updateBook(@Valid @ModelAttribute("book") Book book,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/services/book/edit";
        }
        book = bookService.saveBook(book);
        return "redirect:/elibrary/secured/services/book/list";
    }

    @GetMapping(value = {"/elibrary/secured/services/book/delete/{bookId}"})
    public String deleteBook(@PathVariable Integer bookId, Model model) {
        bookService.deleteBookById(bookId);
        return "redirect:/elibrary/secured/services/book/list";
    }

    @GetMapping(value = {"/elibrary/secured/services/book/search"})
    public ModelAndView searchBooks(@RequestParam String searchString) {
        ModelAndView modelAndView = new ModelAndView();
        List<Book> books = bookService.searchBooks(searchString);
        modelAndView.addObject("books", books);
        modelAndView.addObject("searchString", searchString);
        modelAndView.addObject("booksCount", books.size());
        modelAndView.setViewName("secured/services/book/list");
        return modelAndView;
    }

}
