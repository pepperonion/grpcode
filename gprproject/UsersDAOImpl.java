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
public class UsersDAOImpl implements UsersDAO {
    @PersistenceUnit
    private static EntityManagerFactory factory; 

    public UsersDAOImpl() {
    }
    
    @Override
    public List<Users> getUsersList() {
        factory = Persistence.createEntityManagerFactory("com.sp_GPRproject_war_1.0PU");
        EntityManager em = factory.createEntityManager();
        
        List<Users> userList = em.createQuery("SELECT u FROM Users u")
                .getResultList();
        
        em.close();
        return userList;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addUser(String username, String pass, String email) {
        factory = Persistence.createEntityManagerFactory("com.sp_GPRproject_war_1.0PU");
        EntityManager em = factory.createEntityManager();
        
        Users newUser = new Users(username, pass, email);
        em.persist(newUser);
        
        em.close();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteUser(int id) {
        factory = Persistence.createEntityManagerFactory("com.sp_GPRproject_war_1.0PU");
        EntityManager em = factory.createEntityManager();
        
        em.createQuery("DELETE FROM Users u WHERE u.id=:idPar")
                .setParameter("idPar", id)
                .executeUpdate();
        
        em.close();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateUserDetails(int id, String username, String pass, String email) {
        factory = Persistence.createEntityManagerFactory("com.sp_GPRproject_war_1.0PU");
        EntityManager em = factory.createEntityManager();

        em.createQuery("UPDATE Users u SET u.username =:userPar, u.passwrd=:passPar, u.email=:emailPar WHERE u.id=:idPar")
                .setParameter("userPar",username)
                .setParameter("passPar", pass)
                .setParameter("emailPar", email)
                .setParameter("idPar", id)
                .executeUpdate();
        
        em.close();
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
