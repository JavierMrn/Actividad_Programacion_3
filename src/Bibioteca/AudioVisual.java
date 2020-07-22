package Bibioteca;

public class AudioVisual extends Material{
    private int duracion;

    //Constructores
    public AudioVisual() {
        super();
        this.duracion = 0;
    }
    
    public AudioVisual(int codigo, String titulo, int duracion) {
        super(titulo, codigo);
        this.duracion = duracion;
    }

    //Metodos
    public void imprimirInfo() {
        System.out.println("Titulo del audivisual: " + titulo);
        System.out.println("Duración: " + duracion + " min");
    }
    
    //Getters and Setters
    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
}
