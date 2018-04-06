package com.groep2.bioscoopapp.domainlayer;

import java.io.Serializable;

/**
 * Created by Kevin van Loon on 31-3-2018.
 */

public class AdultTicket extends Ticket implements Serializable {

    private int price;

    public AdultTicket(User user, Presentation presentation, Seat seat) {
        super(user, presentation, seat);
        this.price = 10;
    }

    @Override
    public int getPrice() {
        return 10;
    }

}
