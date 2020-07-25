package biblioteca;
import java.util.*;

public class MainClass {

    public static void main(String[] args) throws Exception {
        ArrayList<Carrera> carreras = new ArrayList<>();
        String seleccion;
        boolean bandera;
        Scanner sc = new Scanner(System.in);

        activarDatos(carreras);

        //Interfaz y Menu
        System.out.println("------------------------------------------------");
        System.out.println("           Biblioteca Andrés Segovia            ");
        System.out.println("------------------------------------------------");

        //Menu menu = new Menu(carreras); //Habilita el menu con los datos quemados
        Menu menu = new Menu(); //No hay datos almacenados.
        menu.activarMenu();
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
