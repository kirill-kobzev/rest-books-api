package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rest.db.pojo.Book;
import rest.service.BookService;

import java.util.List;


/**
 * Главвный контроллер приложения, обрабатывает REST запросы
 */
@RestController
public class BookController {
    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    // этот метод принимает GET запрос и возвращает список всех книг
    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public List<Book> booksList(Model model) {
        return bookService.getBooksList();
    }
}
