package controller;
import bin.Cargo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CargoDAO;

@WebServlet(name = "CargoController", urlPatterns = {"/CargoController"})
public class CargoController extends HttpServlet {

  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acao = request.getParameter("acao");
        PrintWriter resposta = response.getWriter();
        resposta.write("<script>");
        
        if ( acao != null ){
            
         String id = request.getParameter("id");
         if ( id != null && !id.isEmpty() && !id.equals("0") ) {
         CargoDAO dao = new CargoDAO();
         int idCargo = Integer.parseInt(id);
                
    switch( acao ) {
    case "excluir":
     if ( dao.excluir(idCargo) ) {
     resposta.print("alert('Cargo excluído com sucesso!');");
     resposta.print("location.href='listar_cargo.jsp';");
     
      }
  break;
  case "alterar":
  Cargo cargo = dao.recuperarPorId(idCargo);
    if( cargo == null ) {
      resposta.print("alert('cargo não encontrado!');");
      resposta.print("history.back();");
    } else {
       request.setAttribute("c", cargo);
       request.getRequestDispatcher("/cadastrar_cargo.jsp").forward(request, response);
       
         }break;
                }
         } else {
      resposta.write("alert('ID Inválido!');");
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
        PrintWriter resposta = response.getWriter();
        
        String id = request.getParameter("id");
        String tipo = request.getParameter("tipo");
        Cargo cargo = new Cargo();
        cargo.setTipo(tipo);

        CargoDAO dao = new CargoDAO();
        boolean sucesso = false;
        String mensagem = "";
        if ( id != null && !id.isEmpty() && !id.equals("0") ) {
            int idCargo = Integer.parseInt(id);
            cargo.setId(idCargo);
            sucesso = dao.alterar(cargo);
            mensagem = "Cargo alterado com sucesso!";
        } else {            
            sucesso = dao.inserir(cargo);
            mensagem = " O cargo foi cadastrado com sucesso!";
             
        }   
        
        if ( sucesso == true ) {
            resposta.print("<h1>"+mensagem+"</h1>");
            resposta.print("<a href='listar_cargo.jsp'>voltar</a>");
        
        } else {
          
            resposta.print("<h2 style='color:black'> Erro ao tentar salvar cargo! </h2>");
            resposta.print("<a href='javascript:history.back()'>voltar</a>");
        }
        resposta.close();        
    }
}
