package bin;

import bin.Aluno;
import java.util.Date;

public class Avaliacao {

    private int id;
    private String biotipo;
    private Date data_ava;
    private int idade;
    private double peso;
    private double ombro;
    private double braco_relaxado;
    private double braco_contraido;
    private double antebraco;
    private double torax;
    private double panturrilha;
    private double cintura;
    private double abdomen;
    private double quadril;
    private double coxa;
    private Date validade_ava;
    private Aluno aluno;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBiotipo() {
        return biotipo;
    }

    public void setBiotipo(String biotipo) {
        this.biotipo = biotipo;
    }

    public Date getData_ava() {
        return data_ava;
    }

    public void setData_ava(Date data_ava) {
        this.data_ava = data_ava;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getOmbro() {
        return ombro;
    }

    public void setOmbro(double ombro) {
        this.ombro = ombro;
    }

    public double getBraco_relaxado() {
        return braco_relaxado;
    }

    public void setBraco_relaxado(double braco_relaxado) {
        this.braco_relaxado = braco_relaxado;
    }

    public double getBraco_contraido() {
        return braco_contraido;
    }

    public void setBraco_contraido(double braco_contraido) {
        this.braco_contraido = braco_contraido;
    }

    public double getAntebraco() {
        return antebraco;
    }

    public void setAntebraco(double antebraco) {
        this.antebraco = antebraco;
    }

    public double getTorax() {
        return torax;
    }

    public void setTorax(double torax) {
        this.torax = torax;
    }

    public double getPanturrilha() {
        return panturrilha;
    }

    public void setPanturrilha(double panturrilha) {
        this.panturrilha = panturrilha;
    }

    public double getCintura() {
        return cintura;
    }

    public void setCintura(double cintura) {
        this.cintura = cintura;
    }

    public double getAbdomen() {
        return abdomen;
    }

    public void setAbdomen(double abdomen) {
        this.abdomen = abdomen;
    }

    public double getQuadril() {
        return quadril;
    }

    public void setQuadril(double quadril) {
        this.quadril = quadril;
    }

    public double getCoxa() {
        return coxa;
    }

    public void setCoxa(double coxa) {
        this.coxa = coxa;
    }

    public Date getValidade_ava() {
        return validade_ava;
    }

    public void setValidade_ava(Date validade_ava) {
        this.validade_ava = validade_ava;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public String toString() {
        return "Avaliacao{"
                + "\n id=" + id
                + "\n biotipo=" + biotipo
                + "\n data_ava=" + data_ava
                + "\n idade=" + idade
                + "\n peso=" + peso
                + "\n ombro=" + ombro
                + "\n braco_relaxado=" + braco_relaxado
                + "\n braco_contraido=" + braco_contraido
                + "\n antebraco=" + antebraco
                + "\n torax=" + torax
                + "\n panturrilha=" + panturrilha
                + "\n cintura=" + cintura
                + "\n abdomen=" + abdomen
                + "\n quadril=" + quadril
                + "\n coxa=" + coxa
                + "\n validade_ava=" + validade_ava + '}';
    }

}
