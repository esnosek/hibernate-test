package library.dao;

import library.entity.Author;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveOrUpdate(Author author) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(author);
    }

    public void save(Author author) {
        Session session = sessionFactory.openSession();
        session.save(author);
    }

    public List<Author> findByIds(List<Integer> authorsIds) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Author a where a.id in (:ids)").setParameterList("ids", authorsIds);
        return query.list();
    }

    public List<Author> findAll() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Author.class);
        return criteria.list();
    }
}
