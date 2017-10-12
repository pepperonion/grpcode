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
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author Despoina
 */
@DeclareRoles({"admin", "user"})
public class ReviewsDAOImpl implements ReviewsDAO {
    
    @PersistenceUnit
    private static EntityManagerFactory factory; 

    @Override
    @RolesAllowed("admin")
    public List<Reviews> getReviewsList() {
        
        factory = Persistence.createEntityManagerFactory("com.sp_GPRproject_war_1.0PU");
        EntityManager em = factory.createEntityManager();
        
        List<Reviews> reslist = em.createQuery("SELECT r FROM Reviews r")
                .getResultList();
        em.close();
        return reslist;
    }

    @Override
    @PermitAll
    public Reviews getReviewById(int rId) {
        
        factory = Persistence.createEntityManagerFactory("com.sp_GPRproject_war_1.0PU");
        EntityManager em = factory.createEntityManager();
        
        Reviews result = (Reviews)em.createQuery("SELECT r FROM Reviews r WHERE r.id=:idpar")
                .setParameter("idpar", rId)
                .getSingleResult();
        em.close();
        return result;
    }

    @Override
    @PermitAll
    public List<Reviews> getReviewsByUserID(int usrId) {
        
        factory = Persistence.createEntityManagerFactory("com.sp_GPRproject_war_1.0PU");
        EntityManager em = factory.createEntityManager();
        
        List<Reviews> reslist = em.createQuery("SELECT r FROM Reviews r WHERE r.usrId=:usrId")
                .setParameter("usrId", usrId)
                .getResultList();
        em.close();
        return reslist;

    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @PermitAll
    public List<Reviews> getReviewsByGameId(int gameId) {
        
        factory = Persistence.createEntityManagerFactory("com.sp_GPRproject_war_1.0PU");
        EntityManager em = factory.createEntityManager();
        
        List<Reviews> reslist = em.createQuery("SELECT r FROM Reviews r WHERE r.gameId=:gameId")
                .setParameter("gameId", gameId)
                .getResultList();
        em.close();
        return reslist;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RolesAllowed("user")
    public void addReview(String text, Users userId, Games gameId) {
        
        factory = Persistence.createEntityManagerFactory("com.sp_GPRproject_war_1.0PU");
        EntityManager em = factory.createEntityManager();
        
        Reviews nRev = new Reviews(text, userId, gameId);
        
        em.persist(nRev);
        em.close();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @PermitAll
    public void deleteReview(int id) {
        
        factory = Persistence.createEntityManagerFactory("com.sp_GPRproject_war_1.0PU");
        EntityManager em = factory.createEntityManager();
        
        em.createQuery("DELETE FROM Reviews r WHERE r.id=:idPar")
                .setParameter("idPar", id)
                .executeUpdate();
        em.close();
    }

    @Override
    @PermitAll
    public void updateReview(int id, String text, int gameId) {
        
        factory = Persistence.createEntityManagerFactory("com.sp_GPRproject_war_1.0PU");
        EntityManager em = factory.createEntityManager();
        
        em.createQuery("UPDATE Reviews r SET r.text=:textPar, r.gameId=:gameIdPar WHERE r.id=:idPar")
                .setParameter("textPar", text)
                .setParameter("gameIdPar", gameId)
                .setParameter("idPar", id)
                .executeUpdate();
        em.close();
    }
    
}
