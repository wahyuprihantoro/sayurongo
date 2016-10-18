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

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng current = new LatLng(-6.38798763, 106.79041386);
        mMap.addMarker(new MarkerOptions().position(current).title("your location"));
        List<LatLng> locations = new ArrayList<>();
        locations = getLocations();
        for (int i = 0; i < locations.size(); i++) {
            if (UserData.getInstance().isSeller(this)) {
                mMap.addMarker(new MarkerOptions().title("pembeli").position(locations.get(i)).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_userlocation_green)));
            } else {
                mMap.addMarker(new MarkerOptions().title("penjual").position(locations.get(i)).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_userlocation_green)));
            }
        }
        if (UserData.getInstance().isSeller(this)) {
            locations = getSellerLocations();
            for (int i = 0; i < locations.size(); i++) {
                mMap.addMarker(new MarkerOptions().title("penjual").position(locations.get(i)).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_userlocation_pink)));
            }
        }
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(current, 16));

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if (marker.getTitle().equals("penjual")) {
                    ProfileActivity_.intent(getApplicationContext()).flags(Intent.FLAG_ACTIVITY_NEW_TASK).extra("lat", marker.getPosition().latitude).extra("lng", marker.getPosition().longitude)
                            .extra("code", ProfileActivity.PROFIL_PENJUAL).start();
                }
                return false;
            }
        });
    }

    public List<LatLng> getLocations() {
        List<LatLng> locations = new ArrayList<>();
        locations.add(new LatLng(-6.38594048, 106.79032803));
        locations.add(new LatLng(-6.38632432, 106.79301023));
        locations.add(new LatLng(-6.38890458, 106.79125071));
        locations.add(new LatLng(-6.38363743, 106.79152966));
        locations.add(new LatLng(-6.38171821, 106.78929806));
        locations.add(new LatLng(-6.37952176, 106.78977013));
        locations.add(new LatLng(-6.3804174, 106.79180861));
        locations.add(new LatLng(-6.37847684, 106.78828955));

        return locations;
    }

    public List<LatLng> getSellerLocations() {
        List<LatLng> locations = new ArrayList<>();
        locations.add(new LatLng(-6.39022321, 106.79272277));
        locations.add(new LatLng(-6.37994048, 106.79332803));
        locations.add(new LatLng(-6.38532432, 106.79201023));
        locations.add(new LatLng(-6.38390458, 106.79025071));
        locations.add(new LatLng(-6.38563743, 106.78952966));
        locations.add(new LatLng(-6.38171821, 106.78029806));
        locations.add(new LatLng(-6.37852176, 106.78977013));
        locations.add(new LatLng(-6.3814174, 106.79080861));
        return locations;
    }

}
