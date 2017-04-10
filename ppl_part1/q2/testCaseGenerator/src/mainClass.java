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
     * @param args a b c where a=no. of girls to be generated b=no. of boys to be generated c=no. of gifts to be generated
     */
    public static void main(String[] args) {
        GenerateGirls girls =new GenerateGirls(Integer.parseInt(args[0]));
        GenerateBoys boys = new GenerateBoys(Integer.parseInt(args[1]));
        GenerateGifts gifts = new GenerateGifts (Integer.parseInt(args[2]));
    }
    
}
