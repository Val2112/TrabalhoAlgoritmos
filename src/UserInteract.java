import java.util.Scanner;

public class UserInteract {
    //instanciando as classes LivroService, UsuarioService e Scanner
     Scanner scanner = new Scanner(System.in);
     LivroService livroService = new LivroService();
     UsuarioService usuarioService = new UsuarioService();
  //método exibirMenu
    public void exibirMenu() {
        int opcao = 0;
        while (opcao != 9) {
            System.out.println("1 - Adicionar Livro" +
                    "\n2 - Listar Livros" +
                    "\n3 - Adicionar Usuário" +
                    "\n4 - Listar Usuários" +
                    "\n5 - Buscar Livro por Título" +
                    "\n6 - Buscar Usuário por Nome" +
                    "\n7 - Remover Usuário" +
                    "\n8 - Remover Livro" +
                    "\n9 - Sair");

            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                //chama o método adicionarLivro
                    adicionarLivro();
                    break;
                case 2:
                //chama o método listarLivros
                    listarLivros();
                    break;
                case 3:
                //chama o método adicionarUsuario
                    adicionarUsuario();
                    break;
                case 4:
                //chama o método listarUsuarios
                    listarUsuarios();
                    break;
                case 5:
                //chama o método buscarLivroPorTitulo
                    buscarLivroPorTitulo();
                    break;
                case 6:
                //chama o método buscarUsuarioPorNome
                    buscarUsuarioPorNome();
                    break;
                case 7:
                //chama o método removerUsuario
                    removerUsuario();
                    break;
                case 8:
                //chama o método removerLivro
                    removerLivro();
                    break;
                case 9:
                //mensagem de saída
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        }
    
//método para o usuário adicionar um livro
    private void adicionarLivro() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        Livros livros = new Livros(titulo, autor);
        livroService.adicionarLivro(livros);
        System.out.println("Livro adicionado com sucesso.");
    }
//método para listar os livros
    private void listarLivros() {
        if(livroService.ListaLivroVazio()){
            System.out.println("Lista de Livros vazia.");
        }
        else{
        System.out.println("Lista de Livros:");
        livroService.listarLivros().forEach(System.out::println);
        }
    }
//método para o usuário adicionar um usuário
    private void adicionarUsuario() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("ID: ");
        String id = scanner.nextLine();
        Usuarios usuarios = new Usuarios(nome, id);
        usuarioService.adicionarUsuario(usuarios);
        System.out.println("Usuário adicionado com sucesso.");
    }
//método para listar os usuários
    private void listarUsuarios() {
        if(usuarioService.ListaUsuarioVazio()){
            System.out.println("Lista de Usuários vazia.");
        }
        else{
        System.out.println("Lista de Usuários:");
        usuarioService.listarUsuarios().forEach(System.out::println);
        }
    }
//método para buscar um livro por título
    private void buscarLivroPorTitulo() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        livroService.buscarPorTitulo(titulo).ifPresentOrElse(
            System.out::println,
            () -> System.out.println("Livro não encontrado.")
        );
    }
//método para buscar um usuário por nome
    private void buscarUsuarioPorNome() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        usuarioService.buscarPorNome(nome).ifPresentOrElse(
            System.out::println,
            () -> System.out.println("Usuário não encontrado.")
        );
    }
    //método para remover um usuário
    private void removerUsuario() {
        System.out.print("ID: ");
        String id = scanner.nextLine();
        if(usuarioService.buscarPorId(id).isEmpty()){
            System.out.println("Usuário não encontrado.");
            return;
        }
        usuarioService.removerUsuario(id);
        System.out.println("Usuário removido com sucesso.");
    }
    //método para remover um livro
    private void removerLivro() {
        System.out.println("Título: ");
        String titulo = scanner.nextLine();
        if(livroService.buscarPorTitulo(titulo).isEmpty()){
            System.out.println("Livro não encontrado.");
            return;
        }
        livroService.removerLivro(titulo);
        System.out.println("Livro removido com sucesso.");
    }
}