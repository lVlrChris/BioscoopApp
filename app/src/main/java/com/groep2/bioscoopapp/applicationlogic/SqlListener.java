package com.groep2.bioscoopapp.applicationlogic;

import com.groep2.bioscoopapp.domainlayer.Ticket;

import java.util.ArrayList;

public interface SqlListener {

    void onQueryExecute(ArrayList<Ticket> tickets);
}
