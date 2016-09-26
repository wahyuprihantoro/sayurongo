package id.prihantoro.sayurongo.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import id.prihantoro.sayurongo.R;
import id.prihantoro.sayurongo.model.InvoiceItem;

/**
 * Created by Wahyu Prihantoro on 20-Sep-16.
 */
@EViewGroup(R.layout.layout_invoice_item)
public class InvoiceItemView extends RelativeLayout {

    public InvoiceItem item;
    @ViewById
    TextView nama;
    @ViewById
    TextView total;
    @ViewById
    TextView rincian;

    public InvoiceItemView(Context context, InvoiceItem item) {
        super(context);
        this.item = item;
    }

    public InvoiceItemView(Context context, AttributeSet attrs, InvoiceItem item) {
        super(context, attrs);
        this.item = item;
    }

    public InvoiceItemView(Context context, AttributeSet attrs, int defStyleAttr, InvoiceItem item) {
        super(context, attrs, defStyleAttr);
        this.item = item;
    }

    @AfterViews
    void init() {
        nama.setText(item.getNama());
        rincian.setText(item.getRincian());
        total.setText(item.getTotal());
    }
}
