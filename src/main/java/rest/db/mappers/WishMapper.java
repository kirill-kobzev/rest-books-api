package rest.db.mappers;

import org.springframework.jdbc.core.RowMapper;
import rest.db.pojo.Author;
import rest.db.pojo.Book;
import rest.db.pojo.Wish;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WishMapper implements RowMapper<Wish> {

    @Override
    public Wish mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Wish(rs.getInt("wishes_id"),
                new Book(
                        rs.getInt("id"),
                        rs.getString("name"),
                        new Author(
                                rs.getInt("id_author"),
                                rs.getString("fio"))));
    }

}
