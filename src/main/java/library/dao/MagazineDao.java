package library.dao;

import library.entity.Magazine;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MagazineDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Magazine magazine) {
        Session session = sessionFactory.getCurrentSession();
        session.save(magazine);
    }

    public List<Magazine> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Magazine.class);
        return criteria.list();
    }

    public void update(Magazine magazine) {
        Session session = sessionFactory.getCurrentSession();
        session.update(magazine);
    }

    public Magazine findOne(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Magazine.class);
        criteria.add(Restrictions.eq("id", id));
        return (Magazine) criteria.list().get(0);
    }
}
