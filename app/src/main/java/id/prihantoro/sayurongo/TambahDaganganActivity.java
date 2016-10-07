package id.prihantoro.sayurongo;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import id.prihantoro.sayurongo.fragment.TambahDaganganFragment;
import id.prihantoro.sayurongo.fragment.TambahDaganganFragment_;

/**
 * Created by Wahyu Prihantoro on 07-Oct-16.
 */
@EActivity(R.layout.activity_tambah_dagangan)
public class TambahDaganganActivity extends AppCompatActivity {

    @AfterViews
    void init(){
        getSupportActionBar().setTitle("TAMBAH DAGANGAN");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TambahDaganganFragment fragment = TambahDaganganFragment_.builder().build();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).disallowAddToBackStack().commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
