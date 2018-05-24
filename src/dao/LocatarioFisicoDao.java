package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.LocatarioFisico;



public class LocatarioFisicoDao implements DaoGenerica<LocatarioFisico> {
    private ConexaoBanco conexao;

    public LocatarioFisicoDao(ConexaoBanco conexao) {
        this.conexao = conexao;
    }

    @Override
    public void inserir(LocatarioFisico locatario) {
        String sql = "INSERT INTO Locatario (Nome_Locatario, Endereco_Locatario, Bairro_Locatario, Cidade_Locatario, Estado_Locatario, Celular_Locatario, Telefone_Locatario, Email_Locatario, Senha_Locatario) VALUES (?,?,?,?,?,?,?,?,?)";
        String sql2 = "INSERT INTO Fisico_Locatario (Cod_Locatario, Sexo_Locatario, CPF_Locatario) VALUES (?,?,?)";
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
                sentenca.setString(2, locatario.getSexo_Locatario());
                sentenca.setString(3, locatario.getCPF_Locatario());
                sentenca.execute();
                sentenca.close();
                this.conexao.getConnection().close();                
            }
        } catch(SQLException ex){
            throw new RuntimeException(ex);            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LocatarioFisicoDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public void alterar(LocatarioFisico locatario) {
        String sql = "UPDATE Locatario set Nome_Locatario = ?, Endereco_Locatario = ?, Bairro_Locatario = ?, Cidade_Locatario = ?, Estado_Locatario = ?, Celeluar_Locatario = ?, Telefone_Locatario = ?, Email_Locatario = ?, Senha_Locatario = ? where Cod_Locatario = ?";
        String sql2 = "UPDATE Fisico_Locador set Sexo_Locador = ?, CPF_Locador = ? where Cod_Locador = ?";
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
                sentenca.setString(1, locatario.getSexo_Locatario());
                sentenca.setString(2, locatario.getCPF_Locatario());
                sentenca.setInt(3, locatario.getCod_Locatario());
                sentenca.execute();
                sentenca.close();
                this.conexao.getConnection().close();                
            }
        } catch(SQLException ex){
            throw new RuntimeException(ex);            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LocatarioFisicoDao.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LocatarioFisicoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<LocatarioFisico> consultar() {
        ArrayList<LocatarioFisico> listaLocatarioFisico = new ArrayList<LocatarioFisico>();
        String sql = "SELECT * FROM Locatario join Fisico_Locatario on Locatario.Cod_Locatario = Fisico_Locatario.Cod_Locatario";
        
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
                    LocatarioFisico locatarioFisico = new LocatarioFisico();
                    locatarioFisico.setCod_Locatario(resultadoSentenca.getInt("Cod_Locatario"));
                    locatarioFisico.setNome_Locatario(resultadoSentenca.getString("Nome_Locatario"));
                    locatarioFisico.setEndereco_Locatario(resultadoSentenca.getString("Endereco_Locatario"));
                    locatarioFisico.setBairro_Locatario(resultadoSentenca.getString("Bairro_Locatario"));
                    locatarioFisico.setCidade_Locatario(resultadoSentenca.getString("Cidade_Locatario"));
                    locatarioFisico.setEstado_Locatario(resultadoSentenca.getString("Estado_Locatario"));
                    locatarioFisico.setCelular_Locatario(resultadoSentenca.getString("Celular_Locatario"));
                    locatarioFisico.setTelefone_Locatario(resultadoSentenca.getString("Telefone_Locatario"));
                    locatarioFisico.setEmail_Locatario(resultadoSentenca.getString("Email_Locatario"));
                    locatarioFisico.setSenha_Locatario(resultadoSentenca.getString("Senha_Locatario"));
                    locatarioFisico.setSexo_Locatario(resultadoSentenca.getString("Sexo_Locatario"));
                    locatarioFisico.setCPF_Locatario(resultadoSentenca.getString("CPF_Locatario"));
                   
                    //adiciona cada tupla na listaEscolas que será retornada para a janela Escola
                    listaLocatarioFisico.add(locatarioFisico);
                }

                sentenca.close();
                this.conexao.getConnection().close();
            }
            
            return listaLocatarioFisico;
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
