/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchFinder;

import java.util.ArrayList;

/**
 * Objects of this class are actual boy entities
 * 
 * @author Rishabh Rishu(IIT2015068)
 */
public class Boy {

    private String name;
    private int attractiveness;
    private double girlfriendBudget;
    private int intelligenceLevel;
    private boolean isCommited;
    private String type;
/**
 * Creates an instance of boy
 * @param name Name of boy
 * @param attractiveness Attractiveness of boy
 * @param girlfriendBudget Girlfriend Budget of boy
 * @param intelligenceLevel Intelligence Level of Boy
 * @param type Type of boy
 */
    public Boy(String name, int attractiveness, double girlfriendBudget, int intelligenceLevel, String type) {
        this.setName(name);
        this.setAttractiveness(attractiveness);
        this.setGirlfriendBudget(girlfriendBudget);
        this.setIntelligenceLevel(intelligenceLevel);
        this.setType(type);
        isCommited = false;
    }
/**
 * Used to set/modify name of boy
 * @param name Name of boy
 */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Used to set/modify attractiveness of boy
     * @param attractiveness attractiveness level of boy
     */
    public void setAttractiveness(int attractiveness) {
        this.attractiveness = attractiveness;
    }
    /**
     * Used to set/modify girlfriendbudget of boy
     * @param girlfriendBudget girlfriend budget of a boy
     */
    public void setGirlfriendBudget(double girlfriendBudget) {
        this.girlfriendBudget = girlfriendBudget;
    }
    /**
     * Used to set/modify intelligence level of boy
     * @param intelligenceLevel intelligence level of boy
     */
    public void setIntelligenceLevel(int intelligenceLevel) {
        this.intelligenceLevel = intelligenceLevel;
    }
    /**
     * Used to set/modify type of boy
     * @param type type of boy
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * Used to set the relationship status of boy
     * @param value true if boy gets committed, false otherwise
     */
    public void setStatus(boolean value){
        isCommited = value;
    }
/**
 * Returns the name of boy
 * @return Name of boy
 */
    public String getName() {
        return name;
    }
    /**
     * Returns attractiveness level of boy
     * @return Attractiveness Level
     */
    public int getAttractiveness() {
        return attractiveness;
    }
    /**
     * Returns girlfriend budget of boy
     * @return girlfriend budget
     */
    public double getGirlfriendBudget() {
        return girlfriendBudget;
    }
    /**
     * Returns intelligence level of boy
     * @return intelligence level
     */
    public int getIntelligenceLevel() {
        return intelligenceLevel;
    }
    /**
     * Returns true if the boy is in a relationship, false otherwise
     * @return Relationship Status
     */
    public boolean getStatus() {
        return isCommited;
    }
    /**
     * Returns type of boy
     * @return Type
     */
    public String getType() {
        return type;
    }
/**
 * Calculate and return the happiness of boy, based on his type
 * @param girl girlfriend of the boy
 * @param giftBasket list of all the gifts the boy gave to his present girlfriend
 * @return happiness of the boy
 */
    public double getHappiness(Girl girl, ArrayList<Gifts> giftBasket) {
        double happiness = 0;
        float cost = 0;
        if (null != type) {
            switch (type) {
                case "miser":
                    for (Gifts gifts : giftBasket) {
                        cost = cost + gifts.getPrice();
                    }
                    happiness = girlfriendBudget - cost;
                    break;
                case "generous":
                    happiness = girl.getHappiness(giftBasket);
                    break;
                case "geeks":
                    happiness = girl.getIntelligenceLevel();
                    break;
                default:
                    break;
            }
        }
        return happiness;
    }
}
