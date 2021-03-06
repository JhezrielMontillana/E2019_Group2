package com.example.clientapplication;

import android.content.Context;
import android.content.SharedPreferences;


public class SessionManagement {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String SHARED_PREF_NAME = "session";
    String SESSION_KEY = "sessionKey";
    String SESSION_EMAIL_KEY = "sessionEmailKey";
    String SESSION_FN_KEY = "sessionFirstNameKey";
    String SESSION_LN_KEY = "sessionLastNameKey";
    String SESSION_GENDER_KEY = "sessionGenderKey";
    String SESSION_AGE_KEY = "sessionAgeKey";
    String SESSION_BDATE_KEY = "sessionBdateKey";

    public SessionManagement(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveSession(User user) {
        int id = user.getId();
        int age = user.getAge();
        String email = user.getEmail(),
                firstname = user.getFirstname(),
                lastname = user.getLastname(),
                gender = user.getGender(),
                bday = user.getBirthdate();

        editor.putInt(SESSION_KEY, id).commit();
        editor.putInt(SESSION_AGE_KEY, age).commit();
        editor.putString(SESSION_EMAIL_KEY, email).commit();
        editor.putString(SESSION_FN_KEY, firstname).commit();
        editor.putString(SESSION_LN_KEY, lastname).commit();
        editor.putString(SESSION_GENDER_KEY, gender).commit();
        editor.putString(SESSION_BDATE_KEY, bday).commit();
    }

    public int getSessionID() {
        return sharedPreferences.getInt(SESSION_KEY, -1);
    }

    public User getSession() {
        int id = sharedPreferences.getInt(SESSION_KEY, -1);
        int age = sharedPreferences.getInt(SESSION_AGE_KEY, -1);
        String _email = sharedPreferences.getString(SESSION_EMAIL_KEY, "");
        String _lastname = sharedPreferences.getString(SESSION_LN_KEY, "");
        String _firstname = sharedPreferences.getString(SESSION_FN_KEY, "");
        String _gender = sharedPreferences.getString(SESSION_GENDER_KEY, "");
        String _bdate = sharedPreferences.getString(SESSION_BDATE_KEY, "");
        User user = new User(id, _email, _firstname, _lastname, _gender, _bdate, age);
        return user;
    }

    public void removeSession() {
        editor.putInt(SESSION_KEY, -1);
        editor.putInt(SESSION_AGE_KEY, -1);
        editor.putString(SESSION_EMAIL_KEY, "");
        editor.putString(SESSION_FN_KEY, "");
        editor.putString(SESSION_LN_KEY, "");
        editor.putString(SESSION_GENDER_KEY, "");
        editor.putString(SESSION_BDATE_KEY, "");
        editor.commit();
    }
}
