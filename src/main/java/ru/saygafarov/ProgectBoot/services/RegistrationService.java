package ru.saygafarov.ProgectBoot.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.saygafarov.ProgectBoot.model.Person;
import ru.saygafarov.ProgectBoot.repositories.PeopleRepositories;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final PeopleRepositories peopleRepositories;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void register(Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setRole("ROLE_USER");
        peopleRepositories.save(person);
    }
}
