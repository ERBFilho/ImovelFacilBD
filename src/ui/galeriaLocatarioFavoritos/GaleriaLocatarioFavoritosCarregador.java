/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.galeriaLocatarioFavoritos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author khadgar
 */
public class GaleriaLocatarioFavoritosCarregador extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("galeriaLocatarioFavoritos.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("FAVORITOS");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    public static void main(String[] args) {
        launch(args);
        
    }
    
}