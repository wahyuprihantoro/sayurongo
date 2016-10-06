package id.prihantoro.sayurongo.fragment;

import android.support.v4.app.Fragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

import id.prihantoro.sayurongo.R;

/**
 * Created by Wahyu Prihantoro on 06-Oct-16.
 */
@EFragment(R.layout.fragment_tambah_dagangan)
public class TambahDaganganFragment extends Fragment {

    @AfterViews
    void init() {

    }

    @Click
    public void sayuran() {
        Fragment fragment = DetailJenisDaganganFragment_.builder().arg("jenis", "Jenis : Sayuran").build();
        getFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).addToBackStack("tambah_dagangan").commit();
    }

    @Click
    public void buahBuahan() {
        Fragment fragment = DetailJenisDaganganFragment_.builder().arg("jenis", "Jenis : Buah - buahan").build();
        getFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).addToBackStack("tambah_dagangan").commit();
    }

    @Click
    public void makananLaut() {
        Fragment fragment = DetailJenisDaganganFragment_.builder().arg("jenis", "Jenis : Makanan Laut").build();
        getFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).addToBackStack("tambah_dagangan").commit();
    }

    @Click
    public void daging() {
        Fragment fragment = DetailJenisDaganganFragment_.builder().arg("jenis", "Jenis : Daging").build();
        getFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).addToBackStack("tambah_dagangan").commit();
    }

    @Click
    public void makananOlahan() {
        Fragment fragment = DetailJenisDaganganFragment_.builder().arg("jenis", "Jenis : Makanan Olahan").build();
        getFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).addToBackStack("tambah_dagangan").commit();
    }

    @Click
    public void bumbuMasak() {
        Fragment fragment = DetailJenisDaganganFragment_.builder().arg("jenis", "Jenis : Bumbu Masak").build();
        getFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).addToBackStack("tambah_dagangan").commit();
    }
}
