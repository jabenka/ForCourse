import java.time.Instant;

public class Ticket {

    private String id;

    private String concertHall;

    private int eventCode;

    private Instant creationTime;

    private boolean isPromo;

    private char stadiumSector;

    private double backpackWeight;

    private double price;

    public Ticket(String id, String concertHall, int eventCode, Instant creationTime, boolean isPromo
            , char stadiumSector, double backpackWeight, double price) {
        this.id = id;
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.creationTime = creationTime;
        this.isPromo = isPromo;
        this.stadiumSector = stadiumSector;
        this.backpackWeight = backpackWeight;
        this.price = price;
    }

    public Ticket(String id,String concertHall, int eventCode, Instant creationTime){
        this.id = id;
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.creationTime = creationTime;
    }

    public Ticket() {
        this.id = "";
        this.concertHall = "";
        this.eventCode = 0;
        this.creationTime = null;
        this.isPromo = false;
        this.stadiumSector = '-';
        this.backpackWeight = 0;
        this.price = 0;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + id + '\'' +
                ", concertHall='" + concertHall + '\'' +
                ", eventCode=" + eventCode +
                ", creationTime=" + creationTime +
                ", isPromo=" + isPromo +
                ", stadiumSector=" + stadiumSector +
                ", backpackWeight=" + backpackWeight +
                ", price=" + price +
                '}';
    }
}
