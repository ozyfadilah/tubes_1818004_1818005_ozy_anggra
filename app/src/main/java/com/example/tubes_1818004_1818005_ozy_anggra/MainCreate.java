package com.example.tubes_1818004_1818005_ozy_anggra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enama, Ealamat, Eharga;
    private String Snama, Salamat, Sharga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Enama = (EditText) findViewById(R.id.create_nama);
        Ealamat = (EditText) findViewById(R.id.create_alamat);
        Eharga = (EditText) findViewById(R.id.create_harga);
        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Salamat = String.valueOf(Ealamat.getText());
                Sharga = String.valueOf(Eharga.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama pantai",
                            Toast.LENGTH_SHORT).show();
                } else if (Salamat.equals("")){
                    Ealamat.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi alamat",
                            Toast.LENGTH_SHORT).show();
                } else if (Sharga.equals("")) {
                    Eharga.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi harga",
                            Toast.LENGTH_SHORT).show();
                }else {
                    Enama.setText("");
                    Ealamat.setText("");
                    Eharga.setText("");
                    Toast.makeText(MainCreate.this, "Pantai telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateAnggota (new Pantai(null, Snama, Salamat, Sharga));
                    Intent a = new Intent(MainCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}
