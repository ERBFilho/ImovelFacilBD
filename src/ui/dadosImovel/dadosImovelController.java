/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.dadosImovel;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import ui.imovelfacilbd.FXMLDocumentController;

/**
 * FXML Controller class
 *
 * @author khadgar
 */
public class dadosImovelController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("---TELA DADOS DO IMOVEL---");
        System.out.println("Tipo de usuário ativo: "+ FXMLDocumentController.tipoDeUsuario);
        System.out.println("Id do usuário Logado: "+ FXMLDocumentController.idEstatico);
    }    
    
}
