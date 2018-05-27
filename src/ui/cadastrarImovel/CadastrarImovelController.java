/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.cadastrarImovel;

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
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
public class CadastrarImovelController implements Initializable {

    @FXML
    private AnchorPane painelRaiz;
    @FXML
    private ImageView avatarPerfil;
    @FXML
    private ImageView voltarBut;
    @FXML
    private ImageView cancelarBut;
    @FXML
    private ImageView salvarBut;
    @FXML
    private TextField nomeImovelEntrada;
    @FXML
    private TextField enderecoEntrada;
    @FXML
    private TextField bairroEntrada;
    @FXML
    private TextField cidadeEntrada;
    @FXML
    private TextField estadoEntrada;
    @FXML
    private TextField categoriaEntrada;
    @FXML
    private TextArea descricaoEntrada;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("---TELA CADASTRAR IMOVEL---");
        System.out.println("Tipo de usuário ativo: "+ FXMLDocumentController.tipoDeUsuario);
        System.out.println("Id do usuário Logado: "+ FXMLDocumentController.idEstatico);
    }    
    
    
    @FXML
    private void salvar(){
        //AQUI DEVE PEGAR OS VALORES DAS BOXES E ARMAZENAR NO BD
        
        
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText(null);
        alerta.setTitle("Sucesso");
        alerta.setContentText("Imovel Cadastrado");
        alerta.showAndWait();
        
        voltar();
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
