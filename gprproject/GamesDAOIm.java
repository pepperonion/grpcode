/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sp.gprproject;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author Despoina
 */
public class GamesDAOIm implements GamesDAO {
    
    @PersistenceUnit
    private static EntityManagerFactory factory; 

    
    public List<Games> getListOfGames() {
        factory = Persistence.createEntityManagerFactory("com.sp_GPRproject_war_1.0PU");
        EntityManager em = factory.createEntityManager();
        
        List<Games> gameData = em.createQuery("SELECT x FROM Games x")
                .getResultList();
        
        em.close();
        return gameData;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public GamesDAOIm() {
    }

    @Override
    public void updateListOfGames(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteGame(int id) {
        factory = Persistence.createEntityManagerFactory("com.sp_GPRproject_war_1.0PU");
        EntityManager em = factory.createEntityManager();
        
        //em.getTransaction().begin();
        
        em.createQuery("DELETE FROM Games e WHERE e.id = :v")
                .setParameter("v", id)
                .executeUpdate();
        //em.getTransaction().commit();
        em.close();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addNewGame(String title, String genre, Date date, String company) {
                
        factory = Persistence.createEntityManagerFactory("com.sp_GPRproject_war_1.0PU");
        
        EntityManager em = factory.createEntityManager();
        
        Games ngame = new Games(title, genre, date, company);
        em.persist(ngame);
        
        em.close();
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Games findGame(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
