package id.prihantoro.sayurongo.utils;

import android.app.Activity;
import android.content.Context;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import id.prihantoro.sayurongo.BantuanActivity_;
import id.prihantoro.sayurongo.DaganganActivity_;
import id.prihantoro.sayurongo.LoginActivity_;
import id.prihantoro.sayurongo.PengaturanActivity_;
import id.prihantoro.sayurongo.PesananActivity_;
import id.prihantoro.sayurongo.RateAppActivity_;
import id.prihantoro.sayurongo.RegisterActivity_;
import id.prihantoro.sayurongo.RiwayatActivity_;
import id.prihantoro.sayurongo.TelusuriActivity_;
import id.prihantoro.sayurongo.prefs.UserData;

/**
 * Created by Wahyu Prihantoro on 15-Sep-16.
 */
@EBean
public class DrawerNavigator {
    @RootContext
    Context context;

    UserData userData = new UserData();

    public void setupNavigation(int pos) {
        boolean finish = true;
        if (userData.isBuyer(context)) {
            if (pos == 1) {
                TelusuriActivity_.intent(context).start();
            } else if (pos == 2) {
                RiwayatActivity_.intent(context).start();
            } else if (pos == 4) {
                BantuanActivity_.intent(context).start();
            } else if (pos == 5) {
                RateAppActivity_.intent(context).start();
            } else if (pos == 6) {
                PengaturanActivity_.intent(context).start();
            } else if (pos == 7) {
                LoginActivity_.intent(context).start();
                userData.logout(context);
            }
        } else if (userData.isSeller(context)) {
            if (pos == 1) {
                TelusuriActivity_.intent(context).start();
            } else if (pos == 2) {
                PesananActivity_.intent(context).start();
            } else if (pos == 3) {
                DaganganActivity_.intent(context).start();
            } else if (pos == 4) {
                RiwayatActivity_.intent(context).start();
            } else if (pos == 6) {
                BantuanActivity_.intent(context).start();
            } else if (pos == 7) {
                RateAppActivity_.intent(context).start();
            } else if (pos == 8) {
                PengaturanActivity_.intent(context).start();
            } else if (pos == 9) {
                LoginActivity_.intent(context).start();
                userData.logout(context);
            }
        } else {
            if (pos == 1) {
                RegisterActivity_.intent(context).start();
            } else if (pos == 2) {
                LoginActivity_.intent(context).start();
            } else if (pos == 4) {
                BantuanActivity_.intent(context).start();
            } else if (pos == 5) {
                RateAppActivity_.intent(context).start();
            } else if (pos == 6) {
                PengaturanActivity_.intent(context).start();
            }
        }
        if (finish) {
            ((Activity) context).finish();
        }
    }
}
