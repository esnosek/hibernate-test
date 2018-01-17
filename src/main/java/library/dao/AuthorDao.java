package library.dao;

import library.entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Author author) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(author);
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
