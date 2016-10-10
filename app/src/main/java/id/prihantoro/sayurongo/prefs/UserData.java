package id.prihantoro.sayurongo.prefs;


import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by Wahyu Prihantoro on 05-Sep-16.
 */
public class UserData {
    public static final int BUYER = 1;
    public static final int SELLER = 2;
    public static final int UNKNOWN = 0;
    public static final String SHAREDPFREF = "asdjhsabdkjasmdasd";
    public static final String ROLE = "role";
    public static final String FIRST_LOGIN = "first_login";

    private static UserData instance;

    public static UserData getInstance() {
        if (instance == null) {
            instance = new UserData();
        }
        return instance;
    }


    public boolean firstLogin(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHAREDPFREF, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(FIRST_LOGIN, false);
    }

    public void setFirstLogin(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHAREDPFREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(FIRST_LOGIN, true);
        editor.commit();
    }

    public boolean isBuyer(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHAREDPFREF, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(ROLE, 0) == BUYER;
    }

    public boolean isSeller(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHAREDPFREF, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(ROLE, 0) == SELLER;
    }

    public boolean unKnownRole(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHAREDPFREF, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(ROLE, 0) == UNKNOWN;
    }

    public void logout(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHAREDPFREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
        setFirstLogin(context);
    }

    public void setRole(Context context, int role) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHAREDPFREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(ROLE, role);
        editor.commit();
    }

}