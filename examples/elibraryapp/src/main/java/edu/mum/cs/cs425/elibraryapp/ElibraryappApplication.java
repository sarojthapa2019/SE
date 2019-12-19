package edu.mum.cs.cs425.elibraryapp;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.mum.cs.cs425.elibraryapp.model.Book;
import edu.mum.cs.cs425.elibraryapp.repository.BookRepository;

@SpringBootApplication
public class ElibraryappApplication implements CommandLineRunner{
	
	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(ElibraryappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello ELibraryApp!!!");
		Book book = new Book("Patterns of Entrprsie Application Architecture", 6.00f, LocalDate.of(2003, 11, 1));
		Book savedBook = bookRepository.save(book);
		System.out.println(savedBook);
	}

}
