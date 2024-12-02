package org.zxcjaba.persistence.dao;

import org.hibernate.Session;
import org.zxcjaba.persistence.entity.Ticket;
import org.zxcjaba.persistence.entity.User;
import org.zxcjaba.persistence.misc.HibernateUtil;

import java.util.List;

public class UserDAO {
    private static UserDAO instance = new UserDAO();

    private UserDAO() {}

    public static UserDAO getInstance() {
        return instance;
    }

    public void saveUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public User getUserById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    public void deleteUserById(Long userId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        User user = session.get(User.class, userId);
        if (user != null) {
            List<Ticket> tickets = session.createQuery("FROM Ticket WHERE user.id = :userId", Ticket.class)
                    .setParameter("userId", userId)
                    .list();
            for (Ticket ticket : tickets) {
                session.delete(ticket);
            }
            session.delete(user);
            session.getTransaction().commit();
        }
        session.close();
    }

    public void updateUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }
}
