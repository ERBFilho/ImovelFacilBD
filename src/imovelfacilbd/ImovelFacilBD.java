/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imovelfacilbd;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.LocadorFisico;
import modelo.LocadorJuridico;
import tab.LocadorFisicoTab;
import tab.LocadorJuridicoTab;

/**
 *
 * @author Gustavo
 */
public class ImovelFacilBD extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        //LocadorFisico lf1 = new LocadorFisico("Maria", "Rua 02", "Centro", "VC", "Bahia", "888888", "88888", "gu.cruz17@hotmail.com", "12345", "F", "000.978.087-21");
             
        //LocadorFisicoTab lft = new LocadorFisicoTab();
        //lft.inserir(lf1);
       
        LocadorJuridico lj1 = new LocadorJuridico("UESB", "Desconhecido", "SP", "São Paulo", "Flórida", "65666", "556777", "usp@hotmail.com", "12345", "USP", "675.665.087-21");
              
        LocadorJuridicoTab ljt = new LocadorJuridicoTab();
        ljt.inserir(lj1);
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
