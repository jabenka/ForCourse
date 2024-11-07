package org.zxcjaba.entity.Users;

public class Admin extends User {

    public void checkTicket()
    {
        System.out.println("Checking ticket by Admin");
    }

    @Override
    public void printRole()
    {
        System.out.println("Role: Admin");
    }



}
