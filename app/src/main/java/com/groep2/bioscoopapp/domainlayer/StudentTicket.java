package com.groep2.bioscoopapp.domainlayer;

import java.io.Serializable;

/**
 * Created by Kevin van Loon on 28-3-2018.
 */

public class StudentTicket extends Ticket implements Serializable {

    private int price;
    public StudentTicket(User user, Presentation presentation, Seat seat){
        super(user, presentation, seat);
        this.price = 8;
    }

    public int getPrice() {
        return 8;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
