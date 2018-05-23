package modelo;

public class LocadorJuridico extends Locador {    
    private String Razao_Social_Locador ;
    private String CNPJ_Locador;

    public LocadorJuridico() {
    }

    public LocadorJuridico(String Nome_Locador, String Endereco_Locador, String Bairro_Locador, String Cidade_Locador, String Estado_Locador, String Celular_Locador, String Telefone_Locador, String Email_Locador, String Senha_Locador, String Razao_Social_Locador, String CNPJ_Locador) {
        this.setNome_Locador(Nome_Locador);
        this.setEndereco_Locador(Endereco_Locador);
        this.setBairro_Locador(Bairro_Locador);
        this.setCidade_Locador(Cidade_Locador);;
        this.setEstado_Locador(Estado_Locador);
        this.setCelular_Locador(Celular_Locador);
        this.setTelefone_Locador(Telefone_Locador);
        this.setEmail_Locador(Email_Locador);
        this.setSenha_Locador(Senha_Locador);
        this.Razao_Social_Locador = Razao_Social_Locador;
        this.CNPJ_Locador = CNPJ_Locador;
    }

    public LocadorJuridico(String Nome_Locador, String Endereco_Locador, String Bairro_Locador, String Cidade_Locador, String Estado_Locador, String Celular_Locador, String Email_Locador, String Senha_Locador, String Razao_Social_Locador, String CNPJ_Locador) {
        this.setNome_Locador(Nome_Locador);
        this.setEndereco_Locador(Endereco_Locador);
        this.setBairro_Locador(Bairro_Locador);
        this.setCidade_Locador(Cidade_Locador);;
        this.setEstado_Locador(Estado_Locador);
        this.setCelular_Locador(Celular_Locador);
        this.setEmail_Locador(Email_Locador);
        this.setSenha_Locador(Senha_Locador);
        this.Razao_Social_Locador = Razao_Social_Locador;
        this.CNPJ_Locador = CNPJ_Locador;
    }

   public String getRazao_Social_Locador() {
        return Razao_Social_Locador;
    }

    public void setRazao_Social_Locador(String Razao_Social_Locador) {
        this.Razao_Social_Locador = Razao_Social_Locador;
    }

    public String getCNPJ_Locador() {
        return CNPJ_Locador;
    }

    public void setCNPJ_Locador(String CNPJ_Locador) {
        this.CNPJ_Locador = CNPJ_Locador;
    }
}
