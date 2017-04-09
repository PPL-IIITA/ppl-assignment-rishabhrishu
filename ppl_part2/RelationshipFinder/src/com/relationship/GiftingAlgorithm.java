/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relationship;

import java.util.ArrayList;

/**
 * An abstract base class for all the gifting algorithms
 *
 * @author Rishabh Rishu(IIT2015068)
 */
public abstract class GiftingAlgorithm implements Algorithm {

    protected Boy boy;
    protected Girl girl;
    protected ArrayList<Gift> giftStore;
    _Logger logger;

    /**
     *
     * @param boy boy, in the couple
     * @param girl girl, in the couple
     * @param giftStore list of all the available gifts
     */
    public GiftingAlgorithm(Boy boy, Girl girl, ArrayList<Gift> giftStore) {
        this.boy = boy;
        this.girl = girl;
        this.giftStore = giftStore;
    }

    /**
     * Makes the basket of gifts, which a boy gifts to the girl
     *
     * @return the list of gifts
     */
    public abstract ArrayList<Gift> makeGiftBasket();

    /**
     * Sets a logging utility
     *
     * @param logger object of type _Logger, which is basically filename
     */
    public void setLogger(_Logger logger) {
        this.logger = logger;
    }

}
