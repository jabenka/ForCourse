package org.zxcjaba.entity.Users;

public class Visitor extends User{

    public void getTicket(){
        System.out.println("Getting ticket by Visitor");
    }




    @Override
    public void printRole() {
        System.out.println("Role: Visitor");
    }
}
