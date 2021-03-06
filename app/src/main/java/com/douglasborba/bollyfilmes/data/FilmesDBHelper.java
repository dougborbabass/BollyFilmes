package com.douglasborba.bollyfilmes.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class FilmesDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "bollyfilmes.db";

    public FilmesDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlTableFilmes = "CREATE TABLE " + FilmesContract.FilmeEntry.TABLE_NAME + " (" +
                FilmesContract.FilmeEntry._ID + " INTEGER PRIMARY KEY, " +
                FilmesContract.FilmeEntry.COLUMN_TITULO + " TEXT NOT NULL, " +
                FilmesContract.FilmeEntry.COLUMN_DESCRICAO + " TEXT NOT NULL, " +
                FilmesContract.FilmeEntry.COLUMN_POSTER_PATH + " TEXT NOT NULL, " +
                FilmesContract.FilmeEntry.COLUMN_CAPA_PATH + " TEXT NOT NULL, " +
                FilmesContract.FilmeEntry.COLUMN_AVALIACAO + " REAL " + ");";

        sqLiteDatabase.execSQL(sqlTableFilmes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + FilmesContract.FilmeEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
