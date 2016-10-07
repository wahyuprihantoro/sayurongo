package id.prihantoro.sayurongo;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import id.prihantoro.sayurongo.fragment.FragmentDrawer;
import id.prihantoro.sayurongo.fragment.TambahDaganganFragment;
import id.prihantoro.sayurongo.fragment.TambahDaganganFragment_;
import id.prihantoro.sayurongo.prefs.UserData;
import id.prihantoro.sayurongo.utils.DrawerNavigator;

/**
 * Created by Wahyu Prihantoro on 15-Sep-16.
 */
@EActivity(R.layout.activity_dagangan)
public class DaganganActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {
    @ViewById
    Toolbar toolbar;
    UserData userData = new UserData();
    @Bean
    DrawerNavigator navigator;

    @ViewById
    Button tambahDagangan;

    private FragmentDrawer drawerFragment;

    @AfterViews
    void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("DAGANGAN");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        drawerFragment.setDrawerListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        navigator.setupNavigation(position);
    }

    @Click
    void tambahDagangan() {
        TambahDaganganActivity_.intent(getApplicationContext()).flags(Intent.FLAG_ACTIVITY_NEW_TASK).start();
    }
}