package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rest.db.dao.entities.Article;
import rest.db.pojo.Book;
import rest.db.pojo.Wish;
import rest.service.ArticleService;
import rest.service.BookService;

import java.util.List;


/**
 * Главвный контроллер приложения, обрабатывает REST запросы
 */
@RestController
public class BookController {
    private BookService bookService;
    private ArticleService articleService;

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    // этот метод принимает GET запрос и возвращает список всех книг
    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public List<Book> booksList(Model model) {
        return bookService.getBooksList();
    }

    // этот метод принимает GET запрос и возвращает список статей
    // Используется HIBERNATE
    @RequestMapping(value = "/articleList", method = RequestMethod.GET)
    public List<Article> showArticleList(Model model) {
        return  articleService.getArticleList();
    }

    // этот метод принимает GET запрос и возвращает список желаний
    @RequestMapping(value = "/wish", method = RequestMethod.GET)
    public List<Wish> wishList(Model model) {
        return bookService.getWishList();
    }

    // этот метод принимает POST запрос c 2 параметрами
    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public String addBook(
            @RequestParam(value = "nameBook") String nameBook,
            @RequestParam(value = "author") int author
    ) {
        return bookService.addBook(nameBook, author);
    }

    // этот метод принимает PUT запрос c 3 параметрами
    @RequestMapping(value = "/book/{id}", method = RequestMethod.PUT)
    public String updateBook(
            @RequestParam("nameBook") String nameBook,
            @PathVariable("id") int id
    ) {
        return bookService.updateBook(id, nameBook);
    }

    // этот метод принимает DELETE запрос c 1 параметром
    @RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
    public String deleteBook(
            @PathVariable(value = "id") int id
    ) {
        return bookService.deleteBook(id);
    }

}
