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


//    @Pref
//    UserPrefs_ userPrefs;

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
    }

    public void setRole(Context context, int role) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHAREDPFREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(ROLE, role);
        editor.commit();
    }

}