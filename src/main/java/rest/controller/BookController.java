package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rest.db.pojo.Book;
import rest.db.pojo.Wish;
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

    // этот метод принимает GET запрос и возвращает список желаний
    @RequestMapping(value = "/wish", method = RequestMethod.GET)
    public List<Wish> wishList(Model model) {
        return bookService.getWishList();
    }

    // этот метод принимает POST запрос c 2 параметрами,
    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public String addBook(
            @RequestParam(value = "nameBook") String nameBook,
            @RequestParam(value = "author") int author
    ) {
        return bookService.addBook(nameBook, author);
    }
}
