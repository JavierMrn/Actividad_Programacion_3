package Bibioteca;

import java.util.ArrayList;

public class Estudiante {

    private String nombre;
    private String genero;
    private String cedula;
    private ArrayList<Prestamo> registroPrestamos = new ArrayList<>();

    //Constructores
    public Estudiante() {
        this.nombre = "";
        this.genero = "";
        this.cedula = "";
        registroPrestamos.clear();
    }

    public Estudiante(String nombre, String genero, String cedula) {
        this.nombre = nombre;
        this.genero = genero;
        this.cedula = cedula;
        registroPrestamos.clear();
    }

    //Verificar número de cédula
    public boolean verificarCedula(String cedula) {
        boolean cedulaCorrecta = false;

        try {
            if (cedula.length() == 10) {
                int tercerDijito = Integer.parseInt(cedula.substring(2, 3));
                int[] cofValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                int verificador = Integer.parseInt(cedula.substring(9, 10));
                int suma = 0;
                int dijito = 0;
                for (int i = 0; i < (cedula.length() - 1); i++) {
                    dijito = Integer.parseInt(cedula.substring(i, i + 1)) * cofValCedula[i];
                    suma += ((dijito % 10) + (dijito / 10));
                }

                if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                    cedulaCorrecta = true;
                } else {
                    cedulaCorrecta = (10 - (suma % 10)) == verificador;
                }
            } else {
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException e) {
            cedulaCorrecta = false;
        } catch (Exception err) {
            System.out.println("Una excepcion ocurrio en el proceso de validadcion");
            cedulaCorrecta = false;
        }
        if (!cedulaCorrecta) {
            System.out.println("La Cédula ingresada es Incorrecta");
        }
        return cedulaCorrecta;
    }

    //Metodo para añadir un prestamo
    public void addPrestamo(Prestamo a) {
        registroPrestamos.add(a);
    }

    //Metodo que consulta los prestamos
    public boolean isResponsable() {

        return !registroPrestamos.isEmpty();
    }
    
    public void mostrarInfo(){
        System.out.println("Nombre del Estudiante: " + nombre);
        System.out.println("Genero del Estudiante: " + genero);
        System.out.println("Materiales prestados: " + registroPrestamos.size());
    }

    //Metodos getters and setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public ArrayList<Prestamo> getRegistroPrestamos() {
        return registroPrestamos;
    }
}
