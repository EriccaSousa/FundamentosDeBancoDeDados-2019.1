package view;

import java.io.IOException;

import dao.AdminsDAO;
import dao.UsuariosDAO;
import util.Helper;
import view.screens.*;

public class Menu extends Helper {

    // Concistência do tipo de interface: Baixa, há formas melhores de se fazer.
    // Se tiver uma forma melhor crie uma branch, faça e então dê Merge Request.

    protected static String nomeUsuario; // <- Usado pela classe mochila;

    // Métodos ajudantes -->

    protected static void titulo() {

        // Apaga o console:
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            try {
                new ProcessBuilder("cmd", "/c", "clear").inheritIO().start().waitFor();
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }

        // Linux
        else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

        // Apresenta título:
        println("----- PokePedia -----\n\n");
    }

    protected static int lerOpcao() {

        // !Este método só pode ser usado para pegar uma opção de menu do usuário!

        // Pega um número do usuário:
        print("Digite uma opção: ");
        return nextInt();
    }

    protected static void voltar() {

        println();

        // Pega qualquer coisa do usuário:
        print("Pressione qualquer tecla para voltar. . .");

        // Segura o console até receber algo:
        nextLine();
    }

    // <-- Métodos ajudantes

    // Métodos de tela -->

    // Primeira tela:
    public static void home() {

        do {
            titulo();
            println("Página Inicial");
            println("1. Login   ||   2. Cadastrar   ||   0. Sair");
            int opcao = lerOpcao();

            switch (opcao) {
            case 1:
                login();
                return;
            case 2:
                Cadastrar.usuario("usuario");
                return;
            case 0:
                return;
            default:
                break;
            }
        } while (true);
    }

    // Tela de login:
    private static void login() {
        titulo();

        println("Login");
        print("Nome de usuário: ");
        String nome = nextLine();

        print("Senha: ");
        String senha = nextLine();

        if (AdminsDAO.check(nome, senha)) {
            println("Admin");
            homeAdmin();

        } else if (UsuariosDAO.check(nome, senha)) {
            println("Usuário");
            nomeUsuario = nome;
            homeUsuario();

        } else {
            println("Senha ou nome errado.");
            voltar();
            home();
        }
    }

    // Primeira tela do usuário comum após login ou cadasto:
    protected static void homeUsuario() {

        do {
            titulo();
            println("Página do Usuário");
            println("1. Listar   ||   2. Pesquisar   ||   3. Mochila   0. Voltar");
            int opcao = lerOpcao();

            switch (opcao) {
            case 1:
                Listar.home("usuario");
                return;
            case 2:
                Pesquisar.home("usuario");
                return;
            case 3:
                Mochila.home();
                return;
            case 0:
                home();
                return;
            default:
                break;
            }
        } while (true);
    }

    // Primeira tela do usuário administrador após login:
    protected static void homeAdmin() {

        do {
            titulo();
            println("Página do Administrador");
            println("1. Listar   ||   2. Pesquisar   ||   3. Adicionar   ||   4. Remover   ||   5. Atualizar   ||   6. Cadastrar   ||   0. Voltar");
            int opcao = lerOpcao();

            switch (opcao) {
            case 1:
                Listar.home("admin");
                return;
            case 2:
                Pesquisar.home("admin");
                return;
            case 3:
                Adicionar.home();
                return;
            case 4:
                Remover.home();
                return;
            case 5:
                Atualizar.home();
                return;
            case 6:
                Cadastrar.home();
                return;
            case 0:
                home();
                return;
            default:
                break;
            }
        } while (true);
    }
    // <-- Métodos de tela
}