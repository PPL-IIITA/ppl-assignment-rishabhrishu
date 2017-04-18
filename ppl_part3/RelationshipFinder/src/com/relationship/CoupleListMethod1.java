/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relationship;

import java.util.*;

/**
 * An array based implementation of container to save couples, where searching is accomplished in linear time
 * @author Rishabh Rishu(IIT2015068)
 */
public class CoupleListMethod1 extends CoupleList{

    Couple[] couplelist;
    /**
     * 
     * @param list list of couples
     */
    public CoupleListMethod1(ArrayList<Couple> list){
        couplelist = list.toArray(new Couple[list.size()]);
    }
    
    @Override
    public String hasGirlfriend(String boyName) {
        for( Couple c: couplelist){
            if (c.getBoy().getName().equalsIgnoreCase(boyName)){
                return c.getGirl().getName();
            }
        }
        return "Not Found";
    }


    
}
