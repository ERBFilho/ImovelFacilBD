package modelo;

public class LocadorFisico extends Locador {    
    private String Sexo_Locador;
    private String CPF_Locador;
    
    public LocadorFisico(){        
        
    }

    public LocadorFisico(String Nome_Locador, String Endereco_Locador, String Bairro_Locador, String Cidade_Locador, String Estado_Locador, String Celular_Locador, String Telefone_Locador, String Email_Locador, String Senha_Locador, String Sexo_Locador,String CPF_Locador) {
        this.setNome_Locador(Nome_Locador);
        this.setEndereco_Locador(Endereco_Locador);
        this.setBairro_Locador(Bairro_Locador);
        this.setCidade_Locador(Cidade_Locador);;
        this.setEstado_Locador(Estado_Locador);
        this.setCelular_Locador(Celular_Locador);
        this.setTelefone_Locador(Telefone_Locador);
        this.setEmail_Locador(Email_Locador);
        this.setSenha_Locador(Senha_Locador);
        this.Sexo_Locador = Sexo_Locador;
        this.CPF_Locador = CPF_Locador;
    }

    public LocadorFisico(String Nome_Locador, String Endereco_Locador, String Bairro_Locador, String Cidade_Locador, String Estado_Locador, String Celular_Locador, String Email_Locador, String Senha_Locador, String Sexo_Locador,String CPF_Locador) {
        this.setNome_Locador(Nome_Locador);
        this.setEndereco_Locador(Endereco_Locador);
        this.setBairro_Locador(Bairro_Locador);
        this.setCidade_Locador(Cidade_Locador);;
        this.setEstado_Locador(Estado_Locador);
        this.setCelular_Locador(Celular_Locador);
        this.setEmail_Locador(Email_Locador);
        this.setSenha_Locador(Senha_Locador);
        this.Sexo_Locador = Sexo_Locador;
        this.CPF_Locador = CPF_Locador;
    }

    public String getCPF_Locador() {
        return CPF_Locador;
    }

    public void setCPF_Locador(String CPF_Locador) {
        this.CPF_Locador = CPF_Locador;
    }

    public String getSexo_Locador() {
        return Sexo_Locador;
    }

    public void setSexo_Locador(String Sexo_Locador) {
        this.Sexo_Locador = Sexo_Locador;
    }    
}
