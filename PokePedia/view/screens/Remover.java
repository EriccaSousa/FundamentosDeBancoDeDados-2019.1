package view.screens;

import dao.PokemonsDAO;
import view.Menu;

public class Remover extends Menu {

    public static void home() {

        do {
            titulo();

            println("Remover Pokémon");
            print("Digite o id: ");
            int id = nextInt();

            if (PokemonsDAO.delete(id)) {
                println("Removido com sucesso.");
            } else {
                println("Pokémon não removido.");
            }

            voltar();
            homeAdmin();

            return;

        } while (true);
    }
}