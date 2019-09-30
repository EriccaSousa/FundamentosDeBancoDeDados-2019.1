package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import util.*;

public class DB extends Helper {

    private static Connection connection = null;
    private static final String host = "ec2-54-83-36-37.compute-1.amazonaws.com";
    private static final Integer port = 5432;
    private static final String user = "xkvgcntahkddys";
    private static final String password = "3d21ad86dfa68de4dd6e8dceb7b9892ecc9374f6b55e3962a90a159e08083450";
    private static final String database = "da0035u8m4eh7o";

    public static Connection Connect() {

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + database, user,
                    password);
            print("Connected!");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        print("Connection closed...");
    }
}