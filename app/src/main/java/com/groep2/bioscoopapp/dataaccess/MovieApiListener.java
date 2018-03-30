package com.groep2.bioscoopapp.dataaccess;

import org.json.JSONObject;

public interface MovieApiListener {
    public void onResultSetAvailable(JSONObject resultSet);
}
