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
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;


import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class Movimientos extends AppCompatActivity {


    //Se crean las variables para el boton y el recycler view
    RecyclerView recyclerView;



    SwipeRefreshLayout swipeRefreshLayout;

    // Creo un objeto de MyDataBase para usar el readAll
    MyDatabaseHelper myDB;
    ArrayList<String> metodo_input, categoria_input, hora_input, fecha_input, cantidad_input, descripcion_input;
    CustomAdapter customAdapter;



    private Button mostrarlaycategoriamovi;
    private BottomSheetDialog bottomsheetcategoriamovi;
    TextView txtmovi;

    private Button mostrarlaycategoriamovi2;
    private BottomSheetDialog bottomsheetcategoriamovi2;
    TextView txtmovi2;

    private Button mostrarlaycategoriamovi3;
    private BottomSheetDialog bottomsheetcategoriamovi3;
    TextView txtmovi3;



    // Lista de elementos provisionales oara la onda esat del recycler view
    List<ListElement> elements;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimientos);


        swipeRefreshLayout=findViewById(R.id.SwipeUp);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //Como aqui se repite lo que se van a poner en los ietms de las cardview
                // entonces tenemos que limpiar los arraylist de los datos que ya tenian para poder
                //imprimirlos otra vez
               metodo_input.clear(); ;
               categoria_input.clear();
               hora_input.clear();
               fecha_input.clear();
               cantidad_input.clear();
               descripcion_input.clear();

               // aqui se copia y se quita el void de lo que vedria siendo el storeDataInArrays
                // solo para que nos ejecute el metodo de la base de datos y nos agregue campos a los arraylist
                    //Declaro un objero Cursor y le= dijo que iba a ser igual al metodo de MyDatabAse readAllData
                    Cursor cursor = myDB.readAllDta();
                    if(cursor.getCount() == 0){

                    }else{
                        while (cursor.moveToNext()){
                            // Aqui obtiene los datos de los array y los pone en cada columna de la tabla
                            cantidad_input.add(cursor.getString(1));
                            metodo_input.add(cursor.getString(2));
                            fecha_input.add(cursor.getString(3));
                            hora_input.add(cursor.getString(4));
                            categoria_input.add(cursor.getString(5));
                            descripcion_input.add(cursor.getString(6));
                            System.out.println("hola: "+cantidad_input);
                        }
                        customAdapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);

                }
            }
        });

        // Se les busca por su ID
        recyclerView = findViewById(R.id.laviureciclada);

// instancio la variable de MyBaseData  y le puso contesto aqui
        myDB = new MyDatabaseHelper(Movimientos.this);
        //inicializo los arraylist
        cantidad_input = new ArrayList<>();
        metodo_input = new ArrayList<>();
        fecha_input = new ArrayList<>();
        hora_input = new ArrayList<>();
        categoria_input = new ArrayList<>();
        descripcion_input = new ArrayList<>();


        storeDataInArrays();

        customAdapter = new CustomAdapter(Movimientos.this,this, cantidad_input, metodo_input, fecha_input, hora_input,
                categoria_input, descripcion_input);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Movimientos.this));


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
                sheetView.findViewById(R.id.todo).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(Movimientos.this, "Categoria: Todo", Toast.LENGTH_SHORT).show();
                        bottomsheetcategoriamovi.dismiss();

                        txtmovi.setTextSize(30);
                        txtmovi.setText("Todo");

                    }
                });

                sheetView.findViewById(R.id.agua).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(Movimientos.this, "Categoria: Ingresos", Toast.LENGTH_SHORT).show();
                        bottomsheetcategoriamovi.dismiss();
                        txtmovi.setTextSize(30);
                        txtmovi.setText("Ingresos");

                    }
                });

                sheetView.findViewById(R.id.comida).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(Movimientos.this, "Categoria: Gastos", Toast.LENGTH_SHORT).show();
                        bottomsheetcategoriamovi.dismiss();
                        txtmovi.setTextSize(30);
                        txtmovi.setText("Gastos");

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

    // pone los datos en Arraylist
    void storeDataInArrays(){
        //Declaro un objero Cursor y le dijo que iba a ser igual al metodo de MyDatabAse readAllData
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0){

        }else{
            while (cursor.moveToNext()){
                // Aqui obtiene los datos de los array y los pone en cada columna de la tabla
                cantidad_input.add(cursor.getString(1));
                metodo_input.add(cursor.getString(2));
                fecha_input.add(cursor.getString(3));
                hora_input.add(cursor.getString(4));
                categoria_input.add(cursor.getString(5));
                descripcion_input.add(cursor.getString(6));
                System.out.println("hola: "+cantidad_input);
            }

        }
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







}