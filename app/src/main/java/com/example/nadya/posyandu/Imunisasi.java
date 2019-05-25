package com.example.nadya.posyandu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;


public class Imunisasi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kegiatanposyandu);
    }

    private String namaimunisasi, waktu;

    public Imunisasi() {
    }

    public Imunisasi(String namaimunisasi, String waktu) {
        this.namaimunisasi = namaimunisasi;
        this.waktu = waktu;
    }

    public String getImunisasi() {
        return namaimunisasi;
    }

    public void setImunisasi(String name) {
        this.namaimunisasi = name;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu ) {
        this.waktu = waktu;
    }
}