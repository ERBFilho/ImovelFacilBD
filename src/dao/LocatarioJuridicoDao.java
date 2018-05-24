package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.LocatarioJuridico;

public class LocatarioJuridicoDao implements DaoGenerica<LocatarioJuridico> {
    private ConexaoBanco conexao;

    public LocatarioJuridicoDao(ConexaoBanco conexao) {
        this.conexao = conexao;
    }
    
    @Override
    public void inserir(LocatarioJuridico locatario) {
        String sql = "INSERT INTO Locatario (Nome_Locatario, Endereco_Locatario, Bairro_Locatario, Cidade_Locatario, Estado_Locatario, Celular_Locatario, Telefone_Locatario, Email_Locatario, Senha_Locatario) VALUES (?,?,?,?,?,?,?,?,?)";
        String sql2 = "INSERT INTO Juridico_Locatario (Cod_Locatario, Razao_Social_Locatario, CNPJ_Locatario) VALUES (?,?,?)";
        String sql3 = "SELECT max(Cod_Locatario) FROM Locatario";
        int maxId = 0;
        
        try{
            if(this.conexao.conectar()){
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                sentenca.setString(1, locatario.getNome_Locatario());
                sentenca.setString(2, locatario.getEndereco_Locatario());
                sentenca.setString(3, locatario.getBairro_Locatario());
                sentenca.setString(4, locatario.getCidade_Locatario());
                sentenca.setString(5, locatario.getEstado_Locatario());
                sentenca.setString(6, locatario.getCelular_Locatario());
                sentenca.setString(7, locatario.getTelefone_Locatario());
                sentenca.setString(8, locatario.getEmail_Locatario());
                sentenca.setString(9, locatario.getSenha_Locatario());
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
                sentenca.setString(2, locatario.getRazao_Social_Locatario());
                sentenca.setString(3, locatario.getCNPJ_Locatario());
                sentenca.execute();
                sentenca.close();
                this.conexao.getConnection().close();                
            }
        } catch(SQLException ex){
            throw new RuntimeException(ex);            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LocatarioJuridicoDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public void alterar(LocatarioJuridico locatario) {
        String sql = "UPDATE Locatario set Nome_Locatario = ?, Endereco_Locatario = ?, Bairro_Locatario = ?, Cidade_Locatario = ?, Estado_Locatario = ?, Celeluar_Locatario = ?, Telefone_Locatario = ?, Email_Locatario = ?, Senha_Locatario = ? where Cod_Locatario = ?";
        String sql2 = "UPDATE Juridico_Locador set Razao_Social_Locatario = ?, CNPJ_Locatario = ? where Cod_Locatario = ?";
        try{
            if(this.conexao.conectar()){
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);                
                sentenca.setString(1, locatario.getNome_Locatario());
                sentenca.setString(2, locatario.getEndereco_Locatario());
                sentenca.setString(3, locatario.getBairro_Locatario());
                sentenca.setString(4, locatario.getCidade_Locatario());
                sentenca.setString(5, locatario.getEstado_Locatario());
                sentenca.setString(6, locatario.getCelular_Locatario());
                sentenca.setString(7, locatario.getTelefone_Locatario());
                sentenca.setString(8, locatario.getEmail_Locatario());
                sentenca.setString(9, locatario.getSenha_Locatario());
                sentenca.setInt(10, locatario.getCod_Locatario());
                sentenca.execute();
                sentenca.close();
                sentenca = this.conexao.getConnection().prepareStatement(sql2);                
                sentenca.setString(1, locatario.getRazao_Social_Locatario());
                sentenca.setString(2, locatario.getCNPJ_Locatario());
                sentenca.setInt(3, locatario.getCod_Locatario());
                sentenca.execute();
                sentenca.close();
                this.conexao.getConnection().close();                
            }
        } catch(SQLException ex){
            throw new RuntimeException(ex);            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LocatarioJuridicoDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public void excluir(int id) {
        String sql = "DELETE FROM Locatario WHERE Cod_Locatario = ?";
        
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
            Logger.getLogger(LocatarioJuridicoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<LocatarioJuridico> consultar() {
        ArrayList<LocatarioJuridico> listaLocatarioJuridico = new ArrayList<LocatarioJuridico>();
        String sql = "SELECT * FROM Locatario join Juridico_Locatario on Locatario.Cod_Locatario = Juridico_Locatario.Cod_Locatario";
        
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
                    LocatarioJuridico locatarioJuridico = new LocatarioJuridico();
                    locatarioJuridico.setCod_Locatario(resultadoSentenca.getInt("Cod_Locatario"));
                    locatarioJuridico.setNome_Locatario(resultadoSentenca.getString("Nome_Locatario"));
                    locatarioJuridico.setEndereco_Locatario(resultadoSentenca.getString("Endereco_Locatario"));
                    locatarioJuridico.setBairro_Locatario(resultadoSentenca.getString("Bairro_Locatario"));
                    locatarioJuridico.setCidade_Locatario(resultadoSentenca.getString("Cidade_Locatario"));
                    locatarioJuridico.setEstado_Locatario(resultadoSentenca.getString("Estado_Locatario"));
                    locatarioJuridico.setCelular_Locatario(resultadoSentenca.getString("Celular_Locatario"));
                    locatarioJuridico.setTelefone_Locatario(resultadoSentenca.getString("Telefone_Locatario"));
                    locatarioJuridico.setEmail_Locatario(resultadoSentenca.getString("Email_Locatario"));
                    locatarioJuridico.setSenha_Locatario(resultadoSentenca.getString("Senha_Locatario"));
                    locatarioJuridico.setRazao_Social_Locatario(resultadoSentenca.getString("Razao_Social_Locatario"));
                    locatarioJuridico.setCNPJ_Locatario(resultadoSentenca.getString("CNPJ_Locatario"));
                   
                    //adiciona cada tupla na listaEscolas que será retornada para a janela Escola
                    listaLocatarioJuridico.add(locatarioJuridico);
                }

                sentenca.close();
                this.conexao.getConnection().close();
            }
            
            return listaLocatarioJuridico;
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LocadorJuridicoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    
}
