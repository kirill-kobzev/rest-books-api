package rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.db.dao.BookDao;
import rest.db.pojo.Book;
import rest.db.pojo.Wish;

import java.util.List;

/**
 * Сервис слой приложения
 */
@Service
public class BookServiceImpl implements BookService {
    private BookDao bookDao;

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<Book> getBooksList() {
        return bookDao.getBooksList();
    }

    @Override
    public List<Wish> getWishList() {
        return bookDao.getWishList();
    }
}
