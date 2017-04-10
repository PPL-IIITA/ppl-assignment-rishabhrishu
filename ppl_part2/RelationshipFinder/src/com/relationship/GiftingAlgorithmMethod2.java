/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relationship;

import java.util.ArrayList;

/**
 * Implementation of gifting algorithm , method 2 as in q8
 *
 * @author Rishabh Rishu(IIT2015068)
 */
public class GiftingAlgorithmMethod2 extends GiftingAlgorithm {

    ArrayList<Gift> giftBasket;

    /**
     *
     * @param boy boy, in the couple
     * @param girl girl, in the couple
     * @param giftStore list of all the available gifts
     */
    public GiftingAlgorithmMethod2(Boy boy, Girl girl, ArrayList<Gift> giftStore) {
        super(boy, girl, giftStore);
    }

    @Override
    public ArrayList<Gift> makeGiftBasket() {
        double cost = 0.0;
        for (Gift gift : giftStore) {
            if (gift instanceof LuxuryGift) {
                giftBasket.add(gift);
                logger.log("<GIFTING>" + gift);
                giftStore.remove(gift);
                cost += gift.getPrice();
                break;
            }
        }
        for (Gift gift : giftStore) {
            if (gift instanceof UtilityGift) {
                giftBasket.add(gift);
                logger.log("<GIFTING>" + gift);
                giftStore.remove(gift);
                cost += gift.getPrice();
            }
        }
        for (Gift gift : giftStore) {
            if (gift instanceof EssentialGift) {
                giftBasket.add(gift);
                logger.log("<GIFTING>" + gift);
                giftStore.remove(gift);
                cost += gift.getPrice();
            }
        }
        if (boy instanceof MiserBoy) {
            while (cost < girl.getBudget()) {
                Gift tmp = giftStore.get(0);
                giftStore.remove(tmp);
                cost += tmp.getPrice();
                if (cost < boy.getBudget()) {
                    giftBasket.add(tmp);
                    logger.log("<GIFTING>" + tmp);

                }
            }

        } else if (boy instanceof GenerousBoy) {
            while (cost < boy.getBudget()) {
                Gift tmp = giftStore.get(0);
                giftStore.remove(tmp);
                cost += tmp.getPrice();
                if (cost < boy.getBudget()) {
                    giftBasket.add(tmp);
                    logger.log("<GIFTING>" + tmp);
                }
            }
        } else {
            while (cost < girl.getBudget()) {
                Gift tmp = giftStore.get(0);
                giftStore.remove(tmp);
                cost += tmp.getPrice();
                if (cost < boy.getBudget()) {
                    giftBasket.add(tmp);
                    logger.log("<GIFTING>" + tmp);
                }
            }
        }

        return giftBasket;
    }

    @Override
    public String getName() {
        return "Gifting Algorithm Method 2";
    }
}
