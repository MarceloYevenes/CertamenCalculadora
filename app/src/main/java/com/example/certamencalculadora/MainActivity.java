package com.example.certamencalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button NumerosRandom, borrar, sumar, restar, multiplicar, dividir,esPar, esPrimo;
    TextView Num1, Num2, parPrimo, r_fimal, Sig;
    int numero1, numero2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NumerosRandom = findViewById(R.id.NumerosRandom);

        //DEFINICION AREAS DE TEXTO NUMEROS RANDOM//
        Num1=findViewById(R.id.Num1);
        Num2=findViewById(R.id.Num2);
        Sig = findViewById(R.id.Sig);

        //DEFINICION AREAS DE TEXTO PAR/PRIMO//
        parPrimo = findViewById(R.id.parPrimo);
        r_fimal = findViewById(R.id.r_final);

        //OPERACIONES
        borrar = findViewById(R.id.borrar);
        sumar = findViewById(R.id.sumar);
        multiplicar = findViewById(R.id.mult);
        dividir = findViewById(R.id.div);
        restar = findViewById(R.id.restar);

        esPar = findViewById(R.id.esPar);
        esPrimo = findViewById(R.id.esPrimo);


        //AL PRESIONAR EL BÓTON SE GENERAN LOS NUMEROS RANDOM//
        NumerosRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r = new Random();
                numero1 = r.nextInt(100);
                numero2 = r.nextInt(100);

                String num1= String.valueOf(numero1);
                String num2= String.valueOf(numero2);

                Num1.setText(num1);
                Num2.setText(num2);
            }
        });

        //FUNCION LIMPIAR CAMPOS DE TEXTO
        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Num1.setText("Num1");
                Num2.setText("Num2");
                parPrimo.setText("---");
                r_fimal.setText("00");
                Sig.setText("?");
            }
        });

        //FUNCION SUMAR NUMEROS//
        sumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if( Num1.getText().equals("Num1")){
                    parPrimo.setText("Error");
                    r_fimal.setText("Error");
                }else
                {
                    int res=numero1+numero2;
                    Sig.setText("+");
                    r_fimal.setText(res+"");
                    parPrimo.setText("---");
            }


            }
        });

        //FUNCION PARA MULTIPLICAR
        multiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if( Num1.getText().equals("Num1")){
                    parPrimo.setText("Error");
                    r_fimal.setText("Error");
                }else
                {
                    int res=numero1*numero2;
                    Sig.setText("X");
                    r_fimal.setText(res+"");
                    parPrimo.setText("---");
                }


            }
        });
        //FUNCION PARA DIVIDIR
        dividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if( Num1.getText().equals("Num1")){
                    parPrimo.setText("Error");
                    r_fimal.setText("Error");
                }else if(numero2==0){
                    parPrimo.setText("Error");
                    r_fimal.setText("Division por 0");
                }

                else
                {
                    float res=(float)numero1/numero2;
                    Sig.setText("/");
                    r_fimal.setText(res+"");
                    parPrimo.setText("---");
                }

            }
        });

        restar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if( Num1.getText().equals("Num1")){
                    parPrimo.setText("Error");
                    r_fimal.setText("Error");
                }else
                {
                    int res=numero1-numero2;
                    Sig.setText("-");
                    r_fimal.setText(res+"");
                    parPrimo.setText("---");
                }


            }
        });

        esPar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if( r_fimal.getText().toString().equals("---") ||r_fimal.getText().toString().equals("Error") || r_fimal.getText().toString().equals("00")){
                    parPrimo.setText("Error");
                    r_fimal.setText("Error");
                }else {
                    int convertir = Integer.parseInt(r_fimal.getText().toString());
                    if (convertir % 2 == 0) {
                        parPrimo.setText("Es par");

                    } else {
                        parPrimo.setText("No es par");
                    }
                }
            }
        });

        esPrimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean comprobar=false;
                int contador=0;
                if( r_fimal.getText().toString().equals("---") ||r_fimal.getText().toString().equals("Error") || r_fimal.getText().toString().equals("00")){
                    parPrimo.setText("Error");
                    r_fimal.setText("Error");
                }else {
                    int convertir = Integer.parseInt(r_fimal.getText().toString());
                    for(int i=1; i<10; i=i+1){
                        if(convertir%i==0 && convertir!=convertir){
                            contador++;
                        }
                    }

                    if (contador==1){
                        parPrimo.setText("Es primo");

                    } else {
                        parPrimo.setText("No es primo");
                    }
                }
            }
        });







    }
}
