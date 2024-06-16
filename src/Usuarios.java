public class Usuarios {
    //atributos
    private String nome;
    private String id;
    //construtor
    public Usuarios(String nome, String id) {
        this.nome = nome;
        this.id = id;
    }
  //getters
    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }

    @Override
    
    public String toString() {
        return "Usuario{" +
                "nome: '" + nome + '\'' +
                ", id: '" + id + '\'' +
                '}';
    }
}