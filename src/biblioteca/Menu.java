package biblioteca;

import java.util.*;

public class Menu {

    //Variables
    private ArrayList<Carrera> carreras = new ArrayList<>();
    private String seleccion = "";
    private Prestamo auxPrestamo = new Prestamo();
    private int auxint;
    private Estudiante auxEstudiante = new Estudiante();
    private Carrera auxCarrera = new Carrera();
    private int diasMes = 30;
    private int maxDias = 45;
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
                System.out.println(Menu.marco);
                this.activarMenu();
                break;
        }
    }

    //Metodo que registra un nuevo estudiante
    public void opcionNuevoEstudiante() {
        auxEstudiante = new Estudiante();
        String cedula = "", nombre, genero;

        this.verificarCarrera(); //Verifica que exita la carrera

        do {
            //Verificar información del estudiante
            cedula = this.verificarCedula();
            auxEstudiante.setCedula(cedula);
            nombre = this.verificarString("Ingrese el nombre del estudiante: ");
            auxEstudiante.setNombre(nombre);
            genero = this.verificarString("Ingrese el genero del estudiante: ");
            auxEstudiante.setGenero(genero);
            System.out.println("");

            this.opcionesVarias("  1. Guardar | 2. Reintentar | 3. Salir", true);
            bandera = seleccion.equals("2");
            auxint = 1;

            if (seleccion.equals("3")) {
                this.activarMenu();
                bandera = false;
            }

        } while (bandera);

        auxint = 0;

        //Opciones para continuar....
        if (seleccion.equals("1")) {
            if (!auxCarrera.addStudent(auxEstudiante)) {
                System.out.println("             Guardado Exitosamente");
                System.out.println(marco);
            }
            this.opcionesVarias("  1. Nuevo Estudiante | 2. Salir", false);
            switch (seleccion) {
                case "1":
                    this.opcionNuevoEstudiante();
                    break;
                case "2":
                    this.activarMenu();
                    break;
            }
        }
    }

    //Metodo que registra una nueva carrera
    public void opcionNuevaCarrera() {
        String nombreCarrera, nombreDirector;
        int duracion;

        //Verificar y llenar información de carrera
        nombreCarrera = this.verificarString("Ingrese el nombre de la carrera: ");
        nombreDirector = this.verificarString("Ingrese el nombre del director: ");

        do {
            duracion = this.verificarEnteros("Ingrese el número de semestres: ", "Ingrese un número valido...");
            if (duracion >= 3 && duracion <= 15) {
                bandera = false;
            } else {
                System.out.println("Ingrese un número valido...");
                bandera = true;
            }
        } while (bandera);

        System.out.println("");
        sc.nextLine();
        this.opcionesVarias("  1. Guardar | 2. Reintentar | 3. Salir", true);

        switch (seleccion) {
            case "1":
                Carrera carrera = new Carrera(nombreCarrera, duracion, nombreDirector);
                carreras.add(carrera);
                System.out.println("             Guardado Exitosamente              ");
                System.out.println(marco);
                this.opcionesVarias("  1. Nueva Carrera | 2. Salir", false);
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
            case "3":
                this.activarMenu();
                break;
        }
    }

    //Metodo que indica las opciones que tiene un prestamo
    public void opcionPrestamo() {

        this.opcionesVarias("  1. Registrar Nuevo Prestamo | 2. Entrega de Material \n\t\t      3. Salir", true);

        if (seleccion.equals("3")) { //Llamar a la función que activa el menu
            this.activarMenu();
        }

        //Verificar la carrera y al estudiante para poder continuar
        this.verificarCarrera();
        this.verificarEstudiante();

        //Imprimir la información del estudiante si se ha podido encontrar
        System.out.println(marco);
        System.out.println("Información: ");
        System.out.println("");
        auxEstudiante.mostrarInfo();
        System.out.println("");

        //Verificar las opciones para continuar
        switch (seleccion) {
            case "1": //Si la selección fue 1, llama a la función nuevoPrestamo
                this.opcionesVarias("  1. Aceptar | 2. Reintentar", false);
                switch (seleccion) {
                    case "1":
                        //Si en las últimas 3 entregas el estudiante no ha devuelto el material a tiempo no 
                        //permite la realización de un nuevo prestamo
                        if (!auxEstudiante.isResponsable()) {
                            System.out.println("El estudiante tiene que pagar multa por atrasos, \n"
                                    + "no se puede prestar mas materiales hasta que cancele.");
                            System.out.println("");
                            this.opcionesVarias("  1. Cancelar Pago y Continuar      | 2. Salir", false);
                            if (!seleccion.equals("1")) {
                                this.opcionPrestamo();
                            }
                        }

                        //Opciones disponibles para prestar
                        System.out.println("Tipo de material a prestar: ");
                        System.out.println("");
                        this.opcionesVarias("  1. Libro | 2. Audiovisual", false);
                        this.opcionNuevoPrestamo(Integer.parseInt(seleccion));
                        break;
                    case "2": //Opción para reintentar
                        this.opcionPrestamo();
                        break;
                }
                break;

            case "2": //Si la selección fue 2, llama a la función nuevaEntrega
                this.opcionesVarias("  1. Aceptar | 2. Reintentar", false);
                switch (seleccion) {
                    case "1":
                        if (auxEstudiante.getRegistroPrestamos().isEmpty()) {
                            System.out.println("No hay prestamos registrados...");
                            System.out.println(marco);
                            this.opcionesVarias("  1. Aceptar | 2. Salir", false);
                            if (!seleccion.equals("1")) {
                                this.activarMenu();
                            } else {
                                this.opcionPrestamo();
                            }
                        }

                        System.out.println("Tipo de material a entregar: ");
                        System.out.println("");
                        this.opcionesVarias("  1. Libro | 2. Audiovisual", false);
                        this.opcionEntregaPrestamo(Integer.parseInt(seleccion));
                        break;
                    case "2":
                        this.opcionPrestamo();
                        break;
                }
        }
    }

    //Metodo para llenar un nuevo prestamo
    private void opcionNuevoPrestamo(int selec) {
        String titulo = "", area = "", idioma = "";
        int codigo = 0;
        int duracion = 0;
        Libro libro = null;
        AudioVisual audioVisual = null;
        if (selec == 1) {

            System.out.println("Nuevo Prestamo - Libro");
            System.out.println("");
            codigo = this.verificarEnteros("Ingrese el código del libro (Ej. 123): ", "Ingrese un código valido...");

            sc.nextLine();

            //Verificar y llenar información del prestamo...
            titulo = this.verificarString("Titulo del libro: ");
            area = this.verificarString("Area del libro: ");
            idioma = this.verificarString("Idioma del libro: ");

        } else if (selec == 2) {

            System.out.println("Nuevo Prestamo - Audiovisual");
            System.out.println("");

            titulo = this.verificarString("Título del audiovisual: ");
            codigo = this.verificarEnteros("Código del audiovisual (Ej. 123): ", "Ingrese un código valido...");
            duracion = this.verificarEnteros("Duración del audiovisual: ", "Ingrese una duración valida...");
            sc.nextLine();
        }

        System.out.println("");
        this.opcionesVarias("  1. Guardar | 2. Reintentar", false);

        if (seleccion.equals("1")) {
            if (selec == 1) {
                libro = new Libro(codigo, titulo, area, idioma);
            } else {
                audioVisual = new AudioVisual(codigo, titulo, duracion);
            }

            this.establecerDatos(libro, audioVisual);
            this.informacionTiket(libro, audioVisual);

            System.out.println("");
            this.opcionesVarias("  1. Opciones Prestamo | 2. Salir", false);

            switch (seleccion) {
                case "1":
                    this.opcionPrestamo();
                    break;
                case "2":
                    this.activarMenu();
                    break;
            }
        } else {
            this.opcionNuevoPrestamo(selec);
        }
    }

    //Metodo que registra las entregas
    private void opcionEntregaPrestamo(int selec) {
        String tipo = (selec == 1) ? "libro" : "audiovisual";

        do {
            this.verificarMaterial(tipo);

            if (auxPrestamo.isEntregado()) {
                System.out.println("Material entregado... ");
                System.out.println(marco);
            } else {
                bandera = false;
            }

            System.out.println("Datos del Material: ");
            System.out.println("");

            if (selec == 1) {
                auxPrestamo.getLibro().imprimirInfo();
            } else {
                auxPrestamo.getMaVisual().imprimirInfo();
            }

            System.out.println("");
            sc.nextLine();

            if (auxPrestamo.isEntregado()) {
                auxPrestamo.imprimirInfo();
                System.out.println("");
                this.opcionesVarias("  1. Reintentar Código | 2. Opciones Prestamo", false);
                switch (seleccion) {
                    case "1":
                        bandera = true;
                        break;
                    case "2":
                        bandera = false;
                        this.opcionPrestamo();
                        break;
                }
            }
        } while (bandera);

        this.opcionesVarias("  1. Aceptar | 2. Reintentar | 3. Salir", true);

        switch (seleccion) {
            case "1":
                System.out.println("Ingrese fecha de entrega: ");

                do {
                    auxPrestamo.devolverMaterial(this.llenarFecha());
                    System.out.println("");
                    sc.nextLine();
                    this.opcionesVarias("  1. Aceptar | 2. Reintentar Fecha", false);
                    bandera = !seleccion.equals("1");

                } while (bandera);

                this.informacionTiket(auxPrestamo.getLibro(), auxPrestamo.getMaVisual());

                System.out.println("");
                this.opcionesVarias("  1. Opciones Prestamo | 2. Salir", false);

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
                this.opcionEntregaPrestamo(selec);
                break;
            case "3":
                this.activarMenu();
                break;
        }
    }

    //Metodo que muestra la información de los estudiantes
    public void opcionReportesEstudiantes() {
        this.verificarCarrera();
        this.verificarEstudiante();

        System.out.println(marco);
        System.out.println("Prestamos registrados: ");
        System.out.println(marco);

        if (auxEstudiante.getRegistroPrestamos().isEmpty()) {
            System.out.println("No se han registrado prestamos");
            System.out.println(marco);
        }

        for (Prestamo registroPrestamo : auxEstudiante.getRegistroPrestamos()) {
            if (registroPrestamo.getMaVisual() == null) {
                registroPrestamo.getLibro().imprimirInfo();
                registroPrestamo.imprimirInfo();
            } else {
                registroPrestamo.getMaVisual().imprimirInfo();
                registroPrestamo.imprimirInfo();
            }
            System.out.println("");
        }

        this.opcionesVarias("  1. Nueva Verificación | 2. Salir", false);

        switch (seleccion) {
            case "1":
                this.opcionReportesEstudiantes();
                break;
            case "2":
                this.activarMenu();
                break;
        }
    }

    //Metodo que da cierra a la aplicación
    public void opcionSalir() {
        System.out.println("      Gracias por utilizar nuestro sistema.     ");
        System.out.println(marco);
        System.exit(0);
    }

    //Metodo que sirve para verificar una carrera
    private void verificarCarrera() {
        if (carreras.isEmpty()) {
            System.out.println("No hay datos registrados...");
            System.out.println(marco);
            System.out.println("Creando Nueva Carrera: ");
            this.opcionNuevaCarrera();
        } else {
            System.out.println("En qué carrera se encuentra el estudiante: ");
            for (int i = 0; i < carreras.size(); i++) {
                System.out.println("    " + (i + 1) + ". " + carreras.get(i).getNombre());
                System.out.println("\tDirector: " + carreras.get(i).getNombreDirector());
            }

            System.out.println("");
            System.out.println("    " + (carreras.size() + 1) + ". Nueva Carrera | " + (carreras.size() + 2) + ". Salir");
            System.out.println(marco);
            do {
                auxint = 0;
                auxint = this.verificarEnteros("     Selección (Eje. 1,2...): ", marco + "\nOpción no validad...\n" + marco);

                bandera = true;

                if (auxint == (carreras.size() + 1)) {
                    sc.nextLine();
                    System.out.println(marco);
                    this.opcionNuevaCarrera();
                    break;
                } else if (auxint == (carreras.size() + 2)) {
                    sc.nextLine();
                    System.out.println(marco);
                    this.activarMenu();
                    break;
                }

                if ((auxint <= 0) || (auxint > (carreras.size() + 2))) {
                    System.out.println(marco);
                    System.out.println("    Opción no existente");
                    System.out.println(marco);
                    bandera = true;
                } else if ((auxint >= 1) && (auxint <= carreras.size())) {
                    auxint--;
                    auxCarrera = carreras.get(auxint);
                    System.out.println(marco);
                    break;
                }
            } while (bandera);
        }
    }

    //Metodo para verificar el número de cédula
    private String verificarCedula() {
        String cedula = "";
        if (auxint != 1) {
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

    //Metodo para verificar al estudiante
    private void verificarEstudiante() {
        do {
            String cedula = this.verificarCedula();

            for (Estudiante estu : auxCarrera.getRegistroAlumnos()) {
                if (estu.getCedula().equalsIgnoreCase(cedula)) {
                    auxEstudiante = estu;
                    bandera = false;
                }
            }

            if (bandera) {
                System.out.println("Estudiante no encontrado...");
                System.out.println("");
                this.opcionesVarias("  1. Reintentar cédula | 2. Opciones Prestamo | 3. Salir", true);

                switch (seleccion) {
                    case "1":
                        auxint++;
                        bandera = true;
                        break;
                    case "2":
                        bandera = false;
                        this.opcionPrestamo();
                        break;
                    case "3":
                        bandera = false;
                        break;
                }
            }

        } while (bandera);
    }

    //Metodo que valida el material
    private void verificarMaterial(String tipo) {
        int codigo = 0;

        do {
            bandera = false;
            auxPrestamo = new Prestamo();

            codigo = this.verificarEnteros(("Ingrese el código del " + tipo + ": "), "Ingrese un código valido...");
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
                this.opcionesVarias("  1. Reintentar código | 2. Opciones Prestamo", false);

                switch (seleccion) {
                    case "1":
                        bandera = false;
                        break;
                    case "2":
                        bandera = true;
                        this.opcionPrestamo();
                        break;
                }
            }
        } while (!bandera);
    }

    //Metodo que verifica si la información entregada solo contiene números
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

    //Metodo que verifica si la información entregada solo contiene letras
    private String verificarString(String nota1) {
        String dato = "";

        do {

            System.out.print(nota1);
            bandera = true;

            while (bandera) {
                try {
                    dato = sc.nextLine();
                    bandera = false;
                } catch (InputMismatchException e) {
                    sc.nextLine();
                    System.out.println("Dato no valido...");
                }
            }

            if (dato.equals("")) {
                System.out.println("Debe Llenar la información...");
                bandera = true;
            } else {
                bandera = false;
            }

        } while (bandera);

        return dato;
    }

    //Metodos para modificar y llenar las fechas fechas
    public Date modificarFecha() {
        Date fecha = new Date();
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

        return new Date(anio + 1900, mes, dia);
    }

    private Date llenarFecha() {
        do {
            dia = this.verificarEnteros("Dia (Ejem. 23): ", "Dia no valido...");

            if (dia > 0 && dia <= 30) {
                bandera = false;
            } else {
                System.out.println("Dia no valido...");
                bandera = true;
            }
        } while (bandera);

        do {
            mes = this.verificarEnteros("Mes (Ejem. 07): ", "Mes no valido...");

            if (mes > 0 && mes <= 12) {
                bandera = false;
                mes--;
            } else {
                System.out.println("Mes no valido...");
                bandera = true;
            }

        } while (bandera);

        do {
            anio = this.verificarEnteros("Año (Ejem. 2020): ", "Año no valido...");

            if (anio > 2000) {
                bandera = false;
            } else {
                System.out.println("Año no valido...");
                bandera = true;
            }

        } while (bandera);

        String diaEntrega = Integer.toString(anio) + Integer.toString(mes) + Integer.toString(this.dia);

        String diaDev = (Integer.toString(auxPrestamo.getFechaPrestamo().getYear()) + Integer.toString(auxPrestamo.getFechaPrestamo().getMonth())
                + Integer.toString(auxPrestamo.getFechaPrestamo().getDate()));

        if (Integer.parseInt(diaEntrega) < Integer.parseInt(diaDev)) {
            System.out.println("Fecha no valida... ");
            this.llenarFecha();
        }

        return new Date(anio, mes, dia);
    }

    //Metodos que establecen la información en los pretamos
    private void establecerDatos(Libro libro, AudioVisual audioVisual) {
        Date fecha = new Date();
        fecha.setYear(fecha.getYear() + 1900);
        fecha.setMonth(fecha.getMonth());
        if (audioVisual == null) {
            this.auxPrestamo = new Prestamo(fecha, libro);
        } else {
            this.auxPrestamo = new Prestamo(fecha, audioVisual);
        }
        this.auxPrestamo.setFechaDevolucion(this.modificarFecha());
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
    }

    //Metodo que establece las opciones
    private void opcionesVarias(String cadenaExtra, boolean activarOA) {
        do {
            bandera = false;

            System.out.println(cadenaExtra);
            System.out.println(marco);
            System.out.print("    Selección: ");
            seleccion = sc.nextLine();
            seleccion = seleccion.replace(" ", "");
            System.out.println(marco);

            if (activarOA) {
                if (!(seleccion.equals("1") || seleccion.equals("2") || seleccion.equals("3"))) {
                    bandera = true;
                    System.out.println("          Seleccione una opción existente       ");
                    System.out.println(marco);
                }
            } else {
                if (!(seleccion.equals("1") || seleccion.equals("2"))) {
                    bandera = true;
                    System.out.println("          Seleccione una opción existente       ");
                    System.out.println(marco);
                }
            }
        } while (bandera);
    }
}
