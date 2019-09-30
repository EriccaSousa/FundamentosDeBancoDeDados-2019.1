package view;

import java.util.Locale;

import db.DB;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(new Locale("en", "US"));

        DB.Connect();

        Menu.home();
        
        DB.closeConnection();
    }
}