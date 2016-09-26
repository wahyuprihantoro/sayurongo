package id.prihantoro.sayurongo;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.LinearLayout;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import id.prihantoro.sayurongo.custom.DaganganItemView_;
import id.prihantoro.sayurongo.fragment.FragmentDrawer;
import id.prihantoro.sayurongo.model.DaganganItem;
import id.prihantoro.sayurongo.prefs.UserData;
import id.prihantoro.sayurongo.utils.DrawerNavigator;

/**
 * Created by Wahyu Prihantoro on 15-Sep-16.
 */
@EActivity(R.layout.activity_profile)
public class ProfileActivity extends AppCompatActivity {
    public static final int PROFIL_PENJUAL = 1;

    @ViewById
    Toolbar toolbar;
    UserData userData = new UserData();
    @Bean
    DrawerNavigator navigator;
    @ViewById
    LinearLayout linearLayout;
    @Extra
    int code;

    private FragmentDrawer drawerFragment;

    @AfterViews
    void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("PROFILE");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
//        drawerFragment = (FragmentDrawer)
//                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
//        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
//        drawerFragment.setDrawerListener(this);

        DaganganItem item = new DaganganItem("Wortel", "tersisa 5 kg", "20000/kg");
        linearLayout.addView(DaganganItemView_.build(this, item));
        item = new DaganganItem("Tomat", "tersisa 3 kg", "30000/kg");
        linearLayout.addView(DaganganItemView_.build(this, item));
        item = new DaganganItem("Cabe", "tersisa 6 kg", "20000/kg");
        linearLayout.addView(DaganganItemView_.build(this, item));
        item = new DaganganItem("Kunyit", "tersisa 4 kg", "7500/kg");
        linearLayout.addView(DaganganItemView_.build(this, item));
        item = new DaganganItem("Lengkuas", "tersisa 3 kg", "5500/kg");
        linearLayout.addView(DaganganItemView_.build(this, item));
        item = new DaganganItem("Jahe", "tersisa 5 kg", "7000/kg");
        linearLayout.addView(DaganganItemView_.build(this, item));
    }

    @Click
    public void lanjutkan() {
        KonfirmasiActivity_.intent(this).start();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public void onDrawerItemSelected(View view, int position) {
//        navigator.setupNavigation(position);
//    }
}