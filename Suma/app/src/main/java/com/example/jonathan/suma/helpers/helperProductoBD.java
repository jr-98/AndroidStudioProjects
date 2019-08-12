package com.example.jonathan.suma.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.telephony.mbms.StreamingServiceInfo;

public class helperProductoBD extends SQLiteOpenHelper {
    public helperProductoBD(Context context,String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE producto (id INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT,codigo TEXT UNIQUE,precio DOUBLE, existencia INTEGER );");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void guardar(String nombre, String codigo, double precio, int existencia){
        ContentValues valores = new ContentValues();
        valores.put("nombre",nombre);
        valores.put("codigo", codigo);
        valores.put("precio",precio);
        valores.put("existencia",existencia);
        this.getWritableDatabase().insert("producto",null,valores);

    }
    public void modificar(String nombre, String codigo, double precio, int existencia){
        ContentValues valores = new ContentValues();
        valores.put("nombre",nombre);
        valores.put("precio",precio);
        valores.put("existencia",existencia);
        this.getWritableDatabase().update("producto",valores,"codigo='"+codigo+"'",null);

    }
    public void eliminarTodos(){
       this.getWritableDatabase().delete("producto",null,null);
    }
    public String getAll(){
        String resultado= null;
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM producto",null);
        if(cursor.moveToFirst()){
            do{
                String nombre= cursor.getString(cursor.getColumnIndex("nombre"));
                String codigo = cursor.getString(cursor.getColumnIndex("codigo"));
                Double precio = cursor.getDouble(cursor.getColumnIndex("precio"));
                int existencia = cursor.getInt(cursor.getColumnIndex("existencia"));
                resultado+= nombre +codigo+precio+existencia;
            }while (cursor.moveToNext());

        }
        return resultado;
    }
    public void eliminarCod(String codigo){
        this.getWritableDatabase().delete("producto","codigo='"+codigo+"'",null);

    }
    public String getCodigo(String cod){
        String resultado= null;
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM producto WHERE codigo ='"+cod+"'",null);
        if(cursor.moveToFirst()){
            do{
                String nombre= cursor.getString(cursor.getColumnIndex("nombre"));
                String codigo = cursor.getString(cursor.getColumnIndex("codigo"));
                Double precio = cursor.getDouble(cursor.getColumnIndex("precio"));
                int existencia = cursor.getInt(cursor.getColumnIndex("existencia"));
                resultado+= nombre + codigo+precio+existencia;
            }while (cursor.moveToNext());

        }
        return resultado;
    }
}
