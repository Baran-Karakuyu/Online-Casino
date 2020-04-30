package ch.bbbaden.Casino.Games.Yatzy;


import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Würfel
 * 
 * @author Yannick Wulf
 */
public class Würfel {
    
    int auge;
    int value;
    boolean hold = false;
    Random rnd = new Random();
    
    
    public int würfle(){
        auge =  rnd.nextInt(6) + 1;
        value = auge;
        return auge;
    }
    
    public int getValue(){
        return value;
    }
    
}
