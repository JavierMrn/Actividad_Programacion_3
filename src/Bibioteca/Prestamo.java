package Bibioteca;

public class Prestamo {

    private String fechaRealizacion, fechaDevolucion;
    private boolean atrasado;
    private Libro libro;
    private AudioVisual maVisual;
    Material material;

    //Constructores
    public Prestamo() {
        this.fechaRealizacion = "";
        this.fechaDevolucion = "";
        this.libro = null;
        this.maVisual = null;
        this.atrasado = false;
    }

    public Prestamo(String fechaRealizacion, AudioVisual maVisual) {
        this.fechaRealizacion = fechaRealizacion;
        this.maVisual = maVisual;
        this.libro = null;
        this.atrasado = false;
    }

    public Prestamo(String fechaRealizacion, Libro libro) {
        this.fechaRealizacion = fechaRealizacion;
        this.libro = libro;
        this.maVisual = null;
        this.atrasado = false;
    }

    //Metodos
    public void devolverMatrial(String fecha) {
        
    }
    
    //Metodo verificar fechas
    public boolean verificarFecha(String fecha){
        int valoFecha;
        String nuevaFecha = "";
        for(char c: fecha.toCharArray()){
            if(Character.isDigit(c)){
                nuevaFecha += c;
            }
        }
        
        
        
        return false;
    }
    
    public void imprimirInfo(){
        if(maVisual == null){
            libro.imprimirInfo();
        }else{
            maVisual.imprimirInfo();
        }
        System.out.println("Fecha realización: " + fechaRealizacion);
        System.out.println("Fecha devolución: " + fechaDevolucion);
    }

    //Metodos getters and setters
    public String getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(String fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
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
}
