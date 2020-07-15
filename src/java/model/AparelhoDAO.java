
package model;

import bin.Aparelho;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class AparelhoDAO extends Conexao {
    public boolean inserir(Aparelho a) {
        try {
            String sql ="INSERT INTO aparelho (numero, nome, descricao) " 
                    + "VALUES (?,?,?)";
            Connection con = Conexao.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, a.getNumero());
            ps.setString(2, a.getNome());
            ps.setString(3, a.getDescricao());
           
            ps.execute();
            ps.close();
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println("AparelhoDAO::inserir");
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean alterar(Aparelho a) {
    try {
           String sql = "UPDATE aparelho SET numero=?, nome=?, descricao=? WHERE id=?";
            Connection con = Conexao.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, a.getNumero());
            ps.setString(2, a.getNome());
            ps.setString(3, a.getDescricao());
            ps.setInt(4,a.getId());
            
            ps.execute();
            ps.close();
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println("AparelhoDAO::alterar");
            System.out.println(e.getMessage());
            return false;
        }
    }
  
    
    public boolean excluir(int id) {
        try {
            String sql = "DELETE FROM aparelho WHERE id=?";
            Connection con = Conexao.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ps.close();
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println("AparelhoDAO::excluir");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Aparelho buscarPorId(int id) {
        try {
            String sql = "SELECT id, numero, nome, descricao FROM aparelho "
                        
                        + "WHERE id=?";
            Connection con = Conexao.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Aparelho aparelho = null;
            if ( rs.next() ) {
                aparelho = new Aparelho();
                aparelho.setId(rs.getInt("id"));
                aparelho.setNumero(rs.getString("numero"));
                aparelho.setNome(rs.getString("nome"));
                aparelho.setDescricao(rs.getString("descricao"));
               
            }
            ps.close();
            con.close();
            return aparelho;
        } catch (Exception e) {
            System.out.println("AparelhoDAO::buscarPorId");
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    
    public List<Aparelho> getLista() {
        List<Aparelho> lista = new ArrayList<Aparelho>();
        try {
            String sql = "SELECT id, numero, nome, descricao FROM aparelho ";
                        
            Connection con = Conexao.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while ( rs.next() ) {
                Aparelho aparelho = new Aparelho();
                aparelho.setId(rs.getInt("id"));
                aparelho.setNumero(rs.getString("numero"));
                aparelho.setNome(rs.getString("nome"));
                aparelho.setDescricao(rs.getString("descricao"));
               
                                
                lista.add(aparelho);
            }
            System.out.println("AparelhoDAO::getLista");
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println("AparelhoDAO::getLista");
            System.out.println(e.getMessage());
        }
        return lista;
    }
}
