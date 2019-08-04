package Kino;

import Kino.model.*;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {

            System.out.println("K-zarządzaj kinami, F-zarządzaj filmami, B-kup bilety, Q-wyjście");
            String dec = sc.nextLine().toUpperCase();

            switch (dec) {
                case "K":
                    Kino kino = new Kino();
                    break;
                case "F":
                    Filmy filmy = new Filmy();
                    break;
                case "B":
                    Bilety bilety = new Bilety();
                    break;
                case "Q":
                    sc.close();
                    flag = false;
                    break;
            }

        }

    }
}
