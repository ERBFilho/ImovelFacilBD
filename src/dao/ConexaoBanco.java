package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
        
    private String url;
    private String usuario;
    private String senha;
    private Connection conexao;
    
    public ConexaoBanco(){
        this.url = "jdbc:mysql://localhost:3306/imovelfacil?userTimezpne=true&serverTimezone=UTC";
        this.usuario = "root";
        this.senha = "";
    }
    
    public boolean conectar() throws ClassNotFoundException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.conexao = DriverManager.getConnection(url, usuario, senha);
            return true;
        }
        catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    
    public Connection getConnection(){
        return conexao;
    }
}
