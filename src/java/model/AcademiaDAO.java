package model;

import bin.Academia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AcademiaDAO {

    public boolean inserir(Academia a) {
        try {
            String sql = "INSERT INTO academia (cnpj, nome, endereco, telefone) "
                    + "VALUES (?,?,?,?)";
            Connection con = Conexao.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, a.getCnpj());
            ps.setString(2, a.getNome());
            ps.setString(3, a.getEndereco());
            ps.setString(4, a.getTelefone());
            ps.execute();
            ps.close();
            con.close();

            return true;
        } catch (Exception e) {
            System.out.println("AcademiaDAO::inserir");
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean alterar(Academia a) {
        try {
            String sql = "UPDATE academia SET cnpj=?, nome=?, endereco=?, telefone=?" + "WHERE id=?";
            Connection con = Conexao.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, a.getCnpj());
            ps.setString(2, a.getNome());
            ps.setString(3, a.getEndereco());
            ps.setString(4, a.getTelefone());
            ps.setInt(5, a.getId());
            ps.execute();
            ps.close();
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println("AcademiaDAO::alterar");
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean excluir(int id) {
        try {
            String sql = "DELETE FROM academia WHERE id=?";
            Connection con = Conexao.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ps.close();
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println("AcademiaDAO::excluir");
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Academia buscarPorId(int id) {
        try {
            String sql = "SELECT id, cnpj, nome, endereco, telefone "
                    + "FROM academia "
                    + "WHERE Id=?";
            Connection con = Conexao.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Academia academia = null;
            if (rs.next()) {
                academia = new Academia();
                academia.setId(rs.getInt("id"));
                academia.setCnpj(rs.getString("cnpj"));
                academia.setNome(rs.getString("nome"));
                academia.setEndereco(rs.getString("endereco"));
                academia.setTelefone(rs.getString("telefone"));

            }
            ps.close();
            con.close();
            return academia;
        } catch (Exception e) {
            System.out.println("AcademiaDAO::buscarPorId");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ArrayList<Academia> getLista() {
        ArrayList<Academia> lista = new ArrayList<Academia>();
        try {
            String sql = "SELECT id, cnpj, nome, endereco, telefone FROM academia";
            Connection con = Conexao.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Academia academia = new Academia();
                academia.setId(rs.getInt("id"));
                academia.setCnpj(rs.getString("cnpj"));
                academia.setNome(rs.getString("nome"));
                academia.setEndereco(rs.getString("endereco"));
                academia.setTelefone(rs.getString("telefone"));

                lista.add(academia);
            }
            System.out.println("AcademiaDAO::getLista");
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println("AcademiaDAO::getLista");
            System.out.println(e.getMessage());
        }
        return lista;
    }
}
