/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.perfilLocatario;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author khadgar
 */
public class perfilLocatarioCarregador extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
      Parent root = FXMLLoader.load(getClass().getResource("perfilLocatario.fxml"));
      Scene scene = new Scene(root);
      
      primaryStage.setTitle("Tela Locatario");
      primaryStage.setScene(scene);
      primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
