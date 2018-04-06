package com.groep2.bioscoopapp.applicationlogic;

import android.content.Context;

import com.groep2.bioscoopapp.dataaccess.TicketSQLDAO;
import com.groep2.bioscoopapp.domainlayer.Presentation;
import com.groep2.bioscoopapp.domainlayer.Ticket;
import com.groep2.bioscoopapp.guilayer.PaymentActivity;

import java.util.ArrayList;

/**
 * Created by Kevin van Loon on 31-3-2018.
 */

public class TicketManager implements SqlListener {

    private static TicketManager instance;

    private ArrayList<Ticket> tickets;
    private ArrayList<Ticket> orderTickets;
    private Context context;
    private TicketAdapter ticketAdapter;

    //Constructor private to make singleton
    private TicketManager(Context context) {
        this.tickets = new ArrayList<>();
        this.orderTickets = new ArrayList<>();
        this.context = context;
    }

    //Singleton instance
    public static TicketManager getInstance(Context context) {
        if(instance == null) {
            instance = new TicketManager(context);
        }
        return instance;
    }

    public ArrayList<Ticket> getTickets() {
        TicketSQLDAO ticketSQLDAO = new TicketSQLDAO(context, this);
        ticketSQLDAO.selectAllTickets();
        return tickets;
    }

    public ArrayList<Ticket> getOrderTickets() {
        return orderTickets;
    }

    public void clearOrderTickets() {
        orderTickets.clear();
    }

    public void addTicket(Ticket ticket) {
        TicketSQLDAO ticketSQLDAO = new TicketSQLDAO(context, this);
        //inserts ticket in database and sets row id as id.
        ticket.setId(ticketSQLDAO.insertTicket(ticket));
        //this.tickets.add(ticket);
    }

    public void addOrderTicket(Ticket ticket) {
        this.orderTickets.add(ticket);
    }

    public void onQueryExecute(ArrayList<Ticket> tickets) {
        this.tickets.addAll(tickets);
        ticketAdapter.notifyDataSetChanged();
    }

    public void setTicketAdapter(TicketAdapter ticketAdapter) {
        this.ticketAdapter = ticketAdapter;
    }
}

