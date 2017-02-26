/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package matchFinder;
/**
 * The Main Class of Match Finder Application
 * @author Rishabh Rishu(IIT2015068)
 */
public class MainClass {

    /**
     * Calls the init class for initialization and calculation of everything
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        init a = new init();
        a.run();
        a.printCouples();
    }
    
}
