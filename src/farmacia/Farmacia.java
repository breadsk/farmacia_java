/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package farmacia;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Date;

/**
 *
 * @author Nicolás Cáceres Latorre
 */

public class Farmacia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        boolean entradaValida;
        Medicamento medicamento = null;//Con esto me aseguro que en el paso 2 no
        //se puede usar al ser nulo
        
        do{
        
            entradaValida = true;
            System.out.println("----Menu Principal----");
            System.out.println("1. Ingrese un medicamento");
            System.out.println("2. Segunda opcion");
            System.out.println("3. Salir");
            System.out.println("Seleccione una opcion");
            
            try{
                //Leemos la opcion del usuario
                opcion = scanner.nextInt();
                scanner.nextLine();
            
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el nombre del medicamento: ");                        
                        String nombre = scanner.nextLine();
                        
                        System.out.println("Ingrese el precio del medicamento: ");
                        int precio = scanner.nextInt();
                        scanner.nextLine();
                        
                        System.out.println("Ingrese el stock del medicamento: ");
                        int stock = scanner.nextInt();
                        scanner.nextLine();
                        
                        System.out.println("Ingrese el dia, no agregue 0 si es menor a 10");
                        int dia = scanner.nextInt();
                        scanner.nextLine();
                        
                        System.out.println("Ingrese el mes, no agregue 0 si es menor a 10");
                        int mes = scanner.nextInt();
                        scanner.nextLine();
                        
                        System.out.println("Ingrese el año ( ej: 2018 ) ");
                        int anio = scanner.nextInt();                        
                        
                        Date fechaCaducidad = new Date(anio-1900,mes-1,dia);                       
                        medicamento = new Medicamento(nombre, precio, stock, fechaCaducidad);
                        System.out.println("Medicamento ingresado satisfactoriamente");
                        System.out.println("--------");
                        System.out.println("Nombre: " + medicamento.getNombre());
                        System.out.println("Precio: " + medicamento.getStock());
                        System.out.println("Fecha Caducidad: " + medicamento.getFechaCaducidad());                        
                        System.out.println("--------");
                        break;
                    case 2:
                        if(medicamento != null){
                            System.out.println("Nombre: " + medicamento.getNombre());
                            System.out.println("Precio: " + medicamento.getPrecio());
                            System.out.println("Stock: " + medicamento.getStock());
                        }else{
                            System.out.println("Primero debes crear un medicamento");
                        }
                        break;
                    case 3:
                        System.out.println("Ha salido del programa adios");
                        break;
                    default:
                        System.out.println("Opcion no valida, intentelo nuevamente");
                }
            } catch(InputMismatchException e){
                System.out.println("Error, debe ingresar una opcion numerica ( 1,2,3 )");
                entradaValida = false;
            } finally {
                //Limpiamos el buffer del scanner para evitar bucles infinitos
                scanner.nextLine();
            }
            
        }while(!entradaValida  || opcion != 3);
        
        scanner.close();
    }
    
}
