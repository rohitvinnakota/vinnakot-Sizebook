package com.example.rohit.sizebook;

import java.util.Date;

/**
 * Created by Rohit on 2017-02-05.
 * The person class provides methods and attributes for a person object
 * Each person object is stored in an arraylist which the main app iterates over
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


    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets neck.
     *
     * @return the neck
     */
    public String getNeck() {
        return neck;
    }

    /**
     * Sets neck.
     *
     * @param neck the neck
     */
    public void setNeck(String neck) {
        this.neck = neck;
    }

    /**
     * Gets bust.
     *
     * @return the bust
     */
    public String getBust() {
        return bust;
    }

    /**
     * Sets bust.
     *
     * @param bust the bust
     */
    public void setBust(String bust) {
        this.bust = bust;
    }

    /**
     * Gets chest.
     *
     * @return the chest
     */
    public String getChest() {
        return chest;
    }

    /**
     * Sets chest.
     *
     * @param chest the chest
     */
    public void setChest(String chest) {
        this.chest = chest;
    }

    /**
     * Gets waist.
     *
     * @return the waist
     */
    public String getWaist() {
        return waist;
    }

    /**
     * Sets waist.
     *
     * @param waist the waist
     */
    public void setWaist(String waist) {
        this.waist = waist;
    }

    /**
     * Gets hip.
     *
     * @return the hip
     */
    public String getHip() {
        return hip;
    }

    /**
     * Sets hip.
     *
     * @param hip the hip
     */
    public void setHip(String hip) {
        this.hip = hip;
    }

    /**
     * Gets inseam.
     *
     * @return the inseam
     */
    public String getInseam() {
        return inseam;
    }

    /**
     * Sets inseam.
     *
     * @param inseam the inseam
     */
    public void setInseam(String inseam) {
        this.inseam = inseam;
    }

    /**
     * Gets comment.
     *
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets comment.
     *
     * @param comment the comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }


    /**
     * Instantiates a new Person.
     *
     * @param name the name
     */
    public Person(String name){
        this.name = name;
    }
    @Override
    /*
    Overrides the toString class which is how we view the object in a ListView
     */
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