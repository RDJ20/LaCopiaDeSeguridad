package com.example.cartera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity3 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        System.out.println("Hola");
    }
    // Esta codigo funciona para hacer que el boton cambie de Activity y es un metodo INICIO
    public void Ingresos(View View){
        Intent siguiente= new Intent(this, ingresos.class);
        startActivity(siguiente);
    }
    // Esta codigo funciona para hacer que el boton cambie de Activity FIN
    public void Gastos(View View){
        Intent siguiente= new Intent(this, Gastos.class);
        startActivity(siguiente);
    }

    public void Movimientos(View View){
        Intent siguiente= new Intent(this, Movimientos.class);
        startActivity(siguiente);
    }
}