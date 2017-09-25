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
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Despoina
 */
@Path("/Games")
@Stateless
public class GamesService implements Serializable{
    
    GamesDAOIm GamesObj = new GamesDAOIm();

    @GET
    @Produces("application/json")
    public List<Games> getLOG(){
        List<Games> LOGdata = GamesObj.getListOfGames();
        return LOGdata;
    }
    
    @PUT
    @Path("/newGame/{par1}/{par2}/{par3}/{par4}")
    public void addGameToList(@PathParam("par1") String titlePar,
            @PathParam("par2") String genrePar,
            @PathParam("par3") Date datePar,
            @PathParam("par4") String companyPar){
        GamesObj.addNewGame(titlePar, genrePar, datePar, companyPar);
    }
}
