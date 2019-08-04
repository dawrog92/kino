package Kino.controller;

import Kino.database.DBConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Controller {

    DBConnect dao = new DBConnect();

    public void addKino (String nazwa) throws SQLException {
        String insertSQL = "insert into kino(nazwa) values (?)";
        PreparedStatement st = dao.getCon().prepareStatement(insertSQL);
        st.setString(1, nazwa);
        st.execute();
        st.close();

        System.out.println("Czy chcesz zatwierdzić wprowadzone dane? t/n");
        Scanner sc = new Scanner(System.in);
        String dec = sc.nextLine().toLowerCase();
        if (dec.equals("t")) {
            dao.getCon().commit();
        }
        else {
            dao.getCon().rollback();
        }
    }

    public void delKino (int ID) throws SQLException {
        String delSQL = "delete from kino where ID=?";
        PreparedStatement st = dao.getCon().prepareStatement(delSQL);
        st.setInt(1, ID);
        st.execute();
        st.close();

        System.out.println("Czy chcesz usunąć dane? t/n");
        Scanner sc = new Scanner(System.in);
        String dec = sc.nextLine().toLowerCase();
        if (dec.equals("t")) {
            dao.getCon().commit();
        } else {
            dao.getCon().rollback();
        }
    }

    public void showKino () throws SQLException {

        String selectSQL = "select * from kino";
        Statement st = dao.getCon().createStatement();
        ResultSet rs = st.executeQuery(selectSQL);

        while (rs.next()) {
            System.out.println(rs.getString("ID")+" "+rs.getString("nazwa"));
        }
        st.close();
    }

    public void addFilm (String nazwa, int kino_ID) throws SQLException {

        String insertSQL = "insert into filmy(nazwa, kino_ID) values(?, ?)";
        PreparedStatement st = dao.getCon().prepareStatement(insertSQL);
        st.setString(1, nazwa);
        st.setInt(2, kino_ID);
        st.execute();
        st.close();

        System.out.println("Czy chcesz zatwierdzić wprowadzone dane? t/n");
        Scanner sc = new Scanner(System.in);
        String dec = sc.nextLine().toLowerCase();
        if (dec.equals("t")) {
            dao.getCon().commit();
        }
        else {
            dao.getCon().rollback();
        }
    }

    public void showFilm () throws SQLException {

        String selectSQL = "SELECT f.ID, f.nazwa, k.ID, k.nazwa FROM filmy f INNER JOIN kino k ON f.kino_ID = k.ID;";
        Statement st = dao.getCon().createStatement();
        ResultSet rs = st.executeQuery(selectSQL);

        while (rs.next()) {
            System.out.println(rs.getString("f.ID")+" "+rs.getString("f.nazwa")+" - "+rs.getString("k.ID")+" "+rs.getString("k.nazwa"));
        }
        st.close();
    }

    public void delFilm (int ID) throws SQLException {
        String delSQL = "delete from filmy where ID=?";
        PreparedStatement st = dao.getCon().prepareStatement(delSQL);
        st.setInt(1, ID);
        st.execute();
        st.close();

        System.out.println("Czy chcesz usunąć dane? t/n");
        Scanner sc = new Scanner(System.in);
        String dec = sc.nextLine().toLowerCase();
        if (dec.equals("t")) {
            dao.getCon().commit();
        } else {
            dao.getCon().rollback();
        }
    }

    public void buyTicket (int filmy_ID, int ilosc) throws SQLException {
        String insertSQL = "insert into bilety(filmy_ID, ilosc) values(?, ?)";
        PreparedStatement st = dao.getCon().prepareStatement(insertSQL);
        st.setInt(1, filmy_ID);
        st.setInt(2, ilosc);
        st.execute();
        st.close();

        System.out.println("Czy chcesz zatwierdzić wprowadzone dane? t/n");
        Scanner sc = new Scanner(System.in);
        String dec = sc.nextLine().toLowerCase();
        if (dec.equals("t")) {
            dao.getCon().commit();
        }
        else {
            dao.getCon().rollback();
        }
    }

    public void showTicket () throws SQLException {
        String selectSQL = "SELECT b.ID, b.ilosc, f.nazwa f_nazwa, f.ID, k.nazwa k_nazwa FROM bilety b INNER JOIN filmy f ON f.ID = b.filmy_ID INNER JOIN kino k ON k.ID=f.kino_ID;";
        Statement st = dao.getCon().createStatement();
        ResultSet rs = st.executeQuery(selectSQL);

        while (rs.next()) {
            System.out.println(rs.getString("b.ID")+" "+rs.getString("b.ilosc")+" - "+rs.getString("f_nazwa")+" "+rs.getString("f.ID")+" "+rs.getString("k_nazwa"));
        }
        st.close();
    }

    public void delTicket (int ID) throws SQLException {
        String delSQL = "delete from bilety where ID=?";
        PreparedStatement st = dao.getCon().prepareStatement(delSQL);
        st.setInt(1, ID);
        st.execute();
        st.close();

        System.out.println("Czy chcesz usunąć bilety? t/n");
        Scanner sc = new Scanner(System.in);
        String dec = sc.nextLine().toLowerCase();
        if (dec.equals("t")) {
            dao.getCon().commit();
        } else {
            dao.getCon().rollback();
        }
    }
}
