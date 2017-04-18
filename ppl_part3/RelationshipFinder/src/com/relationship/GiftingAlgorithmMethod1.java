/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relationship;

import java.util.ArrayList;

/**
 * Implementation of gifting algorithm , method 1 as in q2
 *
 * @author Rishabh Rishu(IIT2015068)
 */
public class GiftingAlgorithmMethod1 extends GiftingAlgorithm {

    ArrayList<Gift> giftBasket;
    private ArrayList<Gift> CopyofGifts;

    /**
     *
     * @param boy boy, in the couple
     * @param girl girl, in the couple
     * @param giftStore list of all the available gifts
     */
    public GiftingAlgorithmMethod1(Boy boy, Girl girl, ArrayList<Gift> giftStore) {
        super(boy, girl, giftStore);
        giftBasket = new ArrayList<Gift>();
        CopyofGifts = new ArrayList<Gift>();
        for (Gift g : giftStore) {
            this.CopyofGifts.add(g);
        }
    }

    @Override
    public ArrayList<Gift> makeGiftBasket() throws GiftStoreEmptyException {
        Gift minGift = giftStore.get(0);
        giftStore.remove(minGift);
        if (giftStore.isEmpty()) {
            throw new GiftStoreEmptyException("No more gifts available");
        }
        double cost = minGift.getPrice();
        giftBasket.add(minGift);
        logger.log("<GIFTING>" + minGift);
        if (boy instanceof MiserBoy) {
            while (cost < girl.getBudget()) {
                Gift tmp = giftStore.get(0);
                giftStore.remove(tmp);
                if (giftStore.isEmpty()) {
                    throw new GiftStoreEmptyException("No more gifts available");
                }
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
                if (giftStore.isEmpty()) {
                    throw new GiftStoreEmptyException("No more gifts available");
                }
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
                if (giftStore.isEmpty()) {
                    throw new GiftStoreEmptyException("No more gifts available");
                }
                cost += tmp.getPrice();
                if (cost < boy.getBudget()) {
                    giftBasket.add(tmp);
                    logger.log("<GIFTING>" + tmp);
                }
            }
            while (!giftStore.isEmpty()) {
                Gift tmp = giftStore.get(0);
                giftStore.remove(tmp);
                if (giftStore.isEmpty()) {
                    throw new GiftStoreEmptyException("No more gifts available");
                }
                if (tmp instanceof LuxuryGift) {
                    giftBasket.add(tmp);
                    logger.log("<GIFTING>" + tmp);
                    break;
                }
            }
        }
        for (Gift g : this.CopyofGifts) {
            if (!giftStore.contains(g)) {
                giftStore.add(g);
            }
        }
        return giftBasket;
    }

    @Override
    public String getName() {
        return "Gifting Algorithm Method 1";
    }

}
