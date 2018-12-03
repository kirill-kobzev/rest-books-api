package rest.db.pojo;

public class Author {
    private int author_id;
    private String fio;

    public Author(int author_id, String fio) {
        this.author_id = author_id;
        this.fio = fio;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @Override
    public String toString() {
        return "Author{" +
                "author_id=" + author_id +
                ", fio='" + fio + '\'' +
                '}';
    }
}
