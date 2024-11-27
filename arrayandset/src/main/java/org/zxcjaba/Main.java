package org.zxcjaba;

import org.zxcjaba.arrayList.ArrayList;
import org.zxcjaba.hashSet.exceptions.CollisionException;
import org.zxcjaba.hashSet.HashSet;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> nums=new ArrayList<>();
        ArrayList<String> strings=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();

        strings.add("Hello");
        strings.add("World");
        strings.add("Hello");
        for (String a:strings) {
            System.out.println(a);
        }


        nums.add(1);
        nums.add(2);
        nums.add(3);
        //testing resize
        for(int i=4;i<=15;i++){
            nums.add(i);
        }
        for(Integer a:nums){
            System.out.println(a);
        }

        System.out.println(nums.get(1));//2

        int deleted=nums.delete(1);//2
        System.out.println(deleted);//2

        System.out.println(nums.get(1));//3

        boolean contains=nums.contains(1);//true
        System.out.println(contains);




            //SET
    try {
        for (int i=0;i<10;i++){
            set.add(i);
            System.out.println("i="+i);
        }
        set.add(2);
    }catch (CollisionException e){
        System.out.println("EXCEPTION!!"+e.getMessage());
    }

        System.out.println();
        boolean da = set.contains(1);
        System.out.println(da);


        while (set.iterator().hasNext()) {
            System.out.println(set.iterator().next());
        }

    }
}