package com.example.dordonez.primos;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText numEntrada1, numEntrada2;
    private TextView resultSalida;

    private static ArrayList<Integer> intervaloPrimos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        numEntrada1 = (EditText) findViewById(R.id.entraNum1);
        numEntrada2 = (EditText) findViewById(R.id.entradaNum2);
        resultSalida = (TextView) findViewById(R.id.resultadoPrimo);

    }


    public void botonPrimo(View v){

        Integer num1 = Integer.parseInt(numEntrada1.getText().toString());
        Integer num2 = Integer.parseInt(numEntrada2.getText().toString());

        int nAnaliz1 = (int)num1;
        int nAnaliz2 = (int)num2;



        if (nAnaliz1 == 0  || nAnaliz2 == 0){
            resultSalida.setText("NO permitido");
        }else {



            //Busca numeros en intervalo dado
            intervalo(nAnaliz1, nAnaliz2);

            //Imprimiles si hay

            if (intervaloPrimos.isEmpty()){
                resultSalida.setText("No existen primos en el intervalo ["+nAnaliz1+"]-["+nAnaliz2+"]");
            }else{

                Log.d("Depuracion","ANTES de for concatenador de cadena");
                //En el caso de que existan valores


                Log.d("Depuracion","Longitud intervaloPrimos"+intervaloPrimos.size());

                String  cadenaMost = "";
                for(Integer numPrimo: intervaloPrimos){

                    cadenaMost.concat(numPrimo.toString());
                }

                Log.d("Depuracion","DESPUES de for concatenador de cadena");
                resultSalida.setText(cadenaMost);
            }

        }
    }


    private static void intervalo(int inic, int fin){


        Log.d("Depuracion","INIC: "+inic+" FIN: "+fin);


        for (int i = inic; i < fin;i++){
            if(primo(i)){
                //System.out.println("PRIMO [ "+i+" ]");
                Log.d("Depuracion","valor i: "+i);
                intervaloPrimos.add(i);
            }
         }
    }

    private static boolean primo(int n){

        boolean isPrimo = true;

        for(int i = 2; i < n; i++){
            //Comprobar si es primo
            if (n % i == 0){
                isPrimo = false;
            }
        }

        return isPrimo;
    }

}
