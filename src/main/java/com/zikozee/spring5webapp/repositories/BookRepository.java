package com.zikozee.spring5webapp.repositories;

import com.zikozee.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
