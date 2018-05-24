package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import modelo.LocadorFisico;

public class LocadorFisicoTab implements DaoGenerica<LocadorFisico> {
    private ConexaoBanco conexao;
    
    public LocadorFisicoTab(){
        conexao = new ConexaoBanco();
    }
    
    @Override
    public void inserir(LocadorFisico locador) {
        String sql = "INSERT INTO Locador (Nome_Locador, Endereco_Locador, Bairro_Locador, Cidade_Locador, Estado_Locador, Celular_Locador, Telefone_Locador, Email_Locador, Senha_Locador) VALUES (?,?,?,?,?,?,?,?,?)";
        String sql2 = "INSERT INTO Fisico_Locador (Cod_Locador, Sexo_Locador, CPF_Locador) VALUES (?,?,?)";
        String sql3 = "SELECT max(Cod_Locador) FROM Locador";
        int maxId = 0;
        
        try{
            if(this.conexao.conectar()){
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                sentenca.setString(1, locador.getNome_Locador());
                sentenca.setString(2, locador.getEndereco_Locador());
                sentenca.setString(3, locador.getBairro_Locador());
                sentenca.setString(4, locador.getCidade_Locador());
                sentenca.setString(5, locador.getEstado_Locador());
                sentenca.setString(6, locador.getCelular_Locador());
                sentenca.setString(7, locador.getTelefone_Locador());
                sentenca.setString(8, locador.getEmail_Locador());
                sentenca.setString(9, locador.getSenha_Locador());
                sentenca.execute();
                sentenca.close();
                
                sentenca = this.conexao.getConnection().prepareStatement(sql3);
                ResultSet resultadoSentenca = sentenca.executeQuery();
                if(resultadoSentenca != null && resultadoSentenca.next()){
                    maxId = resultadoSentenca.getInt("max(Cod_Locador)");
                }                
                sentenca.close();
                
                sentenca = this.conexao.getConnection().prepareStatement(sql2);
                sentenca.setInt(1, maxId);
                sentenca.setString(2, locador.getSexo_Locador());
                sentenca.setString(3, locador.getCPF_Locador());
                sentenca.execute();
                sentenca.close();
                this.conexao.getConnection().close();                
            }
        } catch(SQLException ex){
            throw new RuntimeException(ex);            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LocadorFisicoTab.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public void alterar(LocadorFisico locador) {
        String sql = "UPDATE Locador set Nome_Locador = ?, Endereco_Locador = ?, Bairro_Locador = ?, Cidade_Locador = ?, Estado_Locador = ?, Celular_Locador = ?, Telefone_Locador = ?, Email_Locador = ?, Senha_Locador = ? where Cod_Locador = ?";
        String sql2 = "UPDATE Fisico_Locador set Sexo_Locador = ?, CPF_Locador = ? where Cod_Locador = ?";
        try{
            if(this.conexao.conectar()){
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);                
                sentenca.setString(1, locador.getNome_Locador());
                sentenca.setString(2, locador.getEndereco_Locador());
                sentenca.setString(3, locador.getBairro_Locador());
                sentenca.setString(4, locador.getCidade_Locador());
                sentenca.setString(5, locador.getEstado_Locador());
                sentenca.setString(6, locador.getCelular_Locador());
                sentenca.setString(7, locador.getTelefone_Locador());
                sentenca.setString(8, locador.getEmail_Locador());
                sentenca.setString(9, locador.getSenha_Locador());
                sentenca.setInt(10, locador.getCod_Locador());
                sentenca.execute();
                sentenca.close();
                sentenca = this.conexao.getConnection().prepareStatement(sql2);                
                sentenca.setString(1, locador.getSexo_Locador());
                sentenca.setString(2, locador.getCPF_Locador());
                sentenca.setInt(3, locador.getCod_Locador());
                sentenca.execute();
                sentenca.close();
                this.conexao.getConnection().close();                
            }
        } catch(SQLException ex){
            throw new RuntimeException(ex);            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LocadorFisicoTab.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public void excluir(int id) {
        String sql = "DELETE FROM Locador WHERE Cod_Locador = ?";
        
        try{
            if(this.conexao.conectar())
            {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                sentenca.setInt(1, id);
                
                sentenca.execute();
                sentenca.close();                
                
                this.conexao.getConnection().close();
            }
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LocadorFisicoTab.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<LocadorFisico> consultar() {
        ArrayList<LocadorFisico> listaLocadorFisico = new ArrayList<LocadorFisico>();
        String sql = "SELECT * FROM Locador join Fisico_Locador on Locador.Cod_Locador = Fisico_Locador.Cod_Locador";
        
        try
        {
            if(this.conexao.conectar())
            {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                //recebe o resultado da consulta
                ResultSet resultadoSentenca = sentenca.executeQuery();

                //percorrer cada linha do resultado
                while(resultadoSentenca.next()) 
                {
                    //resgata o valor de cada linha, selecionando pelo nome de cada coluna da tabela Escola
                    LocadorFisico locadorFisico = new LocadorFisico();
                    locadorFisico.setCod_Locador(resultadoSentenca.getInt("Cod_Locador"));
                    locadorFisico.setNome_Locador(resultadoSentenca.getString("Nome_Locador"));
                    locadorFisico.setEndereco_Locador(resultadoSentenca.getString("Endereco_Locador"));
                    locadorFisico.setBairro_Locador(resultadoSentenca.getString("Bairro_Locador"));
                    locadorFisico.setCidade_Locador(resultadoSentenca.getString("Cidade_Locador"));
                    locadorFisico.setEstado_Locador(resultadoSentenca.getString("Estado_Locador"));
                    locadorFisico.setCelular_Locador(resultadoSentenca.getString("Celular_Locador"));
                    locadorFisico.setTelefone_Locador(resultadoSentenca.getString("Telefone_Locador"));
                    locadorFisico.setEmail_Locador(resultadoSentenca.getString("Email_Locador"));
                    locadorFisico.setSenha_Locador(resultadoSentenca.getString("Senha_Locador"));
                    locadorFisico.setSexo_Locador(resultadoSentenca.getString("Sexo_Locador"));
                    locadorFisico.setCPF_Locador(resultadoSentenca.getString("CPF_Locador"));
                   
                    //adiciona cada tupla na listaEscolas que será retornada para a janela Escola
                    listaLocadorFisico.add(locadorFisico);
                }

                sentenca.close();
                this.conexao.getConnection().close();
            }
            
            return listaLocadorFisico;
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LocadorFisicoTab.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
