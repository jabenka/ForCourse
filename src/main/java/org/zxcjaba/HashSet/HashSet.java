package org.zxcjaba.HashSet;

import org.zxcjaba.HashSet.Exceptions.CollisionException;

import java.util.Iterator;
import java.util.Set;

public class HashSet<T> implements Iterable<T> {

    private T[] elements;
    private int size;
    private int length;
    private int current;

    public HashSet() {
        length = 0;
        size = 10;
        elements = (T[]) new Object[size];
        current = 0;
    }

    public HashSet(int size) {
        this.size = size;
        elements = (T[]) new Object[size];
    }
    public void add(T element) {
        if(length ==size) {
            T[] newElements = (T[]) new Object[length*2];
            System.arraycopy(elements, 0, newElements, 0, length);
            elements = newElements;
            size=2*size;
        }
        int index=(element.hashCode())%size;


        //unique without tree
        if(elements[index]!=null) {throw new CollisionException("This place is taken");}

        elements[index] = element;
        length++;
    }

    public boolean contains(T element) {
        int index=(size-1)&element.hashCode()%size;
        if(elements[index]!=null) {
            return elements[index].equals(element);
        }
        return false;
    }

    public T delete(T element) {
        int index=(size-1)&element.hashCode()%size;
        if(elements[index]!=null) {
            T returnable=elements[index];
            elements[index]=null;
            length--;
            return returnable;
        }
        return null;
    }


    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>(){
            @Override
            public boolean hasNext() {
                return current<length;
            }

            @Override
            public T next() {
                return elements[current++];
            }
        };
    }
}
