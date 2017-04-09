/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relationship;

import java.util.ArrayList;

/**
 * Abstract class for the couple making algorithms
 * @author Rishabh Rishu(IIT2015068)
 */
public abstract class CoupleAllocator implements Algorithm{
    
    protected ArrayList<Boy> boyList;
    protected ArrayList<Girl> girlList;
    _Logger logger;
    /**
     * Constructor for Couple Allocator algorithm
     * @param boyList list of all the boys
     * @param girlList list of all the girls
     */
    public CoupleAllocator(ArrayList<Boy> boyList,ArrayList<Girl> girlList){
        this.boyList = boyList;
        this.girlList = girlList;
    }
    /**
     * Creates the couples
     * @return list of couples thus formed
     */
    public abstract ArrayList<Couple> makeCouple();

    /**
     * Overloaded method to create the couple, when gifting algorithm is to be specified
     * @param algorithm the algorithm to be used for gifting, namely "Method 1" and "Method 2"
     * @return list of couples thus formed
     */
    public abstract ArrayList<Couple> makeCouple(String algorithm);
    /**
     * Perform a break-up of couple
     * @param couple the couple whose break up needs to be done
     * @return list of remaining couples
     */
    public abstract ArrayList<Couple> breakupCouple(Couple couple);
    /**
     * Finds a new boyfriend for a girl
     * @param g Girl
     * @return couple formed by girl
     */
    public abstract Couple findNewBf(Girl g);
    
    /**
     * Sets a logging utility
     * @param logger object of type _Logger, which is basically filename
     */
    public void setLogger(_Logger logger){
        this.logger = logger;
    }
}
