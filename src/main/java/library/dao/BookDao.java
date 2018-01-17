package library.dao;

import library.entity.Book;
import library.entity.Publisher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
        Transaction transaction = null;
        try {
            Publisher publisher = publisherDao.findOne(Integer.valueOf(publisherId));
            transaction = session.beginTransaction();
            publisher.addBook(book);
            session.saveOrUpdate(publisher);
            transaction.commit();
        }
        catch(RuntimeException e) {
            if(transaction!=null)
                transaction.rollback();
            throw e;
        }
        finally {
            session.close();
        }
    }

}
