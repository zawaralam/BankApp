/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

/**
 *
 * @author zawar
 */
//This is the concrete state subclass
public class Gold extends Level {

    @Override
    //checks the balance of a customer file to identify the state of customer, based on the balance
    //changes the fee, and sets a string value equal to the level
    public void changeLevel(CustomerMenuController c) {

        if (c.getBalance() >= 20000.00) {
            c.setLevel(new Platinum());
             c.fee = 0;
            c.displayLevel = "Platinum";
        } else if (c.getBalance() < 10000.00) {
            c.setLevel(new Silver());
            c.fee = 20;
            c.displayLevel = "Silver";
        } else {
            c.fee = 10;
            c.displayLevel = "Gold";
        }
    }

}
