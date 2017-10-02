/*
 * Copyright (C) 2017 Despoina
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.sp.gprproject;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author Despoina
 */
public class ReviewsDAOImpl implements ReviewsDAO {
    
    @PersistenceUnit
    private static EntityManagerFactory factory; 

    @Override
    public List<Reviews> getReviewsList() {
        
        factory = Persistence.createEntityManagerFactory("com.sp_GPRproject_war_1.0PU");
        EntityManager em = factory.createEntityManager();
        
        List<Reviews> reslist = em.createQuery("SELECT r FROM Reviews r")
                .getResultList();
        
        return reslist;
    }

    @Override
    public Reviews getReviewById(int rId) {
        
        factory = Persistence.createEntityManagerFactory("com.sp_GPRproject_war_1.0PU");
        EntityManager em = factory.createEntityManager();
        
        Reviews result = (Reviews)em.createQuery("SELECT r FROM Reviews r WHERE r.id=:idpar")
                .setParameter("idpar", rId)
                .getSingleResult();
        
        return result;
    }

    @Override
    public List<Reviews> getReviewsByUserID(int usrId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reviews> getReviewsByGameId(int gameId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addReview(String text, int userId, int gameId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteReview(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateReview(int id, String text, int gameId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
