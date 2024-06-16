import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class UsuarioService {
    //Lista de usuários
    private List<Usuarios> usuarios = new ArrayList<>();
   //método para adicionar um usuário na lista
    public void adicionarUsuario(Usuarios usuario) {
        usuarios.add(usuario);
    }
   //método para listar os usuários
    public List<Usuarios> listarUsuarios() {
        return new ArrayList<>(usuarios);
    }
   //método para buscar um usuário por id
    public Optional<Usuarios> buscarPorId(String id) {
        return usuarios.stream()
   //filtra a lista de usuários
                       .filter(usuario -> usuario.getId().equals(id))
                       //retorna o primeiro usuário encontrado com o id informado
                       .findFirst();
    }
   //método para buscar um usuário por nome
    public Optional<Usuarios> buscarPorNome(String nome) {
        return usuarios.stream()
        //filtra a lista de usuários
                       .filter(usuario -> usuario.getNome().equalsIgnoreCase(nome))
                       //retorna a lista de usuários encontrados com o nome informado
                       .findFirst();
    }
//método para remover um usuário
    public void removerUsuario(String id) {
        //remove o usuário com o id informado
        usuarios.removeIf(usuario -> usuario.getId().equals(id));
    }
    //método para verificar se a lista de usuários está vazia
    public boolean ListaUsuarioVazio(){
        //retorna true se a lista de usuários estiver vazia
        return usuarios.isEmpty();
    }
}