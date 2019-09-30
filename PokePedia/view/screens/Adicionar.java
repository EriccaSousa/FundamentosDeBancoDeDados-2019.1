package view.screens;

import java.sql.SQLException;

import dao.PokemonsDAO;
import model.Pokemon;
import view.Menu;

public class Adicionar extends Menu {

    public static void home() {
        do {
            titulo();

            println("Adicionar Pokémon");

            print("Digite o id: ");
            int id = nextInt();

            print("Digite o nome: ");
            String nome = nextLine();

            print("Digite o tipo: ");
            String tipo = nextLine();

            print("Digite a categoria: ");
            String categoria = nextLine();

            print("Digite a altura: ");
            double altura = nextDouble();

            print("Digite o peso: ");
            double peso = nextDouble();

            print("Digite a geração: ");
            int geracao = nextInt();

            Pokemon pokemon = new Pokemon(id, nome, tipo, categoria, altura, peso, geracao);

            println();
            println(pokemon);
            println();

            try {
                if (PokemonsDAO.insert(pokemon)) {
                    println("Adicionado com sucesso.");
                } else {
                    println("Pokémon não adicionado.");
                }
                
            } catch (SQLException e) {
                println("O id já está em uso.");
            }

            voltar();

            homeAdmin();
            return;

        } while (true);
    }
}