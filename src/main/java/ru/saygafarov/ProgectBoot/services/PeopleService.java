package ru.saygafarov.ProgectBoot.services;

import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.saygafarov.ProgectBoot.model.Book;
import ru.saygafarov.ProgectBoot.model.Person;
import ru.saygafarov.ProgectBoot.repositories.PeopleRepositories;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PeopleService {

    private final PeopleRepositories peopleRepositories;

    public List<Person> findAll() {
        return peopleRepositories.findAll();
    }

    public Person findOne(int id) {
        return peopleRepositories.findById(id).orElseThrow();
    }

    @Transactional
    public void save(Person person) {
        peopleRepositories.save(person);
    }

    @Transactional
    public void update(int id, Person updatePerson) {
        updatePerson.setId(id);
        peopleRepositories.save(updatePerson);
    }

    @Transactional
    public void delete(int id) {
        peopleRepositories.deleteById(id);
    }

    public Optional<Person> getPersonByFullName(String  fullName) {
        return peopleRepositories.findByFullName(fullName);
    }

    public List<Book> getBooksByPersonId(int id) {
        Optional<Person> person = peopleRepositories.findById(id);
        if (person.isPresent()) {
            Hibernate.initialize(person.get().getBooks());

            person.get().getBooks().forEach(book -> {
                long diffInMillies = Math.abs(book.getTakenAt().getTime() - new Date().getTime());
                if (diffInMillies > 864_000_000) {
                    book.setExpired(true);
                }
            });

            return person.get().getBooks();

        } else {
            return Collections.emptyList();
        }
    }


}
