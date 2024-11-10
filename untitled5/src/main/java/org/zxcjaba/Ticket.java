package org.zxcjaba;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ticket {

    String ticketClass;
    String ticketType;
    String startDate;
    double price;

}
