//package library.service;
//
//import library.dao.BookDao;
//import library.dao.PublisherDao;
//import library.dto.BookDto;
//import library.dto.PublisherDto;
//import library.entity.Book;
//import library.entity.Publisher;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class BookService {
//
//    @Autowired
//    private PublisherDao publisherDao;
//
//    @Autowired
//    private ModelMapper modelMapper;
//
//
//
//    public Book save(BookDto bookDto){
//        Book book = new Book();
//        book.setTitle(bookDto.getTitle());
//        bookDao.save(book, bookDto.getPublisherId());
//        return book;
//    }
//
//}
