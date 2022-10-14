package ru.saygafarov.ProgectBoot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;

@Entity
@Table(name = "Person")
@Data
@NoArgsConstructor
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 100, message = "Name should be between 2 and 100 characters")
    @Column(name = "full_name")
    private String fullName;

    @Min(value = 1900, message = "Year of born should be greater then 1900")
    @Column(name = "year_of_born")
    private int yearOfBorn;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "owner")
    @ToString.Exclude
    private List<Book> books;

    public Person(String fullName, int yearOfBorn) {
        this.fullName = fullName;
        this.yearOfBorn = yearOfBorn;
    }
}
