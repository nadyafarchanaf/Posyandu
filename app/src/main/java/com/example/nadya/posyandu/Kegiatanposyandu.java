package com.example.nadya.posyandu;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Kegiatanposyandu extends AppCompatActivity {
    private List<Imunisasi> imunisasiList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ImunisasiAdapter iAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kegiatanposyandu);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        iAdapter = new ImunisasiAdapter(imunisasiList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(iAdapter);

        prepareImunisasiData();
    }

    private void prepareImunisasiData() {
        Imunisasi imunisasi = new Imunisasi("Hepatitis B-1", "Baru lahir");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("Polio-0", "Baru lahir");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("BCG", "1 Bulan");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("Hepatitis-2", "2 Bulan");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("DPT-1", "2 Bulan");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("HIB-1", "2 Bulan");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("PCV-1", "2 Bulan");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("PCV-1", "2 Bulan");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("Rotavirus", "2 Bulan");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("Hepatitis-3", "3 Bulan");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("Polio-2", "3 Bulan");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("DPT-2", "3 Bulan");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("HIB-2", "3 Bulan");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("Hepatitis-4", "4 Bulan");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("Polio-3", "4 Bulan");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("IPV", "4 Bulan");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("DPT-3", "4 Bulan");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("HIB-3", "4 Bulan");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("PCV-2", "4 Bulan");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("Rotavirus-2", "4 Bulan");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("PCV-3", "6 Bulan");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("Rotavirus-3", "6 Bulan");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("Influenza", "6 Bulan");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("Campak-1", "9 Bulan");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("PCV-4", "12 Bulan");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("Varisela", "12 Bulan");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("Japanesse Ensefalitis", "12 Bulan");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("Campak-2", "18 Bulan");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("Polio-4", "18 Bulan");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("DPT-4", "18 Bulan");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("HIB-4", "18 Bulan");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("Japanesse Ensefalitis-2", "24 Bulan");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("Tifoid-1", "24 Bulan");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("Hepatitis A-1", "24 Bulan");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("Hepatitis A-2", "30 Bulan");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("DPT-5", "5 Tahun");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("MMR-2", "5 Tahun");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("Tifoid-2", "5 Tahun");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("Campak-3", "6 Tahun");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("Tifoid-3", "8 Tahun");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("Dengue-1", "9 Tahun");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("Dengue-2", "9.5 Tahun");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("Dengue-3", "10 Tahun");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("DPT-6", "10 Tahun");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("HPV-1", "10 Tahun");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("HPV-2", "10.5 Tahun");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("Tifoid-4", "11 Tahun");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("Tifoid-5", "14 Tahun");
        imunisasiList.add(imunisasi);

        imunisasi = new Imunisasi("Tifoid-6", "17 Tahun");

        imunisasi = new Imunisasi("DPT-7", "18 Tahun");
        imunisasiList.add(imunisasi);

        iAdapter.notifyDataSetChanged();
    }
}