package biblioteca;

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
        System.out.println("Duración del audiovisual: " + duracion + " min");
        System.out.println("Código del audiovisual: " + codigo);
    }
    
    //Getters and Setters
    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
}
