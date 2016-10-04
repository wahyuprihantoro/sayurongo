package id.prihantoro.sayurongo;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import id.prihantoro.sayurongo.custom.InvoiceItemView_;
import id.prihantoro.sayurongo.model.InvoiceItem;

/**
 * Created by Wahyu Prihantoro on 20-Sep-16.
 */
@EActivity(R.layout.activity_konfirmasi)
public class KonfirmasiActivity extends AppCompatActivity {
    @ViewById
    TextView total;
    @ViewById
    CheckBox diantar;
    @ViewById
    CheckBox langsung;
    @ViewById
    LinearLayout linearLayout;

    @AfterViews
    void init() {
        getSupportActionBar().setTitle("KONFIRMASI");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int total = 0;
        InvoiceItem item = new InvoiceItem("Wortel", 20000, 3);
        total += item.harga * item.jumlah;
        linearLayout.addView(InvoiceItemView_.build(this, item));
        item = new InvoiceItem("Tomat", 30000, 2);
        total += item.harga * item.jumlah;
        linearLayout.addView(InvoiceItemView_.build(this, item));
        item = new InvoiceItem("Jahe", 7000, 2);
        total += item.harga * item.jumlah;
        linearLayout.addView(InvoiceItemView_.build(this, item));
        item = new InvoiceItem("Lengkuas", 5500, 1);
        total += item.harga * item.jumlah;
        linearLayout.addView(InvoiceItemView_.build(this, item));
        this.total.setText(total + "");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Click
    void proses() {
        SuccessTransactionActivity_.intent(this).start();
        finish();
    }

    @Click
    void diantar() {
        diantar.setChecked(true);
        langsung.setChecked(false);
    }
    @Click
    void langsung() {
        diantar.setChecked(false);
        langsung.setChecked(true);
    }
}
