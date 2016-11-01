package id.prihantoro.sayurongo.fragment;

import android.support.v4.app.Fragment;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
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

    @ViewById
    Spinner nama;

    @ViewById
    EditText harga;
    @ViewById
    EditText satuan;
    @ViewById
    EditText kuantitas;

    @AfterViews
    void init() {
        if (jenis != null) {
            jenisTextView.setText(jenis);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.buah, android.R.layout.simple_spinner_item);
        if (jenis.toLowerCase().contains("buah")) {
            adapter = ArrayAdapter.createFromResource(getContext(),
                    R.array.buah, android.R.layout.simple_spinner_item);
        } else if (jenis.toLowerCase().contains("sayur")) {
            adapter = ArrayAdapter.createFromResource(getContext(),
                    R.array.sayur, android.R.layout.simple_spinner_item);
        } else if (jenis.toLowerCase().contains("laut")) {
            adapter = ArrayAdapter.createFromResource(getContext(),
                    R.array.makanan_laut, android.R.layout.simple_spinner_item);
        } else if (jenis.toLowerCase().contains("olahan")) {
            adapter = ArrayAdapter.createFromResource(getContext(),
                    R.array.makanan_olahan, android.R.layout.simple_spinner_item);
        } else if (jenis.toLowerCase().contains("masak")) {
            adapter = ArrayAdapter.createFromResource(getContext(),
                    R.array.bumbu_masak, android.R.layout.simple_spinner_item);
        } else if (jenis.toLowerCase().contains("daging")) {
            adapter = ArrayAdapter.createFromResource(getContext(),
                    R.array.daging, android.R.layout.simple_spinner_item);
        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nama.setAdapter(adapter);
    }

    @Click
    void simpan() {
        if (harga.getText().toString().isEmpty() || satuan.getText().toString().isEmpty() || kuantitas.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), "isian tidak valid", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "berhasil disimpan", Toast.LENGTH_SHORT).show();
            getActivity().finish();
        }
    }

    @Click
    void linearLayout() {
    }
}