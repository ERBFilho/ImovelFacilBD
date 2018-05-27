/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.galeriaLocatarioFavoritos;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ui.imovelfacilbd.FXMLDocumentController;

/**
 * FXML Controller class
 *
 * @author khadgar
 */
public class GaleriaLocatarioFavoritosController implements Initializable {

    @FXML
    private AnchorPane painelRaiz;
    @FXML
    private ImageView voltarBut;
    @FXML
    private ImageView avatarPerfil;
    @FXML
    private ImageView img00;
    @FXML
    private ImageView img10;
    @FXML
    private ImageView img20;
    @FXML
    private ImageView img01;
    @FXML
    private ImageView img11;
    @FXML
    private ImageView img22;
    @FXML
    private ImageView carregarBut;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("---TELA FAVORITOS LOCATARIO---");
        System.out.println("Tipo de usuário ativo: "+ FXMLDocumentController.tipoDeUsuario);
        System.out.println("Id do usuário Logado: "+ FXMLDocumentController.idEstatico);
    }
    
    @FXML
    private void carregar(){
        //implementar
        System.out.println("Carrega imagens");
    }

    @FXML
    private void voltarBut(){
        System.out.println("boltao voltar pressionado.");
            sair();
            abrir("/ui/perfilLocatario/perfilLocatario.fxml","PERFIL LOCATARIO");
    }

    private void abrir(String local, String titulo)
    {
        
            Parent parent;
        try {
            parent = FXMLLoader.load(getClass().getResource(local));
                  
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle(titulo);
            
            stage.setScene(new Scene(parent));
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    private void sair() 
    {
        Stage stage = (Stage) painelRaiz.getScene().getWindow();
        stage.close();
    }
    
}
