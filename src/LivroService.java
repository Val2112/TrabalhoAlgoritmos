import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LivroService {
    //Lista de livros
    private List<Livros> livros = new ArrayList<>();
//método para adicionar um livro na lista
    public void adicionarLivro(Livros livro) {
        livros.add(livro);
    }
//método para listar os livros
    public List<Livros> listarLivros() {
        return new ArrayList<>(livros);
    }
//método para buscar um livro por título
    public Optional<Livros> buscarPorTitulo(String titulo) {
        return livros.stream()
        //filtra a lista de livros
                     .filter(livro -> livro.getTitulo().equalsIgnoreCase(titulo))
                     //retorna o primeiro livro encontrado com o título informado
                     .findFirst();
    }
//método para remover um livro
    public void removerLivro(String titulo) {
        //remove o livro com o título informado
        livros.removeIf(livro -> livro.getTitulo().equalsIgnoreCase(titulo));
    }
    //método para verificar se a lista de livros está vazia
    public boolean ListaLivroVazio(){
        //retorna true se a lista de livros estiver vazia
        return livros.isEmpty();
    }

}