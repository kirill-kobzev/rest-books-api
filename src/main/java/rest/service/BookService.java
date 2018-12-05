package rest.service;


import rest.db.pojo.Book;
import rest.db.pojo.Wish;

import java.util.List;

public interface BookService {

    List<Book> getBooksList();
    List<Wish> getWishList();

    String addBook(String nameBook, int author);

    String updateBook(int id, String nameBook);

    String deleteBook(int id);
}
