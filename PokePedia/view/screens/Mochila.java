package view.screens;

import dao.MochilasDAO;
import dao.PokemonsDAO;
import model.Pokemon;
import view.Menu;

public class Mochila extends Menu {

    public static void home() {
        do {
            titulo();
            println("Mochila");

            println("1. Listar   ||   2. Adicionar   ||   3. Remover   ||   0. Voltar");
            switch (lerOpcao()) {
            case 1:
                listar();
                return;
            case 2:
                adicionar();
                return;
            case 3:
                remover();
                return;
            case 0:
                homeUsuario();
                return;
            default:
                break;
            }
        } while (true);
    }

    private static void remover() {
        titulo();
        print("Digite o id:");
        int id = nextInt();

        for (Pokemon var : PokemonsDAO.select(id)) {
            println(var);
        }

        println("\nRemover?");
        println("1. Sim   ||   2. Não");
        if (lerOpcao() == 1) {

            if (MochilasDAO.delete(nomeUsuario, id)) {
                println("Removido com sucesso.");
            } else {
                println("Não foi possível remover.");
            }

            voltar();
            home();
        } else {
            home();
        }
    }

    private static void adicionar() {
        titulo();
        print("Digite o id:");
        int id = nextInt();

        for (Pokemon var : PokemonsDAO.select(id)) {
            println(var);
        }

        println("\nAdicionar?");
        println("1. Sim   ||   2. Não");
        if (lerOpcao() == 1) {

            if (MochilasDAO.insert(nomeUsuario, id)) {
                println("Adicionado com sucesso.");
            } else {
                println("Não foi possível adicionar.");
            }

            voltar();
            home();
        } else {
            home();
        }
    }

    private static void listar() {
        titulo();

        for (Pokemon var : MochilasDAO.select(nomeUsuario)) {
            println(var);
        }

        voltar();
        home();
    }
}