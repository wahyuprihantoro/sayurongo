package id.prihantoro.sayurongo;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

/**
 * Created by Wahyu Prihantoro on 07-Oct-16.
 */
@EActivity(R.layout.activity_detail_riwayat)
public class DetailRiwayatActivity extends AppCompatActivity {

    @AfterViews
    void init() {
        getSupportActionBar().setTitle("Kucing Terbang");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
