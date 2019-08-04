package Kino.model;

import Kino.controller.Controller;

import java.sql.SQLException;
import java.util.Scanner;

public class Bilety {

    Controller uc = new Controller();
    Scanner sc = new Scanner(System.in);
    boolean flag = true;

    public Bilety () throws SQLException {
        while (flag) {
            System.out.println("----- Witaj w module BILETY");
            System.out.println("P-pokaż bilety, K-kup bilet, U-usuń bilet, Q-wyjście");
            String dec = sc.nextLine().toUpperCase();

            switch (dec) {
                case "K":
                    uc.showFilm();
                    System.out.println("Podaj ID filmu: ");
                    int filmy_ID = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Podaj ilość biletów: ");
                    int ilosc = sc.nextInt();
                    sc.nextLine();
                    uc.buyTicket(filmy_ID, ilosc);
                    break;
                case "U":
                    uc.showTicket();
                    System.out.println("Podaj ID biletu: ");
                    int ID = sc.nextInt();
                    sc.nextLine();
                    uc.delTicket(ID);
                    break;
                case "P":
                    System.out.println("Lista biletów");
                    uc.showTicket();
                    break;
                case "Q":
                    flag = false;
                    break;
            }
        }
    }

}
