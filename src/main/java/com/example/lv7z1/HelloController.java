package com.example.lv7z1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

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
    //ObservableList<Korisnik> korisnici;
    public KorisniciModel korisnici;
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    public void initialize(){
        korisnici=new KorisniciModel();
        korisnici.napuni();
        lista.setItems(korisnici.getKorisnici());
        ime.textProperty().bindBidirectional(korisnici.getTrenutniKorisnik().imeProperty());
        prezime.textProperty().bindBidirectional(korisnici.getTrenutniKorisnik().prezimeProperty());
        email.textProperty().bindBidirectional(korisnici.getTrenutniKorisnik().emailProperty());
        korisnicko_ime.textProperty().bindBidirectional(korisnici.getTrenutniKorisnik().korisnicko_imeProperty());
        lozinka.textProperty().bindBidirectional(korisnici.getTrenutniKorisnik().lozinkaProperty());
        lista.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    korisnici.setTrenutniKorisnik(newValue);
                    detaljiKorisnika(korisnici.getTrenutniKorisnik());
                });

        ime.textProperty().addListener((observable, oldValue, newValue) -> {
            Korisnik selektovaniKorisnik=lista.getSelectionModel().getSelectedItem();
            if (selektovaniKorisnik != null) {
                selektovaniKorisnik.setIme(newValue);
            }
        });
        prezime.textProperty().addListener((observable, oldValue, newValue) -> {
            Korisnik selektovaniKorisnik=korisnici.getTrenutniKorisnik();
            if (selektovaniKorisnik != null) {
                selektovaniKorisnik.setPrezime(newValue);
            }
        });
        email.textProperty().addListener((observable, oldValue, newValue) -> {
            Korisnik selektovaniKorisnik=korisnici.getTrenutniKorisnik();
            if (selektovaniKorisnik != null) {
                selektovaniKorisnik.setEmail(newValue);
            }
        });
        korisnicko_ime.textProperty().addListener((observable, oldValue, newValue) -> {
            Korisnik selektovaniKorisnik=korisnici.getTrenutniKorisnik();
            if (selektovaniKorisnik != null) {
                selektovaniKorisnik.setKorisnicko_ime(newValue);
            }
        });
        lozinka.textProperty().addListener((observable, oldValue, newValue) -> {
            Korisnik selektovaniKorisnik=korisnici.getTrenutniKorisnik();
            if (selektovaniKorisnik != null) {
                selektovaniKorisnik.setLozinka(newValue);
            }
        });

    }
    @FXML
    public  void onClickDodaj(ActionEvent event){
         Korisnik prazno=new Korisnik();
         korisnici.dodaj(prazno);
         korisnici.setTrenutniKorisnik(prazno);
         lista.getSelectionModel().select(prazno);
    }
    @FXML
    public void onClickKraj(ActionEvent event){
        Stage stage=(Stage) kraj.getScene().getWindow();
        stage.close();
    }
    private void detaljiKorisnika(Korisnik k){
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