package view.screens;

import dao.PokemonsDAO;
import model.Pokemon;
import view.Menu;

public class Pesquisar extends Menu {

    public static void home(String quem) {
        do {
            titulo();

            println("Pesquisar por:");
            println("1. Id   ||   2. Nome  || 0. Voltar");
            int opcao = lerOpcao();

            switch (opcao) {
            case 1:
                byId(quem);
                return;
            case 2:
                byNome(quem);
                return;
            case 0:
                if (quem.equals("usuario")) {
                    homeUsuario();
                } else if (quem.equals("admin")) {
                    homeAdmin();
                }
                return;
            default:
                break;
            }
        } while (true);
    }

    private static void byId(String quem) {

        do {
            titulo();
            print("Digite o id: ");
            int id = nextInt();
            println();

            for (Pokemon var : PokemonsDAO.select(id)) {
                println(var);
            }

            voltar();
            home(quem);
            return;

        } while (true);
    }

    private static void byNome(String quem) {
        do {
            titulo();
            print("Digite o nome: ");

            try {
                String nome = nextLine();

                println(); // Flush

                // Converte a primeira letra para maiúsculo, as outras para minúsculo.
                nome = nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();

                // Listando
                for (Pokemon var : PokemonsDAO.select(nome)) {
                    println(var);
                }

            } catch (Exception e) {
                println("Erro.\nNenhum Pokémon encontrado.");
            }

            voltar();
            home(quem);
            return;
        } while (true);
    }
}