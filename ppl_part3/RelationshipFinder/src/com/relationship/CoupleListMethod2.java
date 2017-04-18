/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relationship;

import java.util.*;

/**
 * A sorted array based implementation of container to store couples, searching
 * is done via binary search
 *
 * @author Rishabh Rishu(IIT2015068)
 */
public class CoupleListMethod2 extends CoupleList {

    Couple[] couplelist;

    /**
     *
     * @param list list of couples
     */
    public CoupleListMethod2(ArrayList<Couple> list) {
        Collections.sort(list, new NameComparator());
        couplelist = list.toArray(new Couple[list.size()]);
    }

    @Override
    public String hasGirlfriend(String boyName) {
        return this.binarySearch(boyName);
    }

    public class NameComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            String obj1 = ((Couple) o1).getBoy().getName();
            String obj2 = ((Couple) o2).getBoy().getName();
            if (obj1 == obj2) {
                return 0;
            }
            if (obj1 == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            return obj1.compareTo(obj2);
        }
    }

    /**
     * Implementation of binary search
     *
     * @param boyName name of the boy, whose girlfriend is to be searched
     * @return girl's name if any, "Not Found" otherwise
     */
    public String binarySearch(String boyName) {
        int l = 0;
        int h = couplelist.length;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (couplelist[mid].getBoy().getName().equalsIgnoreCase(boyName)) {
                return couplelist[mid].getGirl().getName();
            } else if (couplelist[mid].getBoy().getName().compareTo(boyName) < 0) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return "Not Found";
    }

}
