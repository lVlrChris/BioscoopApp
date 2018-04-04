package com.groep2.bioscoopapp.applicationlogic;

import android.content.Context;

import com.groep2.bioscoopapp.dataaccess.TicketSQLDAO;
import com.groep2.bioscoopapp.domainlayer.Ticket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin van Loon on 31-3-2018.
 */

public class TicketManager {

    private static TicketManager instance;

    public ArrayList<Ticket> tickets;
    private TicketSQLDAO ticketSQLDAO;

    //Constructor private to make singleton
    private TicketManager(Context context) {
        this.tickets = new ArrayList<>();
        ticketSQLDAO = new TicketSQLDAO(context);
    }

    //Singleton instance
    public static TicketManager getInstance(Context context) {
        if(instance == null) {
            instance = new TicketManager(context);
        }

        return instance;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        //inserts ticket in database and sets row id as id.
        ticket.setId(ticketSQLDAO.insertTicket(ticket));
        this.tickets.add(ticket);
    }
}

