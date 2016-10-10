package id.prihantoro.sayurongo;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

import id.prihantoro.sayurongo.fragment.FragmentDrawer;
import id.prihantoro.sayurongo.prefs.UserData;
import id.prihantoro.sayurongo.utils.DrawerNavigator;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener, OnMapReadyCallback {
    @ViewById
    Toolbar toolbar;
    UserData userData = new UserData();
    @Bean
    DrawerNavigator navigator;
    private GoogleMap mMap;

    private FragmentDrawer drawerFragment;

    @AfterViews
    void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("TELUSURI");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        drawerFragment.setDrawerListener(this);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng current = new LatLng(-6.402520, 106.793889);
        mMap.addMarker(new MarkerOptions().position(current).title("your location"));
        List<LatLng> locations = new ArrayList<>();
        locations = getLocations();
        for (int i = 0; i < locations.size(); i++) {
            mMap.addMarker(new MarkerOptions().title("buyer").position(locations.get(i)).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_userlocation_green)));
        }
        if (UserData.getInstance().isSeller(this)) {
            locations = getSellerLocations();
            for (int i = 0; i < locations.size(); i++) {
                mMap.addMarker(new MarkerOptions().title("seller").position(locations.get(i)).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_userlocation_pink)));
            }
        }
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(current, 16));

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if (UserData.getInstance().isSeller(getApplicationContext()) && marker.getTitle().equals("seller")){

                } else {
                    ProfileActivity_.intent(getApplicationContext()).flags(Intent.FLAG_ACTIVITY_NEW_TASK).extra("lat", marker.getPosition().latitude).extra("lng", marker.getPosition().longitude)
                            .extra("code", ProfileActivity.PROFIL_PENJUAL).start();
                }

                return false;
            }
        });
    }

    public List<LatLng> getLocations() {
        List<LatLng> locations = new ArrayList<>();
        locations.add(new LatLng(-6.402826, 106.793982));
        locations.add(new LatLng(-6.404283, 106.791520));
        locations.add(new LatLng(-6.401536, 106.795087));
        locations.add(new LatLng(-6.403519, 106.792480));
        locations.add(new LatLng(-6.401739, 106.791246));
        locations.add(new LatLng(-6.400886, 106.793381));
        locations.add(new LatLng(-6.404710, 106.793816));
        locations.add(new LatLng(-6.399891, 106.793838));

        return locations;
    }

    public List<LatLng> getSellerLocations() {
        List<LatLng> locations = new ArrayList<>();
        locations.add(new LatLng(-6.401826, 106.793982));
        locations.add(new LatLng(-6.404283, 106.792520));
        locations.add(new LatLng(-6.401536, 106.793087));
        locations.add(new LatLng(-6.401519, 106.792480));
        locations.add(new LatLng(-6.404739, 106.791246));
        locations.add(new LatLng(-6.400886, 106.794381));
        locations.add(new LatLng(-6.401710, 106.792816));
        locations.add(new LatLng(-6.398891, 106.794838));

        return locations;
    }

}
