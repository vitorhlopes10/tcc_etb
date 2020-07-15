package bin;

import java.util.Date;

public class Aluno {

    private int id;
    private String cpf;
    private String nome;
    private String email;
    private Date data_nasc;
    private String sexo;
    private String endereco;
    private String telefone;
    private String status;
    private double valor_mensalidade;
    private String plano;
    private String senha;
    private Academia academia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getValor_mensalidade() {
        return valor_mensalidade;
    }

    public void setValor_mensalidade(double valor_mensalidade) {
        this.valor_mensalidade = valor_mensalidade;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Academia getAcademia() {
        return academia;
    }

    public void setAcademia(Academia academia) {
        this.academia = academia;
    }

    @Override
    public String toString() {
        return "Aluno{"
                + "\n id=" + id
                + "\n cpf=" + cpf
                + "\n nome=" + nome
                + "\n email=" + email
                + "\n data_nasc=" + data_nasc
                + "\n sexo=" + sexo
                + "\n endereco=" + endereco
                + "\n telefone=" + telefone
                + "\n status=" + status
                + "\n valor_mensalidade=" + valor_mensalidade
                + "\n plano=" + plano
                + "\n senha=" + senha + '}';
    }
}
