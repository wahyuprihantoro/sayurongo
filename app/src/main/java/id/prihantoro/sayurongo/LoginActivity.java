package id.prihantoro.sayurongo;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import id.prihantoro.sayurongo.fragment.FragmentDrawer;
import id.prihantoro.sayurongo.model.User;
import id.prihantoro.sayurongo.prefs.UserData;
import id.prihantoro.sayurongo.utils.DrawerNavigator;

/**
 * Created by Wahyu Prihantoro on 15-Sep-16.
 */
@EActivity(R.layout.activity_login)
public class LoginActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {
    @ViewById
    Toolbar toolbar;
    UserData userData = new UserData();
    @Bean
    DrawerNavigator navigator;
    @ViewById
    EditText name;
    @ViewById
    EditText password;

    private FragmentDrawer drawerFragment;

    @AfterViews
    void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("MASUK");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        drawerFragment.setDrawerListener(this);
    }

    @Click
    public void login() {
        User user = User.getUserByName(name.getText().toString(), password.getText().toString());
        if (user == null) {
            user = User.getUserByPhone(name.getText().toString(), password.getText().toString());
        }
        if (user != null) {
            UserData.getInstance().setId(this, user.getId());
            if (user.isSeller) {
                userData.setRole(getApplicationContext(), UserData.SELLER);
            } else {
                userData.setRole(getApplicationContext(), UserData.BUYER);
            }
            MainActivity_.intent(this).start();
            finish();
        } else {
            Toast.makeText(this, "No. HP atau password anda salah", Toast.LENGTH_SHORT).show();
        }
    }

    @Click
    public void forgetPassword() {
        ForgetPasswordActivity_.intent(this).start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
}