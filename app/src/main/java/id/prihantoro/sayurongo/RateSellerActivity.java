package id.prihantoro.sayurongo;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Wahyu Prihantoro on 04-Oct-16.
 */
@EActivity(R.layout.activity_rate_seller)
public class RateSellerActivity extends AppCompatActivity {

    @ViewById
    LinearLayout up;
    @ViewById
    LinearLayout down;

    @AfterViews
    void init() {
        getSupportActionBar().setTitle("RATE PEDAGANG");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        down.setVisibility(View.GONE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Click
    void like() {
        up.setVisibility(View.VISIBLE);
        down.setVisibility(View.GONE);
        MainActivity_.intent(this).start();
        finish();
    }

    @Click
    void dislike() {
        down.setVisibility(View.VISIBLE);
        up.setVisibility(View.GONE);
        MainActivity_.intent(this).start();
        finish();
    }
    @Click
    void like1() {
        up.setVisibility(View.VISIBLE);
        down.setVisibility(View.GONE);
        MainActivity_.intent(this).start();
        finish();
    }

    @Click
    void dislike1() {
        down.setVisibility(View.VISIBLE);
        up.setVisibility(View.GONE);
        MainActivity_.intent(this).start();
        finish();
    }
}
