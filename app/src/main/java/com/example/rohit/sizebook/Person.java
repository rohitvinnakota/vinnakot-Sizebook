package com.example.rohit.sizebook;

import java.util.Date;

/**
 * Created by Rohit on 2017-02-05.
 */

public class Person {

    private String name;
    private String date;
    private String neck;
    private String bust;
    private String chest;
    private String waist;
    private String hip;
    private String inseam;
    private String comment;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNeck() {
        return neck;
    }

    public void setNeck(String neck) {
        this.neck = neck;
    }

    public String getBust() {
        return bust;
    }

    public void setBust(String bust) {
        this.bust = bust;
    }

    public String getChest() {
        return chest;
    }

    public void setChest(String chest) {
        this.chest = chest;
    }

    public String getWaist() {
        return waist;
    }

    public void setWaist(String waist) {
        this.waist = waist;
    }

    public String getHip() {
        return hip;
    }

    public void setHip(String hip) {
        this.hip = hip;
    }

    public String getInseam() {
        return inseam;
    }

    public void setInseam(String inseam) {
        this.inseam = inseam;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public Person(String name){
        this.name = name;
    }
    @Override
    public String toString(){
        String ans = "Name: ";
        ans += name;
        if(bust.equals("")==false){
            ans += "  Bust:" + bust;
        }
        if(chest.equals("")==false){
            ans += "  chest:" + chest;
        }
        if(waist.equals("")==false){
            ans += "  waist:" + waist;
        }
        if(inseam.equals("")==false){
            ans += "  inseam:" + inseam;
        }
        return ans;
        }
    }