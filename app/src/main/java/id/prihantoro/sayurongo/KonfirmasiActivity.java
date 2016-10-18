package id.prihantoro.sayurongo;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import java.util.Calendar;
import java.util.Date;

import id.prihantoro.sayurongo.custom.InvoiceItemView_;
import id.prihantoro.sayurongo.model.Invoice;
import id.prihantoro.sayurongo.model.InvoiceItem;

/**
 * Created by Wahyu Prihantoro on 20-Sep-16.
 */
@EActivity(R.layout.activity_konfirmasi)
public class KonfirmasiActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {
    @ViewById
    TextView total;
    @ViewById
    CheckBox diantar;
    @ViewById
    CheckBox langsung;
    @ViewById
    LinearLayout linearLayout;
    @ViewById
    TextView clockValue;
    @Extra
    Invoice invoice;

    @AfterViews
    void init() {
        getSupportActionBar().setTitle("KONFIRMASI");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Calendar now = Calendar.getInstance();
        String time = new Date().getHours() + ":" + new Date().getMinutes();
        clockValue.setText(time);
        int total = 0;
        if (invoice != null) {
            for (InvoiceItem item : invoice.invoices) {
                if (item.jumlah > 0) {
                    total += item.harga * item.jumlah;
                    linearLayout.addView(InvoiceItemView_.build(this, item));
                }
            }
        }
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

    @Click
    void clockLayout() {
        Calendar now = Calendar.getInstance();
        TimePickerDialog dpd = TimePickerDialog.newInstance(
                KonfirmasiActivity.this,
                now.get(Calendar.HOUR_OF_DAY),
                now.get(Calendar.MINUTE),
                true
        );
        dpd.show(getFragmentManager(), "Datepickerdialog");
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {
        String time = hourOfDay + ":" + minute;
        clockValue.setText(time);
    }
}
