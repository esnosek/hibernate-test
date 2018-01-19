package library.dao;

import library.entity.Book;
import library.entity.Publisher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private PublisherDao publisherDao;

    public void save(Book book, String publisherId) {
        Session session = sessionFactory.openSession();
        Publisher publisher = publisherDao.findOne(Integer.valueOf(publisherId));
        publisher.addBook(book);
        session.saveOrUpdate(publisher);
    }

}
