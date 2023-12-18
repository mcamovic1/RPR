package com.example.lv7z1;

import static org.junit.jupiter.api.Assertions.*;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.control.ListViewMatchers;

import java.io.IOException;

@ExtendWith(ApplicationExtension.class)
class HelloControllerTest {
  /*@Start
  public void start(Stage stage) throws IOException {
      FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
      Scene scene = new Scene(fxmlLoader.load(), 320, 240);
      stage.setTitle("Korisnici");
      stage.setScene(scene);
      stage.show();
      stage.toFront(); //da se prozor prikaze ispred
  }
  @Test
    void dodajTest(FxRobot robot){
      ListView listView = robot.lookup("#lista").queryListView();
      robot.clickOn("#dodaj");
      assertEquals(4, listView.getItems().size());
  }
  @Test
    void proveraPolja(FxRobot robot){
      ListView<Korisnik> listView = robot.lookup("#lista").queryListView();
      robot.clickOn("#dodaj");
      robot.clickOn("#ime").write("NewName");
      robot.clickOn("#prezime").write("NewLastName");
      robot.clickOn("#email").write("new.email@example.com");
      robot.clickOn("#korisnicko_ime").write("newUsername");
      robot.clickOn("#lozinka").write("newPassword");
      robot.clickOn("#dodaj");
      int index=listView.getItems().size();
      Platform.runLater(()->{
          listView.getSelectionModel().select(index-2);
          robot.clickOn(listView);
      });
      assertEquals("NewName", robot.lookup("#ime").queryAs(TextField.class).getText());
      assertEquals("NewLastName", robot.lookup("#prezime").queryAs(TextField.class).getText());
      assertEquals("new.email@example.com", robot.lookup("#email").queryAs(TextField.class).getText());
      assertEquals("newUsername", robot.lookup("#korisnicko_ime").queryAs(TextField.class).getText());
      assertEquals("newPassword", robot.lookup("#lozinka").queryAs(PasswordField.class).getText());
  }
  @Test
    void dodavanjePraznogKorisnikaTest(FxRobot robot){
      robot.clickOn("#dodaj");
      TextField imeField = robot.lookup("#ime").query();
      TextField prezimeField = robot.lookup("#prezime").query();
      TextField emailField = robot.lookup("#email").query();
      TextField korisnickoImeField = robot.lookup("#korisnicko_ime").query();
      PasswordField lozinkaField = robot.lookup("#lozinka").query();
      assertTrue(imeField.getText().isEmpty());
      assertTrue(prezimeField.getText().isEmpty());
      assertTrue(emailField.getText().isEmpty());
      assertTrue(korisnickoImeField.getText().isEmpty());
      assertTrue(lozinkaField.getText().isEmpty());
  }
  }*/
}