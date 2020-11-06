package com.example.cartera;

import androidx.appcompat.app.AppCompatActivity;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.text.format.DateFormat;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.Calendar;
import java.util.Locale;

public class Gastos extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    //para mostrar el bottom sheet
    private Button showSheet;
    private BottomSheetDialog bottomSheetDialog;

    // Para mostra el bottomsheet de la categoria
    private Button mostrarlayoutcategoria;
    private BottomSheetDialog bottomsheetcategoria;
    //variable Text view
    TextView txt;
    TextView txtcat;
    ImageView imagen;
    ImageView imagencat;





    //Para el date Picker Dialog y el Time
    public int horaa;
    private TextView año;
    private TextView mes;
    private TextView hora;
    private TextView dia;





    //Variables para cambiar el Number
    int ingreso;
    EditText numeroingreso;

    // Para el Dialogo de calendario
    private RelativeLayout layout;
    private String[] values;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gastos);

        //---------------------------------------------------------------------------------------------------------
        // Se declara una variable textview para poder cambiarle el nombre al hacer click en efectivo o credito y se busca por su id
        txt= (TextView) findViewById(R.id.efectivo);
        txtcat=findViewById(R.id.textcategoria);
        // Se declara una variable ImageView para poder cambiarle la imagen al hacer click en efectivo o credito y se busca por su id
        imagen=(ImageView) findViewById(R.id.imagencambiable);
        imagencat=findViewById(R.id.lineapunteadacategoria);
        // Se declara un avriable EditText para poder cambiarle el valor al edit Text, se busca por su id
        numeroingreso=(EditText) findViewById(R.id.numeroingreso);
        // Para el Dialogo de calendario
        layout= findViewById(R.id.linearLayout);
        //---------------------------------------------------------------------------------------------------------





        //---------------------------------------------------------------------------------------------------------
        //Para hacer cambiar la fecha de la casilla de fecha por la fecha actual aqui se declaran las variables de los textview
        // aqui es donde habia escrito por segunda vez los text view en el error que me daba
        año = findViewById(R.id.casillaaño);
        mes = findViewById(R.id.casillames);
        dia = findViewById(R.id.casilladia);
        hora =findViewById(R.id.casillahora);
        //---------------------------------------------------------------------------------------------------------




        //---------------------------------------------------------------------------------------------------------
        //Este codigo es para ponerle fecha a la casilla de fecha y hora solo la fecha actual como predeterminado
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yyyy/HH", Locale.US);
        String strDate = sdf.format(cal.getTime());
        String[] values = strDate.split("/");
        // para poner solo los meses en numero
        Format f = new SimpleDateFormat("dd/MMMM/yyyy");
        f = new SimpleDateFormat("M");
        String strMonth = f.format(new Date());
        // Para poner solo los minutos de la hora
        Format m= new SimpleDateFormat("mm");
        m = new SimpleDateFormat("mm");
        String strMinuto = m.format(new Date());
        dia.setText(values[0]);
        mes.setText(strMonth);
        año.setText(values[2]);
        hora.setText(values[3]+":"+strMinuto);
        //---------------------------------------------------------------------------------------------------------


        //---------------------------------------------------------------------------------------------------------
        // se busca el layout para que cuando hagan click se active lo demas
        findViewById(R.id.linearLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // aqui se llama al metodo de mostrar el dialogo que nos da para poner la fecha
                MostrarDialogoFechas();
            }
        });

        findViewById(R.id.casillahora).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MostrarDialogoHoras ();
            }
        });
        //---------------------------------------------------------------------------------------------------------










        //---------------------------------------------------------------------------------------------------------
        //Vincula el Bottom Sheet con un boton en este caso el layout
        showSheet=findViewById(R.id.spinner);

        //Este codigo puede sentir cuando se clickeo el boton y ejecuta una serie de ordenes
        showSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                bottomSheetDialog= new BottomSheetDialog(Gastos.this,R.style.bottomtheme);

                //Esta parte de codigo indica que archivo XML dentro de las carpetas de layouts se va a usar "bottomsheet_layout"
                // y que Layout dentro del XML se va mostar "bottomsheet" o sea el layout mas grande, el principal xd el que contiene a todos
                View sheetView= LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottomsheet_layout,
                        (ViewGroup) findViewById(R.id.bottomsheet));

                //Esta parte del codigo dice por ejemplo que cuando alguien haga click sobre el layout "hola" se va mostrar un mensaje o algo
                sheetView.findViewById(R.id.hola).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(Gastos.this, "Método de pago: Efectivo", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                        txt.setText("Efectivo");
                        imagen.setImageResource(R.drawable.quetzal);
                    }
                });

                sheetView.findViewById(R.id.layautcredito).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(Gastos.this, "Método de pago: Credito", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                        txt.setText("Credito");
                        imagen.setImageResource(R.drawable.tarjeta);
                    }
                });

                bottomSheetDialog.setContentView(sheetView);
                //Para Mostrar el Bottom Sheet
                bottomSheetDialog.show();

            }
        });
        //---------------------------------------------------------------------------------------------------------



        mostrarlayoutcategoria=findViewById(R.id.botoncategoria);


        mostrarlayoutcategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                bottomsheetcategoria= new  BottomSheetDialog(Gastos.this,R.style.bottomtheme);

                //Esta parte de codigo indica que archivo XML dentro de las carpetas de layouts se va a usar "bottomsheet_layout"
                // y que Layout dentro del XML se va mostar "bottomsheet" o sea el layout mas grande, el principal xd el que contiene a todos
                View sheetView= LayoutInflater.from(getApplicationContext()).inflate(R.layout.categorialay,
                        (ViewGroup) findViewById(R.id.layoutcategoria));

                //Esta parte del codigo dice por ejemplo que cuando alguien haga click sobre el layout "hola" se va mostrar un mensaje o algo
                sheetView.findViewById(R.id.agua).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(Gastos.this, "Categoria: Agua", Toast.LENGTH_SHORT).show();
                        bottomsheetcategoria.dismiss();
                        txtcat.setTextSize(30);
                        txtcat.setText("Agua");
                        imagencat.setImageResource(R.drawable.gota);
                    }
                });

                sheetView.findViewById(R.id.electricidad).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(Gastos.this, "Categoria: Electricidad", Toast.LENGTH_SHORT).show();
                        bottomsheetcategoria.dismiss();
                        txtcat.setTextSize(30);
                        txtcat.setText("Electricidad");
                        imagencat.setImageResource(R.drawable.bombillo);
                    }
                });

                sheetView.findViewById(R.id.comida).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(Gastos.this, "Categoria: Comida", Toast.LENGTH_SHORT).show();
                        bottomsheetcategoria.dismiss();
                        txtcat.setTextSize(30);
                        txtcat.setText("Comida");
                        imagencat.setImageResource(R.drawable.alimnetos);
                    }
                });

                sheetView.findViewById(R.id.casa).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(Gastos.this, "Categoria: Compras para la Casa", Toast.LENGTH_SHORT).show();
                        bottomsheetcategoria.dismiss();
                        txtcat.setTextSize(17);
                        txtcat.setText("Compras para la Casa");
                        imagencat.setImageResource(R.drawable.casa);
                    }
                });

                sheetView.findViewById(R.id.otras).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(Gastos.this, "Categoria: Otras", Toast.LENGTH_SHORT).show();
                        bottomsheetcategoria.dismiss();
                        txtcat.setTextSize(30);
                        txtcat.setText("Otras");
                        imagencat.setImageResource(R.drawable.cosas);
                    }
                });







                bottomsheetcategoria.setContentView(sheetView);
                //Para Mostrar el Bottom Sheet
                bottomsheetcategoria.show();

            }
        });







    }














    public void Inicio(View View){
        Intent siguiente= new Intent(this, MainActivity.class);
        startActivity(siguiente);
    }
    public void Ingresos(View View){
        Intent siguiente= new Intent(this, ingresos.class);
        startActivity(siguiente);
    }
    public void Movimientos(View View){
        Intent siguiente= new Intent(this, Movimientos.class);
        startActivity(siguiente);
    }


    public void obtenerNumeros(){
        ingreso=Integer.valueOf(numeroingreso.getText().toString());

    }



    // este es el metodo para mostra el dialogo de calendario para poner fechas
    public void MostrarDialogoFechas(){
        DatePickerDialog dialogofecha = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));

        dialogofecha.show();
    }


    public void MostrarDialogoHoras (){
        Calendar calendar = Calendar.getInstance();
        final int horaa = calendar.get(Calendar.HOUR);
        int minuto = calendar.get(Calendar.MINUTE);
        boolean is24HourFormat = DateFormat.is24HourFormat(this);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {

            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                System.out.println(hour+":"+minute);
                Calendar calendar1 = Calendar.getInstance();
                calendar1.set(Calendar.HOUR, hour);
                calendar1.set(Calendar.MINUTE, minute);
                String dateText = DateFormat.format("h:mm", calendar1).toString();
                hora.setText(dateText);
            }
        }, horaa, minuto, is24HourFormat);

        timePickerDialog.show();

    }



    // Esta funcion sirve para que se cambien los datos en los textview del activity
    @Override
    public void onDateSet(DatePicker view, int añoo, int mees, int diaa) {
        // el mes + 1 es por que Java cuenta los meses desde 0 o sea que enero seria 0, pero nosotros conocemos enero como el mes 1 xd
        mees=mees+1;
        //Para cambiarlos de int a string y asi que se vayan ya cambiados al textview
        String date = diaa +"";
        String meees= mees+"";
        String añooo= añoo+"";
        dia.setText(date);
        mes.setText(meees);
        año.setText(añooo);
        //Recordar el error que me daba antes era por que habia escrito dos veces Text View, 1 cuando declare las variables
        // y otra cuando los busque por su ID y al parecer solo es una vez xd

    }






}
