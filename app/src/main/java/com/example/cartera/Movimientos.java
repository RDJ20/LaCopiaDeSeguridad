package com.example.cartera;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class Movimientos extends AppCompatActivity {

    private Button mostrarlaycategoriamovi;
    private BottomSheetDialog bottomsheetcategoriamovi;
    TextView txtmovi;

    private Button mostrarlaycategoriamovi2;
    private BottomSheetDialog bottomsheetcategoriamovi2;
    TextView txtmovi2;



    // Lista de elementos provisionales oara la onda esat del recycler view
    List<ListElement> elements;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimientos);

        init();


        mostrarlaycategoriamovi=findViewById(R.id.botoncategoriamovi);
        txtmovi=findViewById(R.id.todotextview);

        mostrarlaycategoriamovi2=findViewById(R.id.button4);
        txtmovi2=findViewById(R.id.textView);


        mostrarlaycategoriamovi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                bottomsheetcategoriamovi= new  BottomSheetDialog(Movimientos.this,R.style.bottomtheme);

                //Esta parte de codigo indica que archivo XML dentro de las carpetas de layouts se va a usar "bottomsheet_layout"
                // y que Layout dentro del XML se va mostar "bottomsheet" o sea el layout mas grande, el principal xd el que contiene a todos
                View sheetView= LayoutInflater.from(getApplicationContext()).inflate(R.layout.movimientoscategoria,
                        (ViewGroup) findViewById(R.id.todoo));

                //Esta parte del codigo dice por ejemplo que cuando alguien haga click sobre el layout "hola" se va mostrar un mensaje o algo
                sheetView.findViewById(R.id.sueldo).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(Movimientos.this, "Categoria: Sueldo", Toast.LENGTH_SHORT).show();
                        bottomsheetcategoriamovi.dismiss();
                        txtmovi.setTextSize(30);
                        txtmovi.setText("Sueldo");

                    }
                });

                sheetView.findViewById(R.id.todo).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(Movimientos.this, "Categoria: Todo", Toast.LENGTH_SHORT).show();
                        bottomsheetcategoriamovi.dismiss();
                        txtmovi.setTextSize(30);
                        txtmovi.setText("Todo");

                    }
                });

                sheetView.findViewById(R.id.regalo).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(Movimientos.this, "Categoria: Regalo", Toast.LENGTH_SHORT).show();
                        bottomsheetcategoriamovi.dismiss();
                        txtmovi.setTextSize(30);
                        txtmovi.setText("Regalo");

                    }
                });

                sheetView.findViewById(R.id.venta).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(Movimientos.this, "Categoria: Ventas", Toast.LENGTH_SHORT).show();
                        bottomsheetcategoriamovi.dismiss();
                        txtmovi.setTextSize(30);
                        txtmovi.setText("Venta");
                    }
                });

                sheetView.findViewById(R.id.cielo).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(Movimientos.this, "Categoria: Bless", Toast.LENGTH_SHORT).show();
                        bottomsheetcategoriamovi.dismiss();
                        txtmovi.setTextSize(17);
                        txtmovi.setText("Me cayó del cielo");
                    }
                });

                //Esta parte del codigo dice por ejemplo que cuando alguien haga click sobre el layout "hola" se va mostrar un mensaje o algo
                sheetView.findViewById(R.id.agua).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(Movimientos.this, "Categoria: Agua", Toast.LENGTH_SHORT).show();
                        bottomsheetcategoriamovi.dismiss();
                        txtmovi.setTextSize(30);
                        txtmovi.setText("Agua");
                    }
                });

                sheetView.findViewById(R.id.electricidad).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(Movimientos.this, "Categoria: Electricidad", Toast.LENGTH_SHORT).show();
                        bottomsheetcategoriamovi.dismiss();
                        txtmovi.setTextSize(25);
                        txtmovi.setText("Electricidad");
                    }
                });

                sheetView.findViewById(R.id.comida).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(Movimientos.this, "Categoria: Comida", Toast.LENGTH_SHORT).show();
                        bottomsheetcategoriamovi.dismiss();
                        txtmovi.setTextSize(30);
                        txtmovi.setText("Comida");
                    }
                });

                sheetView.findViewById(R.id.casa).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(Movimientos.this, "Categoria: Compras para la Casa", Toast.LENGTH_SHORT).show();
                        bottomsheetcategoriamovi.dismiss();
                        txtmovi.setTextSize(12);
                        txtmovi.setText("Compras para la Casa");
                    }
                });

                sheetView.findViewById(R.id.otras).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(Movimientos.this, "Categoria: Otras", Toast.LENGTH_SHORT).show();
                        bottomsheetcategoriamovi.dismiss();
                        txtmovi.setTextSize(30);
                        txtmovi.setText("Otras");
                    }
                });


                bottomsheetcategoriamovi.setContentView(sheetView);
                //Para Mostrar el Bottom Sheet
                bottomsheetcategoriamovi.show();

            }
        });







        //Meses

        mostrarlaycategoriamovi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                bottomsheetcategoriamovi2= new  BottomSheetDialog(Movimientos.this,R.style.bottomtheme);

                //Esta parte de codigo indica que archivo XML dentro de las carpetas de layouts se va a usar "bottomsheet_layout"
                // y que Layout dentro del XML se va mostar "bottomsheet" o sea el layout mas grande, el principal xd el que contiene a todos
                View sheetView= LayoutInflater.from(getApplicationContext()).inflate(R.layout.mesescategoria,
                        (ViewGroup) findViewById(R.id.meses));

                //Esta parte del codigo dice por ejemplo que cuando alguien haga click sobre el layout "hola" se va mostrar un mensaje o algo
                sheetView.findViewById(R.id.enero).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(Movimientos.this, "Enero", Toast.LENGTH_SHORT).show();
                        bottomsheetcategoriamovi2.dismiss();
                        txtmovi2.setTextSize(30);
                        txtmovi2.setText("Enero");

                    }
                });

                sheetView.findViewById(R.id.febrero).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(Movimientos.this, "Febrero", Toast.LENGTH_SHORT).show();
                        bottomsheetcategoriamovi2.dismiss();
                        txtmovi2.setTextSize(30);
                        txtmovi2.setText("Febrero");

                    }
                });

                sheetView.findViewById(R.id.marzo).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(Movimientos.this, "Marzo", Toast.LENGTH_SHORT).show();
                        bottomsheetcategoriamovi2.dismiss();
                        txtmovi2.setTextSize(30);
                        txtmovi2.setText("Marzo");

                    }
                });

                sheetView.findViewById(R.id.abril).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(Movimientos.this, "Abril", Toast.LENGTH_SHORT).show();
                        bottomsheetcategoriamovi2.dismiss();
                        txtmovi2.setTextSize(30);
                        txtmovi2.setText("Abril");

                    }
                });

                sheetView.findViewById(R.id.mayo).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(Movimientos.this, "Mayo", Toast.LENGTH_SHORT).show();
                        bottomsheetcategoriamovi2.dismiss();
                        txtmovi2.setTextSize(30);
                        txtmovi2.setText("Mayo");

                    }
                });

                sheetView.findViewById(R.id.junio).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(Movimientos.this, "Junio", Toast.LENGTH_SHORT).show();
                        bottomsheetcategoriamovi2.dismiss();
                        txtmovi2.setTextSize(30);
                        txtmovi2.setText("Junio");

                    }
                });

                sheetView.findViewById(R.id.Julio).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(Movimientos.this, "Julio", Toast.LENGTH_SHORT).show();
                        bottomsheetcategoriamovi2.dismiss();
                        txtmovi2.setTextSize(30);
                        txtmovi2.setText("Julio");

                    }
                });
                sheetView.findViewById(R.id.agosto).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(Movimientos.this, "Agosto", Toast.LENGTH_SHORT).show();
                        bottomsheetcategoriamovi2.dismiss();
                        txtmovi2.setTextSize(30);
                        txtmovi2.setText("Agosto");

                    }
                });

                sheetView.findViewById(R.id.septiembre).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(Movimientos.this, "Septiembre", Toast.LENGTH_SHORT).show();
                        bottomsheetcategoriamovi2.dismiss();
                        txtmovi2.setTextSize(27);
                        txtmovi2.setText("Septiembre");

                    }
                });

                sheetView.findViewById(R.id.octubre).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(Movimientos.this, "Octubre", Toast.LENGTH_SHORT).show();
                        bottomsheetcategoriamovi2.dismiss();
                        txtmovi2.setTextSize(30);
                        txtmovi2.setText("Octubre");

                    }
                });

                sheetView.findViewById(R.id.noviembre).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(Movimientos.this, "Noviembre", Toast.LENGTH_SHORT).show();
                        bottomsheetcategoriamovi2.dismiss();
                        txtmovi2.setTextSize(27);
                        txtmovi2.setText("Noviembre");

                    }
                });

                sheetView.findViewById(R.id.diciembre).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(Movimientos.this, "Diciembre", Toast.LENGTH_SHORT).show();
                        bottomsheetcategoriamovi2.dismiss();
                        txtmovi2.setTextSize(27);
                        txtmovi2.setText("Diciembre");

                    }
                });

                bottomsheetcategoriamovi2.setContentView(sheetView);
                //Para Mostrar el Bottom Sheet
                bottomsheetcategoriamovi2.show();

            }
        });









    }

    public void Inicio(View View){
        Intent siguiente= new Intent(this, MainActivity3.class);
        startActivity(siguiente);
    }
    public void Gastos(View View){
        Intent siguiente= new Intent(this, Gastos.class);
        startActivity(siguiente);
    }
    public void Siguiente(View View){
        Intent siguiente= new Intent(this, ingresos.class);
        startActivity(siguiente);
    }
    public void Base(View View){
        Intent siguiente = new Intent(this, MainActivity.class);
        startActivity(siguiente);
    }




    public void init() {
        elements= new ArrayList<>();
        elements.add(new ListElement(592,null,"12 de octubre","45:11","Comida","prueba jeje"));
        elements.add(new ListElement(452,"credito","13 de octubre","46:11","Casa","prueba jje"));
        elements.add(new ListElement(45,"Efectivo","14 de octubre","85:11","Otras","prueba jejee"));

        ListAdapter listAdapter= new ListAdapter(elements, this);
        RecyclerView recyclerView= findViewById(R.id.laviureciclada);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }

}