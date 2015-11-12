package com.example.dordonez.threads;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    public ProgressBar miProgress;
    public EditText resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        miProgress = (ProgressBar)findViewById(R.id.progressBar);
        resultado = (EditText)findViewById(R.id.resultado);
    }

   public void longCalculationWithoutThreads(View v){
       Log.v("MY LOG", "En LongCalculation():" + Thread.currentThread().getId());
       try{
           Thread.currentThread().sleep(4000);

       }catch (InterruptedException e){

           resultado.setText("Finished long Calculations");
       }
   }

    public void longCalulationWithThreats(View v){
        (new Thread(){
            public void run(){
                    Log.v("MYLOG","En longCalculation():" +Thread.currentThread().getId()); for (int i=1; i<=4; i++) {
                        try {
                            Thread.currentThread();
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {} final int j = i;
                        miProgress.post(new Runnable () {
                            public void run() {
                                resultado.setText("Working long calculations with threads " + j); miProgress.incrementProgressBy(25);
                            } });
                    }
                //Problema de acceso al thread principal
                //resultado.setText("Working long calculations with threads ");
            }
        }).start();
    }

    public void longCalculationWithAsynTask(View v){

        Long parameter = (long) 4000;
        MyAsyncTask mAsyncTask = new MyAsyncTask();
         mAsyncTask.execute(parameter);
    }




}
