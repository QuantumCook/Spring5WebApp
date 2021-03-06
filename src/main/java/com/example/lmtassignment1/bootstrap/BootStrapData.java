package com.example.lmtassignment1.bootstrap;

import com.example.lmtassignment1.domain.Author;
import com.example.lmtassignment1.domain.Book;
import com.example.lmtassignment1.domain.Publisher;
import com.example.lmtassignment1.repositories.AuthorRepository;
import com.example.lmtassignment1.repositories.BookRepository;
import com.example.lmtassignment1.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Erid", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "21314543132");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());

        Publisher penguin = new Publisher("Penguin", "10001 Broadway", "New York", "NY", "101561");

        publisherRepository.save(penguin);

        System.out.println("publishers: " + publisherRepository.count());
    }
}
