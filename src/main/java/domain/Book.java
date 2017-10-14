package domain;

import java.io.Serializable;

/**
 * Created by lenovo on 2017/10/7.
 */
public class Book implements Serializable  {
    private static  final  long serialVersionUID=1231545212211313L;

    private  long id;
    private String isbn;
    private String title;

    private Category category;
    private String author;

    public  Book(){

    }

    public  Book(
            long id,
            String isbn,
            String title,
            Category category,
            String author)
    {
        this.setId(id);
        this.setIsbn(isbn);
        this.setTitle(title);
        this.setCategory(category);
        this.setAuthor(author);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
