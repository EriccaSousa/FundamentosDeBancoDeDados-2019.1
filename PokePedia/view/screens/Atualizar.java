package view.screens;

import dao.PokemonsDAO;
import model.Pokemon;
import view.Menu;

public class Atualizar extends Menu {

	public static void home() {
		do {

			titulo();
			println("Atualizar Pokémon por: ");
			println("1. Nome   ||   2. Tipo   ||   3. Categoria   ||   4. Altura   ||   5. Peso   ||   6. Geração   ||   0. Voltar");

			switch (lerOpcao()) {
			case 1:
				nome();
				return;
			case 2:
				tipo();
				return;
			case 3:
				categoria();
				return;
			case 4:
				altura();
				return;
			case 5:
				peso();
				return;
			case 6:
				geracao();
				return;
			case 0:
				homeAdmin();
				return;

			default:
				break;
			}

		} while (true);
	}

	private static void nome() {
		String novoNome = null;

		do {
			titulo();

			println("Atualizar ID");
			print("Digite o ID: ");
			int idAtual = nextInt();

			for (Pokemon var : PokemonsDAO.select(idAtual)) {
				println(var);
			}

			println("\nContinuar?\n1. Sim   ||   2. Não");
			int opcao = nextInt();

			if (opcao == 1) {
				print("Informe o novo nome: ");
				novoNome = nextLine();

				if (PokemonsDAO.updateNome(novoNome, idAtual)) {
					println();
					for (Pokemon var : PokemonsDAO.select(idAtual)) {
						println(var);
					}
					println("Nome alterado com sucesso!\n");
				} else {
					println("Ocorreu um erro ao atualizar informações.\n");
				}
			}
			voltar();
			home();
			return;
		} while (true);
	}

	public static void tipo() {
		String novoTipo = null;

		do {
			titulo();

			println("Atualizar Tipo");
			print("Digite o ID: ");
			int idAtual = nextInt();

			for (Pokemon var : PokemonsDAO.select(idAtual)) {
				println(var);
			}

			println("\nContinuar?\n1. Sim   ||   2. Não");
			int opcao = nextInt();

			if (opcao == 1) {
				print("Informe o novo tipo: ");
				novoTipo = nextLine();

				if (PokemonsDAO.updateTipo(novoTipo, idAtual)) {
					println();
					for (Pokemon var : PokemonsDAO.select(idAtual)) {
						println(var);
					}
					println("Tipo alterado com sucesso!\n");
				} else {
					println("Ocorreu um erro ao atualizar informações.\n");
				}
			}
			voltar();
			home();
			return;
		} while (true);
	}

	public static void categoria() {
		String novaCategoria = null;
		do {
			titulo();

			println("Atualizar Categoria");
			print("Digite o ID: ");
			int idAtual = nextInt();

			for (Pokemon var : PokemonsDAO.select(idAtual)) {
				println(var);
			}

			println("\nContinuar?\n1. Sim   ||   2. Não");
			int opcao = nextInt();

			if (opcao == 1) {
				print("Informe a nova Categoria: ");
				novaCategoria = nextLine();

				if (PokemonsDAO.updateCategoria(novaCategoria, idAtual)) {
					println();
					for (Pokemon var : PokemonsDAO.select(idAtual)) {
						println(var);
					}
					println("Categoria alterada com sucesso!\n");
				} else {
					println("Ocorreu um erro ao atualizar informações!\n");
				}
			}
			voltar();
			home();
			return;
		} while (true);
	}

	public static void altura() {
		double novaAltura = 0;

		do {
			titulo();

			println("Atualizar Altura");
			print("Digite o ID: ");
			int idAtual = nextInt();

			for (Pokemon var : PokemonsDAO.select(idAtual)) {
				println(var);
			}

			println("\nContinuar?\n1. Sim   ||   2. Não");
			int opcao = nextInt();

			if (opcao == 1) {
				print("Informe a nova Altura: ");
				novaAltura = nextDouble();
				if (PokemonsDAO.updateAltura(novaAltura, idAtual)) {
					println();
					for (Pokemon var : PokemonsDAO.select(idAtual)) {
						println(var);
					}
					println("Altura alterada com sucesso!\n");
				} else {
					println("Ocorreu um erro ao atualizar informações.\n");
				}
			}
			voltar();
			home();
			return;
		} while (true);
	}

	public static void peso() {
		double novoPeso = 0;

		do {
			titulo();

			println("Atualizar Peso");
			print("Digite o ID: ");
			int idAtual = nextInt();

			for (Pokemon var : PokemonsDAO.select(idAtual)) {
				println(var);
			}

			println("\nContinuar?\n1. Sim   ||   2. Não");
			int opcao = nextInt();

			if (opcao == 1) {
				print("Informe o novo Peso: ");
				novoPeso = nextDouble();

				if (PokemonsDAO.updatePeso(novoPeso, idAtual)) {
					println();
					for (Pokemon var : PokemonsDAO.select(idAtual)) {
						println(var);
					}
					println("Peso alterado com sucesso!\n");
				} else {
					println("Ocorreu um erro ao atualizar informações!\n");
				}
			}
			voltar();
			home();
			return;
		} while (true);
	}

	public static void geracao() {
		int novaGeracao = 0;

		do {
			titulo();

			println("Atualizar Geração");
			print("Digite o ID: ");
			int idAtual = nextInt();

			for (Pokemon var : PokemonsDAO.select(idAtual)) {
				println(var);
			}

			println("\nContinuar?\n1. Sim   ||   2. Não");
			int opcao = nextInt();

			if (opcao == 1) {
				print("Informe a nova Geração: ");
				novaGeracao = nextInt();

				if (PokemonsDAO.updateGeracao(novaGeracao, idAtual)) {
					println();
					for (Pokemon var : PokemonsDAO.select(idAtual)) {
						println(var);
					}
					println("Geração alterada com sucesso!\n");
				} else {
					println("Ocorreu um erro ao atualizar informações!\n");
				}
			}
			voltar();
			home();
			return;
		} while (true);
	}
}