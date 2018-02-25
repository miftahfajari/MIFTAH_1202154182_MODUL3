package com.example.mtahfajar.miftah_1202154182_modul3;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Miftah on 25/02/2018.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView tv1, tv2;
    CardView cardView;
    ItemClickListener itemClickListener;


    public RecyclerViewHolder(View itemView) {
        super(itemView);

        tv1 = (TextView) itemView.findViewById(R.id.daftar_judul);
        tv2 = (TextView) itemView.findViewById(R.id.daftar_deskripsi);
        cardView = (CardView) itemView.findViewById(R.id.cardView);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        this.itemClickListener.onItemClick(this.getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
