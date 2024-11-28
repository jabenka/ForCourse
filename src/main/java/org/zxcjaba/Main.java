package org.zxcjaba;

import org.zxcjaba.persistence.dao.TicketDAO;
import org.zxcjaba.persistence.dao.UserDAO;
import org.zxcjaba.persistence.entity.Ticket;
import org.zxcjaba.persistence.entity.User;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO=UserDAO.getInstance();
        TicketDAO ticketDAO=TicketDAO.getInstance();

        User user = new User();
        user.setName("John Doe");
        userDAO.saveUser(user);

        Ticket ticket1 = new Ticket();
        ticket1.setType("ilovejava");
        ticket1.setUser(user);
        ticketDAO.saveTicket(ticket1);

        Ticket ticket2 = new Ticket();
        ticket2.setType("fromisgoodseriesiguess");
        ticket2.setUser(user);
        ticketDAO.saveTicket(ticket2);

        User fetchedUser = userDAO.getUserById(user.getId());
        System.out.println("Fetched User: " + fetchedUser.getName());

        List<Ticket> tickets = ticketDAO.getTicketsByUserId(user.getId());
        for (Ticket ticket : tickets) {
            System.out.println("Ticket Type: " + ticket.getType());
        }

        ticketDAO.updateTicketType(ticket1.getId(), "First Class");
        Ticket updatedTicket = ticketDAO.getTicketById(ticket1.getId());
        System.out.println("Updated Ticket Type: " + updatedTicket.getType());

        userDAO.deleteUserById(user.getId()); User deletedUser = userDAO.getUserById(user.getId());
        System.out.println("Deleted User: " + (deletedUser == null ? "null" : deletedUser.getName()));
    }
}