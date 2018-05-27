/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.imovelfacilbd;

import com.jfoenix.controls.JFXCheckBox;
import dao.ConexaoBanco;
import dao.LocadorJuridicoDao;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Gustavo
 */
public class FXMLDocumentController implements Initializable {
    //Componetes
    //variável estática para passsar o id do usuário.
    public static String idEstatico = "-1";
    public static int tipoDeUsuario = -1;//1-Locador  2-Locatario
    
    private ConexaoBanco conexao;
    PreparedStatement pStm = null;
    
    @FXML
    private ImageView logarBut;
    @FXML
    private ImageView cadastrarBut;
    @FXML
    private JFXCheckBox locatarioCheck;
    @FXML
    private JFXCheckBox locadorCheck;
    @FXML
    private TextField senhaField;
    @FXML
    private TextField loginField;
    @FXML
    private AnchorPane painelRaiz;
    
    
    Image logarButPressed = new Image("/imagens/Login/logarClicadoBut.png");
    Image logarButReleased = new Image("/imagens/Login/logarBut.png");
    Image logarButHover = new Image("/imagens/Login/logarHoverBut.png");
    Image logarButExited = new Image("/imagens/Login/logarBut.png");
    
    Image cadastrarButPressed = new Image("/imagens/Login/cadastrarClicadoBut.png");
    Image cadastrarButReleased = new Image("/imagens/Login/cadastrarBut.png");
    Image cadastrarButHover = new Image("/imagens/Login/cadastrarHoverBut.png");
    Image cadastrarButExited = new Image("/imagens/Login/cadastrarBut.png");
    
            
    //Metodos logar
    @FXML
    public void mousePressed(){
        //System.out.println("Botão Logar clicado");
        logarBut.setImage(logarButPressed);
        
        //RECEBE OS VALORES DIGITADOS
        String login = loginField.getText();
        String senha = senhaField.getText();
        
        //CONFERE SE EXISTE AO MENOS UMA OPÇÃO SELECIONADA
        if(!locatarioCheck.isSelected() && !locadorCheck.isSelected()){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("ERRO!");
            alerta.setHeaderText(null);
            alerta.setContentText("Selecione ao menos uma opçao:\n[LOCADOR] ou [LOCATÁRIO]");
            alerta.showAndWait();
            return;
        }
        //CONFERINDO SE OS CAMPOS FORAM PREENCHIDOS
        if(login.equals("") || senha.equals("")){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro!");
            alerta.setHeaderText(null);
            alerta.setContentText("Preencha todos os campos!");
            alerta.showAndWait();
            return;
        }
        //LOGANDO COMO LOCADOR
        if(locadorCheck.isSelected()){
            
            String  querie = "SELECT * FROM locador WHERE Cod_Locador = ?";
            int aLogin = -1;
            String aSenha = "";
            
            
            try{
                if(this.conexao.conectar()){
                    pStm = this.conexao.getConnection().prepareStatement(querie);
                    pStm.setInt(1,Integer.parseInt(login));
                    ResultSet locadoresComOLogin = pStm.executeQuery();
                    
              
                    while(locadoresComOLogin.next()){
                        aLogin = locadoresComOLogin.getInt("Cod_Locador");
                        aSenha = locadoresComOLogin.getString("Senha_Locador");
                    }
                    
                    System.out.println("Login é:"+login+" aLogin é: "+aLogin+" senha é: "+senha+" aSenha é: "+aSenha);
                    //CONFERINDO SE AS INFORMAÇÕES ESTÃO CORRETAS
                    if(aLogin == Integer.parseInt(login) && senha.equals(aSenha)){
                        System.out.println("LOCADOR: Logado Com sucesso");
                        
                        //FECHA JANELA ATUAL
                        sair();
                        //ABRE JANELA DO LOCADOR
                        idEstatico = login;
                        tipoDeUsuario = 1;
                        abrir("/ui/perfilLocador/perfilLocador.fxml","Locador");
                                  
                    }else{
                        System.out.println("Credenciais Inválidas.");
                    }
                   
                }
            } catch(SQLException ex){
                throw new RuntimeException(ex);            
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LocadorJuridicoDao.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (pStm != null){  try {
                    pStm.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                    }
}
                
            }
         //LOGANDO COMO LOCATÁRIO   
        }else if(locatarioCheck.isSelected()){
            String  querie = "SELECT * FROM locatario WHERE Cod_Locatario = ?";
            int aLogin = -1;
            String aSenha = "";
            
                
                try {
                    if(this.conexao.conectar()){
                        pStm = this.conexao.getConnection().prepareStatement(querie);
                        pStm.setInt(1, Integer.parseInt(login));
                        ResultSet locatariosComLogin = pStm.executeQuery();
                        
                        while(locatariosComLogin.next()){
                            aLogin = locatariosComLogin.getInt("Cod_Locatario");
                            aSenha = locatariosComLogin.getString("Senha_Locatario");
                        }                       
                        System.out.println("Login é:"+login+" aLogin é: "+aLogin+" senha é: "+senha+" aSenha é: "+aSenha);
                        //CONFERINDO SE AS INFORMAÇÕES ESTÃO CORRETAS
                        if(aLogin == Integer.parseInt(login) && senha.equals(aSenha)){
                            System.out.println("LOCADOR: Logado Com sucesso");
                            
                            //FECHA JANELA ATUAL
                            sair();
                            //ABRE JANELA DO LOCADOR
                            idEstatico = login;
                            tipoDeUsuario = 2;
                            
                            abrir("/ui/perfilLocatario/perfilLocatario.fxml","Janela Locatário");
                        }
                        
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }catch (SQLException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    if(pStm != null){
                        try {
                            pStm.close();
                        } catch (SQLException ex) {
                            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                        
                
            
        }
        
                
        
    }
    @FXML
    public void mouseReleased(){
        logarBut.setImage(logarButReleased);
//        System.out.println("Botão Logar liberado");
    }
    @FXML
    public void mouseHover(){
        logarBut.setImage(logarButHover);
//        System.out.println("Mouse hover");
    }
    @FXML
    public void mouseExit(){
        logarBut.setImage(logarButExited);
//        System.out.println("Mouse saiu");
    }
    
    //Metodos cadastrar
    @FXML
    public void mousePressedC(){
        cadastrarBut.setImage(cadastrarButPressed);
        if(locadorCheck.isSelected()){
            sair();
            abrir("/ui/cadastroLocador/cadastroLocador.fxml","CADASTRO LOCADOR");
        }else if (locatarioCheck.isSelected()){
            sair();
            abrir("/ui/cadastroLocatario/cadastroLocatario.fxml","CADASTRO LOCATARIO");
        }
        
//        System.out.println("Botão Logar clicado");
    }
    @FXML
    public void mouseReleasedC(){
        cadastrarBut.setImage(cadastrarButReleased);
//        System.out.println("Botão Logar liberado");
    }
    @FXML
    public void mouseHoverC(){
        cadastrarBut.setImage(cadastrarButHover);
//        System.out.println("Mouse hover");
    }
    @FXML
    public void mouseExitC(){
        cadastrarBut.setImage(cadastrarButExited);
//        System.out.println("Mouse saiu");
    }
    
    
    
    
    @FXML
    private void selecionarLocador(ActionEvent event) 
    {
        //impede que as duas caixas fiquem selecionadas ao mesmo tempo
        if(locadorCheck.isSelected()){
            locatarioCheck.setSelected(false);
        }
    }

    @FXML
    private void selecionarLocatario(ActionEvent event) 
    {
        //impede que as duas caixas fiquem selecionadas ao mesmo tempo
        if(locatarioCheck.isSelected()){
            locadorCheck.setSelected(false);
        }
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
    
    @FXML
    private void sair() 
    {
        Stage stage = (Stage) painelRaiz.getScene().getWindow();
        stage.close();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conexao = new ConexaoBanco();
    }    
    
}
