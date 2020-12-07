package com.example.tubes_1818004_1818005_ozy_anggra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Pantai> ListPantai = new ArrayList<Pantai>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListPantai );
        mListView = (ListView) findViewById(R.id.list_Pantai);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListPantai.clear();
        List<Pantai> contacts = db.ReadPantai();
        for (Pantai cn : contacts) {
            Pantai judulModel = new Pantai();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_alamat(cn.get_alamat());
            judulModel.set_harga(cn.get_harga());
            ListPantai.add(judulModel);
            if ((ListPantai.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada Pantai",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Pantai obj_itemDetails = (Pantai) o;
        String Sid = obj_itemDetails.get_id();
        String Snama = obj_itemDetails.get_nama();
        String Salamat = obj_itemDetails.get_alamat();
        String Sharga = obj_itemDetails.get_harga();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Ialamat", Salamat);
        goUpdel.putExtra("Iharga", Sharga);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListPantai.clear();
        mListView.setAdapter(adapter_off);
        List<Pantai> contacts = db.ReadPantai();
        for (Pantai cn : contacts) {
            Pantai judulModel = new Pantai();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_alamat(cn.get_alamat());
            judulModel.set_harga(cn.get_harga());
            ListPantai.add(judulModel);
            if ((ListPantai.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada Pantai",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
