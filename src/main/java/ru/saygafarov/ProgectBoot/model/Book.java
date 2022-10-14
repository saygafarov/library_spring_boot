package ru.saygafarov.ProgectBoot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "Book")
@Data
@NoArgsConstructor
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //@NotEmpty(message = "Name of book should not be empty")
    @Size(min = 2, max = 100, message = "Name of book should be between 2 and 100 characters")
    @Column(name = "title")
    private String title;

    //@NotEmpty(message = "Author should not be empty")
    @Size(min = 2, max = 100, message = "Name of book should be between 2 and 100 characters")
    @Column(name = "author")
    private String author;

    //@NotEmpty(message = "Year of production should not be empty")
    @Min(value = 1500, message = "Year of production should be greater then 1500")
    @Column(name = "year_of_production")
    private int yearOfProduction;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    @ToString.Exclude
    private Person owner;

    @Column(name = "taken_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date takenAt;

    @Transient
    private boolean expired;

    public Book( String title, String author, int yearOfProduction) {
        this.title = title;
        this.author = author;
        this.yearOfProduction = yearOfProduction;
    }
}
