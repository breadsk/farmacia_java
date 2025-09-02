/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmacia;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author nikom
 */
public class Medicamento {
    private String nombre;
    private int precio;
    private int stock;
    private Date fechaCaducidad;
    
    public Medicamento(String nombre,int precio,int stock,Date fechaCaducidad)throws IllegalArgumentException{
        this.setNombre(nombre);
        this.setPrecio(precio);
        this.setStock(stock);
        this.setFechaCaducidad(fechaCaducidad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar nulo o vacio");
        }
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) throws IllegalArgumentException {
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }
        if(precio <= 5000){
            throw new IllegalArgumentException("El precio debe ser mayor a 5000");
        }
        if (precio > 1000000) { // Límite máximo razonable
            throw new IllegalArgumentException("El precio no puede exceder $1,000,000");
        }
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock <= 0) {
            throw new IllegalArgumentException("Stock no puede cero 0");
        }
        if(stock >= 50){
            throw new IllegalArgumentException("Stock 50 maximo permitido");
        }
        this.stock = stock;
    }

    public String getFechaCaducidad() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");       
        return formato.format(this.fechaCaducidad);
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        if (fechaCaducidad == null) {
            throw new IllegalArgumentException("La fecha de caducidad no puede ser nula");
        }            
        this.fechaCaducidad = fechaCaducidad;    }

    public void generarVenta(int cantidad){  
        int total = this.precio * cantidad;
        Date fechaVenta = new Date(2025,9,2);
        System.out.println("----Venta----");
        System.out.println("Total de venta es: " + "$"+total + " de medicamento: "+ this.nombre);
        System.out.println("Fecha de venta: " + fechaVenta);
    }
    
    
    @Override
    public String toString() {
        return "Medicamento = {" + "nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + ", fechaCaducidad=" + fechaCaducidad + '}';
    }
    
    
}
