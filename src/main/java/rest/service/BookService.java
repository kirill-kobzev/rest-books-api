package rest.service;


import rest.db.pojo.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooksList();
}
