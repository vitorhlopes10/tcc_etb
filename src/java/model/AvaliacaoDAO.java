package model;

import bin.Avaliacao;
import bin.Aluno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AvaliacaoDAO {

    public boolean inserir(Avaliacao a) {
        try {
            String sql = "INSERT INTO avaliacao_fisica (biotipo, data_ava, idade, peso,"
                    + "ombro, braco_relaxado, braco_contraido, antebraco,"
                    + "torax, panturrilha, cintura, abdomen, quadril, coxa,validade_ava, id_aluno) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            Connection con = Conexao.conectar();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, a.getBiotipo());
            pstm.setDate(2, new Date(a.getData_ava().getTime()));
            pstm.setInt(3, a.getIdade());
            pstm.setDouble(4, a.getPeso());
            pstm.setDouble(5, a.getOmbro());
            pstm.setDouble(6, a.getBraco_relaxado());
            pstm.setDouble(7, a.getBraco_contraido());
            pstm.setDouble(8, a.getAntebraco());
            pstm.setDouble(9, a.getTorax());
            pstm.setDouble(10, a.getPanturrilha());
            pstm.setDouble(11, a.getCintura());
            pstm.setDouble(12, a.getAbdomen());
            pstm.setDouble(13, a.getQuadril());
            pstm.setDouble(14, a.getCoxa());
            pstm.setDate(15, new Date(a.getValidade_ava().getTime()));
            pstm.setInt(16, a.getAluno().getId());
            pstm.execute();
            pstm.close();
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println("AvaliacaoDAO::inserir");
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean alterar(Avaliacao a) {
        try {
            String sql = "UPDATE avaliacao_fisica SET biotipo=?,data_ava=?,idade=?,peso=?,"
                    + "ombro=?,braco_relaxado=?,braco_contraido=?,antebraco=?,"
                    + "torax=?,panturrilha=?,cintura=?,abdomen=?,quadril=?,coxa=?,validade_ava=?,id_aluno=? WHERE id=?";
            Connection con = Conexao.conectar();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, a.getBiotipo());
            pstm.setDate(2, new Date(a.getData_ava().getTime()));
            pstm.setInt(3, a.getIdade());
            pstm.setDouble(4, a.getPeso());
            pstm.setDouble(5, a.getOmbro());
            pstm.setDouble(6, a.getBraco_relaxado());
            pstm.setDouble(7, a.getBraco_contraido());
            pstm.setDouble(8, a.getAntebraco());
            pstm.setDouble(9, a.getTorax());
            pstm.setDouble(10, a.getPanturrilha());
            pstm.setDouble(11, a.getCintura());
            pstm.setDouble(12, a.getAbdomen());
            pstm.setDouble(13, a.getQuadril());
            pstm.setDouble(14, a.getCoxa());
            pstm.setDate(15, new Date(a.getValidade_ava().getTime()));
            pstm.setInt(16, a.getAluno().getId());
            pstm.setInt(17, a.getId());
            pstm.execute();
            pstm.close();
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println("AvaliacaoDAO::alterar");
            System.out.println(e.getMessage());
            return false;
        }

    }

    public boolean excluir(int id) {
        try {
            String sql = "DELETE FROM avaliacao_fisica WHERE id=?";
            Connection con = Conexao.conectar();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();
            pstm.close();
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println("AvaliacaoDAO::excluir");
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Avaliacao carregarPorId(Integer id) {
        try {
            String sql = "SELECT id, biotipo, data_ava, idade, peso, ombro, braco_relaxado, braco_contraido, "
                    + "antebraco, torax, panturrilha, cintura, abdomen, quadril, coxa, "
                    + "validade_ava, id_aluno FROM avaliacao_fisica WHERE id=?";
            Connection con = Conexao.conectar();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            Avaliacao a = null;
            if (rs.next()) {
                a = new Avaliacao();
                a.setId(rs.getInt("id"));
                a.setBiotipo(rs.getString("biotipo"));
                a.setData_ava(rs.getDate("data_ava"));
                a.setIdade(rs.getInt("idade"));
                a.setPeso(rs.getDouble("peso"));
                a.setOmbro(rs.getDouble("ombro"));
                a.setBraco_relaxado(rs.getDouble("braco_relaxado"));
                a.setBraco_contraido(rs.getDouble("braco_contraido"));
                a.setAntebraco(rs.getDouble("antebraco"));
                a.setTorax(rs.getDouble("torax"));
                a.setPanturrilha(rs.getDouble("panturrilha"));
                a.setQuadril(rs.getDouble("quadril"));
                a.setCoxa(rs.getDouble("coxa"));
                a.setValidade_ava(rs.getDate("validade_ava"));

                AlunoDAO daoAluno = new AlunoDAO();
                Aluno aluno = daoAluno.carregarPorId(rs.getInt("id_aluno"));
                a.setAluno(aluno);
            }
            pstm.close();
            con.close();
            return a;
        } catch (Exception e) {
            System.out.println("AvaliacaoDAO::carregarPorId");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ArrayList<Avaliacao> getLista() {
        ArrayList<Avaliacao> lista = new ArrayList<Avaliacao>();
        try {
            String sql = "SELECT id, biotipo, data_ava, idade, peso, ombro, braco_relaxado, braco_contraido, "
                    + "antebraco, torax, panturrilha, cintura, abdomen, quadril, coxa, "
                    + "validade_ava, id_aluno FROM avaliacao_fisica ";
            Connection con = Conexao.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            AlunoDAO daoAluno = new AlunoDAO();

            while (rs.next()) {
                Avaliacao a = new Avaliacao();
                a.setId(rs.getInt("id"));
                a.setBiotipo(rs.getString("biotipo"));
                a.setData_ava(rs.getDate("data_ava"));
                a.setIdade(rs.getInt("idade"));
                a.setPeso(rs.getDouble("peso"));
                a.setOmbro(rs.getDouble("ombro"));
                a.setBraco_relaxado(rs.getDouble("braco_relaxado"));
                a.setBraco_contraido(rs.getDouble("braco_contraido"));
                a.setAntebraco(rs.getDouble("antebraco"));
                a.setTorax(rs.getDouble("torax"));
                a.setPanturrilha(rs.getDouble("panturrilha"));
                a.setQuadril(rs.getDouble("quadril"));
                a.setCoxa(rs.getDouble("coxa"));
                a.setValidade_ava(rs.getDate("validade_ava"));

                Aluno aluno = daoAluno.carregarPorId(rs.getInt("id_aluno"));
                a.setAluno(aluno);

                lista.add(a);

            }
            System.out.println("Listar executado");
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println("AvaliacaoDAO::listar");
            System.out.println(e.getMessage());
        }
        return lista;
    }

}
