package edu.mum.cs.cs425.elibraryapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs425.elibraryapp.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

}
