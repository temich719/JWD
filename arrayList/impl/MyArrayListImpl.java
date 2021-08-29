package com.JWD.arrayList.impl;

import com.JWD.arrayList.MyArrayList;
import java.util.Collection;

public class MyArrayListImpl<E> implements MyArrayList<E> {

    private int capacity;
    private int size = 0;
    private Object[] array;

    public int getMasSize(){
        return this.array.length;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public MyArrayListImpl(){
        this.capacity = 10;
        this.array = new Object[capacity];
    }

    public MyArrayListImpl(int initialCapacity){
        this.capacity = initialCapacity;
        this.array = new Object[initialCapacity];
    }

    @Override
    public void add(int index, E element) {
        Object[] begin;
        Object[] end;
        capacity *= 2;
        begin = new Object[index];
        end = new Object[size - index];
        int k = 0;
        for (int i = 0;i < index;i++){
            begin[i] = array[i];
        }
        for (int i = index;i < size;i++){
            end[k] = array[i];
            k++;
        }
        size++;
        array = new Object[size];
        for (int i = 0;i < begin.length;i++){
            array[i] = begin[i];
        }
        array[begin.length] = element;
        k = 0;
        for (int i = begin.length + 1;i < size;i++){
            array[i] = end[k];
            k++;
        }
    }

    @Override
    public void trimToSize() {
        Object[] objects = new Object[size];
        for (int i = 0;i < size;i++){
            objects[i] = array[i];
        }
        array = objects;
        capacity = size;
    }

    @Override
    public void add(E e) {
        capacity *= 2;
        Object[] mas = array;
        array = new Object[capacity];
        for (int i = 0;i < size;i++){
            array[i] = mas[i];
        }
        array[size] = e;
        size++;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        capacity += c.size()*2;
        int index = size;
        size += c.size();
        Object[] begin = new Object[index];
        Object[] end = c.toArray();
        for (int i = 0;i < index;i++){
            begin[i] = array[i];
        }
        array = new Object[capacity];
        for (int i = 0;i < index;i++){
            array[i] = begin[i];
        }
        int j = 0;
        for (int i = index;i < size;i++){
            array[i] = end[j];
            j++;
        }
        return true;
    }

    @Override
    public void clear() {
        capacity = 10;
        array = new Object[capacity];
        size = 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0;i < size;i++){
            if (array[i].equals(o))return true;
        }
        return false;
    }

    @Override
    public E get(int index) {
        return (E) array[index];
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0;i < size;i++){
            if (array[i].equals(o))return i;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E remove(int index) {
        if (index < 0)throw new IndexOutOfBoundsException();
        if (size == 0) return null;
        E result;
        capacity -= 1;
        size--;
        Object[] begin = new Object[index];
        Object[] end = new Object[size-index];

        for (int i = 0;i < index;i++){
            begin[i] = array[i];
        }
        int k = 0;
        for (int i = index + 1;i < size+1;i++){
            end[k] = array[i];
            k++;
        }
        result = (E)array[index];
        array = new Object[size];
        for (int i = 0;i < index;i++){
            array[i] = begin[i];
        }
        k = 0;
        for (int i = index;i < size;i++){
            array[i] = end[k];
            k++;
        }
        return result;
    }

    @Override
    public boolean remove(Object o) {
        int index = -1;
        boolean result = false;
        for (int i = 0;i < size;i++){
            if (array[i].equals(o)){
                index = i;
                result = true;
                break;
            }
        }
        remove(index);
        return result;
    }

    @Override
    public E set(int index, E element) {
        E result = (E) array[index];
        array[index] = element;
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        trimToSize();
        return array.clone();
    }
    
}
