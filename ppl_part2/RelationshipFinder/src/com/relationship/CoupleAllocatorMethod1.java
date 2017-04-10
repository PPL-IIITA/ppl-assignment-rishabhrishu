/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relationship;

import java.util.ArrayList;

/**
 * Class for Couple Making Algorithm as in q.1
 *
 * @author Rishabh Rishu(IIT2015068)
 */
public class CoupleAllocatorMethod1 extends CoupleAllocator {

    ArrayList<Couple> coupleList;
    ArrayList<Gift> giftList;
    private String algorithm;

    /**
     * @param boyList list of all the boys
     * @param girlList list of all the girls
     * @param giftList list of all the available gifts,i.e, gift store
     */
    public CoupleAllocatorMethod1(ArrayList<Boy> boyList, ArrayList<Girl> girlList, ArrayList<Gift> giftList) {
        super(boyList, girlList);
        this.giftList = giftList;
    }

    /**
     * @param boyList list of all the boys
     * @param girlList list of all the girls
     * @param giftList list of all the available gifts,i.e, gift store
     * @param algorithm the algorithm to be used for gifting
     */
    public CoupleAllocatorMethod1(ArrayList<Boy> boyList, ArrayList<Girl> girlList, ArrayList<Gift> giftList, String algorithm) {
        super(boyList, girlList);
        this.giftList = giftList;
        this.algorithm = algorithm;
    }

    @Override
    public ArrayList<Couple> makeCouple() {
        coupleList = new ArrayList<Couple>();
        for (Girl girl : girlList) {
            if (!girl.getStatus()) {
                for (Boy boy : boyList) {
                    if (!boy.getStatus() && !girl.checkExBf(boy)) {
                        if (boy.getBudget() >= girl.getBudget()) {
                            Couple c = new Couple(girl, boy, giftList,logger);
                            coupleList.add(c);
                            break;
                        }
                    }
                }
            }
        }
        return coupleList;
    }

    @Override
    public ArrayList<Couple> makeCouple(String algorithm) {
        coupleList = new ArrayList<Couple>();
        for (Girl girl : girlList) {
            if (!girl.getStatus()) {
                for (Boy boy : boyList) {
                    if (!boy.getStatus() && !girl.checkExBf(boy)) {
                        Couple c = new Couple(girl, boy, giftList,logger,algorithm);
                    //    logger.log("<COUPLE FORMED>" + "Boy's Name: " + boy.getName() + " Girl's Name: " + girl.getName());
                        coupleList.add(c);
                        break;
                    }
                }
            }
        }

        return coupleList;
    }

    @Override
    public String getName() {
        return "Couple Allocator Method 1";
    }

    @Override
    public ArrayList<Couple> breakupCouple(Couple couple) {
        couple.getBoy().setStatus(false);
        couple.getGirl().setStatus(false);
        coupleList.remove(couple);
        logger.log("<BREAK UP>"+couple);
        return coupleList;
    }

    @Override
    public Couple findNewBf(Girl girl) {
        for (Boy boy : boyList) {
            if (!boy.getStatus() && !girl.checkExBf(boy)) {
                if (boy.getBudget() >= girl.getBudget()) {
            //        logger.log("<COUPLE FORMED>" + "Boy's Name: " + boy.getName() + " Girl's Name: " + girl.getName());
                    Couple couple = new Couple(girl, boy, giftList,logger);
                    return couple;
                }
            }
        }
        return null;
    }

}
