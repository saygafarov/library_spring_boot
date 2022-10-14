package ru.saygafarov.ProgectBoot.dao;

public class BookDAO {
//
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public BookDAO(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public List<Book> index() {
//        return jdbcTemplate
//                .query("SELECT * FROM Book", new BeanPropertyRowMapper<>(Book.class));
//    }
//
//    public Book show(int id) {
//        return jdbcTemplate
//                .query("SELECT * FROM Book WHERE id=?",
//                        new Object[]{id},
//                        new BeanPropertyRowMapper<>(Book.class))
//                .stream()
//                .filter(Objects::nonNull)
//                .findAny()
//                .orElse(null);
//    }
//
//    public void save(Book book) {
//        jdbcTemplate
//                .update("INSERT INTO Book(title, author, year_of_production) VALUES(?, ?, ?)",
//                        book.getTitle(),
//                        book.getAuthor(),
//                        book.getYearOfProduction());
//    }
//
//    public void update(int id, Book updatedBook) {
//        jdbcTemplate
//                .update("UPDATE Book SET title=?, author=?, year_of_production=? WHERE id=?",
//                        updatedBook.getTitle(),
//                        updatedBook.getAuthor(),
//                        updatedBook.getYearOfProduction(),
//                        id);
//    }
//
//    public void delete(int id) {
//        jdbcTemplate
//                .update("DELETE FROM Book WHERE id=?", id);
//    }
//
//    public Optional<Person> getBookOwner(int id) {
//        return jdbcTemplate
//                .query("SELECT Person.* FROM Book JOIN Person ON Book.person_id = Person.id WHERE Book.id = ?",
//                        new Object[]{id},
//                        new BeanPropertyRowMapper<>(Person.class))
//                .stream()
//                .filter(Objects::nonNull)
//                .findAny();
//    }
//
//    public void release(int id) {
//        jdbcTemplate
//                .update("UPDATE Book SET person_id=NULL WHERE id=?", id);
//    }
//
//    public void assign(int id, Person selectedPerson) {
//        jdbcTemplate
//                .update("UPDATE Book SET person_id=? WHERE id=?",
//                        selectedPerson.getId(), id);
//    }
}