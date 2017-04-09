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
public class CoupleAllocBestK {

    protected BestKvalued<Couples> coupleList;
    protected BestKvalued<Gift> giftList;
    protected BestKvalued<Boy> boyList;
    protected BestKvalued<Girl> girlList;
    private BestKvalued<Boy> boysList;
    private BestKvalued<Girl> girlsList;
    private int k;
    private _Logger logger;

    /**
     * @param boyList list of all the boys
     * @param girlList list of all the girls
     * @param giftList list of all the available gifts,i.e, gift store
     * @param k as given in question
     */
    public CoupleAllocBestK(BestKvalued<Boy> boyList, BestKvalued<Girl> girlList, BestKvalued<Gift> giftList, int k, _Logger l) {
        this.boyList = boyList;
        this.girlList = girlList;
        this.giftList = giftList;
        this.k = k;
        coupleList = new BestKvalued<Couples>(k);
        boysList = new BestKvalued<Boy>(k);
        girlsList = new BestKvalued<Girl>(k);
        logger = l;
    }

    /**
     * Makes the couple,as per instructions given in question
     *
     * @param k as in question
     * @return a list of couples, thus formed
     */
    public BestKvalued<Couples> makeCouple(int k) {
        for (int j = 0; j < boyList.getSize(); j++) {
            boysList.add(boyList.get(j));
        }
        for (int j = 0; j < girlList.getSize(); j++) {
            girlsList.add(girlList.get(j));
        }
        Iterator<Girl> it1 = girlList.iterator();
        Iterator<Boy> it2 = boyList.iterator();
        while (true) {

            if (it1.hasNext()) {
                Girl girl = it1.next();
                if (!girl.getStatus()) {
                    {
                        List<Boy> boy = boysList.bestKvalued((Object o1, Object o2) -> {
                            Boy v1 = (Boy) o1;
                            Boy v2 = (Boy) o2;
                            return Integer.compare(v1.getAttractiveness(), v2.getAttractiveness());
                        });
                        Boy b = boy.get(0);
                        for (int j = 0; j < boy.size(); j++) {
                            if (b.getBudget() < boy.get(j).getBudget()) {
                                b = boy.get(j);
                            }
                        }
                        if (b.getBudget() >= girl.getBudget() && !girl.checkExBf(b) &&!b.getStatus()) {
                            coupleList.add(new Couples(girl, b, giftList, k, logger));
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
                        List<Girl> girl = girlsList.bestKvalued((Object o1, Object o2) -> {
                            Girl v1 = (Girl) o1;
                            Girl v2 = (Girl) o2;
                            return Integer.compare(v1.getAttractiveness(), v2.getAttractiveness());
                        });
                        Girl g = girl.get(0);
                        for (int j = 0; j < girl.size(); j++) {
                            if (g.getBudget() > girl.get(j).getBudget()) {
                                g = girl.get(j);
                            }
                        }
                        if (boy.getBudget() >= g.getBudget() && !g.checkExBf(boy) && !g.getStatus()) {
                            coupleList.add(new Couples(g, boy, giftList, k, logger));
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
     * Performs breakup of couples
     *
     * @param couple the couple whose break-up is needed to be performed
     * @return a list without this couple
     */
    public BestKvalued<Couples> breakupCouple(Couples couple) {
        couple.getBoy().setStatus(false);
        couple.getGirl().setStatus(false);
        coupleList.remove(couple);
        return coupleList;
    }
    /**
     * USed to set logger
     * @param logger object of class _Logger
     */
    public void setLogger(_Logger logger){
        this.logger = logger;
    }

}
