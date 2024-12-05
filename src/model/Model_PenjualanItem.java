package model;

import java.text.DateFormat;

public class Model_PenjualanItem {

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public DateFormat getTanggal() {
        return tanggal;
    }

    public void setTanggal(DateFormat tanggal) {
        this.tanggal = tanggal;
    }

    public String getKodeProduk() {
        return kodeProduk;
    }

    public void setKodeProduk(String kodeProduk) {
        this.kodeProduk = kodeProduk;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
    private String idTransaksi;
    private DateFormat tanggal;
    private String kodeProduk;
    private String namaProduk;
    private int jumlah;
    private double harga;

    // Constructor dan getter/setter
    public Model_PenjualanItem(String idTransaksi, DateFormat tanggal, String kodeProduk, String namaProduk, int jumlah, double harga) {
        this.idTransaksi = idTransaksi;
        this.tanggal = tanggal;
        this.kodeProduk = kodeProduk;
        this.namaProduk = namaProduk;
        this.jumlah = jumlah;
        this.harga = harga;
    }

    // ... (getter dan setter untuk setiap atribut)

    public double getTotalHarga() {
        return jumlah * harga;
    }
}