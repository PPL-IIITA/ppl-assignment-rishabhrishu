/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.relationship.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Rishabh Rishu(IIT2015068)
 */
public class Couples {

    BestKvalued<Gift> giftStore;
    BestKvalued<Gift> giftBasket;
    private Girl girl;
    private Boy boy;
    private double happiness;
    private int compatibility;
    private _Logger logger;

    /**
     * Constructor , where algorithm for making gift basket need not be
     * specified
     *
     * @param girl Girl, in the couple
     * @param boy Boy, in the couple
     * @param giftList List of all the available gifts,i.e, gift store
     */
    public Couples(Girl girl, Boy boy, BestKvalued<Gift> giftList, int n, _Logger logger) {
        giftBasket = new BestKvalued<Gift>(n);
        this.girl = girl;
        this.boy = boy;
        this.giftStore = giftList;
        boy.setStatus(true);
        girl.setStatus(true);
        girl.addBf(boy);
        this.setCompatibility();
        this.createGiftBasket();
        this.setHappiness();
        this.logger = logger;
    }

    /**
     * Calculate Happiness of couple
     */
    private void setHappiness() {
        ArrayList<Gift> giftsBasket = new ArrayList<>();
        for (int i = 0; i < giftBasket.getSize(); i++) {
            giftsBasket.add(giftBasket.get(i));
        }
        double girlHappiness = girl.getHappiness(giftsBasket);
        double boyHappiness = boy.getHappiness(girl, giftsBasket);
        happiness = girlHappiness + boyHappiness;
    }

    /**
     * Creates gift basket, which is gifted to girl, by the boy.
     */
    public void createGiftBasket() {
        Gift minGift = this.getGift(giftStore.bestKvalued(new PriceComparator()));
        giftStore.remove(minGift);
        double cost = minGift.getPrice();
        giftBasket.add(minGift);
        if (boy instanceof MiserBoy) {
            while (cost < girl.getBudget()) {
                Gift tmp = this.getGift(giftStore.bestKvalued(new PriceComparator()));
                giftStore.remove(tmp);
                cost += tmp.getPrice();
                if (cost < boy.getBudget()) {
                    giftBasket.add(tmp);
                    //    logger.log("<GIFTING>"+tmp);
                }
            }

        } else if (boy instanceof GenerousBoy) {
            while (cost < boy.getBudget()) {
                Gift tmp = this.getGift(giftStore.bestKvalued(new PriceComparator()));
                giftStore.remove(tmp);
                cost += tmp.getPrice();
                if (cost < boy.getBudget()) {
                    giftBasket.add(tmp);
                    //    logger.log("<GIFTING>"+tmp);
                }
            }
        } else {
            while (cost < girl.getBudget()) {
                Gift tmp = this.getGift(giftStore.bestKvalued(new PriceComparator()));
                giftStore.remove(tmp);
                cost += tmp.getPrice();
                if (cost < boy.getBudget()) {
                    giftBasket.add(tmp);
                    //    logger.log("<GIFTING>"+tmp);
                }
            }
            while (!giftStore.isEmpty()) {
                Gift tmp = this.getGift(giftStore.bestKvalued(new PriceComparator()));
                giftStore.remove(tmp);
                if (tmp instanceof LuxuryGift) {
                    giftBasket.add(tmp);
                    //    logger.log("<GIFTING>"+tmp);
                    break;
                }
            }
        }
    }

    /**
     * Helper method to choose gifts
     *
     * @param gift list of best k gifts, as per cost, lower better.
     * @return a gift of them, with highest value among them
     */
    private Gift getGift(List<Gift> gift) {
        Gift g = gift.get(0);
        for (int j = 0; j < gift.size(); j++) {
            if (g.getValue() < gift.get(j).getValue()) {
                g = gift.get(j);
            }
        }
        return g;
    }

    /**
     * Calculate compatibility of couple
     */
    private void setCompatibility() {
        compatibility = (int) ((boy.getBudget() - girl.getBudget()) + Math.abs(boy.getAttractiveness() - girl.getAttractiveness()) + Math.abs(boy.getIntelligenceLevel() - girl.getIntelligenceLevel()));
    }

    /**
     * Get Happiness of couple
     *
     * @return Happiness of couple
     */
    public double getHappiness() {
        return happiness;
    }

    /**
     * Get compatibility of couple
     *
     * @return Compatibility of couple
     */
    public int getCompatibility() {
        return compatibility;
    }

    /**
     * Returns the boy in couple
     *
     * @return boy
     */
    public Boy getBoy() {
        return boy;
    }

    /**
     * Returns the girl in couple
     *
     * @return girl
     */
    public Girl getGirl() {
        return girl;
    }

    /**
     * A helper method to print all the gift exchanges between couples
     */
    public void printGiftExchange() {
        logger.log("<Couple FORMED>" + this.toString());
        for (int i = 0; i < giftBasket.getSize(); i++) {
            System.out.print(giftBasket.get(i));
            logger.log("<Gifting>" + giftBasket.get(i));
        }
    }

    /**
     * Display details of couple, thus formed
     *
     * @return Formatted string displaying the attributes of a couple
     */
    @Override
    public String toString() {
        return String.format("Name of Boy: " + boy.getName() + "\n" + "Name of Girl: " + girl.getName() + "\nhappiness: " + happiness + "\nCompatibility: " + compatibility + "\n");
    }

    /**
     * Utility Inner class for comparison purposes
     */
    public class PriceComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            Gift g1 = (Gift) o1;
            Gift g2 = (Gift) o2;
            return Double.compare(g2.getPrice(), g1.getPrice());
        }

    }
}
