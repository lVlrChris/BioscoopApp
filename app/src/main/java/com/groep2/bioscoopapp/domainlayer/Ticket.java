package com.groep2.bioscoopapp.domainlayer;

/**
 * Created by Kevin van Loon on 28-3-2018.
 */

public abstract class Ticket {

    private double price;
    private String name;


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name + " " + this.price;
    }
}
