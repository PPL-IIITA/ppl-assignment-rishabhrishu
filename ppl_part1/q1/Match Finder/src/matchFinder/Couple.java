/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchFinder;

import java.lang.Math;
import java.util.*;
/**
 * This class stores all the information about a couple, when formed
 * 
 * @author Rishabh Rishu(IIT2015068)
 */

public class Couple {
    ArrayList<Gifts> giftStore;
    ArrayList<Gifts> giftBasket;
    private Girl girl;
    private Boy boy;
    private double happiness;
    private int compatibility;
/**
 * Creates a new Couple
 * @param girl The girl , girlfriend
 * @param boy The boy , boyfriend
 * @param giftStore Gift Store, from which guy can buy gifts from his girl.(Formally, a list of all the gifts)
 * 
 */
    public Couple(Girl girl, Boy boy, ArrayList<Gifts> giftStore) {
        giftBasket = new ArrayList<Gifts>();
        this.girl = girl;
        this.boy = boy;
        this.giftStore = giftStore;
        boy.setStatus(true);
        girl.setStatus(true);
        this.setCompatibility();
        this.createGiftBasket();
        this.setHappiness();
        
    }
/**
 * Method to perform gifting operation.<br>
 * More formally, this method greedily selects the set of 'best' gifts a boy can give to his girlfriend
 */
    public void createGiftBasket() {
        String typeOfBoy = boy.getType();
        
        Gifts minGift = giftStore.get(0);
        giftStore.remove(minGift);
        double cost = minGift.getPrice();

        if (typeOfBoy.equalsIgnoreCase("miser")) {
            while (cost < girl.getMaintenanceBudget()) {
                Gifts tmp = giftStore.get(0);
                giftStore.remove(tmp);
                cost += tmp.getPrice();
                if (cost < boy.getGirlfriendBudget()) {
                    giftBasket.add(tmp);
                }
            }

        } else if (typeOfBoy.equalsIgnoreCase("generous")) {
            while (cost < boy.getGirlfriendBudget()) {
                Gifts tmp = giftStore.get(0);
                giftStore.remove(tmp);
                cost += tmp.getPrice();
                if (cost < boy.getGirlfriendBudget()) {
                    giftBasket.add(tmp);
                }
            }
        } else {
            while (cost < girl.getMaintenanceBudget()) {
                Gifts tmp = giftStore.get(0);
                giftStore.remove(tmp);
                cost += tmp.getPrice();
                if (cost < boy.getGirlfriendBudget()) {
                    giftBasket.add(tmp);
                }
            }
            while (!giftStore.isEmpty()) {
                Gifts tmp = giftStore.get(0);
                giftStore.remove(tmp);
                if (tmp.getType().equalsIgnoreCase("luxury")) {
                    giftBasket.add(tmp);
                    break;
                }
            }
        }

    }
/**
 * Calculate Happiness of couple
 */
    private void setHappiness() {
        double girlHappiness = girl.getHappiness(giftBasket);
        double boyHappiness = boy.getHappiness(girl, giftBasket);
        happiness = girlHappiness + boyHappiness;
    }
/**
 * Calculate compatibility of couple
 */
    private void setCompatibility() {
        compatibility = (int) ((boy.getGirlfriendBudget() - girl.getMaintenanceBudget()) + Math.abs(boy.getAttractiveness() - girl.getAttractiveness()) + Math.abs(boy.getIntelligenceLevel() - girl.getIntelligenceLevel()));
    }
/**
 * Get Happiness of couple
 * @return Happiness of couple
 */
    public double getHappiness() {
        return happiness;
    }
/**
 * Get compatibility of couple
 * @return Compatibility of couple
 */
    public int getCompatibility() {
        return compatibility;
    }
/**
 * Display details of couple, thus formed
 * @return Formatted string displaying the attributes of a couple
 */
    @Override
    public String toString() {
        return String.format("Name of Boy: " + boy.getName() + "\n" + "Name of Girl: " + girl.getName() + "\n");
    }
    
}
