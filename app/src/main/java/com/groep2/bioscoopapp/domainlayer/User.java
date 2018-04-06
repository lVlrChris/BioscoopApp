package com.groep2.bioscoopapp.domainlayer;

/**
 * Created by Kevin van Loon on 27-3-2018.
 */

public class User {

    private int userId;

    public User(int id){
        this.userId = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
