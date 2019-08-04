package Kino.model;

import Kino.controller.Controller;

import java.sql.SQLException;
import java.util.Scanner;

public class Filmy {

    Controller uc = new Controller();
    Scanner sc = new Scanner(System.in);
    boolean flag = true;

    public Filmy () throws SQLException {

        while (flag) {
            System.out.println("----- Witaj w module FILMY");
            System.out.println("P-pokaż filmy, D-dodaj film, U-usuń film, Q-wyjście");
            String dec = sc.nextLine().toUpperCase();

            switch (dec) {
                case "D":
                    System.out.println("Podaj tytuł filmu: ");
                    String nazwa = sc.nextLine();
                    uc.showKino();
                    System.out.println("Podaj ID kina: ");
                    int kino_ID = sc.nextInt();
                    sc.nextLine();
                    uc.addFilm(nazwa, kino_ID);
                    break;
                case "U":
                    uc.showFilm();
                    System.out.println("Podaj ID filmu: ");
                    int ID = sc.nextInt();
                    sc.nextLine();
                    uc.delFilm(ID);
                    break;
                case "P":
                    System.out.println("Lista filmów");
                    uc.showFilm();
                    break;
                case "Q":
                    flag = false;
                    break;
            }
        }
    }
}
