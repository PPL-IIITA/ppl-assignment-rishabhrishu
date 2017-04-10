/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relationship;

/**
 * Class denoting Utility Gifts
 *
 * @author Rishabh Rishu(IIT2015068)
 */
public class UtilityGift extends Gift {

    private String utilityClass;
    private String utilityValue;

    /**
     *
     * @param price price of the gift
     * @param value value of the gift
     * @param utilityClass utility class of the gift
     * @param utilityValue utility value of the gift
     */
    public UtilityGift(double price, double value, String utilityClass, String utilityValue) {
        super(price, value);
        this.utilityClass = utilityClass;
        this.utilityValue = utilityValue;
    }

    @Override
    public String toString() {
        return String.format("Utility Gift:- Price: %.3f Value: %.3f Utility Class: %s Utility Value; %s \n", super.getPrice(), super.getValue(), utilityClass, utilityValue);
    }

}
