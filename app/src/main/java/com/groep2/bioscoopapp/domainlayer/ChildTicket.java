package com.groep2.bioscoopapp.domainlayer;

        import java.io.Serializable;

/**
 * Created by Kevin van Loon on 31-3-2018.
 */

public class ChildTicket extends Ticket implements Serializable {

    private int price;

    public ChildTicket(User user, Presentation presentation, Seat seat) {
        super(user, presentation, seat);
        this.price = 5;
    }

    public int getPrice() {
        return 5;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
