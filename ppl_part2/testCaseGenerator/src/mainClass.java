/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Main Class of Random Data Generator
 * @author Rishabh Rishu(IIT2015068)
 */
public class mainClass {

    /**
     * @param args 
     */
    public static void main(String[] args) {
        GenerateGirls girls =new GenerateGirls(20);
        GenerateBoys boys = new GenerateBoys(200);
        GenerateGifts gifts = new GenerateGifts (2000);
    }
    
}
