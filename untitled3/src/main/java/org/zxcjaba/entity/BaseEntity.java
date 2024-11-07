package org.zxcjaba.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Random;

import static java.lang.Math.abs;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class BaseEntity {

    Long ID;

    public BaseEntity() {
        this.ID =createId();
    }

    public void print(){
            System.out.println(this.toString());
    }


    private Long createId(){

        String letters="1234567890";

        Random random=new Random();


        StringBuilder ans=new StringBuilder();


        int index=0;
        for(int i=0;i<4;i++){

            ans.append(letters.charAt(index));

            index=abs(random.nextInt())%letters.length();

        }

        return Long.valueOf(ans.toString());

    }
}
