package com.example.mtahfajar.miftah_1202154182_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Miftah on 25/02/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    Context c;
    ArrayList<AirMineral> airMineral;


    public RecyclerAdapter(Context c, ArrayList<AirMineral> airMineral) {
        this.c = c;
        this.airMineral = airMineral;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        final String nama = airMineral.get(position).getNama();
        final String deskripsi = airMineral.get(position).getDeskripsi();
        final int image = airMineral.get(position).getImage();

        holder.tv1.setText(nama);
        //holder.tv2.setText(deskripsi);
        holder.cardView.setBackgroundResource(image);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                openDetailActivity(nama, deskripsi, image);
                Toast.makeText(c, nama, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return airMineral.size();
    }

    private void openDetailActivity(String name, String harga, int image) {
        Intent i = new Intent(c.getApplicationContext(), DetailMenuActivity.class);
        i.putExtra("nama", name);
        i.putExtra("deskripsi", harga);
        i.putExtra("gambar", image);
        c.startActivity(i);
    }
}
