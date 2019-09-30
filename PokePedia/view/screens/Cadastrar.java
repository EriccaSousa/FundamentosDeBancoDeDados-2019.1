package view.screens;

import dao.AdminsDAO;
import dao.UsuariosDAO;
import view.Menu;

public class Cadastrar extends Menu {

    public static void home() {
        do {
            titulo();
            println("Cadastrar");
            println("1. Usuário   ||   2. Administrador   ||   0. Voltar");

            switch (lerOpcao()) {
            case 1:
                usuario("admin");
                return;
            case 2:
                admin();
                return;
            case 0:
                homeAdmin();
                return;
            default:
                break;
            }

        } while (true);
    }

    public static void usuario(String quem) {

        titulo();

        println("Cadastrar usuário");

        print("Nome de usuário: ");
        String nome = nextLine();

        print("Senha: ");
        String senha = nextLine();

        if (!UsuariosDAO.check(nome)) {

            if (UsuariosDAO.insert(nome, senha)) {
                println("OK");
            } else
                println("Não adicionado.");
        } else
            println("Já existe um usuário com este nome.");

        if (quem.equals("admin")) {
            homeAdmin();
        } else if (quem.equals("usuario")) {
            homeUsuario();
        }
    }

    public static void admin() {

        titulo();

        println("Cadastrar administrador");
        print("Nome de usuário: ");
        String nome = nextLine();

        print("Senha: ");
        String senha = nextLine();

        if (!AdminsDAO.check(nome)) {

            if (AdminsDAO.insert(nome, senha)) {
                println("OK");
            } else
                println("Não adicionado.");
        } else
            println("Já existe um usuário com este nome.");

        homeAdmin();
    }
}