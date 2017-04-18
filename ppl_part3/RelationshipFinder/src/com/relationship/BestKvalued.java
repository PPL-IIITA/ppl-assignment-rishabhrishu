/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relationship;

import java.util.*;

/**
 * A data-structure that is like list, but is used to obtain the best k-valued
 * items, higher the value, better the object
 *
 * @author Rishabh Rishu(IIT2015068)
 */
public class BestKvalued<T> implements Container<T> {

    protected ArrayList<T> list;
    private int k;

    /**
     * Constructor : Internally, this data structure uses java.util.ArrayList
     *
     * @param k user input for finding k best items
     */
    public BestKvalued(int k) {
        list = new ArrayList<T>();
        this.k = k;
    }

    /**
     * Returns name of Container
     *
     * @return Name of container
     */
    @Override
    public String getName() {
        return "Best K-Valued";
    }

    /**
     * Checks if list is empty
     *
     * @return True, if list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Checks if list contains object o
     *
     * @param o Reference of Object o
     * @return True, if o is in list, false otherwise
     */
    @Override
    public boolean contains(T o) {
        return list.contains(o);
    }

    /**
     * Adds an object to the list
     *
     * @param e Reference of object to add
     * @return True, if object added successfully,false otherwise
     */
    @Override
    public boolean add(T e) {
        return list.add(e);
    }

    /**
     * Removes and object o from list
     *
     * @param o Object to be removed
     * @return True, if deletion successful, false otherwise
     */
    @Override
    public boolean remove(T o) {
        return list.remove(o);
    }

    /**
     * Returns the element at specified position in the list
     *
     * @param index index of the element to return
     * @return Element at specified position in the list
     */
    @Override
    public T get(int index) {
        return list.get(index);
    }

    /**
     * Removes the element at the specified position in this list. Shifts any
     * subsequent elements to the left (subtracts one from their indices).
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     */
    @Override
    public T remove(int index) {
        return list.remove(index);
    }

    /**
     * <p>
     * Returns a view of the portion of the list. List contains best K valued
     * items, as per comparator supplied. The returned list is backed by this
     * list, so non-structural changes in the returned list are reflected in
     * this list, and vice-versa. The returned list supports all of the optional
     * list operations supported by this list.</p>
     *
     * @param c The Comparator, for ordering list.
     * @return a view of the list, containing best k-valued items
     * @throws ArrayIndexOutOfBoundsException When n is greater than size of
     * list
     */
    public List bestKvalued(Comparator<? super T> c) {
        if (k > list.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Collections.sort(list, c);
        Collections.reverse(list);
        return list.subList(0, k + 1);
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
