package com.example.atul.handcricket;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Atul on 25-02-2017.
 */

public class Prefmanager {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context _context;

    int PRIVATE_MODE = 0;
    public static final String PREF_NAME = "myPref";

    public Prefmanager(Context context) {
        this._context = context;
        sharedPreferences = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void setMyTeam(String myteam) {
        editor.putString("myteam",myteam);
        editor.commit();
    }

    public void setOpTeam(String opteam) {
        editor.putString("opteam",opteam);
        editor.commit();
    }

    public void setOvers(String overs) {
        editor.putString("overs",overs);
        editor.commit();
    }

    public String getMyTeam() {
        return sharedPreferences.getString("myteam",null);
    }

    public String getOpTeam() {
        return sharedPreferences.getString("opteam",null);
    }

    public String getovers (){
        return sharedPreferences.getString("overs","1");
    }
}
