package com.tolong.help.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


// 16-08-2019
// Muhammad Qais Abdurrahim
// 10116289
// IF-7


public class UserPreference {

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public UserPreference(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void setFirstRun(Boolean check) {
        editor = preferences.edit();
        editor.putBoolean("firstRun", check);
        editor.apply();
    }

    public void setIsLogin(String username, String password){
        editor = preferences.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.apply();
    }

    public Boolean isFirstRun() {
        return preferences.getBoolean("firstRun", true);
    }

    public String userLogin(){
        return preferences.getString("username",null);
    }

    public String passwordLogin(){
        return preferences.getString("password",null);
    }
}
