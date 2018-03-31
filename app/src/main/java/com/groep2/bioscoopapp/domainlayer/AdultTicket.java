package com.groep2.bioscoopapp.domainlayer;

import java.io.Serializable;

/**
 * Created by Kevin van Loon on 31-3-2018.
 */

public class AdultTicket extends Ticket implements Serializable {

    private int price;

    public AdultTicket(Presentation presentation, Seat seat) {
        super(presentation, seat);
        this.price = 10;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
