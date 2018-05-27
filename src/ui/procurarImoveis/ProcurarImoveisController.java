/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.procurarImoveis;

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
public class ProcurarImoveisController implements Initializable {

    @FXML
    private ImageView voltarBut;
    @FXML
    private Label imovel1LabelNome;
    @FXML
    private Label imovel1LabelEndereco;
    @FXML
    private Label imovel1LabelBairro;
    @FXML
    private Label imovel1LabelCidade;
    @FXML
    private Label imovel1LabelEstado;
    @FXML
    private Label imovel2LabelNome1;
    @FXML
    private Label imovel2LabelEndereco1;
    @FXML
    private Label imovel2LabelBairro1;
    @FXML
    private Label imovel2LabelCidade1;
    @FXML
    private Label imovel2LabelEstado1;
    @FXML
    private Label imovel3LabelNome2;
    @FXML
    private Label imovel3LabelEndereco2;
    @FXML
    private Label imovel3LabelBairro2;
    @FXML
    private Label imovel3LabelCidade2;
    @FXML
    private Label imovel3LabelEstado2;
    @FXML
    private AnchorPane painelRaiz;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("---TELA PROCURAR IMOVEIS---");
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
