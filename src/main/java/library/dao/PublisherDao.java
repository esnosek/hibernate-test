package library.dao;

import library.entity.Publisher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Publisher publisher) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(publisher);
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
