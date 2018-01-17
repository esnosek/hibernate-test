package library.service;

import library.dao.BookDao;
import library.dto.BookDto;
import library.dto.PublisherDto;
import library.entity.Book;
import library.entity.Publisher;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private ModelMapper modelMapper;

    public Book save(BookDto bookDto){
        Book book = modelMapper.map(bookDto, Book.class);
        bookDao.save(book);
        return book;
    }

}
