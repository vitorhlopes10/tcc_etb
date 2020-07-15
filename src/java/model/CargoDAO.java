package model;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import bin.Cargo;
import java.sql.PreparedStatement;
public class CargoDAO {
public boolean inserir(Cargo c) {
try {
      String sql = "INSERT INTO cargo (tipo) " + "VALUES (?)";
        Connection con = Conexao.conectar();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, c.getTipo());
        ps.execute();
        ps.close();
        con.close();
        return true;
        } catch (Exception e) {
        System.out.println("CargoDAO::inserir");
        System.out.println(e.getMessage());
        return false;
        }
    }
    
    public boolean alterar(Cargo c) {
    try {
           String sql = "UPDATE cargo SET tipo=? " + "WHERE id=?";
            Connection con = Conexao.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getTipo());
            ps.setInt(2, c.getId());
            ps.execute();
            ps.close();
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println("CargoDAO::alterar");
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean  excluir(int id) {
    try {
            String sql = "DELETE FROM cargo WHERE id=?";
            Connection con = Conexao.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ps.close();
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println("CargoDAO::excluir");
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Cargo recuperarPorId(int id) {
    try {
            String sql = "SELECT id, tipo " + "FROM cargo WHERE id=?";
            

            Connection con = Conexao.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Cargo cargo = null;
            
            if ( rs.next() ) {
            cargo = new Cargo();
            cargo.setId(rs.getInt("id"));
            cargo.setTipo(rs.getString("tipo"));
            }
            ps.close();
            con.close();
            return cargo;
        } catch (Exception e) {
            System.out.println("CargoDAO::recuperarPorId");
            System.out.println(e.getMessage());
            return null;
        }
    }
    
     public ArrayList<Cargo> getLista() {
        ArrayList<Cargo> lista = new ArrayList<Cargo>();
     try {
            String sql = "SELECT id, tipo FROM cargo";
            Connection con = Conexao.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            CargoDAO cDAO = new CargoDAO();
            
            while ( rs.next() ) {
            Cargo cargo = new Cargo();
            cargo.setId(rs.getInt("id"));
            cargo.setTipo(rs.getString("tipo"));
            lista.add(cargo);
            }
            
            System.out.println("CargoDAO::getLista");
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println("CargoDAO::getLista");
            System.out.println(e.getMessage());
        }
        return lista;
    }
}
