package org.zxcjaba;

import org.zxcjaba.persistence.dao.TicketServiceDAO;
import org.zxcjaba.persistence.entity.Ticket;
import org.zxcjaba.persistence.entity.TicketType;
import org.zxcjaba.persistence.entity.User;

import java.sql.SQLException;
import java.sql.Timestamp;

public class Main {
    public static void main(String[] args) throws SQLException {
        var TicketService= TicketServiceDAO.getTicketServiceDAO();
        Ticket ticket=new Ticket(1,1, TicketType.DAY,new Timestamp(0L));

        User user = new User();
        user.setName("John Doe");
        TicketService.saveUser(user);
        TicketService.saveTicket(ticket);





    }
}