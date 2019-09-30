package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import model.Pokemon;

public class MochilasDAO {

    public static List<Pokemon> select(String nome) {
        List<Pokemon> list = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = DB.getConnection().prepareStatement("select id, nome, tipo, categoria, altura, peso, geracao from pokemons inner join mochilas m on pokemons.id = m.id_pokemon where nome_usuario = ?;");
            ps.setString(1, nome);
            rs = ps.executeQuery();

            if (rs.next()) {
                do {
                    Pokemon pokemon = new Pokemon(rs.getInt("id"), rs.getString("nome"), rs.getString("tipo"),
                            rs.getString("categoria"), rs.getDouble("altura"), rs.getDouble("peso"),
                            rs.getInt("geracao"));

                    list.add(pokemon);
                } while (rs.next());

                return list;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean insert(String nome, int id) {
        PreparedStatement ps = null;
        try {
            ps = DB.getConnection().prepareStatement("insert into mochilas(nome_usuario, id_pokemon) values(?, ?);");
            ps.setString(1, nome);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows == 1) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean delete(String nome, int id) {
        PreparedStatement ps = null;
        try {
            ps = DB.getConnection().prepareStatement("delete from mochilas where nome_usuario = ? and id_pokemon = ?;");
            ps.setString(1, nome);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows == 1) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}