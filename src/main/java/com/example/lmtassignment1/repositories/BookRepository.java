package com.example.lmtassignment1.repositories;

import com.example.lmtassignment1.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
