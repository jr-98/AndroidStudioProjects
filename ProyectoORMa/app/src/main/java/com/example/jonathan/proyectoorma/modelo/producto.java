package com.example.jonathan.proyectoorma.modelo;
import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import java.util.List;
@Table(name="producto")
public class producto extends Model {
    @Column(name = "nombre", notNull = true)
    private String nombre;
    @Column(name = "codigo", unique = true)
    private String codigo;
    @Column(name = "precio", notNull = true)
    private double precio;
    @Column(name = "existencia", notNull = true)
    private int existencia;

    public producto() {
        super();
    }
    public producto(String nombre, String codigo, double precio, int existencia) {
        super(); //para traer las caracteristicas de la clase padre
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.existencia = existencia;
    }

    public void update(String nombre,String codigo, Double precio, int existencia){
        producto productoUdt = new producto();
        productoUdt.setNombre(nombre);
        productoUdt.setCodigo(codigo);
        productoUdt.setPrecio(precio);
        productoUdt.setExistencia(existencia);
        productoUdt.save();
    }
    //envia una lita con todos los elementos  de la tabla
    public List<producto> obtenerTodoProductos(){
        return new Select().from(producto.class).execute();
    }
    //objeto de la clase producto
    public producto Muestra(){
        return new Select().from(producto.class).executeSingle();
    }
    //borra todas las tuplas de la tabla
    public void deleteAll(){
        new Delete().from(producto.class).execute();
    }
    //Elimina por codigo de producto
    public producto deleteSelected(String codigo){
        return new Select().from(producto.class).where("codigo='"+codigo+"'").executeSingle();
    }
    //Buscar por el codigo
    public producto searchCod(String codigo){
        return new Select().from(producto.class).where("codigo='"+codigo+"'").executeSingle();
    }

//metodo pa// ra actualizar la tuplas de la tabla
    public producto updateRegister(String codigo){
        return new Select().from(producto.class).where("codigo='"+codigo+"'").executeSingle();
    }
    //Geters and Geters_________________________________________________________________________________
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }
}
