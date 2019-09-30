package view.screens;

import java.util.List;

import dao.PokemonsDAO;
import model.Pokemon;
import view.Menu;

public class Listar extends Menu {

    public static void home(String quem) {

        List<Pokemon> pokemonList = PokemonsDAO.selectAll();

        do {
            titulo();

            for (Pokemon var : pokemonList) {
                println(var);
            }

            voltar();

            if (quem.equals("usuario")) {
                homeUsuario();
            } else if (quem.equals("admin")) {
                homeAdmin();
            }
            return;
        } while (true);
    }
}