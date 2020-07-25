package biblioteca;

public class Material {
    protected String titulo;
    protected int codigo;

    //constructores
    public Material() {
        this.titulo = "";
        this.codigo = 0;
    }
    
    public Material(String titulo, int codigo) {
        this.titulo = titulo;
        this.codigo = codigo;
    }
    
    //Getters and Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
