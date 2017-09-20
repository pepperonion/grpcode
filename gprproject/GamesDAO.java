/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sp.gprproject;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Despoina
 */
public interface GamesDAO {

    public List<Games> getListOfGames();
    
    public void updateListOfGames(int id);
    
    public void deleteGame(int id);
    
    public void addNewGame(String title, String genre, Date date, String company);
    
    public Games findGame(int id);
    
}
