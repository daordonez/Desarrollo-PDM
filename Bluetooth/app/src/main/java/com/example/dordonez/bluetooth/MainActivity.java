package com.example.dordonez.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Atributos de clase

    private static final int REQUEST_ENABLE_BLUETOOTH = 0;
    private static final int REQUEST_DISCOVERABLE_BLUETOOTH = 0;

    final BluetoothAdapter miBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    Button btnON, btnOf, btnDiscover;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asociar botones de la clase con los del layout
        btnON = (Button)findViewById(R.id.btnEncender);
        btnOf = (Button)findViewById(R.id.btnApagar);
        btnDiscover = (Button)findViewById(R.id.btnDescubrir);
    }

    //Listeners para los botones
    //Encender
    public void bthON(View v){
        if (!miBluetoothAdapter.isEnabled()){
            //Crea intent para encenderlo en el caso de que este apagado
            Intent intentActivar = new Intent(miBluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(intentActivar,REQUEST_ENABLE_BLUETOOTH);
        }
    }
    public void bthOFF(View v){
        //Desconecta el bt
        miBluetoothAdapter.disable();
        //Situar donde ha tenido lugar la acción
        Context context = getApplicationContext();
        CharSequence texto = "TURNING_OFF BLUETOOTH";
        int duracion = Toast.LENGTH_LONG;
        //Avisar al usuario que se ha apagado el bluetooth
        //Se le pasa al toast el contexto donde se tiene que mostrar , la cadena par amostrar y el
        //tiempo
        Toast toast = Toast.makeText(context,texto,duracion);
        toast.show();
    }

    public void bthDiscover(View v){
        //Si no esta activa la acción de poder descubrir el dispositivo
        if(!miBluetoothAdapter.isDiscovering()){
            //Hacerlo visible
            Context context = getApplicationContext();
            //Texto a mostrar tras hacerlo visible
            CharSequence text = "TU DISPOSITIVO ES AHORA VISIVLE";
            int duracionToast = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context,text,duracionToast);
            toast.show();

            //AHORA ENVIA PETICION DE ACTIVAR VISIBILIDAD

            Intent activarVisibilidad = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
            startActivityForResult(activarVisibilidad,REQUEST_DISCOVERABLE_BLUETOOTH);
        }
    }

}
