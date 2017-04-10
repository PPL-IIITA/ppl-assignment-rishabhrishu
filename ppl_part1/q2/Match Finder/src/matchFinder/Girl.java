/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchFinder;

import java.util.*;
import java.lang.Math;

/**
 * Objects of this class are actual girl entities
 * 
 * @author Rishabh Rishu
 */
public class Girl {

    private String name;
    private int attractiveness;
    private double maintenanceBudget;
    private int intelligenceLevel;
    private boolean isCommited;
    private String type;
/**
 * Creates an instance of girl
 * @param name Name of girl
 * @param attractiveness Attractiveness of girl
 * @param maintenanceBudget Maintenance Budget of girl
 * @param intelligenceLevel Intelligence Level of girl
 * @param type Type of girl
 */
    public Girl(String name, int attractiveness, double maintenanceBudget, int intelligenceLevel, String type) {
        this.setName(name);
        this.setAttractiveness(attractiveness);
        this.setMaintenanceBudget(maintenanceBudget);
        this.setIntelligenceLevel(intelligenceLevel);
        this.setType(type);
        isCommited = false;
    }
/**
 * Used to set/modify name of girl
 * @param name Name of girl
 */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Used to set/modify attractiveness of girl
     * @param attractiveness  attractiveness of girl
     */
    public void setAttractiveness(int attractiveness) {
        this.attractiveness = attractiveness;
    }
    /**
     * Used to set/modify maintenance budget of girl
     * @param maintenanceBudget maintenance budget
     */
    public void setMaintenanceBudget(double maintenanceBudget) {
        this.maintenanceBudget = maintenanceBudget;
    }
    /**
     * Used to set/modify intelligence level of girl
     * @param intelligenceLevel intelligence level
     */
    public void setIntelligenceLevel(int intelligenceLevel) {
        this.intelligenceLevel = intelligenceLevel;
    }
    /**
     * Used to set/modify type of girl
     * @param type type of girl
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * Used to set relationship status of girl
     * @param value true if girl is committed, false otherwise
     */
    public void setStatus(boolean value){
        isCommited = value;
    }
/**
 * Returns name of the girl
 * @return Name
 */
    public String getName() {
        return name;
    }
    /**
     * Returns attractiveness level of the girl
     * @return Attractiveness Level
     */
    public int getAttractiveness() {
        return attractiveness;
    }
    /**
     * Returns Maintenance Budget of the girl
     * @return Maintenance Budget
     */
    public double getMaintenanceBudget() {
        return maintenanceBudget;
    }
    /**
     * Returns Intelligence Level of the Girl
     * @return Intelligence Level
     */
    public int getIntelligenceLevel() {
        return intelligenceLevel;
    }
    /**
     * Returns true if the girl is in relationship, false otherwise
     * @return Relationship Status
     */
    public boolean getStatus() {
        return isCommited;
    }
    /**
     * Returns type of the girl
     * @return type of girl
     */
    public String getType() {
        return type;
    }
/**
 * Calculate and return happiness of the girl, based on her type<br>
 * <em>Note</em> For desperate girl, (cost)<sub>i</sub> - maintenanceBudget turns out to be quite high, so mod 10 is used to contain the result to be in limits of double
 * @param giftBasket list of all the gifts girl got from his boyfriend
 * @return Happiness of the girl
 */
    public double getHappiness(ArrayList<Gifts> giftBasket) {
        double happiness = 0;
        float cost = 0;
        float value = 0;
        if (null != type) {
            switch (type) {
                case "choosy":
                    for (Gifts gifts : giftBasket) {
                        cost = cost + gifts.getPrice();
                        if (gifts.getType().equalsIgnoreCase("luxury")) {
                            value = value + 2 * gifts.getValue();
                        }
                    }
                    happiness = Math.log(Math.abs(cost + value - maintenanceBudget));
                    break;
                
                case "normal":
                    for (Gifts gifts: giftBasket) {
                        cost = cost + gifts.getPrice();
                        value = value + gifts.getValue();
                    }
                    happiness = cost + value - maintenanceBudget;
                    break;
                
                case "desperate":
                    for (Gifts gifts: giftBasket) {
                        cost = cost +gifts.getPrice();
                    }
                    happiness = Math.exp((cost - maintenanceBudget)%10);
                    break;
                default:
                    break;
            }
        }
        return happiness;
    }
}
