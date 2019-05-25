package com.example.nadya.posyandu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ImunisasiAdapter extends RecyclerView.Adapter<ImunisasiAdapter.MyViewHolder> {

    private List<Imunisasi> imunisasiList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView namaimunisasi, waktu;

        public MyViewHolder(View view) {
            super(view);
            namaimunisasi = (TextView) view.findViewById(R.id.namaimunisasi);
            waktu = (TextView) view.findViewById(R.id.waktu);
        }
    }


    public ImunisasiAdapter(List<Imunisasi> imunisasiList) {
        this.imunisasiList = imunisasiList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.imunisasilist, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Imunisasi namaimunisasi = imunisasiList.get(position);
        holder.namaimunisasi.setText(namaimunisasi.getImunisasi());
        holder.waktu.setText(namaimunisasi.getWaktu());
    }

    @Override
    public int getItemCount() {
        return imunisasiList.size();
    }
}

