package org.zxcjaba.entity.Shared;

public class SharedByEmailAndPhone implements Shareable{
    @Override
    public void share() {
        System.out.println("Shared by email and phone");
    }
}
