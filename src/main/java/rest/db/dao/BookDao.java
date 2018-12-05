package rest.db.dao;

import rest.db.pojo.Book;
import rest.db.pojo.Wish;

import java.util.List;

public interface BookDao {

    List<Book> getBooksList();
    List<Wish> getWishList();

    String addBook(String nameBook, int author);

    String updateBook(int id, String nameBook);

    String deleteBook(int id);

}
