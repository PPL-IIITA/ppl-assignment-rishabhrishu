/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relationship;

import java.util.*;

/**
 * A data structure, that is like list, but it returns a random object out of
 * best n objects, higher the value, better the object
 *
 * @author Rishabh Rishu(IIT2015068)
 * @param <T> Type of the Object to put in container
 */
public class RandomK<T> implements Container<T> {

    protected ArrayList<T> list;
    private int n;

    /**
     * Constructor : Internally, this data structure uses java.util.ArrayList
     *
     * @param n user input, for finding a random item out of best n items
     */
    public RandomK(int n) {
        list = new ArrayList<T>();
        this.n = n;
    }

    @Override
    public String getName() {
        return "Random_K";
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(T o) {
        return list.contains(o);
    }

    @Override
    public boolean add(T e) {
        return list.add(e);
    }

    @Override
    public boolean remove(T o) {
        return list.remove(o);
    }

    @Override
    public T get(int index) {
        return list.get(index);
    }

    @Override
    public T remove(int index) {
        return list.remove(index);
    }

    /**
     * Returns a random object out of best n objects, as per comparator
     * provided.
     *
     * @param c The comparator for ordering the list
     * @return A random object out of best n objects
     * @throws ArrayIndexOutOfBoundsException When n is greater than size of the
     * list
     */
    public T getKth(Comparator<? super T> c) {
        if (n > list.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Collections.sort(list, c);
        Collections.reverse(list);
        Random r = new Random();
        return list.get(r.nextInt(n));
    }

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

}
