import java.time.Instant;
import java.util.*;

import static java.lang.Math.abs;

public class TicketService {
    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);

        List<Ticket> tickets=new ArrayList<>();

        Ticket empty=new Ticket();
        tickets.add(empty);
        Ticket full=new Ticket(createId(),"hallB",911, Instant.now(),true,'A',5.04,19.99);
        tickets.add(full);
        Ticket limited=new Ticket(createId(),"hallC",123,Instant.now());
        tickets.add(limited);
        tickets.stream().forEach(System.out::println);


    }


    private static String createId(){

        String letters="qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";

        Random random=new Random();


        StringBuilder ans=new StringBuilder();


        int index=0;
        for(int i=0;i<4;i++){

            ans.append(letters.charAt(index));

            index=abs(random.nextInt())%letters.length();

        }

        return ans.toString();

    }
}