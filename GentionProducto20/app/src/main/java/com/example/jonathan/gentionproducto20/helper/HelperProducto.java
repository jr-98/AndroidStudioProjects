package com.example.jonathan.gentionproducto20.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.jonathan.gentionproducto20.model.Producto;

import java.util.ArrayList;
import java.util.List;

public class HelperProducto extends SQLiteOpenHelper {


    public HelperProducto(Context context,String name,SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("CREATE TABLE producto(id Auto_increment Primary key, nombre VARCHAR(100), codigo VARCHAR(10) UNIQUE, precio DOUBLE(9,2), stock INT  )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void crear(Producto producto){
        ContentValues valores = new ContentValues();
        valores.put("codigo",producto.getCodigo());
        valores.put("nombre",producto.getNombre());
        valores.put("precio",producto.getPrecio());
        valores.put("stock",producto.getStock());
        this.getWritableDatabase().insert("producto",null,valores);
    }
    public List<Producto> mostrar(){
        List<Producto> lista = new ArrayList<>();
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT *FROM PRODUCTO",null );
        if(cursor.moveToFirst()){
            do{
                String nombre = cursor.getString(cursor.getColumnIndex("nombre"));
                String codigo = cursor.getString(cursor.getColumnIndex("codigo"));
                Double precio = cursor.getDouble(cursor.getColumnIndex("precio"));
                int stock = cursor.getInt(cursor.getColumnIndex("stock"));

                Producto producto = new Producto();
                producto.setNombre(nombre);
                producto.setCodigo(codigo);
                producto.setPrecio(precio);
                producto.setStock(stock);

                lista.add(producto);
            }while (cursor.moveToNext());
        }
        return lista;
    }
    public void modificar(Producto producto){
        ContentValues values = new ContentValues();
        values.put("nombre",producto.getNombre());
        values.put("precio",producto.getPrecio());
        values.put("stock",producto.getStock());
        this.getWritableDatabase().update("producto",values,"codigo ='"+producto.getCodigo()+"'",null);
    }
    public void eliminar(Producto producto){
        this.getWritableDatabase().delete("producto","codigo ='"+producto.getCodigo()+"'",null);
    }

}
