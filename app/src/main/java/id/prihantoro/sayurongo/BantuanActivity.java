package id.prihantoro.sayurongo;

import android.graphics.Paint;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import id.prihantoro.sayurongo.fragment.FragmentDrawer;
import id.prihantoro.sayurongo.prefs.UserData;
import id.prihantoro.sayurongo.utils.DrawerNavigator;

/**
 * Created by Wahyu Prihantoro on 15-Sep-16.
 */
@EActivity(R.layout.activity_bantuan)
public class BantuanActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {
    @ViewById
    Toolbar toolbar;
    UserData userData = new UserData();
    @Bean
    DrawerNavigator navigator;
    @ViewById(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @ViewById(R.id.fragment_navigation_drawer)
    RelativeLayout fragmentNavgationDrawer;
    @ViewById
    TextView ask1;
    @ViewById
    TextView ask2;
    @ViewById
    TextView ask3;
    @ViewById
    TextView ask4;
    @ViewById
    TextView ask5;
    @ViewById
    TextView ask7;
    @ViewById
    TextView ans3;
    @ViewById
    TextView ans4;
    @ViewById
    TextView ans5;
    @ViewById
    TextView ans7;
    private FragmentDrawer drawerFragment;

    @AfterViews
    void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("BANTUAN");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        drawerFragment.setDrawerListener(this);
        underline(ask1);
        underline(ask2);
        underline(ask3);
        underline(ask4);
        underline(ask5);
        underline(ask7);
    }

    public void underline(TextView view){
        String text = view.getText().toString();
        view.setPaintFlags(view.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        view.setText(text);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onDrawerItemSelected(View view, int position) {
        navigator.setupNavigation(position);
    }
}