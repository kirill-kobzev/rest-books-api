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

    @Override
    public List<Wish> getWishList() {
        return jdbcTemplate.query("SELECT wishes.wishes_id, books.id, books.name, authors.id_author, authors.fio FROM wishes JOIN books on wishes.book_id = books.id JOIN authors on books.author_id = authors.id_author",
                new WishMapper());

    }
}
