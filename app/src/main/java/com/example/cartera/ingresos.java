package com.example.cartera;

import androidx.appcompat.app.AppCompatActivity;


//para el mes en numeros
import java.text.Format;
import java.util.Date;
//para las horas
import android.text.format.DateFormat;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ingresos extends AppCompatActivity  implements DatePickerDialog.OnDateSetListener {
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
        setContentView(R.layout.activity_ingresos);

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
        String fecha= values[0]+" "+strMonth+" "+values[2]+" ";
        String horaa=values[3]+":"+strMinuto;
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
                bottomSheetDialog= new  BottomSheetDialog(ingresos.this,R.style.bottomtheme);

                //Esta parte de codigo indica que archivo XML dentro de las carpetas de layouts se va a usar "bottomsheet_layout"
                // y que Layout dentro del XML se va mostar "bottomsheet" o sea el layout mas grande, el principal xd el que contiene a todos
                View sheetView= LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottomsheet_layout,
                        (ViewGroup) findViewById(R.id.bottomsheet));

                //Esta parte del codigo dice por ejemplo que cuando alguien haga click sobre el layout "hola" se va mostrar un mensaje o algo
                sheetView.findViewById(R.id.hola).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(ingresos.this, "Método de pago: Efectivo", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                        txt.setText("Efectivo");
                        imagen.setImageResource(R.drawable.quetzal);
                    }
                });

                sheetView.findViewById(R.id.layautcredito).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(ingresos.this, "Método de pago: Credito", Toast.LENGTH_SHORT).show();
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
                bottomsheetcategoria= new  BottomSheetDialog(ingresos.this,R.style.bottomtheme);

                //Esta parte de codigo indica que archivo XML dentro de las carpetas de layouts se va a usar "bottomsheet_layout"
                // y que Layout dentro del XML se va mostar "bottomsheet" o sea el layout mas grande, el principal xd el que contiene a todos
                View sheetView= LayoutInflater.from(getApplicationContext()).inflate(R.layout.catergoriaingresos,
                        (ViewGroup) findViewById(R.id.categoriaingresos));

                //Esta parte del codigo dice por ejemplo que cuando alguien haga click sobre el layout "hola" se va mostrar un mensaje o algo
                sheetView.findViewById(R.id.sueldo).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(ingresos.this, "Categoria: Sueldo", Toast.LENGTH_SHORT).show();
                        bottomsheetcategoria.dismiss();
                        txtcat.setTextSize(30);
                        txtcat.setText("Sueldo");
                        imagencat.setImageResource(R.drawable.businessman);
                    }
                });

                sheetView.findViewById(R.id.regalo).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(ingresos.this, "Categoria: Regalo", Toast.LENGTH_SHORT).show();
                        bottomsheetcategoria.dismiss();
                        txtcat.setTextSize(30);
                        txtcat.setText("Regalo");
                        imagencat.setImageResource(R.drawable.regalo);
                    }
                });

                sheetView.findViewById(R.id.venta).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(ingresos.this, "Categoria: Ventas", Toast.LENGTH_SHORT).show();
                        bottomsheetcategoria.dismiss();
                        txtcat.setTextSize(30);
                        txtcat.setText("Venta");
                        imagencat.setImageResource(R.drawable.store);
                    }
                });

                sheetView.findViewById(R.id.cielo).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Toast.makeText(ingresos.this, "Categoria: Bless", Toast.LENGTH_SHORT).show();
                        bottomsheetcategoria.dismiss();
                        txtcat.setTextSize(17);
                        txtcat.setText("Me cayó del cielo");
                        imagencat.setImageResource(R.drawable.cloudy);
                    }
                });









                bottomsheetcategoria.setContentView(sheetView);
                //Para Mostrar el Bottom Sheet
                bottomsheetcategoria.show();

            }
        });


    }


























        // Esta codigo funciona para hacer que el boton cambie de Activity y es un metodo INICIO
    public void Siguiente(View View){
        Intent siguiente= new Intent(this, MainActivity3.class);
        startActivity(siguiente);

        // Esta codigo funciona para hacer que el boton cambie de Activity y es un metodo FIN

    }
    public void Gastos(View View){
        Intent siguiente= new Intent(this, Gastos.class);
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