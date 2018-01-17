package library.service;

import library.dao.PublisherDao;
import library.dto.BookDto;
import library.dto.PublisherDto;
import library.entity.Book;
import library.entity.Publisher;
import library.entity.PublisherMetadata;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {

    @Autowired
    private PublisherDao publisherDao;

    @Autowired
    private ModelMapper modelMapper;

    public Publisher save(PublisherDto publisherDto) {
        Publisher publisher = modelMapper.map(publisherDto, Publisher.class);
        publisher.addPublisherMetadata(new PublisherMetadata());
        publisherDao.save(publisher);
        return publisher;
    }

    public Book addBook(BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        publisherDao.addBook(Integer.valueOf(bookDto.getPublisherId()), book);
        return book;
    }

    public void delete(String publisherId) {
        publisherDao.delete(Integer.valueOf(publisherId));
    }
}
