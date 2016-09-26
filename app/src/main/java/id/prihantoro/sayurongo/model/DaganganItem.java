package id.prihantoro.sayurongo.model;

/**
 * Created by Wahyu Prihantoro on 20-Sep-16.
 */
public class DaganganItem {
    public String nama;
    public String sisa;
    public String harga;

    public DaganganItem(String nama, String sisa, String harga) {
        this.nama = nama;
        this.sisa = sisa;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSisa() {
        return sisa;
    }

    public void setSisa(String sisa) {
        this.sisa = sisa;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
}
