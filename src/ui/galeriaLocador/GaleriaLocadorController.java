/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.galeriaLocador;

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
import ui.perfilLocador.PerfilLocadorController;

/**
 * FXML Controller class
 *
 * @author khadgar
 */
public class GaleriaLocadorController implements Initializable {

    @FXML
    private AnchorPane painelRaiz;
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
    @FXML
    private ImageView voltarBut;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("---TELA GALERIA LOCADOR---");
        System.out.println("Tipo de usuário ativo: "+ FXMLDocumentController.tipoDeUsuario);
        System.out.println("Id do usuário Logado: "+ FXMLDocumentController.idEstatico);
    }
    
    @FXML
    private void carregarMaisImagens(){
        //DEVE ATUALIZAR AS IMAGENS COM NOVAS. [vai da 00 a 22]
        System.out.println("Novas imagens carregadas.");
        
    }
    
    @FXML
    private void voltar(){
        sair();
        abrir("/ui/perfilLocador/perfilLocador.fxml","PERFIL LOCADOR");
    }

    private void sair(){
        Stage stage = (Stage) painelRaiz.getScene().getWindow();
        stage.close();
    }
    private void abrir(String local, String titulo){
        Parent root;
        
        try {
            root = FXMLLoader.load(getClass().getResource(local));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setScene(new Scene(root));
            stage.show();
            
            
        } catch (IOException ex) {
            Logger.getLogger(PerfilLocadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
