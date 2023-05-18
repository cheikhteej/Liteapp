package com.example.liteapp;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mon_blog";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Créez votre table ici
        String createTableQuery = "CREATE TABLE Article (id INTEGER PRIMARY KEY,  titre varchar(255), contenu TEXT)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Mettez à niveau votre table ici si nécessaire
        String upgradeTableQuery = "DROP TABLE IF EXISTS mytable";
        db.execSQL(upgradeTableQuery);
        onCreate(db);
    }

    public long insertArticle(int id, String titre, String contenu) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("id", id);
        values.put("titre", titre);
        values.put("contenu", contenu);

        long rowId = db.insert("articles", null, values);

        db.close();

        return rowId;
    }

}
