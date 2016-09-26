package id.prihantoro.sayurongo.model;

/**
 * Created by Wahyu Prihantoro on 20-Sep-16.
 */
public class InvoiceItem {
    public String nama;
    public int harga;
    public int jumlah;

    public InvoiceItem(String nama, int harga, int jumlah) {
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    public String getNama() {
        return nama;
    }

    public String getRincian() {
        return harga + "/kg x " + jumlah;
    }

    public String getTotal() {
        return harga * jumlah + "";
    }
}
