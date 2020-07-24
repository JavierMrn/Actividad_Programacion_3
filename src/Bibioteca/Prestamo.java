package Bibioteca;

import java.util.Date;

public class Prestamo {

    private Date fechaPrestamo, fechaDevolucion, fechaEntrega;
    private boolean atrasado;
    private boolean entregado;
    private Libro libro;
    private AudioVisual maVisual;
    

    //Constructores
    public Prestamo() {
        this.fechaPrestamo = null;
        this.fechaDevolucion = null;
        this.fechaEntrega = null;
        this.libro = null;
        this.maVisual = null;
        this.atrasado = false;
        this.entregado = false;
    }

    public Prestamo(Date fechaPrestamo, AudioVisual maVisual) {
        this.fechaPrestamo = fechaPrestamo;
        this.maVisual = maVisual;
        this.libro = null;
        this.atrasado = false;
        this.entregado = false;
    }

    public Prestamo(Date fechaPrestamo, Libro libro) {
        this.fechaPrestamo = fechaPrestamo;
        this.libro = libro;
        this.maVisual = null;
        this.atrasado = false;
        this.entregado = false;
    }

    //Metodos
    public void devolverMaterial(Date fecha) {
        this.fechaEntrega = fecha;
        this.entregado = true;
        
        int diaEnt = (fechaEntrega.getDate()+ fechaEntrega.getMonth() + fechaEntrega.getYear());
        int diaDev = (fechaDevolucion.getDate()+ fechaDevolucion.getMonth() + fechaDevolucion.getYear());
        
        if(diaEnt > diaDev){
            this.atrasado = true;
        }
    }

    public void imprimirInfo() {
        System.out.println("Fecha realización: " + fechaPrestamo.getDate() + "/" + fechaPrestamo.getMonth() + "/" + fechaPrestamo.getYear());
        System.out.println("Fecha máxima de entrega: " + fechaDevolucion.getDate() + "/" + fechaDevolucion.getMonth() + "/" + fechaDevolucion.getYear());
        if (fechaEntrega != null) {
            System.out.println("Fecha de entrega: " + fechaEntrega.getDate() + "/" + fechaEntrega.getMonth() + "/" + fechaEntrega.getYear());
            if (atrasado) {
                System.out.println("Entrega el material atrasado...");
            }
        }
    }

    //Metodos getters and setters
    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public boolean isAtrasado() {
        return atrasado;
    }

    public void setAtrasado(boolean atrasado) {
        this.atrasado = atrasado;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public AudioVisual getMaVisual() {
        return maVisual;
    }

    public void setMaVisual(AudioVisual maVisual) {
        this.maVisual = maVisual;
    }

    public boolean isEntregado() {
        return entregado;
    }
}
