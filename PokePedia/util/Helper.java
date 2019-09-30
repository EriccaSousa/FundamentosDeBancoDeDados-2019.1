package util;

import java.util.Scanner;

// Eu sou Bob o ajudante!
// Fui feito para simplificar seu código.
// Extenda suas classes com esta para que eu possa facilitar o seu trabalho.

public class Helper {

    // Printer:

    public static void print(Object aux) {
        System.out.print(aux);
    }

    public static void println() {
        System.out.println();
    }

    public static void println(Object aux) {
        System.out.println(aux);
    }

    public static void printf(String format, Object... args) {
        System.out.printf(format, args);
    }

    // Scanner:

    static Scanner scan;

    public static int nextInt() {
        scan = new Scanner(System.in);
        int i = scan.nextInt();
        return i;
    }

    public static double nextDouble() {
        scan = new Scanner(System.in);
        double d = scan.nextDouble();
        return d;
    }

    public static String nextLine() {
        scan = new Scanner(System.in);
        String s = scan.nextLine();
        return s;
    }

    public static String next() {
        scan = new Scanner(System.in);
        String s = scan.next();
        return s;
    }
}