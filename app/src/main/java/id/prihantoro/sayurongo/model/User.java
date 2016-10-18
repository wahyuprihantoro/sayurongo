package id.prihantoro.sayurongo.model;

import android.graphics.Bitmap;

import com.google.android.gms.maps.model.LatLng;
import com.orm.SugarRecord;

/**
 * Created by Wahyu Prihantoro on 16-Sep-16.
 */
public class User extends SugarRecord {
    public String name;
    public LatLng latLng;
    public Bitmap photo;
    public String phone;
    public boolean isSeller;
    public String password;

    public User() {
    }

    public User(String name, LatLng latLng, Bitmap photo, String phone, boolean isSeller, String password) {
        this.name = name;
        this.latLng = latLng;
        this.photo = photo;
        this.phone = phone;
        this.isSeller = isSeller;
        this.password = password;
    }
}
