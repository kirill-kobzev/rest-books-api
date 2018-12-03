package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rest.service.BookService;


/**
 * Главвный контроллер приложения, обрабатывает REST запросы
 */
@Controller
public class BookController {
    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    // этот метод принимает GET запрос и выводит список всех книг
    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public String booksList(Model model) {
        model.addAttribute("books", bookService.getBooksList());

        return "book";
    }
}
