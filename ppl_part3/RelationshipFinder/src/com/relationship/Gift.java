/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relationship;

/**
 * Abstract class for all the types of gifts
 *
 * @author Rishabh Rishu(IIT2015068)
 */
public abstract class Gift {

    private double price;
    private double value;

    /**
     *
     * @param price price of the gift
     * @param value value of the gift
     */
    public Gift(double price, double value) {
        this.setPrice(price);
        this.setValue(value);
    }

    /**
     * Sets the price of the gift
     *
     * @param price price of the gift
     */
    public final void setPrice(double price) {
        this.price = price;
    }

    /**
     * Sets the value of the gift
     *
     * @param value value of the gift
     */
    public final void setValue(double value) {
        this.value = value;
    }

    /**
     * Returns price of the gift
     *
     * @return price of the gift
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns value of the gift
     *
     * @return value of the gift
     */
    public double getValue() {
        return value;
    }

}
