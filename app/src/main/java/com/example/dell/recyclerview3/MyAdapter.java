package com.example.dell.recyclerview3;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Dell on 6/5/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private String[] data;
    View row;

    public MyAdapter(Context context, String[] data) {
        this.context = context;
        this.data = data;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        row = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        Item i = new Item(row,context,data);
        return i;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ((Item) holder).t1.setText(data[position]);
        ((Item) holder).b1.setText("<  >");

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class Item extends RecyclerView.ViewHolder implements View.OnClickListener {

        private String[] data;
        private Context context;
        TextView t1;
        Button b1;

        public Item(View itemView, Context context, String[] data) {
            super(itemView);
            this.data = data;
            this.context = context;
            itemView.setOnClickListener(this);
            t1 = (TextView) itemView.findViewById(R.id.name);
            b1 = (Button) itemView.findViewById(R.id.b1);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            this.context.startActivity(new Intent(this.context,Display.class).putExtra("pos",data[position]));

        }
    }
}
