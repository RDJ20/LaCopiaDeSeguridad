package com.example.cartera;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper {
    //Es solo un tag sin mas que decir xd
    private static final String TAG = "DatabaseHelper";

    //Aqui creamos la variables
    //Comenzamos por el nombre de la tabla
    private static final String TABLE_NAME = "YUYU";
    //Seguimos por el nombre de las columnas, OJO aqui que tambien se puede agregar columnas
    private static final String COL1 = "ID";
    private static final String COL2 = "name";
    private static final String COL3 = "name2";
    private static final String COL4 = "name3";


    // Esto le sirve a la clase para ver el contexto de la tabla, su nombre, y su version
    public DataBaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    //Aqui creamos la tabla, y los campos que va a tener, OJO aqui, que tambien se necesita modificar esto para agregar otra columna
    // a la base de datos, alli agregandole donde dice COL3  al a par y del mismo modo una COL4
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + "  (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COL2 +" TEXT," + COL3 +" TEXT,"+ COL4 +" TEXT)";
        //Aqui se crea la base de datos
        db.execSQL(createTable);

    }


    //Creo que aqui se actualiza la base de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db);

    }


    //OJO este metodo tambien es importante para  agregar columnas a la base de datos, Aqui se agregan los datos a la base de datos
    //Para agregar una nueva ciolumna tambien hay que modificar el numero de String en los parametros del metodo
    public boolean addData(String item, String item2, String item3) {
        //Aqui se crea una base de datos :D y se le dice que escriba
        SQLiteDatabase db = this.getWritableDatabase();
        //No se que es pero es necesario tenerlo,
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,item);
        contentValues.put(COL3,item2);
        contentValues.put(COL4,item3);

        // Este codigo solo es para imprimir si se envio algo a la base de datos
        Log.d(TAG, "addData: Adding " + item + item2+ item3 + " to " + TABLE_NAME);


        // Tampoco estoy seguro de que hace, pero hay que agregarle todas las columnas por si acaso
        Long result = db.insert(TABLE_NAME, COL2 + COL3 + COL4, contentValues);

        //if date as inserted incorrectly it will return -1
        // No se que onda xd
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }




    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }



}
