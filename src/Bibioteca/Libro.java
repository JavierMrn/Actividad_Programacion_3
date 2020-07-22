package Bibioteca;

public class Libro extends Material {

    private String area;
    private String idioma;

    //Constructores
    public Libro(int codigo, String titulo, String area, String idioma) {
        super(titulo, codigo);
        this.area = area;
        this.idioma = idioma;
    }

    public Libro() {
        super();
        this.area = "";
        this.idioma = "";
    }

    //Metodos
    public void imprimirInfo() {
        System.out.println("Titulo del libro: " + titulo);
        System.out.println("Area del libro: " + area);
        System.out.println("Idioma: " + idioma);
    }

    //Getters and Setters
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
}
