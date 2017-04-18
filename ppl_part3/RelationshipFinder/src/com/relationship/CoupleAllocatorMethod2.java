/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relationship;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Class for couple making algorithm as in q5
 *
 * @author Rishabh Rishu(IIT2015068)
 */
public class CoupleAllocatorMethod2 extends CoupleAllocator {

    protected ArrayList<Couple> coupleList;
    protected ArrayList<Gift> giftList;
    private String algorithm;

    /**
     * @param boyList list of all the boys
     * @param girlList list of all the girls
     * @param giftList list of all the available gifts,i.e, gift store
     */
    public CoupleAllocatorMethod2(ArrayList<Boy> boyList, ArrayList<Girl> girlList, ArrayList<Gift> giftList) {
        super(boyList, girlList);
        this.giftList = giftList;
        coupleList = new ArrayList<Couple>();
    }

    /**
     * @param boyList list of all the boys
     * @param girlList list of all the girls
     * @param giftList list of all the available gifts,i.e, gift store
     * @param algorithm the algorithm to be used for gifting
     */
    public CoupleAllocatorMethod2(ArrayList<Boy> boyList, ArrayList<Girl> girlList, ArrayList<Gift> giftList, String algorithm) {
        super(boyList, girlList);
        this.giftList = giftList;
        coupleList = new ArrayList<Couple>();
        this.algorithm = algorithm;
    }

    @Override
    public ArrayList<Couple> makeCouple() {
        Collections.sort(girlList, new AttractivenessComparator());
        Iterator<Girl> it1 = girlList.iterator();
        Iterator<Boy> it2 = boyList.iterator();
        while (true) {

            if (it1.hasNext()) {
                Girl girl = it1.next();
                if (!girl.getStatus()) {
                    for (Boy boy : boyList) {
                        if (boy.getBudget() >= girl.getBudget() && !girl.checkExBf(boy)) {
                        //    logger.log("<COUPLE FORMED>" + "Boy's Name: " + boy.getName() + " Girl's Name: " + girl.getName());
                            Couple c = new Couple(girl, boy, giftList, logger);
                            coupleList.add(c);
                            break;
                        }
                    }
                }

            } else {
                break;
            }
            if (it2.hasNext()) {
                Boy boy = it2.next();
                if (!boy.getStatus()) {
                    for (Girl girl : girlList) {
                        if (boy.getBudget() >= girl.getBudget() && !girl.checkExBf(boy)) {
                        //    logger.log("<COUPLE FORMED>" + "Boy's Name: " + boy.getName() + " Girl's Name: " + girl.getName());
                            Couple c = new Couple(girl, boy, giftList, logger);
                            coupleList.add(c);
                            break;
                        }
                    }
                }
            } else {
                break;
            }

        }
        return coupleList;
    }

    @Override
    public ArrayList<Couple> makeCouple(String algorithm) {
        Collections.sort(girlList, new AttractivenessComparator());
        Iterator<Girl> it1 = girlList.iterator();
        Iterator<Boy> it2 = boyList.iterator();
        while (true) {

            if (it1.hasNext()) {
                Girl girl = it1.next();
                if (!girl.getStatus()) {
                    for (Boy boy : boyList) {
                        if (boy.getBudget() >= girl.getBudget() && !girl.checkExBf(boy)) {
                        //    logger.log("<COUPLE FORMED>" + "Boy's Name: " + boy.getName() + " Girl's Name: " + girl.getName());
                            Couple c = new Couple(girl, boy, giftList, logger, algorithm);
                            coupleList.add(c);
                            break;
                        }
                    }
                }

            } else {
                break;
            }
            if (it2.hasNext()) {
                Boy boy = it2.next();
                if (!boy.getStatus()) {
                    for (Girl girl : girlList) {
                        if (boy.getBudget() >= girl.getBudget() && !girl.checkExBf(boy)) {
                            Couple c = new Couple(girl, boy, giftList, logger, algorithm);
                        //    logger.log("<COUPLE FORMED>" + "Boy's Name: " + boy.getName() + " Girl's Name: " + girl.getName());
                            coupleList.add(c);
                            break;
                        }
                    }
                }
            } else {
                break;
            }

        }
        return coupleList;
    }

    @Override
    public ArrayList<Couple> breakupCouple(Couple couple) {
        couple.getBoy().setStatus(false);
        couple.getGirl().setStatus(false);
        coupleList.remove(couple);
        logger.log("<BREAK UP>" + couple);
        return coupleList;
    }

    @Override
    public String getName() {
        return "Couple Allocator Method 2";
    }

    @Override
    public Couple findNewBf(Girl girl) {
        for (Boy boy : boyList) {
            if (boy.getBudget() >= girl.getBudget() && !girl.checkExBf(boy)) {
            //    logger.log("<COUPLE FORMED>" + "Boy's Name: " + boy.getName() + " Girl's Name: " + girl.getName());
                Couple c = new Couple(girl, boy, giftList, logger);
                return c;
            }
        }
        return null;
    }

    public class AttractivenessComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            Girl v1 = (Girl) o1;
            Girl v2 = (Girl) o2;
            return Integer.compare(v1.getAttractiveness(), v2.getAttractiveness());
        }

    }
}
