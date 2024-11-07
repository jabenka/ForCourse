package org.zxcjaba.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.zxcjaba.annotations.NullableWarning;
import java.util.Date;


@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ticket extends BaseEntity {
    @NullableWarning
    Long ID;

    String concertHall;

    int eventCode;

    Date creationTime;

    boolean isPromo;

    char stadiumSector;

    double backpackWeight;

    double price;

    public Ticket() {

        if (this.ID == null)
        {
            System.out.println("Variable [id] is null in [Ticket]!");
        }
    }

    public Ticket(String concertHall, int eventCode, Date creationTime, boolean isPromo, char stadiumSector, double backpackWeight, double price) {
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.creationTime = creationTime;
        this.isPromo = isPromo;
        this.stadiumSector = stadiumSector;
        this.backpackWeight = backpackWeight;
        this.price = price;
    }

    public Ticket(String footballMatch, String a5) {
        super();
        this.ID=super.getID();
    }

    @Override
    public void print(){
        System.out.println("Ticket details: " + this.toString());
    }

}
