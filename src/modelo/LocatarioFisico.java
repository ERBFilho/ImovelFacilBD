package modelo;

public class LocatarioFisico extends Locatario {    
    private String Sexo_Locatario;
    private String CPF_Locatario;

    public LocatarioFisico() {
    }    
    
    public LocatarioFisico(String Nome_Locatario, String Endereco_Locatario, String Bairro_Locatario, String Cidade_Locatario, String Estado_Locatario, String Celular_Locatario, String Telefone_Locatario, String Email_Locatario, String Senha_Locatario, String Sexo_Locatario, String CPF_Locatario) {
        this.setNome_Locatario(Nome_Locatario);
        this.setEndereco_Locatario(Endereco_Locatario);
        this.setBairro_Locatario(Bairro_Locatario);
        this.setCidade_Locatario(Cidade_Locatario);
        this.setEstado_Locatario(Estado_Locatario);
        this.setCelular_Locatario(Celular_Locatario);
        this.setTelefone_Locatario(Telefone_Locatario);
        this.setEmail_Locatario(Email_Locatario);
        this.setSenha_Locatario(Senha_Locatario);
        this.Sexo_Locatario = Sexo_Locatario;
        this.CPF_Locatario = CPF_Locatario;       
    }

    public LocatarioFisico(String Nome_Locatario, String Endereco_Locatario, String Bairro_Locatario, String Cidade_Locatario, String Estado_Locatario, String Celular_Locatario, String Email_Locatario, String Senha_Locatario, String Sexo_Locatario, String CPF_Locatario) {
        this.setNome_Locatario(Nome_Locatario);
        this.setEndereco_Locatario(Endereco_Locatario);
        this.setBairro_Locatario(Bairro_Locatario);
        this.setCidade_Locatario(Cidade_Locatario);
        this.setEstado_Locatario(Estado_Locatario);
        this.setCelular_Locatario(Celular_Locatario);
        this.setEmail_Locatario(Email_Locatario);
        this.setSenha_Locatario(Senha_Locatario);
        this.Sexo_Locatario = Sexo_Locatario;
        this.CPF_Locatario = CPF_Locatario;      
    }
    
    public String getSexo_Locatario() {
        return Sexo_Locatario;
    }

    public void setSexo_Locatario(String Sexo_Locatario) {
        this.Sexo_Locatario = Sexo_Locatario;
    }

    public String getCPF_Locatario() {
        return CPF_Locatario;
    }

    public void setCPF_Locatario(String CPF_Locatario) {
        this.CPF_Locatario = CPF_Locatario;
    }
}
