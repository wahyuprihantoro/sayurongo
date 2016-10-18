package id.prihantoro.sayurongo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wahyu Prihantoro on 18-Oct-16.
 */
public class Invoice implements Serializable {
    public List<InvoiceItem> invoices;

    public Invoice(List<InvoiceItem> invoices) {
        this.invoices = invoices;
    }

    public Invoice() {
        invoices = new ArrayList<>();
    }

    public void addInvoice(InvoiceItem item) {
        invoices.add(item);
    }

    public List<InvoiceItem> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<InvoiceItem> invoices) {
        this.invoices = invoices;
    }
}
