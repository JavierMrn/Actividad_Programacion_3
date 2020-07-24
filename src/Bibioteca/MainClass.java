package Bibioteca;

import Interface.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class MainClass {

    public static void main(String[] args) throws Exception {
        //Datos quemados para las pruebas
        ArrayList<Carrera> carreras = new ArrayList<>();
        
        //Datos Almacenados para pruebas
        //Carreras
        Carrera carreraPrueba = new Carrera("TICs", 8, "Acosta David");
        carreras.add(carreraPrueba);
        //Estudiantes
        /*
        Números de cédulas validos
        1706172648 
        1704997012
        1713627071
        */ 
       
        Estudiante estudiantePrueba = new Estudiante("Aguilar Darwin", "Masculino", "1726789025");
        carreraPrueba.addStudent(estudiantePrueba);
        
        //Prestamos 
        Prestamo prestamoPrueba = new Prestamo(new Date(2020,7, 24), new Libro(123, "Cálculo 2 de Varias Variables 9ed - Larson y Edwards"
                , "Cálculo Integral", "Español"));
        prestamoPrueba.setFechaDevolucion(new Date(2020, 8, 23));
        estudiantePrueba.addPrestamo(prestamoPrueba);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        //Interfaz y Menu
        System.out.println("------------------------------------------------");
        System.out.println("           Biblioteca Andrés Segovia            ");
        System.out.println("------------------------------------------------");

        //Habilita el menu con los datos quemados
        Menu menu1 = new Menu(carreras);
        menu1.activarMenu();
        
        //No hay datos almacenados.
        //Menu menu2 = new Menu(); 
        //menu2.activarMenu();
    }
}
