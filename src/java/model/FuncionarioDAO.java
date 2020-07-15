
package model;
import bin.Academia;
import bin.Cargo;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import bin.Funcionario;
import java.sql.PreparedStatement;
public class FuncionarioDAO {
    
    
public boolean inserir(Funcionario f) {
try {
          String sql = "INSERT INTO funcionario (matricula, cpf, nome, data_nasc, sexo, turno, endereco, email, telefone, senha, id_cargo, id_academia) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection con = Conexao.conectar();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, f.getMatricula());
        ps.setString(2, f.getCpf());
        ps.setString(3, f.getNome());
        ps.setDate(4, new Date (f.getData_nasc().getTime()));
        ps.setString(5, f.getSexo());
        ps.setString(6, f.getTurno());
        ps.setString(7, f.getEndereco());
        ps.setString(8, f.getEmail());
        ps.setString(9, f.getTelefone());
        ps.setString(10, f.getSenha());
        ps.setInt(11, f.getCargo().getId());
        ps.setInt(12, f.getAcademia().getId());
     
        ps.execute();
        ps.close();
        con.close();
        return true;
        } catch (Exception e) {
        System.out.println("FuncionarioDAO::inserir");
        System.out.println(e.getMessage());
        return false;
        }
    }
    
    public boolean alterar(Funcionario func) {
    try {
    String sql = "UPDATE funcionario SET matricula=?, cpf=?, nome=?, data_nasc=?, sexo=?, turno=?, endereco=?, email=?, telefone=?, senha=?, id_cargo=?, id_academia=? WHERE id=?";
        Connection con = Conexao.conectar();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, func.getMatricula());
        ps.setString(2, func.getCpf());
        ps.setString(3, func.getNome());
        ps.setDate(4, new Date(func.getData_nasc().getTime()));
        ps.setString(5, func.getSexo());
        ps.setString(6, func.getTurno());
        ps.setString(7, func.getEndereco());
        ps.setString(8, func.getEmail());
        ps.setString(9, func.getTelefone());
        ps.setString(10, func.getSenha());
        ps.setInt(11, func.getCargo().getId());
        ps.setInt(12, func.getAcademia().getId());
        ps.setInt(13, func.getId());
        ps.execute();
        ps.close();
        con.close();
            return true;
        } catch (Exception e) {
            System.out.println("FuncionarioDAO::alterar");
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean  excluir(int id) {
    try {
            String sql = "DELETE FROM funcionario WHERE id=?";
            Connection con = Conexao.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ps.close();
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println("FuncionarioDAO::excluir");
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Funcionario recuperarPorId(int id) {
    try {
           
            String sql = "SELECT id, matricula, cpf, nome, data_nasc, sexo,turno, endereco, email, telefone, senha, id_cargo, id_academia "
                    + "FROM funcionario WHERE id=?";
            
           
            Connection con = Conexao.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Funcionario func = null;
            if ( rs.next() ) {
              func = new Funcionario();
              func.setId(rs.getInt("id"));
              func.setMatricula(rs.getInt("matricula"));
              func.setCpf(rs.getString("cpf"));
              func.setNome(rs.getString("nome"));
              func.setData_nasc(rs.getDate("data_nasc"));
              func.setSexo(rs.getString("sexo"));
              func.setTurno(rs.getString("turno"));
              func.setEndereco(rs.getString("endereco"));
              func.setEmail(rs.getString("email"));
              func.setTelefone(rs.getString("telefone"));
              func.setSenha(rs.getString("senha"));
           
            CargoDAO cdao = new CargoDAO();
            Cargo cargo = cdao.recuperarPorId( rs.getInt("id_cargo") );
            func.setCargo(cargo);
            
            AcademiaDAO AcademiaDAO = new AcademiaDAO();
            Academia academia = AcademiaDAO.buscarPorId(rs.getInt("id_academia") );
            func.setAcademia(academia);
 
            }
            ps.close();
            con.close();
            return func;
        } catch (Exception e) {
            System.out.println("CargoDAO::recuperarPorId");
             System.out.println("AcademiaDAO::recuperarPorId");
            System.out.println(e.getMessage());
            return null;
        }
    }
    
     public ArrayList<Funcionario> getLista() {
     ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
     try {
            String sql = "SELECT id, matricula, cpf, nome, data_nasc, sexo, turno, "
                    + "endereco, email, telefone, senha, id_cargo, id_academia FROM funcionario";
            Connection con = Conexao.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            CargoDAO cDAO = new CargoDAO();
            AcademiaDAO AcademiaDAO = new AcademiaDAO();
            while ( rs.next() ) {
              Funcionario func = new Funcionario();
              func.setId(rs.getInt("id"));
              func.setMatricula(rs.getInt("matricula"));
              func.setCpf(rs.getString("cpf"));
              func.setNome(rs.getString("nome"));
              func.setData_nasc(rs.getDate("data_nasc"));
              func.setSexo(rs.getString("sexo"));
              func.setTurno(rs.getString("turno"));
              func.setEndereco(rs.getString("endereco"));
              func.setEmail(rs.getString("email"));
              func.setTelefone(rs.getString("telefone"));
              func.setSenha(rs.getString("senha"));
        
           
            Cargo cargo = cDAO.recuperarPorId(rs.getInt("id_cargo"));
            func.setCargo(cargo);
            
            Academia academia = AcademiaDAO.buscarPorId(rs.getInt("id_academia"));
            func.setAcademia(academia);
           
            lista.add(func);
            
            
            
            }
            
            System.out.println("FuncionarioDAO::getLista");
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println("FuncionarioDAO::getLista");
            System.out.println(e.getMessage());
        }
        return lista;
    }
}