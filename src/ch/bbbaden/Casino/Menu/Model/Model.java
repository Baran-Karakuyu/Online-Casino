/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Menu.Model;

import Casino.DataBase.Query;
import Casino.DataBase.User;
import ch.bbbaden.Casino.MainApp;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Baran
 */
public class Model {

    Query sql = new Query();
    ArrayList<User> benutzer = new ArrayList<>();
    String name="";
    
    private MainApp mainApp;

    public void startSlots() throws IOException {
        mainApp.startSlots();
    }

    public void startBlackJack() throws IOException, SQLException, ClassNotFoundException {
        mainApp.startBlackjack();
    }

    public void startRoulette() throws IOException {
        mainApp.startSlots();
    }

    public void startYatzy() throws IOException {
        mainApp.startSlots();
    }

    public void startBingo() throws IOException, SQLException, ClassNotFoundException {
        mainApp.startSlots();
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    public void setUser(String email,String password){
        for(int i=0;i<sql.getUsers().size();i++){
            benutzer.add(sql.getUsers().get(i));
        }
        for(int i= 0;i<sql.getUsers().size();i++){
            if(benutzer.get(i).getEmail().equals(email)){
                if(benutzer.get(i).getPassword().equals(password)){
                    name= benutzer.get(i).getName();
                    System.out.println(name);
                }else{

                }
            }
        }
    }
}
