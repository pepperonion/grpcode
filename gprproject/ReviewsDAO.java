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

/**
 *
 * @author Despoina
 */
public interface ReviewsDAO {
    public List<Reviews> getReviewsList();// return every review stored in the database
    
    public Reviews getReviewById(int rId); // find a specific review in the library
    
    public List<Reviews> getReviewsByUserID(int usrId); // find all reviews created by a single user
    
    public List<Reviews> getReviewsByGameId(int gameId); // find all the reviews abou a specific game
    
    public void addReview(String text, Users userId, Games gameId);
    
    public void deleteReview(int id);
    
    public void updateReview(int id, String text, int gameId);
}
