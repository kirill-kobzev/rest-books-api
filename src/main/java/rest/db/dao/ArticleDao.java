package rest.db.dao;

import rest.db.dao.entities.Article;

import java.util.List;

public interface ArticleDao {
    List<Article> getArticleList();
}
