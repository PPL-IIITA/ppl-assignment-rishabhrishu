/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relationship;

/**
 * Container class for storing the list of couples
 *
 * @author Rishabh Rishu(IIT2015068)
 */
public abstract class CoupleList {

    /**
     * Returns the name of girlfriend of the boy, if any, or "Not Found"
     *
     * @param boyName name of the boy, whose girlfriend is to be found
     * @return name of girl, if present, or "Not Found"
     */
    public abstract String hasGirlfriend(String boyName);
}
