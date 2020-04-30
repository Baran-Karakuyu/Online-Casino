/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Games.Blackjack;

/**
 *
 * @author Andrei Oleniuc
 */

//Represents one Card
public class Cards {
    //The ID of the Card also known in Context as the Random Number
    private int id;
    //The Value of the Card in connection with the Real Card itself
    private int value;

    //Constructor for a Card Object    
    public Cards(int id, int value) {
        this.id = id;
        this.value = value;
    }
    //Getter for ID
    public int getId() {
        return id;
    }
    //Getter for Value 
    public int getValue() {
        return value;
    }


    
}
