package ru.saygafarov.ProgectBoot.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.saygafarov.ProgectBoot.model.Book;
import ru.saygafarov.ProgectBoot.model.Person;
import ru.saygafarov.ProgectBoot.repositories.BooksRepositories;

import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BooksService {

    private final BooksRepositories booksRepositories;

    public List<Book> findAll(boolean sortedByYear) {
        if (sortedByYear) {
            return booksRepositories.findAll(Sort.by("year"));
        } else {
            return booksRepositories.findAll();
        }
    }

    public List<Book> findWithPagination(Integer page, Integer booksPerPage, boolean sortByYear) {
        if (sortByYear) {
            return booksRepositories.findAll(PageRequest.of(page, booksPerPage, Sort.by("year"))).getContent();
        } else {
            return booksRepositories.findAll(PageRequest.of(page, booksPerPage)).getContent();
        }
    }

    public Book findOne(int id) {
        return booksRepositories.findById(id).orElseThrow();
    }

    public List<Book> searchByTitle(String query) {
        return booksRepositories.findByTitleStartingWith(query);
    }

    @Transactional
    public void save(Book book) {
        booksRepositories.save(book);
    }

    @Transactional
    public void update(int id, Book updateBook) {
        Book bookToBeUpdated = booksRepositories.findById(id).get();

        updateBook.setId(id);
        updateBook.setOwner(bookToBeUpdated.getOwner());
        booksRepositories.save(updateBook);
    }

    @Transactional
    public void delete(int id) {
        booksRepositories.deleteById(id);
    }

    public Person getBookOwner(int id) {
        return booksRepositories.findById(id).map(Book::getOwner).orElse(null);
    }

    @Transactional
    public void release(int id) {
        booksRepositories.findById(id).ifPresent(book -> {
           book.setOwner(null);
           book.setTakenAt(null);
        });
    }

    @Transactional
    public void assign(int id, Person selectedPerson) {
        booksRepositories.findById(id).ifPresent(book -> {
            book.setOwner(selectedPerson);
            book.setTakenAt(new Date());
        });
    }
}
