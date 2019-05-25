package com.example.nadya.posyandu.Model;

import java.util.Date;

public class Anak extends User{
    int idIbu;
    Date tanggal_lahir;

    public  Anak(){}

    public Anak(int id, String nama, int idIbu, Date tanggal_lahir) {
        super(id, nama);
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public String getNama() {
        return super.getNama();
    }

    @Override
    public void setNama(String nama) {
        super.setNama(nama);
    }

    public int getIdIbu() {
        return idIbu;
    }

    public void setIdIbu(int idIbu) {
        this.idIbu = idIbu;
    }

    public Date getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(Date tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }
}