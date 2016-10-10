package id.prihantoro.sayurongo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import id.prihantoro.sayurongo.prefs.UserData;

/**
 * Created by Wahyu Prihantoro on 12-Sep-16.
 */
@EActivity(R.layout.activity_splash)
public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000;

    UserData userData = new UserData();

    @AfterViews
    void init() {
        getSupportActionBar().hide();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (userData.firstLogin(getApplicationContext())){
                    MainActivity_.intent(getApplicationContext()).flags(Intent.FLAG_ACTIVITY_NEW_TASK).start();
                } else {
                    ChooseLanguageActivity_.intent(getApplicationContext()).flags(Intent.FLAG_ACTIVITY_NEW_TASK).start();
                    userData.setFirstLogin(getApplicationContext());
                }
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
