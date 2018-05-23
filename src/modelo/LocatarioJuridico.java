package modelo;

public class LocatarioJuridico extends Locatario {
    private String Razao_Social_Locatario;
    private String CNPJ_Locatario;

    public LocatarioJuridico() {
    }

    public LocatarioJuridico(String Nome_Locatario, String Endereco_Locatario, String Bairro_Locatario, String Cidade_Locatario, String Estado_Locatario, String Celular_Locatario, String Telefone_Locatario, String Email_Locatario, String Senha_Locatario, String Razao_Social_Locatario, String CNPJ_Locatario) {
        this.setNome_Locatario(Nome_Locatario);
        this.setEndereco_Locatario(Endereco_Locatario);
        this.setBairro_Locatario(Bairro_Locatario);
        this.setCidade_Locatario(Cidade_Locatario);
        this.setEstado_Locatario(Estado_Locatario);
        this.setCelular_Locatario(Celular_Locatario);
        this.setTelefone_Locatario(Telefone_Locatario);
        this.setEmail_Locatario(Email_Locatario);
        this.setSenha_Locatario(Senha_Locatario);
        this.Razao_Social_Locatario = Razao_Social_Locatario;
        this.CNPJ_Locatario = CNPJ_Locatario;
    }
    
    public LocatarioJuridico(String Nome_Locatario, String Endereco_Locatario, String Bairro_Locatario, String Cidade_Locatario, String Estado_Locatario, String Celular_Locatario, String Email_Locatario, String Senha_Locatario, String Razao_Social_Locatario, String CNPJ_Locatario) {
        this.setNome_Locatario(Nome_Locatario);
        this.setEndereco_Locatario(Endereco_Locatario);
        this.setBairro_Locatario(Bairro_Locatario);
        this.setCidade_Locatario(Cidade_Locatario);
        this.setEstado_Locatario(Estado_Locatario);
        this.setCelular_Locatario(Celular_Locatario);
        this.setEmail_Locatario(Email_Locatario);
        this.setSenha_Locatario(Senha_Locatario);
        this.Razao_Social_Locatario = Razao_Social_Locatario;
        this.CNPJ_Locatario = CNPJ_Locatario;
    }

    public String getRazao_Social_Locatario() {
        return Razao_Social_Locatario;
    }

    public void setRazao_Social_Locatario(String Razao_Social_Locatario) {
        this.Razao_Social_Locatario = Razao_Social_Locatario;
    }

    public String getCNPJ_Locatario() {
        return CNPJ_Locatario;
    }

    public void setCNPJ_Locatario(String CNPJ_Locatario) {
        this.CNPJ_Locatario = CNPJ_Locatario;
    }
}
