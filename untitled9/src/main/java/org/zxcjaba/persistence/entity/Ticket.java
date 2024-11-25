package org.zxcjaba.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;


@Data
@AllArgsConstructor
public class Ticket {
    Integer id;
    Integer userId;
    TicketType ticketType;
    Timestamp creationTime;


}
