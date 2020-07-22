package Bibioteca;

import java.util.*;

public class Menu {

    //Variables
    private ArrayList<Carrera> carreras = new ArrayList<>();
    private String seleccion;
    private Prestamo auxPrestamo = new Prestamo();
    private Estudiante auxEstudiante = new Estudiante();
    private Carrera auxCarrera = new Carrera();

    public static String marco = "--------------------------------------------------------";
    Scanner sc = new Scanner(System.in);

    //Constructores
    public Menu(ArrayList<Carrera> carreras) {
        this.carreras = carreras;
    }

    public Menu() {
    }

    public void activarMenu() {
        this.opciones();
    }

    private void opciones() {
        System.out.println("Seleccione una opción:");
        System.out.println("    1. Añadir nuevo estudiante.");
        System.out.println("    2. Añadir nueva carrera.");
        System.out.println("    3. Crear nuevo pretamo.");
        System.out.println("    4. Reportes por estudiante.");
        System.out.println("    5. Salir.");
        System.out.println(marco);

        System.out.print("    Selección: ");
        seleccion = sc.nextLine();
        System.out.println(marco);

        switch (seleccion) {
            case "1":
                this.opcionNuevoEstudiante();
                break;
            case "2":
                this.opcionNuevaCarrera();
                break;
            case "3":
                this.opcionPrestamo();
                break;
            case "4":
                this.opcionReportesEstudiantes();
                break;
            case "5":
                this.opcionSalir();
                break;
            default:
                System.out.println("          Seleccione una opción existente       ");
                System.out.println(marco);
                this.opciones();
        }
    }

    private void opcionNuevoEstudiante() {
        auxEstudiante = new Estudiante();
        String cedula = "", nombre, genero;

        this.verificarCarrera();
        System.out.println(marco);

        System.out.print("Ingrese el número de cedula del estudiante: ");
        sc.nextLine();
        cedula = sc.nextLine();

        while (!auxEstudiante.verificarCedula(cedula)) {
            System.out.println(marco);
            System.out.print("Ingrese un número valido: ");
            cedula = sc.nextLine();
        }

        auxEstudiante.setCedula(cedula);
        System.out.print("Ingrese el nombre del estudiante: ");
        nombre = sc.nextLine();
        auxEstudiante.setNombre(nombre);
        System.out.print("Ingrese el genero del estudiante: ");
        genero = sc.nextLine();
        auxEstudiante.setGenero(genero);
        System.out.println("");

        this.funcionesVarias("  1. Guardar | 2. Reintentar");

        switch (seleccion) {
            case "1":
                if (!auxCarrera.addStudent(auxEstudiante)) {
                    System.out.println("             Guardado Exitosamente              ");
                    System.out.println(marco);
                }

                this.funcionesVarias("  1. Nuevo Estudiante | 2. Salir");

                switch (seleccion) {
                    case "1":
                        this.opcionNuevoEstudiante();
                        break;
                    case "2":
                        this.activarMenu();
                        break;
                }
                break;

            case "2":
                this.opcionNuevoEstudiante();
                break;
        }
    }

    private void opcionNuevaCarrera() {

        System.out.print("Ingrese el nombre de la carrera: ");
        String nombreCarrera = sc.nextLine();
        System.out.print("Ingrese el nombre del director: ");
        String nombreDirector = sc.nextLine();
        int duracion = this.verificarEnteros("Ingrese el número de semestres: ", "Ingrese un número valido...");

        System.out.println("");
        sc.nextLine();
        this.funcionesVarias("  1. Guardar | 2. Reintentar");

        switch (seleccion) {
            case "1":
                Carrera carrera = new Carrera(nombreCarrera, duracion, nombreDirector);
                carreras.add(carrera);
                System.out.println("             Guardado Exitosamente              ");
                System.out.println(marco);
                this.funcionesVarias("  1. Nueva Carrera | 2. Salir");
                switch (seleccion) {
                    case "1":
                        this.opcionNuevaCarrera();
                        break;
                    case "2":
                        this.activarMenu();
                        break;
                }
                break;
            case "2":
                this.opcionNuevaCarrera();
                break;
        }
    }

