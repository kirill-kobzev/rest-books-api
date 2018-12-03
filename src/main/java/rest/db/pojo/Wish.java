package rest.db.pojo;

public class Wish {
    private int id;
    private Book book;

    public Wish(int id, Book book) {
        this.id = id;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Wish{" +
                "id=" + id +
                ", book=" + book +
                '}';
    }
}
