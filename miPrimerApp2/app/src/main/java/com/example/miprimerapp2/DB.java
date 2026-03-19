package com.example.miprimerapp2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import kotlin.contracts.Returns;

public class DB extends SQLiteOpenHelper{  //llamando la libreria que nos permite usar sqlite
    private static final String DATABASE_NAME="amigos"; //Nombre del base de datos
    private static final int DATABASE_VERSION=1; /* Se establece la version de la base de datos para si en un futuro
                                                    alguien quiere cambiar de version se ejecutara el onUpgrade automatica */
    public DB(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String SQLLdb ="CREATE TABLE amigos (idAmigo INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT,direccion TEXT,email TEXT,dui TEXT,urlFoto TEXT)";
    @Override
    public void onCreate(SQLiteDatabase db) {
         db.execSQL(SQLLdb);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    //actualizar la definicion de la base de datoos
    }
    public String administrar_amigos(String accion, String[] datos){
        try{
            SQLiteDatabase db = getWritableDatabase();
            String mensaje ="ok" ,sql="";
            switch (accion) {
                case"nuevo":
                    sql ="INSERT INTO amigos (nombre,direccion,telefono,email,dui,urlfoto) " +
                            "VALUES('"+datos[1]+"','"+datos[2]+"','"+datos[3]+"','"+datos[4]+"','"+datos[5]+"','"+datos[6]+"')";
                    break;
                case"modificar":
                    sql="UPDATE amigos SET nombre='"+datos[1]+"',direccion'"+datos[2]+"',telefono='"+datos[3]+"',email='"+datos[4]+"'" +
                            ",dui'"+datos[5]+"',urlFoto'"+datos[6]+"'WHERE'"+datos[0]+"'";
                    break;
                case"eliminar":
                    sql="DELETE FROM amigos WHERE idAmigo='"+datos[0]+"'";
                    break;

            }
            db.execSQL(sql);
            db.close();
            return mensaje;
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }
    public Cursor lista_amigos(){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT * FROM amigos", null);

    }
}

