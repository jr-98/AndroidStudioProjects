package com.example.jonathan.gestionproductoa.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.jonathan.gestionproductoa.R;
import com.example.jonathan.gestionproductoa.modelo.producto;

import java.util.ArrayList;
import java.util.List;

public class helperProducto extends SQLiteOpenHelper{
        public helperProducto(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE producto (id INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT,codigo TEXT UNIQUE,precio DOUBLE, existencia INTEGER );");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
        public void guardar(producto producto){
            ContentValues valores = new ContentValues();
            valores.put("nombre",producto.getNombre());
            valores.put("codigo", producto.getCodigo());
            valores.put("precio",producto.getPrecio());
            valores.put("existencia",producto.getExistencia());
            this.getWritableDatabase().insert("producto",null,valores);

        }
    public List<producto> obtenerTodosProductos(){
         List<producto> lista = new ArrayList<producto>();
         Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM producto",null);
        if(cursor.moveToFirst()){
            do{
                String nombre= cursor.getString(cursor.getColumnIndex("nombre"));
                String codigo = cursor.getString(cursor.getColumnIndex("codigo"));
                double precio = cursor.getDouble(cursor.getColumnIndex("precio"));
                int existencia = cursor.getInt(cursor.getColumnIndex("existencia"));
                producto producto = new producto();
                producto.setNombre(nombre);
                producto.setCodigo(codigo);
                producto.setPrecio(precio);
                producto.setExistencia(existencia);
                lista.add(producto);
            }while (cursor.moveToNext());

        }
        return lista;
    }
    public void modicar(producto producto){
            ContentValues valores = new ContentValues();
            valores.put("nombre",producto.getNombre());
            valores.put("precio",producto.getPrecio());
            valores.put("existencia",producto.getExistencia());
            this.getWritableDatabase().update("producto",valores,"codigo ='"+producto.getCodigo()+"'",null);
    }
    public void eliminar(producto producto){
        this.getWritableDatabase().delete("producto","codigo ='"+producto.getCodigo()+"'",null);

    }

}
