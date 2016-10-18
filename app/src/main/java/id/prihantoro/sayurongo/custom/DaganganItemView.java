package id.prihantoro.sayurongo.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import id.prihantoro.sayurongo.R;
import id.prihantoro.sayurongo.model.DaganganItem;
import id.prihantoro.sayurongo.model.InvoiceItem;

/**
 * Created by Wahyu Prihantoro on 20-Sep-16.
 */
@EViewGroup(R.layout.layout_dagangan_item)
public class DaganganItemView extends RelativeLayout {

    public DaganganItem item;
    @ViewById
    TextView nama;
    @ViewById
    TextView sisa;
    @ViewById
    TextView harga;
    @ViewById
    ImageView add;
    @ViewById
    ImageView minus;
    @ViewById(R.id.value)
    EditText value;

    public DaganganItemView(Context context, DaganganItem item) {
        super(context);
        this.item = item;
    }

    public DaganganItemView(Context context, AttributeSet attrs, DaganganItem item) {
        super(context, attrs);
        this.item = item;
    }

    public DaganganItemView(Context context, AttributeSet attrs, int defStyleAttr, DaganganItem item) {
        super(context, attrs, defStyleAttr);
        this.item = item;
    }

    public InvoiceItem getInvoice() {
        int harga = Integer.parseInt(item.harga.substring(0, item.harga.length() - 3));
        InvoiceItem invoiceItem = new InvoiceItem(item.nama, harga, 0);
        invoiceItem.jumlah = Integer.parseInt(value.getText().toString());
        return invoiceItem;
    }

    @AfterViews
    void init() {
        nama.setText(item.nama);
        sisa.setText(item.sisa);
        harga.setText(item.harga);
        value.setText("0");
    }

    @Click
    public void add() {
        int val = Integer.parseInt(value.getText().toString());
        val++;
        value.setText("" + val);
    }

    @Click
    public void minus() {
        int val = Integer.parseInt(value.getText().toString());
        if (val > 0) {
            val--;
        }
        value.setText("" + val);
    }
}
