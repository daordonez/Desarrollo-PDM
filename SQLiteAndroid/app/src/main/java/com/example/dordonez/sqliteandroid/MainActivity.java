package com.example.dordonez.sqliteandroid;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.dordonez.sqliteandroid.database.MySQLiteHelper;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //SQLite Code

        MySQLiteHelper conexion = new MySQLiteHelper(this);

        //Modo escritura
        SQLiteDatabase db = conexion.getWritableDatabase();

        //Generar registros para la BD
        //Si no es nula la respuesta de la creación de la BD

        Random alea = new Random();
        double a = alea.nextDouble();
        if (db != null){
            for (int i=1; i<=3 ;i++){
                int codi = i;
                String nom = "Vicent"+i;
                //Ubicación
                double lat = (double)a*i;
                double lon = (double)a*i;

                db.execSQL("INSERT INTO Clients(codi,nom,Lat,Lon)" +
                        "VALUES("+codi+","+nom+","+lat+","+lon+")");
                //Cerrar la DB
                db.close();
            }
        }




        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

    }
}
