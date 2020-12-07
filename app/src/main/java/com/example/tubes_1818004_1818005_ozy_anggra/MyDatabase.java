package com.example.tubes_1818004_1818005_ozy_anggra;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_pantaiMLG";
    private static final String tb_pantai = "tb_pantai";
    private static final String tb_pantai_id = "id";
    private static final String tb_pantai_nama = "nama";
    private static final String tb_pantai_alamat = "alamat";
    private static final String tb_pantai_harga = "harga";
    private static final String CREATE_TABLE_ANGGOTA = "CREATE TABLE " +
            tb_pantai + "("
            + tb_pantai_id + " INTEGER PRIMARY KEY ,"
            + tb_pantai_nama + " TEXT,"
            + tb_pantai_alamat + " TEXT,"
            + tb_pantai_harga+ " TEXT " + ")";

    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ANGGOTA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CreateAnggota (Pantai mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_pantai_id, mdNotif.get_id());
        values.put(tb_pantai_nama, mdNotif.get_nama());
        values.put(tb_pantai_alamat, mdNotif.get_alamat());
        values.put(tb_pantai_harga, mdNotif.get_harga());
        db.insert(tb_pantai, null, values);
        db.close();
    }

    public List<Pantai> ReadPantai() {
        List<Pantai> judulModelList = new ArrayList<Pantai>();
        String selectQuery = "SELECT * FROM " + tb_pantai;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Pantai mdKontak = new Pantai();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_nama(cursor.getString(1));
                mdKontak.set_alamat(cursor.getString(2));
                mdKontak.set_harga(cursor.getString(3));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }
    public int UpdateAnggota (Pantai mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_pantai_nama, mdNotif.get_nama());
        values.put(tb_pantai_alamat, mdNotif.get_alamat());
        values.put(tb_pantai_harga, mdNotif.get_harga());
        return db.update(tb_pantai, values, tb_pantai_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }
    public void DeleteAnggota (Pantai mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_pantai, tb_pantai_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}