    private void opcionPrestamo() {
        this.funcionesVarias("  1. Registrar Nuevo Prestamo | 2. Entrega de Materiales");

        this.verificarCarrera();
        this.verificarEstudiante();

        System.out.println(marco);
        System.out.println("Información: ");
        auxEstudiante.mostrarInfo();
        System.out.println("");

        switch (seleccion) {
            case "1":
                this.funcionesVarias("  1. Aceptar | 2. Reintentar");
                switch (seleccion) {
                    case "1":
                        System.out.println("Tipo de material a prestar: ");
                        this.funcionesVarias("  1. Libro | 2. Audiovisual");
                        switch (seleccion) {
                            case "1":
                                this.opcionNP_Libro();
                                break;
                            case "2":
                                this.opcionNP_AudioVisual();
                                break;
                        }
                        break;
                    case "2":
                        this.opcionPrestamo();
                        break;
                }
                break;

            case "2":
                this.funcionesVarias("  1. Aceptar | 2. Reintentar");
                switch (seleccion) {
                    case "1":
                        System.out.println("Tipo de material a entregar: ");
                        this.funcionesVarias("  1. Libro | 2. Audiovisual");
                        switch (seleccion) {
                            case "1":
                                this.opcionDP_Libro();
                                break;
                            case "2":
                                this.opcionDP_AudioVisual();
                                break;
                        }
                        break;
                    case "2":
                        this.opcionPrestamo();
                        break;
                }
        }
    }

    private void opcionNP_Libro() {
        String titulo, area, idioma, fechaRealizacion;
        int codigo = 0;

        System.out.println("Nuevo Prestamo - Libro");
        System.out.println("");
        System.out.print("Fecha realización (23-03-2020): ");
        fechaRealizacion = sc.nextLine();
        codigo = this.verificarEnteros("Ingrese el código del libro: ", "Ingrese un código valido...");

        System.out.print("Titulo del libro: ");
        sc.nextLine();
        titulo = sc.nextLine();
        System.out.print("Area del libro: ");
        area = sc.nextLine();
        System.out.print("Idioma del libro: ");
        idioma = sc.nextLine();

        System.out.println("");
        this.funcionesVarias("  1. Guardar | 2. Reintentar");

        switch (seleccion) {
            case "1":
                Libro libro = new Libro(codigo, titulo, area, idioma);
                this.auxPrestamo = new Prestamo(fechaRealizacion, libro);
                auxEstudiante.addPrestamo(auxPrestamo);
                System.out.println("             Guardado Exitosamente              ");
                System.out.println(marco);

                this.funcionesVarias("  1. Nuevo Prestamo | 2. Salir");
                switch (seleccion) {
                    case "1":
                        this.opcionPrestamo();
                        break;
                    case "2":
                        this.activarMenu();
                        break;
                }
                break;
            case "2":
                this.opcionNP_Libro();
                break;
        }
    }

    private void opcionNP_AudioVisual() {
        String titulo, fechaRealizacion;
        int codigo, duracion;

        System.out.println("Nuevo Prestamo - Audiovisual");
        System.out.println("");
        System.out.print("Fecha realización (23-03-2020): ");
        fechaRealizacion = sc.nextLine();
        System.out.print("Título del audiovisual: ");
        titulo = sc.nextLine();
        codigo = this.verificarEnteros("Código del audiovisual: ", "Ingrese un código valido...");
        duracion = this.verificarEnteros("Duración del audiovisual: ", "Ingrese una duración valida...");

        System.out.println("");
        sc.nextLine();
        this.funcionesVarias("  1. Guardar | 2. Reintentar");

        switch (seleccion) {
            case "1":
                AudioVisual audioVisual = new AudioVisual(codigo, titulo, duracion);
                auxPrestamo = new Prestamo(fechaRealizacion, audioVisual);
                auxEstudiante.addPrestamo(auxPrestamo);

                this.funcionesVarias("  1. Nuevo Prestamo | 2. Salir");
                switch (seleccion) {
                    case "1":
                        this.opcionPrestamo();
                        break;
                    case "2":
                        this.activarMenu();
                        break;
                }
                break;
            case "2":
                this.opcionNP_AudioVisual();
                break;
        }
    }

    private void opcionDP_Libro() {
        String fechaDevolucion;
        int codigo = this.verificarEnteros("Ingrese el código del libro: ", "Ingrese un código valido...");

        for (Prestamo per : auxEstudiante.getRegistroPrestamos()) {
            if (per.getMaVisual() == null) {
                if (per.getLibro().getCodigo() == codigo) {
                    auxPrestamo = per;
                    break;
                }
            }
        }

        System.out.println("Datos del Material: ");
        auxPrestamo.getLibro().imprimirInfo();

        System.out.print("Fecha Devolucion (23-03-2020): ");
        fechaDevolucion = sc.nextLine();

        this.funcionesVarias("  1. Guardar | 2. Reintentar");

        switch (seleccion) {
            case "1":
                auxPrestamo.setFechaDevolucion(fechaDevolucion);
                System.out.println("Fecha: " + auxPrestamo.getFechaRealizacion());
                this.funcionesVarias("  1. Guardar | 2. Reintentar");
                switch (seleccion) {
                    case "1":
                        this.opcionPrestamo();
                        break;
                    case "2":
                        this.activarMenu();
                        break;
                }
                break;
            case "2":
                this.opcionPrestamo();
                break;
        }
    }

