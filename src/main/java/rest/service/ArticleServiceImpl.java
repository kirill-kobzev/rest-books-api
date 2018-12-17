package rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.db.dao.ArticleDao;
import rest.db.dao.entities.Article;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleDao articleDao;

    @Autowired
    public void setArticleDao(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @Override
    public List<Article> getArticleList() {
        List<Article> articles = articleDao.getArticleList();
        System.out.println(articles.get(1));
        return articles;
    }
}
