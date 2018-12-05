package rest.db.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import rest.db.mappers.BookMapper;
import rest.db.mappers.WishMapper;
import rest.db.pojo.Book;
import rest.db.pojo.Wish;

import java.util.List;


/**
 * Слой доступа к данным
 */
@Component
public class BookDaoImpl implements BookDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    //этот метод делает запрос на выборку всех книг и возвращает Список Книг
    @Override
    public List<Book> getBooksList() {
        return jdbcTemplate.query("SELECT books.id, books.name, authors.id_author, authors.fio FROM books LEFT JOIN authors on books.author_id = authors.id_author",
                new BookMapper());

    }

    //этот метод делает запрос на выборку всех книг и возвращает Список желаний
    @Override
    public List<Wish> getWishList() {
        return jdbcTemplate.query("SELECT wishes.wishes_id, books.id, books.name, authors.id_author, authors.fio FROM wishes JOIN books on wishes.book_id = books.id JOIN authors on books.author_id = authors.id_author",
                new WishMapper());
    }

    //этот метод добавляет запись в таблицу books
    @Override
    public String addBook(String nameBook, int author) {
        jdbcTemplate.update("INSERT INTO books (name, author_id) VALUES(?, ?)", nameBook, author);
        return "Ok";
    }

    //этот метод обновляет запись в таблице books
    @Override
    public String updateBook(int id, String nameBook) {
        jdbcTemplate.update("UPDATE books SET name = ? WHERE  id = ?", nameBook, id);
        return "Ok";
    }

    //этот метод удаляет запись из таблицы books
    @Override
    public String deleteBook(int id) {
        jdbcTemplate.update("DELETE FROM books WHERE  id = ?", id);
        return "Ok";
    }

}
