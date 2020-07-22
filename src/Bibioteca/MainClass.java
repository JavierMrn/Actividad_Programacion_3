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
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        ArrayList<Prestamo> prestamos = new ArrayList<>();
        estudiantes.clear();
        
        Estudiante a = new Estudiante("Javier Moreno", "Masculino", "1726789025");
        estudiantes.add(a);
        a = new Estudiante("Gladyz Sánchez", "Femenino", "1303753618");
        estudiantes.add(a);
        a = new Estudiante("Pedro Uribe", "Masculino", "1706172648");
        estudiantes.add(a);
        
        Prestamo prestamo = new Prestamo("25-07-2020", new Libro(123, "Matemáticas Discretas", "Matemáticas", "Español"));
        estudiantes.get(0).addPrestamo(prestamo);
        prestamo = new Prestamo("23-07-2020", new Libro(124, "El hada y el mago", "Lenguaje", "Español"));
        estudiantes.get(0).addPrestamo(prestamo);
        prestamo = new Prestamo("29-07-2020", new Libro(125, "La Biblia de Java", "Computación", "Español"));
        estudiantes.get(0).addPrestamo(prestamo);
        prestamo = new Prestamo("29-07-2020", new AudioVisual(123, "Videos Chisosos", 20));
        estudiantes.get(0).addPrestamo(prestamo);
        
        Carrera carrera = new Carrera("Mecanica", 8, "Jose Eredia");
        carreras.add(carrera);
        carrera = new Carrera("TICs", 10, "María ");
        carreras.add(carrera);
        carrera = new Carrera("Filosofía", 8, "Juan ");
        carreras.add(carrera);
        
        carreras.get(0).setRegistroAlumnos(estudiantes);
        
        //Interfaz y Menu
        System.out.println("------------------------------------------------");
        System.out.println("           Biblioteca Andrés Segovia            ");
        System.out.println("------------------------------------------------");

        Menu menu1 = new Menu(carreras); //Habilita el menu con los datos quemados
        menu1.activarMenu();
        //Menu menu2 = new Menu(); //No hay datos almacenados.
        //menu2.activarMenu();

        /*
        //Interface Nuevo Estudiante 
        VnEstudiante nuevoEstudiante = new VnEstudiante();
        nuevoEstudiante.setBounds(0, 0, 500, 500);
        nuevoEstudiante.setLocationRelativeTo(null);
        nuevoEstudiante.setResizable(false);
        nuevoEstudiante.setVisible(false);

        //Interface Nueva Carrera
        VnCarrera nuevaCarrera = new VnCarrera();
        nuevaCarrera.setBounds(0, 0, 500, 500);
        nuevaCarrera.setLocationRelativeTo(null);
        nuevaCarrera.setResizable(false);
        nuevaCarrera.setVisible(false);

        //InterfacePrincipal
        VnInicio vPrincipal = new VnInicio(nuevaCarrera, nuevoEstudiante);
        vPrincipal.setBounds(0, 0, 500, 350);
        vPrincipal.setLocationRelativeTo(null);
        vPrincipal.setResizable(false);
        vPrincipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        vPrincipal.setVisible(true);

        //Targets
        nuevoEstudiante.setTarget(vPrincipal);
        nuevaCarrera.setTarget(vPrincipal);
        */
    }
}
