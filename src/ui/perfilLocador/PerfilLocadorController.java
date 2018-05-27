/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.perfilLocador;

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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ui.imovelfacilbd.FXMLDocumentController;


public class PerfilLocadorController implements Initializable {

    @FXML
    private ImageView avatarPerfil;
    @FXML
    private ImageView cadastrarImovelBut;
    @FXML
    private ImageView meusImoveisBut;
    @FXML
    private ImageView editarPerfilBut;
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
    private AnchorPane painelRaiz;
    
    //imagem do avatar
    Image avatarId = new Image("/imagens/Avatares/"+FXMLDocumentController.idEstatico+".png");
    
    
    @FXML
    public void mousePressedVoltar(){
        System.out.println("clicou para feixar");
        sair();
        abrir("/ui/imovelfacilbd/FXMLDocument.fxml","Menu Principal");
    }
    
    @FXML
    public void editarPerfil(){
        sair();
        abrir("/ui/editarDados/editarDados.fxml","EDITAR DADOS");
    }
    @FXML
    public void cadastrarImoveis(){
        sair();
        abrir("/ui/cadastrarImovel/cadastrarImovel.fxml","CADASTRAR IMOVEL");
    }
    @FXML
    public void meusImoveis(){
        sair();
        abrir("/ui/galeriaLocador/galeriaLocador.fxml","MEUS IMOVEIS");
    }
    
        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("---TELA PERFIL LOCADOR---");
        System.out.println("Tipo de usuário ativo: "+ FXMLDocumentController.tipoDeUsuario);
        System.out.println("Id do usuário Logado: "+ FXMLDocumentController.idEstatico);
        
        avatarPerfil.setImage(avatarId);
        System.out.println("Imagem setada:"+FXMLDocumentController.idEstatico);
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
