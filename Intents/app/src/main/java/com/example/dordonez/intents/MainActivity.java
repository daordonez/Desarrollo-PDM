package com.example.dordonez.intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void photo(View v){
        //Destino de las fotos
        String mediaStorageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath();
        //Nombre para las fotos que se generen
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.ENGLISH).format(new Date());
        //Uri del nuevo fichero que se genera
        Uri uriFichero = Uri.fromFile(new java.io.File(mediaStorageDir + File.separator + "IMG_"+timeStamp+".jpg"));

        //Declaración del intent
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //Información al intent
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,uriFichero);

        //Lanzar el activity
        startActivityForResult(cameraIntent,1);

    }

    public void elPais(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        String urlElPais = "http://www.elpais.com";
        intent.setData(Uri.parse(urlElPais));
        startActivity(intent);
    }
}
