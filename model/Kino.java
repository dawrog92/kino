package Kino.model;

import Kino.controller.Controller;

import java.sql.SQLException;
import java.util.Scanner;

public class Kino {

    Controller uc = new Controller();
    Scanner sc = new Scanner(System.in);
    boolean flag = true;

    public Kino() throws SQLException {

        while (flag) {
            System.out.println("----- Witaj w module KINO");
            System.out.println("P-pokaż kina, D-dodaj kino, U-usuń kino, Q-wyjście");
            String dec = sc.nextLine().toUpperCase();

            switch (dec) {
                case "D":
                    System.out.println("Podaj nazwę kina: ");
                    String nazwa = sc.nextLine();
                    uc.addKino(nazwa);
                    break;
                case "U":
                    uc.showKino();
                    System.out.println("Podaj ID kina: ");
                    int ID = sc.nextInt();
                    sc.nextLine();
                    uc.delKino(ID);
                    break;
                case "P":
                    System.out.println("Lista kin");
                    uc.showKino();
                    break;
                case "Q":
                    flag = false;
                    break;
            }
        }
    }
}
