package com.zhuzi.demo.controller;

import domain.Book;
import domain.Category;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.BookService;
import service.HelloService;
import service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/10/7.
 */
@Controller
@RequestMapping("/book/")
public class BookController {

    //private static  final Logger LOGGER = Logger.getLogger(BookController.class);
    private static Logger logger_ = LogManager.getLogger(BookController.class);

    List<Category> categories=new ArrayList<Category>();
    List<Book> books = new ArrayList<Book>();

    @Autowired
    private BookService bookService;

    private static final Log logger= LogFactory.getLog(BookController.class);

    @RequestMapping(value = "/book_input", method = { RequestMethod.GET,RequestMethod.PUT })
    public String inputBook(Model model)
    {
        List<Category> categories =bookService.getAllCategories();
        model.addAttribute("categories",categories);
        model.addAttribute("book",new Book());
        return "/book/BookAddForm";
    }

    @RequestMapping(value="/book_edit/{id}")
    public String editBook(Model model, @PathVariable long id)
    {
        try
        {
            List<Category> categories=bookService.getAllCategories();
            model.addAttribute("categories",categories);
            Book book =bookService.get(id);
            model.addAttribute("book",book);
            int t = 3/0;
        }catch (Exception ex)
        {
            System.err.println(ex.getMessage());
            return ex.getMessage();
        }

        return "/book/BookEditForm";
    }

    @RequestMapping(value="/book_save")
    public String saveBook(@ModelAttribute Book book)
    {
        Category category=bookService.getCategory(book.getCategory().getId());
        book.setCategory(category);
        bookService.save(book);
        return "redirect:/book/book_list";
    }

    @RequestMapping(value="/book_list",method = { RequestMethod.GET ,RequestMethod.PUT })
    public String listBooks(Model model)
    {
        try
        {
            logger_.info("book_list");
            logger_.debug("book_list");
            List<Book> books= bookService.getAllBooks();
            model.addAttribute("books",books);
        }catch (Exception ex)
        {
            logger_.error(ex.getMessage());
        }
        return "/book/BookList";
    }

    private Category getCategory(int id)
    {
        for(Category category : categories)
        {
            if(id==category.getId())
                return category;
        }
        return null;
    }
}
