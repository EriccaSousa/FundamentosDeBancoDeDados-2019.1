package dao;

import java.sql.*;

import db.DB;

public class UsuariosDAO {

    public static boolean check(String nome, String senha) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = DB.getConnection().prepareStatement("select * from usuarios where nome = ? and senha = ?;");
            ps.setString(1, nome);
            ps.setString(2, senha);
            rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean check(String nome) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = DB.getConnection().prepareStatement("select * from usuarios where nome = ?;");
            ps.setString(1, nome);
            rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean insert(String nome, String senha) {
        PreparedStatement ps = null;

        try {
            ps = DB.getConnection().prepareStatement("insert into usuarios values(?,?);");
            ps.setString(1, nome);
            ps.setString(2, senha);
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