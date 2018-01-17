package library.dao;

import library.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Book book) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(book);
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
