/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relationship;

import java.util.*;

/**
 * A Hash Table based implementation of container for storing list of couples
 *
 * @author Rishabh Rishu(IIT2015068)
 */
public class CoupleListMethod3 extends CoupleList {

    protected HashMap<String, String> hashtable;

    /**
     *
     * @param coupleList list of couples
     */
    public CoupleListMethod3(ArrayList<Couple> coupleList) {
        hashtable = new HashMap<String, String>();
        coupleList.stream().forEach((c) -> {
            hashtable.put(c.getBoy().getName(), c.getGirl().getName());
        });
    }

    @Override
    public String hasGirlfriend(String boyName) {
        String toLowerCase = boyName.toLowerCase();
        return hashtable.getOrDefault(toLowerCase, "Not Found");
    }

}
