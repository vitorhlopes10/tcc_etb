
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bin.Aparelho;
import model.AparelhoDAO;

public class AparelhoController extends HttpServlet {
    
  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acao = request.getParameter("acao");
        PrintWriter resposta = response.getWriter();
        resposta.write("<script>");
        
        if ( acao != null ){
            
            String id = request.getParameter("id");
            if ( id != null && !id.isEmpty() && !id.equals("0") ) {
                AparelhoDAO dao = new AparelhoDAO();
                int idAparelho = Integer.parseInt(id);
                
                switch( acao )
                {
                    case "excluir":
                        if ( dao.excluir(idAparelho) ) {
                            resposta.print("alert('Aparelho excluído com sucesso!');");
                            resposta.print("location.href='listaaparelho.jsp';");
                        }
                        break;
                        
                    case "alterar":
                        Aparelho aparelho = dao.buscarPorId(idAparelho);
                        if( aparelho == null ) {
                            resposta.print("alert('Aparelho não encontrado!');");
                            resposta.print("history.back();");
                        } else {
                            request.setAttribute("a", aparelho);
                            request.getRequestDispatcher("/aparelho.jsp").forward(request, response);
                        }
                        break;
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
        String numero = request.getParameter("numero");
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        
        
        Aparelho aparelho = new Aparelho();
        aparelho.setNumero(numero);
        aparelho.setNome(nome);
        aparelho.setDescricao(descricao);
               
       //aparelho.setId(Integer.parseInt(request.getParameter("id")));
       // aparelho.setNumero(Integer.parseInt(request.getParameter("numero")));
        //aparelho.setNumero(request.getParameter("numero"));
        //String numero = request.getParameter("numero");
        //aparelho.setNome(request.getParameter("nome"));
       // aparelho.setDescricao(request.getParameter("descricao"));
        
        AparelhoDAO dao = new AparelhoDAO();
        boolean sucesso = false;
        String mensagem = "";
        if ( id != null && !id.isEmpty() && !id.equals("0") ) {
            int idAparelho = Integer.parseInt(id);
            aparelho.setId(idAparelho);
            sucesso = dao.alterar(aparelho);
            
            mensagem = "Aparelho alterado com sucesso!";
        } else {            
            sucesso = dao.inserir(aparelho);
            mensagem = "Aparelho cadastrado com sucesso!";
        }   
        
        if ( sucesso == true ) {
            resposta.print("<h1>"+mensagem+"</h1>");
            resposta.print("<a href='listaaparelho.jsp'>voltar</a>");
            // Consegui gravar
        } else {
            // Não consegui gravar
            resposta.print("<h1 style='color:red'>ERRO AO GRAVAR APARELHO</h1>");
            resposta.print("<a href='javascript:history.back()'>voltar</a>");
        }
        resposta.close();        
    }

}

