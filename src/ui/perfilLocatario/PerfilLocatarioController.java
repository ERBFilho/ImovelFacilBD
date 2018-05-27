/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.perfilLocatario;

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
import javafx.scene.control.Label;
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
public class PerfilLocatarioController implements Initializable {

    @FXML
    private AnchorPane painelRaiz;
    @FXML
    private ImageView avatarPerfil;
    @FXML
    private ImageView voltarBut;
    @FXML
    private Label nomeLabel;
    @FXML
    private Label ruaLabel;
    @FXML
    private Label bairroLabel;
    @FXML
    private Label cidadeLabel;
    @FXML
    private Label estadoLabel;
    @FXML
    private Label telefoneLabel;
    @FXML
    private Label celularLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private ImageView procurarImovelBut;
    @FXML
    private ImageView editarPerfilBut;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("---TELA PERFIL LOCATARIO---");
        System.out.println("Tipo de usuário ativo: "+ FXMLDocumentController.tipoDeUsuario);
        System.out.println("Id do usuário Logado: "+ FXMLDocumentController.idEstatico);
    }    
    
    @FXML
    private void mousePressedVoltar(){
        System.out.println("Clicou para voltar");
        sair();
        abrir("/ui/imovelfacilbd/FXMLDocument.fxml","Menu Principal");
        
    }
    @FXML
    public void favoritos(){
        sair();
        abrir("/ui/galeriaLocatarioFavoritos/galeriaLocatarioFavoritos.fxml","FAVORITOS");
    }
    @FXML
    public void procurarImoveis(){
        sair();
        abrir("/ui/procurarImoveis/procurarImoveis.fxml","BUSCAR IMOVEIS");
    }
    @FXML
    public void editarPerfil(){
        sair();
        abrir("/ui/editarDados/editarDados.fxml","EDITAR DADOS");
    }
    
    
    private void sair (){
        Stage stage = (Stage) painelRaiz.getScene().getWindow();
        stage.close();
    }
    private void abrir(String local, String titulo){
        try {
            Parent root = FXMLLoader.load(getClass().getResource(local));
            Scene scene = new Scene(root);
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setScene(scene);
            stage.setTitle(titulo);
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(PerfilLocatarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
