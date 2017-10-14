package service;
import java.util.List;
import java.util.ArrayList;

import domain.Book;
import domain.Category;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2017/10/7.
 */

@Service("BookService")
public class BookServiceImpl implements BookService {

    private List<Category> categories;
    private List<Book> books;

    public BookServiceImpl() {
        categories = new ArrayList<Category>();
        Category category1 = new Category(1, "Computing");
        Category category2 = new Category(2, "Travel");
        Category category3 = new Category(3, "Health");

        categories.add(category1);
        categories.add(category2);
        categories.add(category3);

        books = new ArrayList<Book>();
        books.add(new Book(1L, "9780980839623", "Servlet & JSP:A Tutorial", category1, "Budi Kurniwan"));
        books.add(new Book(2L, "9780980839630", "C# A Beginner's Tutorial", category1, "Jayden Ky"));
    }

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public Category getCategory(int id)
    {
        for(Category category : categories)
        {
            if(id==category.getId())
                return category;
        }
        return null;
    }

    @Override
    public List<Book> getAllBooks()
    {
        return books;
    }

    @Override
    public Book save(Book book)
    {
        book.setId(getNextId());
        books.add(book);
        return book;
    }

    @Override
    public Book get(long id)
    {
        for(Book book : books)
        {
            if(id==book.getId())
                return  book;
        }
        return null;
    }

    @Override
    public Book update(Book book) {
        int bookCount = books.size();
        for (int i=0;i<bookCount;i++)
        {
            Book saveBook=books.get(i);
            if(saveBook.getId()==book.getId())
            {
                books.set(i,book);
                return book;
            }
        }
        return book;
    }

    @Override
    public long getNextId() {
        //need to be locked
        long id = 0L;
        for (Book book : books) {
            long bookId = book.getId();
            if (bookId > id) {
                id = bookId;
            }
        }
        return id + 1;
    }
}
