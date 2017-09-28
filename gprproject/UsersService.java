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

import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Despoina
 */
@Path("/Users")
@Stateless
public class UsersService implements Serializable{

    UsersDAOImpl usersObj = new UsersDAOImpl();
    
    @GET
    public List<Users> getAllUsers() {
        List <Users> list = usersObj.getUsersList();
        
        return list;
    }

    @POST
    @Path("/newUser/{par1}/{par2}/{par3}")
    public void addNewUser(@PathParam("par1") String username, @PathParam("par2") String password, @PathParam("par3") String email) {
        usersObj.addUser(username, email, email);
    }
    
    @PUT
    @Path("/updateUser/{par1}/{par2}/{par3}/{par4}")
    public void updateUser(@PathParam("par1") String username, @PathParam("par2") String password, @PathParam("par3") String email, @PathParam("par4") int id) {
        usersObj.updateUserDetails(id, username, password, email);
    }
    
    @DELETE
    @Path("/deleteUser/{par1}")

    public void deleteUser(@PathParam("par1") int id) {
        usersObj.deleteUser(id);
    }
    
}
