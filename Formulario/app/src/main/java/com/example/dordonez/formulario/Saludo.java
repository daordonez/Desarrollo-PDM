package com.example.dordonez.formulario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Saludo extends AppCompatActivity {

    private Bundle recogida;
    private TextView salida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo);

        recogida = this.getIntent().getExtras();

        String nombrePasado = recogida.getString("Nombre");

        salida = (TextView)findViewById(R.id.textoMostar);

        salida.setText("Hola "+nombrePasado+" !. Bienvenido!");
    }
}
