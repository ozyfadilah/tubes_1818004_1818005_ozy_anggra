package com.example.tubes_1818004_1818005_ozy_anggra;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Pantai> movieItems;

    public CustomListAdapter(Activity activity, List<Pantai> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }
    @Override
    public int getCount() {
        return movieItems.size();
    }

    @Override
    public Object getItem(int location) {
        return  movieItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);
        TextView nama = (TextView) convertView.findViewById(R.id.text_nama);
        TextView alamat = (TextView) convertView.findViewById(R.id.text_alamat);
        TextView harga = (TextView) convertView.findViewById(R.id.text_harga);
        Pantai m = movieItems.get(position);
        nama.setText    ("Nama          : "+ m.get_nama());
        alamat.setText("Alamat        : "+ m.get_alamat());
        harga.setText   ("Harga Rp.   : "+ m.get_harga());
        return convertView;
    }
}

