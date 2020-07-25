package biblioteca;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class MainClass {

    public static void main(String[] args) throws Exception {
        ArrayList<Carrera> carreras = new ArrayList<>();
        String seleccion;
        boolean bandera;
        Scanner sc = new Scanner(System.in);

        activarDatos(carreras);

        //Menu menu = new Menu(carreras); //Habilita el menu con los datos quemados
        Menu menu = new Menu(); //No hay datos almacenados.

        //Interfaz y Menu
        System.out.println("------------------------------------------------");
        System.out.println("           Biblioteca Andrés Segovia            ");
        System.out.println("------------------------------------------------");

        do {
            System.out.println("Seleccione una opción:");
            System.out.println("    1. Añadir nuevo estudiante.");
            System.out.println("    2. Añadir nueva carrera.");
            System.out.println("    3. Opciones Pretamo.");
            System.out.println("    4. Reportes por estudiante.");
            System.out.println("    5. Salir.");
            System.out.println(Menu.marco);

            System.out.print("    Selección: ");
            seleccion = sc.nextLine();
            seleccion = seleccion.replace(" ", "");
            System.out.println(Menu.marco);

            switch (seleccion) {
                case "1":
                    menu.opcionNuevoEstudiante();
                    bandera = true;
                    break;
                case "2":
                    menu.opcionNuevaCarrera();
                     bandera = true;
                    break;
                case "3":
                    menu.opcionPrestamo();
                     bandera = true;
                    break;
                case "4":
                    menu.opcionReportesEstudiantes();
                     bandera = true;
                    break;
                case "5":
                    menu.opcionSalir();
                    bandera = false;
                    break;
                default:
                    bandera = true;
                    System.out.println("          Seleccione una opción existente       ");
                    System.out.println(Menu.marco);
                    break;
            }
        } while (bandera);
    }

    public static void activarDatos(ArrayList<Carrera> carreras) {
        //DATOS QUEMADOS PARA LAS PRUEBAS 
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
        Prestamo prestamoPrueba1 = new Prestamo(new Date(2020, 6, 24), new Libro(123, "Cálculo 2 de Varias Variables 9ed - Larson y Edwards",
                "Cálculo Integral", "Español"));
        prestamoPrueba1.setFechaDevolucion(new Date(2020, 7, 23));
        estudiantePrueba.addPrestamo(prestamoPrueba1);

        Prestamo prestamoPrueba2 = new Prestamo(new Date(2020, 6, 24), new Libro(124, "La biblia de java",
                "Computación", "Español"));
        prestamoPrueba2.setFechaDevolucion(new Date(2020, 7, 23));
        estudiantePrueba.addPrestamo(prestamoPrueba2);

        Prestamo prestamoPrueba3 = new Prestamo(new Date(2020, 6, 24), new Libro(125, "Cálculo para todos",
                "Cálculo Integral", "Español"));
        prestamoPrueba3.setFechaDevolucion(new Date(2020, 7, 23));
        estudiantePrueba.addPrestamo(prestamoPrueba3);
    }
}
