/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.relationship.*;
import java.util.*;

/**
 * Class for couple making algorithm as in q5
 *
 * @author Rishabh Rishu(IIT2015068)
 */
public class CoupleAllocRandK {

    protected RandomK<Couples> coupleList;
    protected RandomK<Gift> giftList;
    protected RandomK<Boy> boyList;
    protected RandomK<Girl> girlList;
    private RandomK<Boy> boysList;
    private RandomK<Girl> girlsList;
    private int n;
    _Logger logger;

    /**
     * @param boyList list of all the boys
     * @param girlList list of all the girls
     * @param giftList list of all the available gifts,i.e, gift store
     * @param n as given in question
     */
    public CoupleAllocRandK(RandomK<Boy> boyList, RandomK<Girl> girlList, RandomK<Gift> giftList, int n) {
        this.boyList = boyList;
        this.girlList = girlList;
        this.giftList = giftList;
        this.n = n;
        coupleList = new RandomK<Couples>(n);
        boysList = new RandomK<Boy>(n);
        girlsList = new RandomK<Girl>(n);
    }

    /**
     * Utility Function for Making Couples
     *
     * @param n as given in question
     * @return list of couples thus formed
     */
    public RandomK<Couples> makeCouple(int n) {
        for (int k = 0; k < boyList.getSize(); k++) {
            boysList.add(boyList.get(k));
        }
        for (int k = 0; k < girlList.getSize(); k++) {
            girlsList.add(girlList.get(k));
        }
        Iterator<Girl> it1 = girlList.iterator();
        Iterator<Boy> it2 = boyList.iterator();
        while (true) {

            if (it1.hasNext()) {
                Girl girl = it1.next();
                if (!girl.getStatus()) {
                    {
                        Boy boy = boysList.getKth((Object o1, Object o2) -> {
                            Boy v1 = (Boy) o1;
                            Boy v2 = (Boy) o2;
                            return Integer.compare(v1.getAttractiveness(), v2.getAttractiveness());
                        });
                        if (boy.getBudget() >= girl.getBudget() && !girl.checkExBf(boy)) {
                            coupleList.add(new Couples(girl, boy, giftList, n, logger));
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
                    {
                        Girl g = girlsList.getKth((Object o1, Object o2) -> {
                            Girl v1 = (Girl) o1;
                            Girl v2 = (Girl) o2;
                            return Integer.compare(v1.getAttractiveness(), v2.getAttractiveness());
                        });
                        if (boy.getBudget() >= g.getBudget() && !g.checkExBf(boy)) {
                            coupleList.add(new Couples(g, boy, giftList, n, logger));
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

    /**
     * Utility method to configure logger
     *
     * @param logger object of class _Logger
     */
    public void setLogger(_Logger logger) {
        this.logger = logger;
    }

    /**
     * Performs break-up of couples
     *
     * @param couple couple whose breakup is to be performed
     * @return modified list of couples
     */
    public RandomK<Couples> breakupCouple(Couples couple) {
        couple.getBoy().setStatus(false);
        couple.getGirl().setStatus(false);
        coupleList.remove(couple);
        return coupleList;
    }

}
