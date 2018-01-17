package library.controller;

import library.dto.AuthorDto;
import library.dto.BookDto;
import library.entity.Author;
import library.entity.Book;
import library.service.AuthorService;
import library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("books")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String create(@RequestBody BookDto bookDto){
        Book book;
        try {
            book = bookService.save(bookDto);
        }
        catch (Exception e) {
            return "Error creating the book: " + e.toString();
        }
        return "Book succesfully created! (id = " + book.getId() + ")";
    }

}
