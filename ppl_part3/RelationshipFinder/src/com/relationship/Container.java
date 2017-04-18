/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relationship;
import java.util.*;

/**
 * An Interface for all the containers used in our application.
 *
 * @author Rishabh Rishu(IIT2015068)
 * @param <T>
 */
public interface Container<T> {

    /**
     * Returns name of Container
     *
     * @return Name of container
     */
    public String getName();

    /**
     * Checks if list is empty
     *
     * @return True, if list is empty, false otherwise
     */
    public boolean isEmpty();

    /**
     * Checks if list contains object o
     *
     * @param o Reference of Object o
     * @return True, if o is in list, false otherwise
     */
    public boolean contains(T o);

    /**
     * Adds an object to the list
     *
     * @param e Reference of object to add
     * @return True, if object added successfully,false otherwise
     */
    public boolean add(T e);

    /**
     * Removes and object o from list
     *
     * @param o Object to be removed
     * @return True, if deletion successful, false otherwise
     */
    public boolean remove(T o);

    /**
     * Returns the element at specified position in the list
     *
     * @param index index of the element to return
     * @return element at specified position in the list
     */
    public T get(int index);

    /**
     * Removes the element at the specified position in this list. Shifts any
     * subsequent elements to the left (subtracts one from their indices).
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     */
    public T remove(int index);
    
    /**
     * Returns the size of the container
     * @return size of container
     */
    public int getSize();
    /**
     * Returns an iterator over the elements in this list in proper sequence.
     * @return an iterator over the elements in this list in proper sequence
     */
    public Iterator<T> iterator();
}
