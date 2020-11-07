package com.example.cartera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    DataBaseHelper mDatabaseHelper;
    private Button btnAdd, btnViewData;
    private EditText editText, holajeje, tt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Estos son los edit text para entrar los datos
        editText = (EditText) findViewById(R.id.editText);
        holajeje = (EditText) findViewById(R.id.editText2);
        tt3 =(EditText) findViewById(R.id.txt3) ;

        // Estos son los botones para ver y a;adir info a la base de datos
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnViewData = (Button) findViewById(R.id.btnView);


        //esta es la instancia de un objeto de la clase o archivo DataBaseHelper, la cual tiene los metodos que necesitamos
        mDatabaseHelper = new DataBaseHelper(this);


        //Es un metodo diferente a lo habitual, pero aqui es donde se le dice al boton de add que va a hacer cuando lo clickeen
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            // Para cuando Hagan click en el boton
            public void onClick(View v) {

                // Aqui se ponen que se va a obtener los datos que metamos en los plainText o en los Editext como se llamen xd
                // Para agregra una nueva entrada de informcion saqui se agrega tambien
                String newEntry = editText.getText().toString();
                String newEntry2= holajeje.getText().toString();
                String newEntry3= tt3.getText().toString();

                if (editText.length() != 0) {

                    //Aqui le envia los datos de los editText a el metodo AddDatta que esta mas abajo
                    //OJO con esta parte, si queremos meter mas columnas o variables este es una de las cosas que debemos de cambia por ejemplo
                    //Agregarle un tercer newentry3, obiamente nos vamos al metodo y le decimos que tiene que recibir tres parametros
                    AddData(newEntry, newEntry2, newEntry3);

                    editText.setText("");
                } else {
                    toastMessage("You must put something in the text field!");
                }

            }
        });



        // Este boton solo redireccion al activity para mostrar la lista de la base de datos nada en especial
        btnViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListDataActivity.class);
                startActivity(intent);
            }
        });

    }





    // Con este metodo agregamos la info a la base de datos, ojo que por el momento solo recibe 2 parametros, quiza tres por la prueba que voy a hacer
    //Esto es lo primero que debemos de modificar para agregar otra columna a la base de datos
    // pero si queremos Agregar mas parametros por ejemplo un tercer nombre debemos de ponerle otro String newEntry 3 para que cuando
    // lo invoquen reciba 3 parametros
    public void AddData(String newEntry, String newEntry2, String newEntry3) {
        // Este booleano le sirve al if de abajo para ver si entro toda la info correctamente
        boolean insertData = mDatabaseHelper.addData(newEntry, newEntry2, newEntry3);

        //Estos solo nos dicen Si la informacion fue entrada correctamente o no
        if (insertData) {
            toastMessage("Data Successfully Inserted!");
        } else {
            toastMessage("Something went wrong");
        }
    }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }


}