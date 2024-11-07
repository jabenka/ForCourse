package org.zxcjaba;


import org.zxcjaba.entity.Shared.Shareable;
import org.zxcjaba.entity.Shared.SharedByEmailAndPhone;
import org.zxcjaba.entity.Shared.SharedByPhone;
import org.zxcjaba.entity.Ticket;
import org.zxcjaba.entity.Users.Admin;
import org.zxcjaba.entity.Users.User;
import org.zxcjaba.entity.Users.Visitor;

import java.time.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Ticket ticket = new Ticket("Football Match", "A5");
        LocalTime localTime = LocalTime.of(18, 0); // 18:00
        LocalDateTime localDateTime = localTime.atDate(LocalDate.now());
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        System.out.println(date);

        ticket.setCreationTime(date);
        ticket.setStadiumSector('A');
        ticket.print();

        Shareable shareByPhone = new SharedByPhone();
        Shareable shareByEmailAndPhone = new SharedByEmailAndPhone();
        shareByPhone.share();
        shareByEmailAndPhone.share();

        Visitor visitor = new Visitor();
        Admin admin = new Admin();
        visitor.printRole();
        admin.printRole();

        if (visitor instanceof Visitor) {
            visitor.getTicket();
        }

        if (admin instanceof Admin) {
            admin.checkTicket();
        }

        Ticket newTicket = new Ticket();
    }
}
