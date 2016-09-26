package id.prihantoro.sayurongo.prefs;

import org.androidannotations.annotations.sharedpreferences.DefaultInt;
import org.androidannotations.annotations.sharedpreferences.DefaultString;
import org.androidannotations.annotations.sharedpreferences.SharedPref;

/**
 * Created by Wahyu Prihantoro on 05-Sep-16.
 */
@SharedPref
public interface UserPrefs {

    @DefaultString("")
    public String id();

    @DefaultString("")
    public String userData();

    @DefaultInt(0)
    public int role();
}
