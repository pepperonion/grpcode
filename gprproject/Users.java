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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

/**
 *
 * @author Despoina
 */
@Entity
@Table(name= "usertbl")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idUserTbl")
    private Long id;
    
    @Column(name="username")
    private String username;
    
    @Column(name="passw")
    private String passwrd;
    
    @Column(name="emailaddr")
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
    + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
    + "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9]"
    + "(?:[a-z0-9-]*[a-z0-9])?",
    message = "{invalid.email}")//ensure the email address is valid
    private String email;
    
    @OneToMany
    private Reviews reviews;

    public Users(String usrname, String passwrd, String email) {
        this.username = usrname;
        this.passwrd = passwrd;
        this.email = email;
    }

    public Users() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String usrname) {
        this.username = usrname;
    }

    public String getPasswrd() {
        return passwrd;
    }

    public void setPasswrd(String passwrd) {
        this.passwrd = passwrd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "]"+ "User[ id=" + id + ", username=" +username+ ", email=" + email;
    }
    
}
