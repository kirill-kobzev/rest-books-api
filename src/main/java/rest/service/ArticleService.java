package rest.service;

import rest.db.dao.entities.Article;
import java.util.List;

public interface ArticleService {
    List<Article> getArticleList();
}
