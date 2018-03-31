package com.groep2.bioscoopapp.applicationlogic;

import com.groep2.bioscoopapp.domainlayer.Ticket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin van Loon on 31-3-2018.
 */

public class TicketManager implements Serializable{

    public List<Ticket> tickets;

    public TicketManager() {
        this.tickets =  new ArrayList<>();
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void addTicket(Ticket ticket){
        this.tickets.add(ticket);
    }

    public void clearTickets(){
        this.tickets.clear();
    }
}
