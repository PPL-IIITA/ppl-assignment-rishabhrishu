/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchFinder;

/**
 * The Main Class of Match Finder Application
 *
 * @author Rishabh Rishu
 */
public class MainClass {

    /**
     * Calls the init class for initialization and calculation of everything
     *
     * @param args k
     */
    public static void main(String[] args) {
        init i = new init();
        int k = Integer.parseInt(args[0]);
        i.run();
        System.out.println("List of all the couples formed");
        i.display();
        System.out.println("List of "+k +" happiest couples formed");
        i.printHappyCouples(k);
        System.out.println("List of "+k +" most compatible couples formed");
        i.printCompatibleCouples(k);
    }

}
