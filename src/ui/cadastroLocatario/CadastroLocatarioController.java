/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.cadastroLocatario;

import ui.cadastroLocador.*;
import com.jfoenix.controls.JFXCheckBox;
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
import javafx.scene.control.TextField;
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
public class CadastroLocatarioController implements Initializable {

    
    @FXML
    private TextField nomeEntrada;
    @FXML
    private TextField enderecoEntrada;
    @FXML
    private TextField bairroEntrada;
    @FXML
    private TextField cidadeEntrada;
    @FXML
    private TextField estadoEntrada;
    @FXML
    private TextField celularEntrada;
    @FXML
    private TextField telefoneEntrada;
    @FXML
    private TextField emailEntrada;
    @FXML
    private TextField senhaEntrada;
    @FXML
    private ImageView butCancelar;
    @FXML
    private ImageView butSalvar;
    @FXML
    private JFXCheckBox pFisicaCheck;
    @FXML
    private TextField cpfEntrada;
    @FXML
    private TextField sexoEntrada;
    @FXML
    private TextField rSocialEntrada;
    @FXML
    private JFXCheckBox pJuridicaCheck;
    @FXML
    private TextField cnpjEntrada;
    @FXML
    private AnchorPane painelRaiz;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("---TELA CADASTRO LOCATARIO---");
        System.out.println("Tipo de usuário ativo: "+ FXMLDocumentController.tipoDeUsuario);
        System.out.println("Id do usuário Logado: "+ FXMLDocumentController.idEstatico);
    }
    
    //METODO PARA SALVAR NO BANCO DE DADOS
    @FXML
    private void salvar(){
        if(pFisicaCheck.isSelected()){
            //salva um locador fisico
            
            
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Sucesso");
            alerta.setHeaderText(null);
            alerta.setContentText("Locador Físico salvo.");
            alerta.showAndWait();
            
            sair();
            abrir("/ui/imovelfacilbd/FXMLDocument.fxml","MENU PRINCIPAL");
            
        }else if(pJuridicaCheck.isSelected()){
            //salva um locador juridico
            
            
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Sucesso");
            alerta.setHeaderText(null);
            alerta.setContentText("Locador Juridico salvo.");
            alerta.showAndWait();
            
            sair();
            abrir("/ui/imovelfacilbd/FXMLDocument.fxml","MENU PRINCIPAL");
        }
    }
    
    
    @FXML
    private void cancelarBut(){
        sair();
        abrir("/ui/imovelfacilbd/FXMLDocument.fxml","MENU PRINCIPAL");
    }
    
    
    @FXML
    private void pFisicaSelecionado(){
        if(pFisicaCheck.isSelected()){
            pJuridicaCheck.setSelected(false);
            cnpjEntrada.setText("");
            cnpjEntrada.setDisable(true);
            rSocialEntrada.setText("");
            rSocialEntrada.setDisable(true);
            
            cpfEntrada.setDisable(false);
            sexoEntrada.setDisable(false);
        }
    }
    @FXML
    private void pJuridicaSelecionado(){
        if(pJuridicaCheck.isSelected()){
            pFisicaCheck.setSelected(false);
            cpfEntrada.setText("");
            cpfEntrada.setDisable(true);
            sexoEntrada.setText("");            
            sexoEntrada.setDisable(true);
            
            cnpjEntrada.setDisable(false);
            rSocialEntrada.setDisable(false);
        }
    }
    
    
    
    private void sair(){
        Stage stage = (Stage) painelRaiz.getScene().getWindow();
        stage.close();
    }
    private void abrir(String local, String titulo){
        Parent root;
        try {
            
            root = FXMLLoader.load(getClass().getResource(local));
            Scene scene = new Scene(root);
            
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setScene(scene);
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(CadastroLocatarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
