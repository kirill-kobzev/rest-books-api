package rest.db.mappers;

import org.springframework.jdbc.core.RowMapper;
import rest.db.pojo.Author;
import rest.db.pojo.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Book(
                rs.getInt("id"),
                rs.getString("name"),
                new Author(
                        rs.getInt("id_author"),
                        rs.getString("fio")));
    }
}