    private void opcionDP_AudioVisual() {
        String fechaDevolucion;
        int codigo = this.verificarEnteros("Código del audiovisual: ", "Ingrese un código valido...");

        for (Prestamo per : auxEstudiante.getRegistroPrestamos()) {
            if (per.getLibro() == null) {
                if (per.getMaVisual().getCodigo() == codigo) {
                    auxPrestamo = per;
                    break;
                }
            }
        }

        System.out.println("Datos del Material: ");
        auxPrestamo.getMaVisual().imprimirInfo();

        System.out.print("Fecha Devolucion (23-03-2020): ");
        sc.nextLine();
        fechaDevolucion = sc.nextLine();

        this.funcionesVarias("  1. Guardar | 2. Reintentar");

        switch (seleccion) {
            case "1":
                auxPrestamo.setFechaDevolucion(fechaDevolucion);
                System.out.println("Fecha: " + auxPrestamo.getFechaDevolucion());
                this.funcionesVarias("  1. Guardar | 2. Reintentar");
                switch (seleccion) {
                    case "1":
                        this.opcionPrestamo();
                        break;
                    case "2":
                        this.activarMenu();
                        break;
                }
                break;
            case "2":
                this.opcionPrestamo();
                break;
        }
    }

    private void opcionReportesEstudiantes() {
        this.verificarCarrera();
        this.verificarEstudiante();

        System.out.println("Prestamos registrados: ");
        for (Prestamo registroPrestamo : auxEstudiante.getRegistroPrestamos()) {
            if (registroPrestamo.getMaVisual() == null) {
                registroPrestamo.imprimirInfo();
            } else {
                registroPrestamo.imprimirInfo();
            }
            System.out.println("");
        }
    }

    private void opcionSalir() {
        System.out.println("      Gracias por utilizar nuestro sistema.     ");
        System.out.println(marco);
    }

    private void verificarCarrera() {
        boolean bandera = true;
        int aux;

        System.out.println("En qué carrera se encuentra el estudiante: ");
        for (int i = 0; i < carreras.size(); i++) {
            System.out.println("    " + (i + 1) + ". " + carreras.get(i).getNombre());
            System.out.println("\tDirector: " + carreras.get(i).getNombreDirector());
        }

        do {
            System.out.println(marco);
            System.out.print("    Selección: ");
            aux = sc.nextInt();
            aux--;

            if (!(aux >= 0 && aux < carreras.size())) {
                System.out.println(marco);
                System.out.println("    Carrera no existente   ");
            } else {
                bandera = false;
                auxCarrera = carreras.get(aux);
            }
        } while (bandera);
    }

    private void verificarEstudiante() {
        String cedula;

        System.out.println(marco);
        System.out.print("Número de cédula del estudiante: ");
        sc.nextLine();
        cedula = sc.nextLine();

        while (!auxEstudiante.verificarCedula(cedula)) {
            System.out.print("Ingrese un número valido: ");
            cedula = sc.nextLine();
        }

        for (Estudiante estu : auxCarrera.getRegistroAlumnos()) {
            if (estu.getCedula().equalsIgnoreCase(cedula)) {
                auxEstudiante = estu;
            }
        }
    }

    private int verificarEnteros(String nota1, String nota2) {
        boolean bandera = true;
        int aux = 0;

        while (bandera) {
            System.out.print(nota1);

            try {
                aux = sc.nextInt();
                bandera = false;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println(nota2);
            }
        }
        return aux;
    }

    private void funcionesVarias(String cadenaExtra) {
        boolean bandera;

        do {
            bandera = false;

            System.out.println(cadenaExtra);
            System.out.println(marco);
            System.out.print("    Selección: ");
            seleccion = sc.nextLine();
            System.out.println(marco);

            if (!(seleccion.equals("1") || seleccion.equals("2"))) {
                bandera = true;
                System.out.println("          Seleccione una opción existente       ");
                System.out.println(marco);
            }
        } while (bandera);
    }
}
