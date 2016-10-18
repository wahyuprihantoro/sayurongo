package id.prihantoro.sayurongo.model;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by Wahyu Prihantoro on 16-Sep-16.
 */
public class User extends SugarRecord {
    public String name;
    public String photo;
    public String phone;
    public boolean isSeller;
    public String password;

    public User() {
    }

    public User(String name, String photo, String phone, boolean isSeller, String password) {
        this.name = name;
        this.photo = photo;
        this.phone = phone;
        this.isSeller = isSeller;
        this.password = password;
    }

    public static User getUserByName(String name, String password) {
        List<User> users = User.find(User.class, "name = ? and password = ?", name, password);
        if (users.size() == 0) {
            return null;
        } else {
            return users.get(0);
        }
    }

    public static User getUserByPhone(String phone, String password) {
        List<User> users = User.find(User.class, "phone = ? and password = ?", phone, password);
        if (users.size() == 0) {
            return null;
        } else {
            return users.get(0);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isSeller() {
        return isSeller;
    }

    public void setSeller(boolean seller) {
        isSeller = seller;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
