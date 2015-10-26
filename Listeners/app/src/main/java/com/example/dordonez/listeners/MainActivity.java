package com.example.dordonez.listeners;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button botonON, botonOFF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creación de la ventana emergente, es necesario indiciarle en que constexto
        //está, en este caso el mismo donde estamos
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);

        //Establecer el titulo de la ventan emergente
        dialogo.setTitle("Borrar archivo");
        //Pregunta que se realiza mediante el mensaje
        dialogo.setMessage("Estás seguro?");
        //¿?
        dialogo.setCancelable(false);


        dialogo.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo, int id) {
                aceptar();
            }
        });

        dialogo.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo, int id){
                cancelar();
            }
        });

        dialogo.show();
    }


    //Evento cuadno se acepta el allert
    public void aceptar() {
        Toast aviso = Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT);
        aviso.show();
    }

    public void cancelar() {
        finish();
    }


}
