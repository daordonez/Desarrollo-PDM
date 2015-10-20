package com.example.dordonez.formulario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText datoEntrada;
    private Button enviarBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaración de entrada
        datoEntrada  = (EditText)findViewById(R.id.datoEntrada);
        //boton enviar

        enviarBtn = (Button)findViewById(R.id.btnMostrar);
    }

    //Oyente botón
    public void capturaCadena(View v){
        Intent intent = new Intent(MainActivity.this, Saludo.class);
        Bundle bund = new Bundle();
        bund.putString("Nombre", String.valueOf(datoEntrada.getText()));
        intent.putExtras(bund);
        startActivity(intent);
    }
}
