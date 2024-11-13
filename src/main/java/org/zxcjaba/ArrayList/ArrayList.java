package org.zxcjaba.ArrayList;


import org.zxcjaba.ArrayList.Exceptions.OutOfBoundsException;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ArrayList<T> implements Iterable<T> {
    private T[] objects;
    private int size;
    private int lastIndex;
    private int current;

    public ArrayList() {
        size = 10;
        lastIndex=0;
        objects = (T[]) new Object[size];
        current=0;
    }

    public void add(T object) {
        if(lastIndex==size){
            T[] newArray = (T[]) new Object[size*2];
            System.arraycopy(objects,0,newArray,0,size);
            objects=newArray;
            size=size*2;

        }
            objects[lastIndex]=object;
            lastIndex++;
    }

    public T get(int index)  {
        if(index>=size || index<0){
                throw new OutOfBoundsException("Index out of bounds");
        }
            return objects[index];
    }

    //At some point delete method shouldn't return anything, but I want to return a value of deleted element
    public T delete(int index) {
        if(index>=size || index<0){
            throw new OutOfBoundsException("Index out of bounds");
        }
        T returnable= move(index);
        index--;
        return returnable;
    }

    public boolean contains(T object) {
        for (T obj: objects) {
            if(obj.equals(object)){
                return true;
            }
        }
        return false;
    }

    private T move(int index) {
        T returnable=objects[index];
        for(int i=index;i<objects.length;i++){
            if(i+1!=objects.length){
                objects[i]=objects[i+1];
            }
        }
        return returnable;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
               return current<lastIndex;
            }

            @Override
            public T next() {
                return objects[current++];
            }
        };
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        for (int i = 0; i < lastIndex; i++) {
            action.accept(objects[i]);
        }
    }


}
