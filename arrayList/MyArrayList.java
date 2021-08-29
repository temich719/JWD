package com.JWD.arrayList;

import java.util.Collection;

public interface MyArrayList<E> {
     void add(int index, E element);
     void add(E e);
     boolean addAll(Collection<? extends E> c);
     void clear();
     boolean contains(Object o);
     E get(int index);
     int indexOf(Object o);
     boolean isEmpty();
     E remove(int index);
     boolean remove(Object o);
     E set(int index, E element);
     int size();
     Object[] toArray();
     void trimToSize();
}
