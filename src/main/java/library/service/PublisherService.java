package library.service;

import library.dao.PublisherDao;
import library.dto.write.BookDto;
import library.entity.Book;
import library.entity.Publisher;
import library.entity.PublisherMetadata;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PublisherService {

    @Autowired
    private PublisherDao publisherDao;
    @Autowired
    private ModelMapper modelMapper;

    public Publisher findOne(int id) {
        return publisherDao.findOne(id);
    }

    public Publisher save(Publisher publisher) {
        PublisherMetadata publisherMetadata = new PublisherMetadata();
        publisherMetadata.setIso(publisher.hashCode());
        publisher.addPublisherMetadata(publisherMetadata);
        publisherDao.save(publisher);
        return publisher;
    }

    public void delete(String publisherId) {
        publisherDao.delete(Integer.valueOf(publisherId));
    }

    public Book addBook(BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        publisherDao.addBook(Integer.valueOf(bookDto.getPublisherId()), book);
        return book;
    }
}
