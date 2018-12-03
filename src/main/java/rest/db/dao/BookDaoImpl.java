package rest.db.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rest.db.pojo.Book;

import java.util.ArrayList;
import java.util.List;


/**
 * Слой доступа к данным
 */
@Component
public class BookDaoImpl implements BookDao {
    private List<Book> books = new ArrayList<>();

    @Autowired
    public BookDaoImpl() {
        books.add(new Book(1, "one"));
        books.add(new Book(2, "two"));
        books.add(new Book(3, "three"));
        books.add(new Book(4, "for"));
    }

    //Метод выводит список книг
    @Override
    public List<Book> getBooksList() {
        return books;
    }
}
