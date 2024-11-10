package org.zxcjaba;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
            validate(readFromFile("tickets.txt"));



    }


    private static List<Ticket> readFromFile(String filename){
            List<Ticket> tickets = new ArrayList<Ticket>();

            try(Scanner scanner = new Scanner(new File(filename))){

                    String line;

                    while(scanner.hasNextLine()){
                        line = scanner.nextLine();
                        String[] tokens = line.split(",");
                        String ticketClass = tokens[0].split(":")[1].replace("\"", "").trim();
                        String ticketType = tokens[1].split(":")[1].replace("\"", "").trim();
                        String startDate = tokens[2].split(":")[1].replace("\"", "").trim();
                        String Price = tokens[3].split(":")[1].replace("}", "").trim();
                        double price=0.0;
                        if(!Price.equals("null") && !Price.isEmpty()) {
                             price = Double.parseDouble(tokens[3].split(":")[1].replace("}", "").trim());
                        }

                        tickets.add(new Ticket(ticketClass, ticketType, startDate, price));

                    }

            } catch (Exception e) {
                e.printStackTrace();

            }

        return tickets;

    }

    private static void validate(List<Ticket> tickets){
        int validCount = 0;
        int[] errors = new int[3];//0-dateException,1-priceException,2-ticketTypeException
        //I know about maps but saving memory is better
        Arrays.fill(errors, 0);
        for (Ticket ticket : tickets) {
            boolean isValid = true;

            // Validate ticket type
            if (ticket.ticketType == null ||
                    (!ticket.ticketType.equals("ДЕНЬ") && !ticket.ticketType.equals("НЕДЕЛЯ") && !ticket.ticketType.equals("МЕСЯЦ") && !ticket.ticketType.equals("ГОД"))) {
                System.err.println("Ошибка: недопустимый тип билета - " + ticket.ticketType);
                errors[2]+=1;
                isValid = false;
            }

            // Validate start date
            if ((ticket.ticketType.equals("ДЕНЬ") || ticket.ticketType.equals("НЕДЕЛЯ") || ticket.ticketType.equals("ГОД"))
                    && (ticket.startDate == null || ticket.startDate.isEmpty())) {
                System.err.println("Ошибка: недопустимая дата начала - " + ticket.startDate);
                errors[1]+=1;
                isValid = false;
            } else {
                try {
                    LocalDate startDate = LocalDate.parse(ticket.startDate);
                    if (startDate.isAfter(LocalDate.now())) {
                        System.err.println("Ошибка: дата начала не может быть в будущем - " + ticket.startDate);
                        errors[0]+=1;
                        isValid = false;
                    }
                } catch (DateTimeParseException e) {
                    System.err.println("Ошибка: недопустимый формат даты - " + ticket.startDate);
                    errors[0]+=1;
                    isValid = false;
                }
            }

            // Validate price
            if (ticket.price <= 0) {
                System.err.println("Ошибка: цена не может быть нулевой или отрицательной - " + ticket.price);
               errors[2]+=1;
                isValid = false;
            } else if (ticket.price % 2 != 0) {
                System.err.println("Ошибка: цена должна быть четной - " + ticket.price);
                errors[2]+=1;
                isValid = false;
            }

            if (isValid) {
                validCount++;
            }
        }

        System.out.println("Всего = " + tickets.size());
        System.out.println("Действительный = " + validCount);
        int index=findMaxIndex(errors);
        String mostCommonError="";
        switch (index){
            case 0:
                mostCommonError="Неверная дата";
            break;
            case 1:
               mostCommonError="Неверная цена";
            break;
            case 2:
                mostCommonError="Неверный тип билета";
             break;
        }
        System.out.println("Самое популярное нарушение = " + mostCommonError);




    }

    private static int findMaxIndex(int[] nums){
        int max = Integer.MIN_VALUE;
        int index=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]>max){
                max = nums[i];
                index = i;
            }
        }
        return index;
    }




}