package rest.db.dao;

import rest.db.pojo.Book;

import java.util.List;

public interface BookDao {
    List<Book> getBooksList();

}
