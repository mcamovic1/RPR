package org.example;

import java.sql.*;
import java.util.ArrayList;

public class GeografijaDAO {
    private static GeografijaDAO instance;
    private Connection connection;
    private GeografijaDAO() {
        try {
            // Kreiranje konekcije
            connection = DriverManager.getConnection("jdbc:sqlite:baza.db");

            // Kreiranje tabele gradova ako ne postoji
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS gradovi (naziv TEXT, drzava TEXT, brojStanovnika INT)");

            // Provera da li postoji baza.db datoteka, ako ne postoji, dodajemo početne podatke
            if (!provjeriPostojanjeTabele()) {
                dodajPocetnePodatke();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static GeografijaDAO getInstance() {
        if (instance == null) {
            instance = new GeografijaDAO();
        }
        return instance;
    }
    private void dodajPocetnePodatke() {
        // Dodajemo početne gradove i države
        dodajGrad(new GradDTO("Pariz", "Francuska", 2200000));
        dodajGrad(new GradDTO("London", "Ujedinjeno Kraljevstvo", 8900000));
        dodajGrad(new GradDTO("Beč", "Austrija", 1800000));
        dodajGrad(new GradDTO("Manchester", "Ujedinjeno Kraljevstvo", 550000));
        dodajGrad(new GradDTO("Graz", "Austrija", 280000));
    }
    private boolean provjeriPostojanjeTabele() throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getTables(null, null, "gradovi", null);
        return resultSet.next();
    }
    public ArrayList<GradDTO> gradovi() {
        ArrayList<GradDTO> gradovi = new ArrayList<>();
        try {
            // Dohvatanje gradova iz baze podataka, sortiranih po broju stanovnika u opadajućem redosledu
            String query = "SELECT * FROM gradovi ORDER BY brojStanovnika DESC";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                GradDTO grad = new GradDTO();
                grad.setNaziv(resultSet.getString("naziv"));
                grad.setDrzava(resultSet.getString("drzava"));
                grad.setBrojStanovnika(resultSet.getInt("brojStanovnika"));
                gradovi.add(grad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gradovi;
    }
    public void dodajGrad(GradDTO grad) {
        try {
            // Dodavanje novog grada u bazu podataka
            String query = "INSERT INTO gradovi (naziv, drzava, brojStanovnika) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, grad.getNaziv());
            preparedStatement.setString(2, grad.getDrzava());
            preparedStatement.setInt(3, grad.getBrojStanovnika());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


