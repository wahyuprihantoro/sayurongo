package id.prihantoro.sayurongo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

import id.prihantoro.sayurongo.prefs.UserData;

/**
 * Created by Wahyu Prihantoro on 03-Oct-16.
 */
@EActivity(R.layout.activity_choose_language)
public class ChooseLanguageActivity extends AppCompatActivity {
    UserData userData = new UserData();

    @Click
    public void english() {
        userData.setFirstLogin(getApplicationContext());
        MainActivity_.intent(getApplicationContext()).flags(Intent.FLAG_ACTIVITY_NEW_TASK).start();
        finish();
    }

    @Click
    public void indonesia() {
        userData.setFirstLogin(getApplicationContext());
        MainActivity_.intent(getApplicationContext()).flags(Intent.FLAG_ACTIVITY_NEW_TASK).start();
        finish();
    }
}
