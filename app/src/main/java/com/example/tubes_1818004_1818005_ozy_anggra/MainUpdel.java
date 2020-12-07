package com.example.tubes_1818004_1818005_ozy_anggra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama, Salamat, Sharga;
    private EditText Enama, Ealamat, Eharga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Salamat = i.getStringExtra("Ialamat");
        Sharga = i.getStringExtra("Iharga");
        Enama = (EditText) findViewById(R.id.updel_nama);
        Ealamat = (EditText) findViewById(R.id.updel_alamat);
        Eharga = (EditText) findViewById(R.id.updel_harga);
        Enama.setText(Snama);
        Ealamat.setText(Salamat);
        Eharga.setText(Sharga);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Salamat = String.valueOf(Ealamat.getText());
                Sharga = String.valueOf(Eharga.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama pantai",
                            Toast.LENGTH_SHORT).show();
                } else if (Salamat.equals("")){
                    Ealamat.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi alamat",
                            Toast.LENGTH_SHORT).show();
                } else if (Sharga.equals("")){
                    Eharga.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi harga tiket masuk",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateAnggota(new Pantai(Sid, Snama, Salamat, Sharga));
                    Toast.makeText(MainUpdel.this, "Data Pantai telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteAnggota (new Pantai(Sid, Snama, Salamat, Sharga));
                Toast.makeText(MainUpdel.this, "Data Pantai telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
