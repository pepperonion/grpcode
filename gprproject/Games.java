/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sp.gprproject;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Despoina
 */
@Entity
@Table(name="gamestbl")
public class Games implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idGamesTbl")
    private Long id;

    @Column(name="title")
    private String title;
    
    @Column(name="genre")
    private String genre;
    
    @Column(name="date")
    private Date date;
    
    @Column(name="rank")
    private Integer rank;
    
    @Column(name="company")
    private String company;

    public Games() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Games(Long id, String title, String genre, Date date, String company) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.date = date;
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "com.sp.gprproject.Games[ id=" + id + " ]";
    }
    
}
