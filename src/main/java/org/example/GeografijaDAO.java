package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class GeografijaDAO {

    private static final String DATABASE_URL = "jdbc:sqlite:baza.db";
    private static Connection connection;
    private static GeografijaDAO instance;

    private GeografijaDAO() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(DATABASE_URL);
            kreirajTabele();
            popuniBazuAkoPrazna();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static GeografijaDAO getInstance() {
        if (instance == null) {
            instance = new GeografijaDAO();
        }
        return instance;
    }

    private void kreirajTabele() {
        try (Statement statement = connection.createStatement()) {
            // Kreiranje tabela ako ne postoje
            statement.execute("CREATE TABLE IF NOT EXISTS drzava (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "naziv TEXT," +
                    "glavni_grad INTEGER," +
                    "FOREIGN KEY (glavni_grad) REFERENCES grad(id)" +
                    ")");
            statement.execute("CREATE TABLE IF NOT EXISTS grad (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "naziv TEXT," +
                    "broj_stanovnika INTEGER," +
                    "drzava INTEGER," +
                    "FOREIGN KEY (drzava) REFERENCES drzava(id)" +
                    ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void popuniBazuAkoPrazna() {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM grad");
            if (resultSet.getInt(1) == 0) {
                // Ako je baza prazna, dodaj podatke
                dodajGrad(new GradDTO("Pariz", 2200000, "Francuska"));
                dodajGrad(new GradDTO("London", 8900000, "Ujedinjeno Kraljevstvo"));
                dodajGrad(new GradDTO("Beč", 1900000, "Austrija"));
                dodajGrad(new GradDTO("Manchester", 547000, "Ujedinjeno Kraljevstvo"));
                dodajGrad(new GradDTO("Graz", 280000, "Austrija"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<GradDTO> gradovi() {
        ArrayList<GradDTO> gradovi = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM grad ORDER BY broj_stanovnika DESC");
            while (resultSet.next()) {
                GradDTO grad = new GradDTO(
                        resultSet.getString("naziv"),
                        resultSet.getInt("broj_stanovnika"),
                        nadjiDrzavu(resultSet.getString("drzava")).getNaziv()
                );
                gradovi.add(grad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gradovi;
    }

    public GradDTO glavniGrad(String drzava) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM grad WHERE naziv = ?"
        )) {
            preparedStatement.setString(1, drzava);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new GradDTO(
                        resultSet.getString("naziv"),
                        resultSet.getInt("broj_stanovnika"),
                        nadjiDrzavu(resultSet.getString("drzava")).getNaziv()
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void obrisiDrzavu(String drzava) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM grad WHERE drzava IN (SELECT id FROM drzava WHERE naziv = ?)"
        )) {
            preparedStatement.setString(1, drzava);
            preparedStatement.executeUpdate();

            preparedStatement.clearParameters();
            preparedStatement.setString(1, drzava);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dodajGrad(GradDTO grad) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO grad (naziv, broj_stanovnika, drzava) VALUES (?, ?, " +
                        "(SELECT id FROM drzava WHERE naziv = ?))"
        )) {
            preparedStatement.setString(1, grad.getNaziv());
            preparedStatement.setInt(2, grad.getBrojStanovnika());
            preparedStatement.setString(3, grad.getDrzava());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dodajDrzavu(DrzavaDTO drzava) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO drzava (naziv, glavni_grad) VALUES (?, " +
                        "(SELECT id FROM grad WHERE naziv = ?))"
        )) {
            preparedStatement.setString(1, drzava.getNaziv());
            preparedStatement.setString(2, drzava.getGlavniGrad());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void izmijeniGrad(GradDTO grad) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE grad SET naziv = ?, broj_stanovnika = ?, drzava = " +
                        "(SELECT id FROM drzava WHERE naziv = ?) WHERE naziv = ?"
        )) {
            preparedStatement.setString(1, grad.getNaziv());
            preparedStatement.setInt(2, grad.getBrojStanovnika());
            preparedStatement.setString(3, grad.getDrzava());
            preparedStatement.setString(4, grad.getNaziv());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public DrzavaDTO nadjiDrzavu(String drzava) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM drzava WHERE naziv = ?"
        )) {
            preparedStatement.setString(1, drzava);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new DrzavaDTO(
                        resultSet.getString("naziv"),
                        resultSet.getString("glavni_grad")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}