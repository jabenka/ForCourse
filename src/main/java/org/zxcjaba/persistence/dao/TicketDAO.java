package org.zxcjaba.persistence.dao;

import org.hibernate.Session;
import org.zxcjaba.persistence.entity.Ticket;
import org.zxcjaba.persistence.misc.HibernateUtil;

import java.util.List;

public class TicketDAO {
    private static TicketDAO instance = new TicketDAO();

    private TicketDAO() {}

    public static TicketDAO getInstance() {
        return instance;
    }

    public void saveTicket(Ticket ticket) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(ticket);
        session.getTransaction().commit();
        session.close();
    }

    public Ticket getTicketById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Ticket ticket = session.get(Ticket.class, id);
        session.close();
        return ticket;
    }

    public List<Ticket> getTicketsByUserId(Long userId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Ticket> tickets = session.createQuery("FROM Ticket WHERE user.id = :userId", Ticket.class)
                .setParameter("userId", userId)
                .list();
        session.close();
        return tickets;
    }

    public void updateTicketType(Long ticketId, String newType) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Ticket ticket = session.get(Ticket.class, ticketId);
        if (ticket != null) {
            ticket.setType(newType);
            session.update(ticket);
            session.getTransaction().commit();
        }
        session.close();
    }

    public void updateTickets(List<Ticket> tickets) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        for (Ticket ticket : tickets) {
            session.update(ticket);
        }
        session.getTransaction().commit();
        session.close();
    }
}
