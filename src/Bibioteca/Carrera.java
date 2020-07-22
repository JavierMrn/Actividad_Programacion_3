package Bibioteca;

import java.util.*;

public class Carrera {

    private String nombre;
    private int duracionSemestre;
    private String nombreDirector;
    private ArrayList<Estudiante> registroAlumnos = new ArrayList<>();
    
    //Constructores 
    public Carrera() {
        this.nombre = "";
        this.duracionSemestre = 0;
        this.nombreDirector = "";
        registroAlumnos.clear();
    }
    
    public Carrera(ArrayList<Estudiante> estudiantes) {
        this.nombre = "";
        this.duracionSemestre = 0;
        this.nombreDirector = "";
        this.registroAlumnos = estudiantes;
        registroAlumnos.clear();
    }

    public Carrera(String nombre, int duracionSemestre, String nombreDirector) {
        this.nombre = nombre;
        this.duracionSemestre = duracionSemestre;
        this.nombreDirector = nombreDirector;
        registroAlumnos.clear();
    }

    //Metodo para ingresar nuevos estudiantes
    public boolean addStudent(Estudiante a) {
        
        for (int i = 0; i < registroAlumnos.size(); i++) {
            if (a.getCedula().equals(registroAlumnos.get(i).getCedula())) {
                System.out.println("          El estudiante ya existe"               );
                System.out.println(Menu.marco);
                return true;
            }
        }
        
        registroAlumnos.add(a);
        return false;
    }

    //Metodos Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getDuracionSemestre() {
        return duracionSemestre;
    }

    public void setDuracionSemestre(int duracionSemestre) {
        this.duracionSemestre = duracionSemestre;
    }

    public String getNombreDirector() {
        return nombreDirector;
    }

    public void setNombreDirector(String nombreDirector) {
        this.nombreDirector = nombreDirector;
    }

    public Estudiante getEstudiante(int index) {
        return registroAlumnos.get(index);
    }

    public ArrayList<Estudiante> getRegistroAlumnos() {
        return registroAlumnos;
    }

    public void setRegistroAlumnos(ArrayList<Estudiante> registroAlumnos) {
        this.registroAlumnos = registroAlumnos;
    }
}
