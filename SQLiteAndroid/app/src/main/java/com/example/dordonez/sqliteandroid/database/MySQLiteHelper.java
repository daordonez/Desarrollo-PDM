package com.example.dordonez.sqliteandroid.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MySQLiteHelper extends SQLiteOpenHelper {

    //Constantes
    private static final String DATABASE_NAME = "Empresa";
    private static final int DATABASE_VERSION = 1;

    //SQL para crear database
    String sqlCreate = "CREATE TABLE Clients(codi INTEGER,nom TEXT" +
            "LAT REAL,Lon REAL)";

    //Constructor. Ejecutar la sentencia declarada antes

    public MySQLiteHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(sqlCreate);
    }

    //Si la versión de la BD ha sido incrementada en el codigo de la
    //aplicación, entonces borra la versión previa

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion){
        //Borrado
        db.execSQL("DROP TABLE IF EXISTS Clients");
        db.execSQL(sqlCreate);
    }

}
