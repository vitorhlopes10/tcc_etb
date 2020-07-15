
package controller;
import bin.Academia;
import bin.Cargo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import model.FuncionarioDAO;
import bin.Funcionario;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

   @WebServlet(name = "FuncionarioController", urlPatterns = {"/FuncionarioController"})
public class FuncionarioController extends HttpServlet {

  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acao = request.getParameter("acao");
        PrintWriter resposta = response.getWriter();
        resposta.write("<script>");
        
        if ( acao != null ){
            
         String id = request.getParameter("id");
         if ( id != null && !id.isEmpty() && !id.equals("0") ) {
         FuncionarioDAO fdao = new FuncionarioDAO();
         SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
         
         int idFuncionario = Integer.parseInt(id);
                
    switch( acao ) {
    case "excluir":
     if ( fdao.excluir(idFuncionario) ) {
     resposta.print("alert('Funcionário excluído com sucesso!');");
     resposta.print("location.href='listar_func.jsp';");
     
      }
  break;
 case "alterar":
        Funcionario func = fdao.recuperarPorId(idFuncionario);
        if( func == null ) {
        resposta.print("alert('Funcionário não encontrado!');");
        resposta.print("history.back();");
        } else {
        request.setAttribute("f", func);
        request.getRequestDispatcher("/cadastrar_func.jsp").forward(request, response);
          }
  break;
                }
         } else {
      resposta.write("alert('Id inválido!');");
      resposta.write("history.back();");
            }
     
        } else {
            
        resposta.write("alert('Ação Inválida!');");
        resposta.write("history.back();");
                
        }
        
        resposta.write("</script>");
        resposta.close();  
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      try {
          PrintWriter resposta = response.getWriter();
          
          String id = request.getParameter("id");
          String matricula = request.getParameter("matricula");
          String cpf = request.getParameter("cpf");
          String nome = request.getParameter("nome");
          String data_nasc = request.getParameter("data_nasc");
          String sexo = request.getParameter("sexo");
          String turno = request.getParameter("turno");
          String endereco = request.getParameter("endereco");
          String email = request.getParameter("email");
          String telefone = request.getParameter("telefone");
          String senha = request.getParameter("senha");
          
          
          
          
          Funcionario func = new Funcionario();
          SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
          
          func.setMatricula(Integer.parseInt(request.getParameter("matricula")));
          func.setCpf(cpf);
          func.setNome(nome);
          func.setData_nasc(df.parse(request.getParameter("data_nasc")));
          func.setSexo(sexo);
          func.setTurno(turno);
          func.setEndereco(endereco);
          func.setEmail(email);
          func.setTelefone(telefone);
          func.setSenha(senha);
          func.setId(0);
        
       
          
         String cargoId = request.getParameter("cargo");
        
        if ( cargoId != null && !cargoId.isEmpty() ) {
            Cargo cargo = new Cargo();
            cargo.setId( Integer.parseInt(request.getParameter("cargo")) );
        
            func.setCargo(cargo);
        } else {
            resposta.write("<script>alert('Selecione um cargo!');history.back();</script>");
            return;
        }
        
        
          String academiaId = request.getParameter("academia");
        
        if ( academiaId != null && !academiaId.isEmpty() ) {
            Academia academia = new Academia();
            academia.setId( Integer.parseInt(request.getParameter("academia")) );
        
            func.setAcademia(academia);
        } else {
            resposta.write("<script>alert('Selecione uma academia!');history.back();</script>");
            return;
        }
        
        
        
        
        
          FuncionarioDAO fdao = new FuncionarioDAO();
          boolean sucesso = false;
          String mensagem = "";
          if ( id != null && !id.isEmpty() && !id.equals("0") ) {
              int idFuncionario = Integer.parseInt(id);
              
              func.setId(idFuncionario);
              sucesso = fdao.alterar(func);
              mensagem = " Funcionario foi alterado com sucesso!";
          } else {
              sucesso = fdao.inserir(func);
              mensagem = " Funcionario foi cadastrado com sucesso!";
          }
          
          if ( sucesso == true ) {
              resposta.print("<h1>"+mensagem+"</h1>");
              resposta.print("<a href='listar_func.jsp'>voltar</a>");
              // Conseguiu salvar
          } else {
              // Não salvou
              resposta.print("<h1 style='color:black'> Erro ao salvar funcionário! </h1>");
              resposta.print("<a href='javascript:history.back()'>voltar</a>");
          }        
          resposta.close();
      } catch (ParseException ex) {
          Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
}
