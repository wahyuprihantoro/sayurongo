package id.prihantoro.sayurongo;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

/**
 * Created by Wahyu Prihantoro on 04-Oct-16.
 */
@EActivity(R.layout.activity_success_transaction)
public class SuccessTransactionActivity extends AppCompatActivity {

    @AfterViews
    void init() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Click
    void confirmButton() {
        finish();
        RateSellerActivity_.intent(this).start();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
