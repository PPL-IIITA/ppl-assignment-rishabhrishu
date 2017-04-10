/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchFinder;
/**
 * Objects of this class are actual gift entities.
 * 
 * @author Rishabh Rishu
 */
public class Gifts {
    private int rating;
    private String difficulty;
    private float price;
    private float value;
    private String utilityValue;
    private String utilityClass;
    private String type;
    
/**
 *  Creates an instance of Essential Gift
 * @param type Type of gift(Essential)
 * @param price Price of gift
 * @param value Value of gift
 */
    public Gifts(String type, float price, float value) {
       this.type = type;
       this.price = price;
       this.value = value;
    }
    /**
     * Creates an instance of Luxury Gift
     * @param type Type of gift(Luxury)
     * @param price Price of gift
     * @param value Value of gift
     * @param rating Rating of gift
     * @param difficulty Difficulty in obtaining gift
     */
    public Gifts(String type, float price, float value, int rating, String difficulty){
        this.type = type;
        this.price = price;
        this.value = value;
        this.rating = rating;
        this.difficulty = difficulty;
    }
    /**
    * Creates an instance of Utility Gift
    * @param type Type of gift (Utility)
    * @param price Price of gift
    * @param value Value of gift
    * @param utilityClass The Utility Class of the gift
    * @param utilityValue The Utility Value of the gift
    */
    public Gifts(String type, float price, float value, String utilityClass, String utilityValue){
        this.type = type;
        this.price = price;
        this.value = value;
        this.utilityClass = utilityClass;
        this.utilityValue = utilityValue;
    }
    /**
     * Returns the price of the gift
     * @return price of the gift
     */
    public float getPrice() {
        return price;
    }
/**
 * Returns the value of the gift
 * @return value of the gift
 */
    public float getValue() {
        return value;
    }
    /**
     * Returns the type of the gift
     * @return type of the gift
     */

    public String getType() {
        return type;
    }
    
    /**
     * Displays the attributes of a gift
     * @return Formatted String showing attributes
     */
    @Override
    public String toString() {
        return String.format("price:"+price + "\t" +"value:"+ value + "\t" + "type:"+type + "\n");
    }
}
