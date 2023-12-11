package com.example.lv7z1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController  {
    @FXML
    private Label welcomeText;
    public TextField ime;
    public TextField prezime;
    public TextField email;
    public TextField korisnicko_ime;
    public PasswordField lozinka;
    public Button dodaj;
    public Button kraj;
    public ListView<Korisnik> lista;
    ObservableList<Korisnik> korisnici;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    public void initialize(){
        korisnici=FXCollections.observableArrayList();
        lista.setItems(korisnici);
        //Listener
        lista.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> detaljiKorisnika(newValue));

        ime.textProperty().addListener((observable, oldValue, newValue) -> {
            Korisnik selektovaniKorisnik=lista.getSelectionModel().getSelectedItem();
            if (selektovaniKorisnik != null) {
                selektovaniKorisnik.setIme(newValue);
            }
        });
        prezime.textProperty().addListener((observable, oldValue, newValue) -> {
            Korisnik selektovaniKorisnik=lista.getSelectionModel().getSelectedItem();
            if (selektovaniKorisnik != null) {
                selektovaniKorisnik.setPrezime(newValue);
            }
        });
        email.textProperty().addListener((observable, oldValue, newValue) -> {
            Korisnik selektovaniKorisnik=lista.getSelectionModel().getSelectedItem();
            if (selektovaniKorisnik != null) {
                selektovaniKorisnik.setEmail(newValue);
            }
        });
        korisnicko_ime.textProperty().addListener((observable, oldValue, newValue) -> {
            Korisnik selektovaniKorisnik=lista.getSelectionModel().getSelectedItem();
            if (selektovaniKorisnik != null) {
                selektovaniKorisnik.setKorisnicko_ime(newValue);
            }
        });
        lozinka.textProperty().addListener((observable, oldValue, newValue) -> {
            Korisnik selektovaniKorisnik=lista.getSelectionModel().getSelectedItem();
            if (selektovaniKorisnik != null) {
                selektovaniKorisnik.setLozinka(newValue);
            }
        });

    }
    @FXML
    public  void onClickDodaj(ActionEvent event){
         Korisnik prazno=new Korisnik();
         korisnici.add(prazno);
         lista.getSelectionModel().select(prazno);
         /*detaljiKorisnika(prazno);
         povezivanjePolja(prazno);*/
    }
    @FXML
    public void onClickKraj(ActionEvent event){
        Stage stage=(Stage) kraj.getScene().getWindow();
        stage.close();
    }
    private void povezivanjePolja(Korisnik k){
        ime.textProperty().bindBidirectional(k.imeProperty());
        prezime.textProperty().bindBidirectional(k.prezimeProperty());
        email.textProperty().bindBidirectional(k.emailProperty());
        korisnicko_ime.textProperty().bindBidirectional(k.korisnicko_imeProperty());
        lozinka.textProperty().bindBidirectional(k.lozinkaProperty());
    }
    private void detaljiKorisnika(Korisnik k){
        /*ime.textProperty().unbindBidirectional(k.imeProperty());
        prezime.textProperty().unbindBidirectional(k.prezimeProperty());
        email.textProperty().unbindBidirectional(k.emailProperty());
        korisnicko_ime.textProperty().unbindBidirectional(k.korisnicko_imeProperty());
        lozinka.textProperty().unbindBidirectional(k.lozinkaProperty());
        /*ime.textProperty().unbind();
        prezime.textProperty().unbind();
        email.textProperty().unbind();
        korisnicko_ime.textProperty().unbind();
        lozinka.textProperty().unbind();*/
        //ocistiPolja(k);
        if(k!=null) {
            ime.setText(k.getIme());
            prezime.setText(k.getPrezime());
            email.setText(k.getEmail());
            korisnicko_ime.setText(k.getKorisnicko_ime());
            lozinka.setText(k.getLozinka());
        }

    }
    private void ocistiPolja(Korisnik k){
        ime.clear();
        prezime.clear();
        email.clear();
        korisnicko_ime.clear();
        lozinka.clear();
    }
}