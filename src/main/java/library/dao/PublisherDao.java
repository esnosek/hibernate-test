package library.dao;

import library.entity.Book;
import library.entity.Publisher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Publisher publisher) {
        Session session = sessionFactory.getCurrentSession();
        session.save(publisher);
    }

    public Publisher findOne(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (Publisher) session.get(Publisher.class, id);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Publisher publisher = (Publisher) session.get(Publisher.class, id);
        session.delete(publisher);
    }

    public void addBook(int id, Book book) {
        Session session = sessionFactory.getCurrentSession();
        Publisher publisher = (Publisher) session.get(Publisher.class, id);
        publisher.addBook(book);
    }
}
