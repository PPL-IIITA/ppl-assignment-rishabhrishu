/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relationship;

import java.util.ArrayList;

/**
 * An abstract class for all the persons
 * @author Rishabh Rishu(IIT2015068)
 */
public abstract class Person {

    private String name;
    private int attractiveness;
    private int intelligenceLevel;
    private boolean isCommited;

    /**
     * Creates an instance of person
     *
     * @param name Name of person
     * @param attractiveness Attractiveness of person
     * @param intelligenceLevel Intelligence Level of person
     */
    public Person(String name, int attractiveness, int intelligenceLevel) {
        this.setName(name);
        this.setAttractiveness(attractiveness);
        this.setIntelligenceLevel(intelligenceLevel);
        isCommited = false;
    }

    /**
     * Used to set/modify name of person
     *
     * @param name Name of person
     */
    public final void setName(String name) {
        this.name = name;
    }

    /**
     * Used to set/modify attractiveness of person
     *
     * @param attractiveness attractiveness level of person
     */
    public final void setAttractiveness(int attractiveness) {
        this.attractiveness = attractiveness;
    }

    /**
     * Used to set/modify intelligence level of person
     *
     * @param intelligenceLevel intelligence level of person
     */
    public final void setIntelligenceLevel(int intelligenceLevel) {
        this.intelligenceLevel = intelligenceLevel;
    }

    /**
     * Used to set the relationship status of person
     *
     * @param value true if person gets committed, false otherwise
     */
    public void setStatus(boolean value) {
        isCommited = value;
    }

    /**
     * Returns the name of person
     *
     * @return Name of person
     */
    public String getName() {
        return name;
    }

    /**
     * Returns attractiveness level of person
     *
     * @return Attractiveness Level
     */
    public int getAttractiveness() {
        return attractiveness;
    }

    /**
     * Returns intelligence level of person
     *
     * @return intelligence level
     */
    public int getIntelligenceLevel() {
        return intelligenceLevel;
    }

    /**
     * Returns true if the person is in a relationship, false otherwise
     *
     * @return Relationship Status
     */
    public boolean getStatus() {
        return isCommited;
    }

    public abstract void setBudget(double budget);

    public abstract double getBudget();

    @Override
    public String toString() {
        return String.format("Name:%s\tAttractiveness:%d\tIntelligence Level:%s\t",  name, attractiveness, intelligenceLevel);
    }

}
