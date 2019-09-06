package com.zikozee.spring5webapp.bootstrap;

import com.zikozee.spring5webapp.model.Author;
import com.zikozee.spring5webapp.model.Book;
import com.zikozee.spring5webapp.model.Publisher;
import com.zikozee.spring5webapp.repositories.AuthorRepository;
import com.zikozee.spring5webapp.repositories.BookRepository;
import com.zikozee.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component //to ensure this is a bean loaded by spring
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Publisher publisher1 = new Publisher("Harper Collins","mile12");
        //publisherRepository.save(publisher1);
        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", publisher1);
//        eric.getBooks().add(ddd);
//        ddd.getAuthors().add(eric);
//        authorRepository.save(eric);
//        bookRepository.save(ddd);
        Set<Author> authors = new HashSet<>();
        authors.add(eric);
        ddd.setAuthors(authors);
        bookRepository.save(ddd);

        // if i were to use authorService, bookService n their respective Impl,
        // it means we want to add more functions to the already defined for CrudRepository OR JpaRepository

        Publisher publisher2 = new Publisher("zee", "Oakland USA");
        //publisherRepository.save(publisher2);
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", publisher2);
//        rod.getBooks().add(noEJB);
//        noEJB.getAuthors().add(rod);
//        authorRepository.save(rod);
//        bookRepository.save(noEJB);
        Set<Author> newAuthors = new HashSet<>();
        newAuthors.add(rod);
        noEJB.setAuthors(newAuthors);
        bookRepository.save(noEJB);
    }
}
