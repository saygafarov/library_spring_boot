package ru.saygafarov.ProgectBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.saygafarov.ProgectBoot.model.Book;

import java.util.List;

@Repository
public interface BooksRepositories extends JpaRepository<Book, Integer> {

    List<Book> findByTitleStartingWith(String title);

}
