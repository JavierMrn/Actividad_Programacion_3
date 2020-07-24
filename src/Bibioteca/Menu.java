package Bibioteca;

import java.util.*;

public class Menu {

    //Variables
    private ArrayList<Carrera> carreras = new ArrayList<>();
    private String seleccion;
    private Prestamo auxPrestamo = new Prestamo();
    private int auxint;
    private Estudiante auxEstudiante = new Estudiante();
    private Carrera auxCarrera = new Carrera();
    private Date fecha;
    private int diasMes = 30;
    private int maxDias = 25;
    private int dia, mes, anio;
    boolean bandera;

    public static String marco = "--------------------------------------------------------";
    Scanner sc = new Scanner(System.in);

    //Constructores
    public Menu(ArrayList<Carrera> carreras) {
        this.carreras = carreras;
    }

    public Menu() {
    }

    //Metodos
    public void activarMenu() {
        this.opciones();
    }

    private void opciones() {
        System.out.println("Seleccione una opción:");
        System.out.println("    1. Añadir nuevo estudiante.");
        System.out.println("    2. Añadir nueva carrera.");
        System.out.println("    3. Opciones Pretamo.");
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

        if (carreras.isEmpty()) {
            System.out.println("Noy hay carreras registradas...");
            System.out.println(marco);
            System.out.println("Creando Nueva Carrera: ");
            this.opcionNuevaCarrera();
        }

        auxEstudiante = new Estudiante();
        String cedula = "", nombre, genero;

        this.verificarCarrera();

        cedula = this.verificarCedula();
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
        String nombreCarrera, nombreDirector;
        int duracion;

        System.out.print("Ingrese el nombre de la carrera: ");
        nombreCarrera = sc.nextLine();
        System.out.print("Ingrese el nombre del director: ");
        nombreDirector = sc.nextLine();

        do {
            duracion = this.verificarEnteros("Ingrese el número de semestres: ", "Ingrese un número valido...");
            if (duracion >= 5 && duracion <= 12) {
                bandera = false;
            } else {
                System.out.println("Ingrese un número valido...");
                bandera = true;
            }
        } while (bandera);

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
        this.funcionesVarias("  1. Registrar Nuevo Prestamo | 2. Entrega de Material");

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
                        System.out.println("");
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
                        System.out.println("");
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

    private void opcionNuevoPrestamo() {
        String titulo, area, idioma;
        int codigo = 0;
        int duracion;

        if (seleccion.equals("1")) {
            System.out.println("Nuevo Prestamo - Libro");
            System.out.println("");
            codigo = this.verificarEnteros("Ingrese el código del libro (Ej. 123): ", "Ingrese un código valido...");

            System.out.print("Titulo del libro: ");
            sc.nextLine();
            titulo = sc.nextLine();
            System.out.print("Area del libro: ");
            area = sc.nextLine();
            System.out.print("Idioma del libro: ");
            idioma = sc.nextLine();
        } else {
            System.out.println("Nuevo Prestamo - Audiovisual");

            System.out.print("Título del audiovisual: ");
            titulo = sc.nextLine();
            codigo = this.verificarEnteros("Código del audiovisual: ", "Ingrese un código valido...");
            duracion = this.verificarEnteros("Duración del audiovisual: ", "Ingrese una duración valida...");
        }
        
        System.out.println("");
        this.funcionesVarias("  1. Guardar | 2. Reintentar");
    }

    public void opcionNP_Libro() {
        String titulo, area, idioma;
        int codigo = 0;

        System.out.println("Nuevo Prestamo - Libro");

        System.out.println("");
        codigo = this.verificarEnteros("Ingrese el código del libro (Ej. 123): ", "Ingrese un código valido...");

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
                this.establecerDatos(libro, null);
                this.informacionTiket(libro, null);
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

    public void opcionNP_AudioVisual() {
        String titulo;
        int codigo, duracion;

        System.out.println("Nuevo Prestamo - Audiovisual");

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
                this.establecerDatos(null, audioVisual);
                this.informacionTiket(null, audioVisual);
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

    public void opcionDP_Libro() {
        fecha = new Date();

        this.verificarMaterial("libro");

        if (auxPrestamo.isEntregado()) {
            System.out.println("Material entregado... ");
            System.out.println(marco);
        }

        System.out.println("Datos del Material: ");
        System.out.println(marco);
        auxPrestamo.getLibro().imprimirInfo();

        System.out.println("");
        sc.nextLine();

        if (auxPrestamo.isEntregado()) {
            auxPrestamo.imprimirInfo();
            System.out.println("");
            this.funcionesVarias("  1. Reintentar Código | 2. Opciones Prestamo");
            switch (seleccion) {
                case "1":
                    this.opcionDP_Libro();
                    break;
                case "2":
                    this.opcionPrestamo();
                    break;
            }
        }

        this.funcionesVarias("  1. Aceptar | 2. Reintentar");

        switch (seleccion) {
            case "1":
                System.out.println("Ingrese fecha de entrega: ");
                do {
                    bandera = true;
                    fecha = this.llenarFecha();
                    System.out.println("");
                    sc.nextLine();
                    this.funcionesVarias("  1. Aceptar | 2. Reintentar");
                    if ("1".equals(seleccion)) {
                        bandera = false;
                    }

                } while (bandera);

                auxPrestamo.devolverMaterial(fecha);

                this.informacionTiket(auxPrestamo.getLibro(), null);

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
                this.opcionDP_Libro();
                break;
        }
    }

    public void opcionDP_AudioVisual() {
        fecha = new Date();
        this.verificarMaterial("audiovisual");

        System.out.println("Datos del Material: ");
        auxPrestamo.getMaVisual().imprimirInfo();

        System.out.println("");
        sc.nextLine();
        this.funcionesVarias("  1. Aceptar | 2. Reintentar");

        switch (seleccion) {
            case "1":
                System.out.println("Ingrese fecha de entrega: ");
                do {
                    bandera = true;
                    fecha = this.llenarFecha();
                    System.out.println("");
                    sc.nextLine();
                    this.funcionesVarias("  1. Aceptar | 2. Reintentar");
                    if ("1".equals(seleccion)) {
                        bandera = false;
                    }

                } while (bandera);

                System.out.println("Holaaaaaaaaaa");
                auxPrestamo.devolverMaterial(fecha);

                this.informacionTiket(null, auxPrestamo.getMaVisual());

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
                this.opcionDP_AudioVisual();
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
        int aux;

        System.out.println("En qué carrera se encuentra el estudiante: ");
        for (int i = 0; i < carreras.size(); i++) {
            System.out.println("    " + (i + 1) + ". " + carreras.get(i).getNombre());
            System.out.println("\tDirector: " + carreras.get(i).getNombreDirector());
        }

        do {
            bandera = true;
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

    private String verificarCedula() {
        String cedula = "";

        if (auxint != 1) {
            System.out.println(marco);
            sc.nextLine();
        }

        System.out.print("Ingrese el número de cedula del estudiante: ");
        cedula = sc.nextLine();

        while (!auxEstudiante.verificarCedula(cedula)) {
            System.out.println(marco);
            System.out.print("Ingrese un número valido: ");
            cedula = sc.nextLine();
        }

        auxint = 0;

        return cedula;
    }

    private void verificarEstudiante() {
        String cedula = this.verificarCedula();

        do {
            bandera = true;

            for (Estudiante estu : auxCarrera.getRegistroAlumnos()) {
                if (estu.getCedula().equalsIgnoreCase(cedula)) {
                    auxEstudiante = estu;
                    bandera = false;
                }
            }

            if (bandera) {
                System.out.println("Estudiante no encontrado...");
                System.out.println("");
                this.funcionesVarias("  1. Ingresar cédula de nuevo | 2. Nuevo Prestamo");

                switch (seleccion) {
                    case "1":
                        auxint++;
                        this.verificarEstudiante();
                        break;
                    case "2":
                        this.opcionPrestamo();
                        break;
                }
            }

        } while (bandera);
    }

    private void verificarMaterial(String tipo) {
        bandera = false;
        auxPrestamo = new Prestamo();

        int codigo = this.verificarEnteros(("Ingrese el código del " + tipo + ": "), "Ingrese un código valido...");
        System.out.println(marco);

        if (tipo.equals("libro")) {
            for (Prestamo per : auxEstudiante.getRegistroPrestamos()) {

                if (per.getMaVisual() == null) {
                    if (per.getLibro().getCodigo() == codigo) {
                        auxPrestamo = per;
                        bandera = true;
                        break;
                    }
                }
            }
        }

        if (tipo.equals("audiovisual")) {
            for (Prestamo per : auxEstudiante.getRegistroPrestamos()) {
                if (per.getLibro() == null) {
                    auxint++;
                    if (per.getMaVisual().getCodigo() == codigo) {
                        auxPrestamo = per;
                        bandera = true;
                        break;
                    }
                }
            }
        }

        if (!bandera) {
            System.out.println("Material no encontrado...");
            System.out.println("");
            sc.nextLine();
            this.funcionesVarias("  1. Reintentar código | 2. Opciones Prestamo");

            switch (seleccion) {
                case "1":
                    this.verificarMaterial(tipo);
                    break;
                case "2":
                    this.opcionPrestamo();
                    break;
            }
        }
    }

    //Metodo verificar fechas
    public void modificarFecha() {
        dia = fecha.getDate() + maxDias;
        mes = fecha.getMonth();
        anio = fecha.getYear();

        do {
            bandera = true;

            if (dia > 30) {
                dia -= diasMes;
                mes++;
                if (mes > 12) {
                    mes = 1;
                    anio++;
                }
            } else {
                bandera = false;
            }
        } while (bandera);

        fecha = new Date(anio, mes, dia);
    }

    private void establecerDatos(Libro libro, AudioVisual audioVisual) {
        fecha = new Date();
        fecha.setYear(fecha.getYear() + 1900);
        fecha.setMonth(fecha.getMonth() + 1);
        if (audioVisual == null) {
            this.auxPrestamo = new Prestamo(fecha, libro);
        } else {
            this.auxPrestamo = new Prestamo(fecha, audioVisual);
        }
        this.modificarFecha();
        this.auxPrestamo.setFechaDevolucion(fecha);
        auxEstudiante.addPrestamo(auxPrestamo);
    }

    private void informacionTiket(Libro libro, AudioVisual audioVisual) {
        System.out.println("             Guardado Exitosamente              ");
        System.out.println(marco);

        System.out.println("Información de entrega: ");
        System.out.println("");
        System.out.println("El estudiante: ");
        auxEstudiante.mostrarInfo();
        System.out.println("\nDatos de material prestado: ");
        if (audioVisual == null) {
            libro.imprimirInfo();
        } else {
            audioVisual.imprimirInfo();
        }
        System.out.println("\nFechas: ");
        this.auxPrestamo.imprimirInfo();

        System.out.println("");
        this.funcionesVarias("  1. Opciones Prestamo | 2. Salir");
    }

    private int verificarEnteros(String nota1, String nota2) {
        bandera = true;
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

    private Date llenarFecha() {
        do {
            dia = this.verificarEnteros("Dia: ", "Dia no valido...");

            if (dia > 0 && dia <= 30) {
                bandera = false;
            } else {
                System.out.println("Dia no valido...");
                bandera = true;
            }
        } while (bandera);

        do {
            mes = this.verificarEnteros("Mes: ", "Mes no valido...");

            if (mes > 0 && mes <= 12) {
                bandera = false;
            } else {
                System.out.println("Mes no valido...");
                bandera = true;
            }

        } while (bandera);

        do {
            anio = this.verificarEnteros("Año: ", "Año no valido...");

            if (anio > 2000) {
                bandera = false;
            } else {
                System.out.println("Año no valido...");
                bandera = true;
            }

        } while (bandera);

        int diaRea = (auxPrestamo.getFechaPrestamo().getDate() + auxPrestamo.getFechaPrestamo().getMonth()
                + auxPrestamo.getFechaPrestamo().getYear());

        if ((dia + mes + anio) < diaRea) {
            System.out.println("Fecha no valida... ");
            this.llenarFecha();
        }

        Date nuevaFecha = new Date(anio, mes, dia);
        return nuevaFecha;
    }

    private void funcionesVarias(String cadenaExtra) {
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
