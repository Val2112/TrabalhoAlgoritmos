public class Livros {
    //atributos
  private String titulo;
    private String autor;
    //construtor
    public Livros(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }
    //getters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo:'" + titulo + '\'' +
                ", autor:'" + autor + '\'' +
                '}';
    }
}