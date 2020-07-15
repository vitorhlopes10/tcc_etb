package model;

import bin.Academia;
import bin.Aluno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AlunoDAO {

    public boolean inserir(Aluno alu) {
        try {
            String sql = "INSERT INTO aluno (cpf, nome, email, data_nasc, sexo, endereco, telefone,"
                    + "status, valor_mensalidade, plano, senha, id_academia) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            Connection con = Conexao.conectar();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, alu.getCpf());
            pstm.setString(2, alu.getNome());
            pstm.setString(3, alu.getEmail());
            pstm.setDate(4, new Date(alu.getData_nasc().getTime()));
            pstm.setString(5, alu.getSexo());
            pstm.setString(6, alu.getEndereco());
            pstm.setString(7, alu.getTelefone());
            pstm.setString(8, alu.getStatus());
            pstm.setDouble(9, alu.getValor_mensalidade());
            pstm.setString(10, alu.getPlano());
            pstm.setString(11, alu.getSenha());
            pstm.setInt(12, alu.getAcademia().getId());
            pstm.execute();
            pstm.close();
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println("AlunoDAO::inserir");
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean alterar(Aluno alu) {
        try {
            String sql = "UPDATE aluno SET cpf=?,nome=?,email=?,data_nasc=?,"
                    + "sexo=?,endereco=?,telefone=?,status=?,"
                    + "valor_mensalidade=?,plano=?,senha=?, id_academia=? WHERE id=?";
            Connection con = Conexao.conectar();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, alu.getCpf());
            pstm.setString(2, alu.getNome());
            pstm.setString(3, alu.getEmail());
            pstm.setDate(4, new Date(alu.getData_nasc().getTime()));
            pstm.setString(5, alu.getSexo());
            pstm.setString(6, alu.getEndereco());
            pstm.setString(7, alu.getTelefone());
            pstm.setString(8, alu.getStatus());
            pstm.setDouble(9, alu.getValor_mensalidade());
            pstm.setString(10, alu.getPlano());
            pstm.setString(11, alu.getSenha());
            pstm.setInt(12, alu.getAcademia().getId());
            pstm.setInt(13, alu.getId());
            pstm.execute();
            pstm.close();
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println("AlunoDAO::alterar");
            System.out.println(e.getMessage());
            return false;
        }

    }

    public boolean excluir(int id) {
        try {
            String sql = "DELETE FROM aluno WHERE id=?";
            Connection con = Conexao.conectar();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();
            pstm.close();
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println("AlunoDAO::excluir");
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Aluno carregarPorId(Integer id) {
        try {
            String sql = "SELECT id, cpf, nome, email, data_nasc, sexo, endereco, telefone,"
                    + "status, valor_mensalidade, plano, senha, id_academia FROM aluno WHERE id=?";
            Connection con = Conexao.conectar();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            Aluno alu = null;
            if (rs.next()) {
                alu = new Aluno();
                alu.setId(rs.getInt("id"));
                alu.setCpf(rs.getString("cpf"));
                alu.setNome(rs.getString("nome"));
                alu.setEmail(rs.getString("email"));
                alu.setData_nasc(rs.getDate("data_nasc"));
                alu.setSexo(rs.getString("sexo"));
                alu.setEndereco(rs.getString("endereco"));
                alu.setTelefone(rs.getString("telefone"));
                alu.setStatus(rs.getString("status"));
                alu.setValor_mensalidade(rs.getDouble("valor_mensalidade"));
                alu.setPlano(rs.getString("plano"));
                alu.setSenha(rs.getString("senha"));
                
                AcademiaDAO daoAcademia = new AcademiaDAO();
                Academia academia = daoAcademia.buscarPorId(rs.getInt("id_academia"));
                alu.setAcademia(academia);

            }
            pstm.close();
            con.close();
            return alu;
        } catch (Exception e) {
            System.out.println("AlunoDAO::carregarPorId");
            System.out.println(e.getMessage());
            return null;
        }

    }

    public ArrayList<Aluno> getLista() {
        ArrayList<Aluno> lista = new ArrayList<Aluno>();
        try {
            String sql = "SELECT id, cpf, nome, email, data_nasc, sexo, endereco, telefone,"
                    + "status, valor_mensalidade, plano, senha, id_academia FROM aluno ";
            Connection con = Conexao.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            AcademiaDAO daoAcademia = new AcademiaDAO();
            
            while (rs.next()) {
                Aluno alu = new Aluno();
                alu.setId(rs.getInt("id"));
                alu.setCpf(rs.getString("cpf"));
                alu.setNome(rs.getString("nome"));
                alu.setEmail(rs.getString("email"));
                alu.setData_nasc(rs.getDate("data_nasc"));
                alu.setSexo(rs.getString("sexo"));
                alu.setEndereco(rs.getString("endereco"));
                alu.setTelefone(rs.getString("telefone"));
                alu.setStatus(rs.getString("status"));
                alu.setValor_mensalidade(rs.getDouble("valor_mensalidade"));
                alu.setPlano(rs.getString("plano"));
                alu.setSenha(rs.getString("senha"));
                
                Academia academia = daoAcademia.buscarPorId(rs.getInt("id_academia"));
                alu.setAcademia(academia);

                lista.add(alu);

            }
            System.out.println("Listar executado");
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println("AlunoDAO::getLista");
            System.out.println(e.getMessage());
        }
        return lista;
    }

}
