package id.prihantoro.sayurongo.fragment;

import android.support.v4.app.Fragment;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ViewById;

import id.prihantoro.sayurongo.R;

/**
 * Created by Wahyu Prihantoro on 06-Oct-16.
 */
@EFragment(R.layout.fragment_detail_jenis_dagangan)
public class DetailJenisDaganganFragment extends Fragment {

    @FragmentArg
    String jenis;
    @ViewById(R.id.jenis)
    TextView jenisTextView;

    @AfterViews
    void init() {
        if (jenis!=null){
            jenisTextView.setText(jenis);
        }
    }

    @Click
    void simpan() {

    }

}
